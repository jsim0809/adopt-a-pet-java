import React, { useState, useEffect } from 'react'
import NewPetForm from './NewPetForm'

const SurrenderForm = props => {
    const [newSurrender, setNewSurrender] = useState("")
    const [allSurrenderForms, setAllSurrenderForms] = useState([])
    const [currentlySelectedApp, setCurrentlySelectedApp] = useState(null)

    const handleSurrenderChange = event => {
        setNewSurrender(event.currentTarget.value)
    }

    const handleSelectedChange = event => {
        setCurrentlySelectedApp(JSON.parse(event.currentTarget.value))
    }

    const handleSurrenderSubmit = event => {
        event.preventDefault()
        fetch("/api/v1/pet_surrender_applications/approve", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                applicationId: currentlySelectedApp.id,
                approvalStatus: newSurrender
            })
        })
          .then(() => {
            window.location.reload(true);
          })
    };

    useEffect(() => {
        fetch("/api/v1/pet_surrender_applications").then((response) => response.json())
            .then(surrenderForms => {
                setAllSurrenderForms(surrenderForms)
            })
    }
        , [])

    let viewAllForms = allSurrenderForms.map(SurrenderForm => {
        return (
            <option key={SurrenderForm.id} value={JSON.stringify(SurrenderForm)}>
                --{`${SurrenderForm.name}, Surrender Application #${SurrenderForm.id}, ${SurrenderForm.applicationStatus}`}--
            </option>
        )
    })

    let viewFormDisplay
    if (currentlySelectedApp !== null) {
        viewFormDisplay = (<div>
            <ul className="form-display">
                <li>{`Applicant Name:${currentlySelectedApp.name}`}</li>
                <li>{`Phone#: ${currentlySelectedApp.phoneNumber}`}</li>
                <li>{`Email: ${currentlySelectedApp.email}`}</li>
                <li>{`Pet Name# ${currentlySelectedApp.petName}`}</li>
                <li>{`Pet Age# ${currentlySelectedApp.petAge}`}</li>
                <li>{`Pet Type: ${currentlySelectedApp.surrenderedPetType.type}`}</li>
                <li>{`Pet Image: ${currentlySelectedApp.petImageUrl}`}</li>
                <li>{`Is pet Vaccinated: ${currentlySelectedApp.vaccinationStatus}`}</li>
                <li>{`Application Status: ${currentlySelectedApp.applicationStatus}`}</li>
            </ul>
        </div>)
    }

    return (
        <form className="put-pet-up-for-adoption adoption-form-section" onSubmit={handleSurrenderSubmit} >
            <label htmlFor="finishedForms">Select a pet surrender form to review:</label>
            <select onChange={handleSelectedChange} name="finishedForms" id="finishedForms">
                <option value="null">--Please choose an option--</option>
                {viewAllForms}
            </select>

            {viewFormDisplay}

            <label htmlFor="approval">Choose Approval Status:</label>
            <select onChange={handleSurrenderChange} value={newSurrender} name="approval" id="approval">
                <option value="">--Please choose an option--</option>
                <option value="approved">Approve</option>
                <option value="denied">Deny</option>
            </select>

            <input className="submit-btn" type="submit" value="Submit" />
        </form>)
}

export default SurrenderForm