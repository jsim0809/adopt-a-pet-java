import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

const AvailablePetsIndex = props => {
  const [availablePetsDisplay, setAvailablePetsDisplay] = useState([]);
  const species = props.match.params.species;

  useEffect(() => {
    fetch(`/api/v1/adoptable_pets/by_type?type=${species}`)
      .then((response) => response.json())
      .then((availablePets) => {
        setAvailablePetsDisplay(availablePets.map((pet) => {
          if (pet.adoptionStatus == "null" || pet.adoptionStatus == "denied") {
            return (
              <div className="columns small-3 display-pets" key={pet.id}>
                <Link to={`/pets/${species}/${pet.id}`}>
                  <img src={pet.imgUrl} alt={`Photo of ${pet.name}`} />
                </Link>
                <div>
                  <Link to={`/pets/${species}/${pet.id}`}>Name: {pet.name}</Link>
                  <p>Age: {pet.age}</p>
                  <p>Vaccination Status: {pet.vaccinationStatus ? 'Yes' : 'No'}</p>
                </div>
              </div>
            )
          }
        }));
      });
  }, [species]);

  let speciesName = ""
  if (species === "two-legged") {
    speciesName = "Two Legged"
  } else if (species === "four-legged") {
    speciesName = "Four Legged"
  }

  return (
    <>
      <h1>{speciesName}</h1>
      <div className="grid-container">
        <div className="grid-x">
          {availablePetsDisplay}
        </div>
      </div>

    </>
  );
};

export default AvailablePetsIndex;