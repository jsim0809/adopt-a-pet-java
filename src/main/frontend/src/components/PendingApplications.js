import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import AdoptionUpdateForm from './AdoptionUpdateForm';
import NewPetUpdateForm from './NewPetUpdateForm';

const PendingApplications = props => {
  const [adoptionApps, setAdoptionApps] = useState([]);
  const [surrenderApps, setSurrenderApps] = useState([]);
  const [adoptionEditForm, setAdoptionEditForm] = useState(null);
  const [surrenderEditForm, setSurrenderEditForm] = useState(null);

  const fetchAdoptionApps = () => {
    fetch(`/api/v1/adoption_applications`)
      .then((response) => response.json())
      .then((adoptionApps) => {
        setAdoptionApps(adoptionApps.map((app) => {
          if (app.applicationStatus == "pending") {
            return (
              <tr key={app.id}>
                <td>{app.pet.name}</td>
                <td>{app.name}</td>
                <td>{app.phoneNumber}</td>
                <td>{app.email}</td>
                <td onClick={() => deleteAdoptionApp(app.id)}><strong>🗙</strong></td>
                <td onClick={() => setAdoptionEditForm(<AdoptionUpdateForm prefilled={app} refresh={refresh} />)}><strong>Edit</strong></td>
              </tr>
            )
          }
        }));
      });
  }

  const fetchSurrenderApps = () => {
    fetch(`/api/v1/pet_surrender_applications`)
      .then((response) => response.json())
      .then((surrenderApps) => {
        setSurrenderApps(surrenderApps.map((app) => {
          if (app.applicationStatus == "pending") {
            return (
              <tr key={app.id}>
                <td>{app.petName}</td>
                <td>{app.name}</td>
                <td>{app.phoneNumber}</td>
                <td>{app.email}</td>
                <td onClick={() => deleteSurrenderApp(app.id)}><strong>🗙</strong></td>
                <td onClick={() => setSurrenderEditForm(<NewPetUpdateForm prefilled={app} refresh={refresh} />)}><strong>Edit</strong></td>
              </tr>
            )
          }
        }));
      });
  };

  const deleteAdoptionApp = (index) => {
    if (confirm("Delete this application?")) {
      fetch(`/api/v1/adoption_applications/${index}`, { method: 'delete' })
        .then(fetchAdoptionApps);
    }
  }

  const deleteSurrenderApp = (index) => {
    if (confirm("Delete this application?")) {
      fetch(`/api/v1/pet_surrender_applications/${index}`, { method: 'delete' })
        .then(fetchSurrenderApps);
    }
  }

  const refresh = () => {
    setAdoptionEditForm(null);
    setSurrenderEditForm(null);
    fetchAdoptionApps();
    fetchSurrenderApps();
  }

  useEffect(fetchAdoptionApps, []);
  useEffect(fetchSurrenderApps, []);

  return (
    <>
      <h1>Edit your application</h1>
      <h2>Adoption Applications</h2>
      <table>
        <thead>
          <tr>
            <th>Applied to adopt</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Delete</th>
            <th>Edit</th>
          </tr>
        </thead>
        <tbody>
          {adoptionApps}
        </tbody>
      </table>

      {adoptionEditForm}

      <h2>Pet Surrender Applications</h2>
      <table>
        <thead>
          <tr>
            <th>Pet to surrender</th>
            <th>Name</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Delete</th>
            <th>Edit</th>
          </tr>
        </thead>
        <tbody>
          {surrenderApps}
        </tbody>
      </table>

      {surrenderEditForm}

    </>
  );
};

export default PendingApplications;
