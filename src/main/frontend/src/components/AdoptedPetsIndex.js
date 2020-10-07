import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

const AdoptedPetsIndex = props => {
  const [AdoptedPets, setAdoptedPets] = useState([]);

  useEffect(() => {
    fetch(`/api/v1/adoptable_pets`)
      .then((response) => response.json())
      .then((adoptedPets) => {
        setAdoptedPets(adoptedPets.map((pet) => {
          if (pet.adoptionStatus == "approved"){
            return (
              <tr key={pet.id}>
                <td><img src={pet.imgUrl} alt={`Photo of ${pet.name}`} /></td>
                <td><Link to={`/pets/${pet.adoptablePetType.type.toLowerCase()}/${pet.id}`}>{pet.name}</Link></td>
                <td>{pet.age}</td>
                <td>{pet.vaccinationStatus ? 'Yes' : 'No'}</td>
              </tr>
            )
          }
        }));
      });
  }, []);

  return (
    <>
      <h1>These pets have found their forever home</h1>
      <table>
        <thead>
          <tr>
            <th>Picture</th>
            <th>Name</th>
            <th>Age</th>
            <th>Vaccination Status</th>
          </tr>
        </thead>
        <tbody>
          {AdoptedPets}
        </tbody>
      </table>
    </>
  );
};

export default AdoptedPetsIndex;
