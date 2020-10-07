import React, { useState } from 'react'

const NewPetForm = props => {
  const [newPet, setNewPet] = useState({
    name: "",
    phoneNumber: "",
    email: "",
    petName: "",
    petAge: "",
    surrenderedPetType: "default",
    petImageUrl: "",
    vaccinationStatus: "default"
  })

  const [appStatus, setAppStatus] = useState("");

  const handlePetChange = event => {
    setNewPet({
      ...newPet,
      [event.currentTarget.name]: event.currentTarget.value
    })
  }

  const handlePetSubmit = event => {
    event.preventDefault()
    let payload = {
      name: newPet.name,
      phoneNumber: newPet.phoneNumber,
      email: newPet.email,
      petName: newPet.petName,
      petAge: newPet.petAge,
      surrenderedPetType: newPet.surrenderedPetType,
      petImageUrl: newPet.petImageUrl,
      vaccinationStatus: newPet.vaccinationStatus,
    }

    let isFilledOut = true;

    let newPetKeys = Object.keys(payload)
    newPetKeys.forEach(key => {
      if (newPet[key] === "") {
        isFilledOut = false
      }
    })

    if (isFilledOut) {
      fetch("/api/v1/pet_surrender_applications", {
        method: 'POST',
        body: JSON.stringify(payload),
        headers: { 'Content-Type': 'application/json' }
      })
        .then(result => {
          if(result.ok){
          setAppStatus("Your request is in process")
         } })
        .catch(error => {
          console.log(error)
        })
    }
  }

  let form;
  if(appStatus !== "Your request is in process"){
    form = (
      <div className="adoption-form-section">
        <form className="put-pet-up-for-adoption" onSubmit={handlePetSubmit}>
          <h2>Put a Pet Up for Adoption!</h2>
          <label>Your Name:
            <input type="text" name="name" onChange={handlePetChange} value={newPet.name} />
          </label>
        
          <label>Phone Number:
            <input type="text" name="phoneNumber" onChange={handlePetChange} value={newPet.phoneNumber} />
          </label>
        
          <label>Email Address:
            <input type="text" name="email" onChange={handlePetChange} value={newPet.email} />
          </label>
        
          <label>Pet Name:
            <input type="text" name="petName" onChange={handlePetChange} value={newPet.petName} />
          </label>
        
          <label>Pet Age:
            <input type="number" name="petAge" onChange={handlePetChange} value={newPet.petAge} />
          </label>
        
          <label>Select Pet Type:</label>
            <select name="surrenderedPetType" onChange={handlePetChange} value={newPet.surrenderedPetType}>
              <option value="default" disabled hidden>--Select Pet Type--</option>
              <option value="2">Four-Legged</option>
              <option value="1">Two-Legged</option>
            </select>
        
          <label>Image Source:
            <input type="text" name="petImageUrl" onChange={handlePetChange} value={newPet.petImageUrl} />
          </label>
        
          <label>Is your pet vaccinated? </label>
            <select name="vaccinationStatus" onChange={handlePetChange} value={newPet.vaccinationStatus}>
              <option value="default" disabled hidden>--Choose one of the following--</option>
              <option value="true">Yes</option>
              <option value="false">No</option>
          </select>

          <div>
            <input className="button submit-btn" type="submit" value="Submit" />
          </div>
        </form>
      </div>
     )
    }

  return (
    <>
      <h1>
        <b>{appStatus}</b>
      </h1>
      {form}
    </>
  )
}

export default NewPetForm
