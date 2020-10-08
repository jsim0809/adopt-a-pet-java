import React, { useState, useEffect } from 'react'

const AdoptionUpdateForm = ({ prefilled, refresh }) => {
  const [newApplication, setNewApplication] = useState({
    name: "",
    phoneNumber: "",
    email: "",
    homeStatus: "default",
  })

  useEffect(() => {
    setNewApplication({
      name: prefilled.name,
      phoneNumber: prefilled.phoneNumber,
      email: prefilled.email,
      homeStatus: prefilled.homeStatus,
    })
  }, [prefilled])

  const handleAppChange = event => {
    setNewApplication({
      ...newApplication,
      [event.currentTarget.name]: event.currentTarget.value
    })
  }

  const handleAppSubmit = event => {
    event.preventDefault()
    let payload = {
      name: newApplication.name,
      phoneNumber: newApplication.phoneNumber,
      email: newApplication.email,
      homeStatus: newApplication.homeStatus,
      petId: prefilled.pet.id,
    }

    let filledOut = true;
    let newAdoptApp = Object.keys(payload);
    newAdoptApp.forEach(key => {
      if (newApplication[key] === "") {
        filledOut = false
      }
    })

    if (filledOut) {
      fetch(`/api/v1/adoption_applications?id=${prefilled.id}`, {
        method: "PUT",
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
      })
        .then((result) => {
          if (result.ok) {
            refresh();
          }
        })
        .catch(error => {
          console.log(error)
        })
    }
  }

  return (
    <div className="adoption-form-section">
      <form className="put-pet-up-for-adoption" onSubmit={handleAppSubmit}>
        <h2>Pet Adoption Form</h2>
        <label>Your Name:
            <input type="text" name="name" onChange={handleAppChange} value={newApplication.name} />
        </label>
        <label>Phone Number:
            <input type="text" name="phoneNumber" onChange={handleAppChange} value={newApplication.phoneNumber} />
        </label>
        <label>Email Address:
            <input type="text" name="email" onChange={handleAppChange} value={newApplication.email} />
        </label>
        <label>Select Home Status:</label>
        <select name="homeStatus" onChange={handleAppChange} value={newApplication.homeStatus}>
          <option value="default" disabled hidden>--Select Home Status--</option>
          <option value="own">Own</option>
          <option value="rent">Rent</option>
        </select>
        <div>
          <input className="button submit-btn" type="submit" value="Submit" />
        </div>
      </form>
    </div>
  )
}

export default AdoptionUpdateForm