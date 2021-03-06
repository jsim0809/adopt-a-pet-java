import React, { useState, useEffect } from 'react'
import AdoptionForm from './AdoptionForm'

const ApprovalForm = props => {
    const [newApproval, setNewApproval] = useState("")
    const [allAdoptionForms, setAllAdoptionForms] = useState([])
    const [currentlySelectedForm, setCurrentlySelectedForm] = useState(null)

    const handleApprovalChange = event => {
        setNewApproval(event.currentTarget.value)
    }

    const handleSelectionChange = event => {
        setCurrentlySelectedForm(JSON.parse(event.currentTarget.value))
    }

    const handleApprovalSubmit = event => {
        event.preventDefault()
        fetch("/api/v1/adoption_applications/approve", {
            method: "POST",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                petId: currentlySelectedForm.pet.id,
                applicationId: currentlySelectedForm.id,
                approvalStatus: newApproval
            })
        })
            .then(() => {
                fetchAllApps();
            })
    };

    const fetchAllApps = () => {
        fetch("/api/v1/adoption_applications").then((response) => response.json())
            .then(adoptionForms => {
                setAllAdoptionForms(adoptionForms)
            })
    }

    useEffect(fetchAllApps, []);

    let allForms = allAdoptionForms.map(AdoptionForm => {
        return <option key={AdoptionForm.id} value={JSON.stringify(AdoptionForm)}>--{`${AdoptionForm.name}, Application#${AdoptionForm.id}, ${AdoptionForm.applicationStatus}`}--</option>
    })

    let formDisplay
    if (currentlySelectedForm !== null) {
        formDisplay = (
            <div>
                <ul className="form-display">
                    <li>{`Applicant Id# ${currentlySelectedForm.id}`}</li>
                    <li>{`Pet Name ${currentlySelectedForm.pet.name}`}</li>
                    <li>{`Applicant Name:${currentlySelectedForm.name}`}</li>
                    <li>{`Phone#: ${currentlySelectedForm.phoneNumber}`}</li>
                    <li>{`Email: ${currentlySelectedForm.email}`}</li>
                    <li>{`Applicant's Home Status: ${currentlySelectedForm.homeStatus}`}</li>
                    <li>{`Application Status: ${currentlySelectedForm.applicationStatus}`}</li>
                </ul>
            </div>)
    }

    return (
        <form className="put-pet-up-for-adoption adoption-form-section" onSubmit={handleApprovalSubmit} >
            <label htmlFor="completedForms">Select an adoption request form to review:</label>
            <select onChange={handleSelectionChange} name="completedForms" id="completedForms">
                <option value="null">--Please choose an option--</option>
                {allForms}
            </select>

            {formDisplay}

            <label htmlFor="approval">Choose Approval Status:</label>
            <select onChange={handleApprovalChange} value={newApproval} name="approval" id="approval">
                <option value="">--Please choose an option--</option>
                <option value="approved">Approve</option>
                <option value="denied">Deny</option>
            </select>

            <input className="submit-btn" type="submit" value="Submit" />
        </form >)
}

export default ApprovalForm
