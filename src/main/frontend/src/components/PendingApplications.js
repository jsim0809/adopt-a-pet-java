import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

const PendingApplications = props => {
  const [adoptionApps, setAdoptionApps] = useState([]);
  const [surrenderApps, setSurrenderApps] = useState([]);

  useEffect(() => {
    fetch(`/api/v1/adoption_applications`)
      .then((response) => response.json())
      .then((adoptionApps) => {
        setAdoptionApps(adoptionApps.map((app) => {
          if (app.applicationStatus == "pending"){
            return (
              <tr key={app.id}>
                <td>{app.pet.name}</td>
                <td>{app.name}</td>
                <td>{app.phoneNumber}</td>
                <td>{app.email}</td>
                <td><strong>🗙</strong></td>
                <td><strong>Edit</strong></td>
              </tr>
            )
          }
        }));
      });
  }, []);

    useEffect(() => {
      fetch(`/api/v1/pet_surrender_applications`)
        .then((response) => response.json())
        .then((surrenderApps) => {
          setSurrenderApps(surrenderApps.map((app) => {
            if (app.applicationStatus == "pending"){
              return (
                <tr key={app.id}>
                  <td>{app.petName}</td>
                  <td>{app.name}</td>
                  <td>{app.phoneNumber}</td>
                  <td>{app.email}</td>
                  <td><strong>🗙</strong></td>
                  <td><strong>Edit</strong></td>
                </tr>
              )
            }
          }));
        });
    }, []);

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

    </>
  );
};

export default PendingApplications;
