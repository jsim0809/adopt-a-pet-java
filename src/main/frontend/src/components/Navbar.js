import React from 'react';
import { Route, Link, Switch } from 'react-router-dom';
import AvailablePetsIndex from "./AvailablePetsIndex"
import NewPetForm from "./NewPetForm"
import PetTypesIndex from "./PetTypesIndex"
import PetShowPage from "./PetShowPage"
import ViewAdoptionForms from "./ViewAdoptionForms"
import AdoptedPetsIndex from "./AdoptedPetsIndex"
import ViewSurrenderForm from "./ViewSurrenderForm"
import PendingApplications from "./PendingApplications"

const Navbar = props => {
  return (
    <>
      <div className="top-bar">
        <div className="top-bar-left">
          <ul className="dropdown menu" data-dropdown-menu>
            <li>
              <Link to="/pets">
                <div className="home">Pet Adoption</div>
              </Link>
            </li>
            <li>
              <Link to="/pets/two-legged">
                <div className="navbar">
                  Two Legged Pets
                </div>
              </Link>
            </li>
            <li>
              <Link to="/pets/four-legged">
                <div className="navbar"> Four Legged Pets</div>
              </Link>
            </li>
            <li>
              <Link to="/adoptions/new">
                <div className="navbar">Put a Pet Up For Adoption </div>
              </Link>
            </li>
            <li>
              <Link to="/pets/adopted">
                <div className="navbar">Success Stories </div>
              </Link>
            </li>
            <li>
              <Link to="/pending_applications">
                <div className="navbar">Update Your Application </div>
              </Link>
            </li>
            <li>
              <Link to="/admin/review/adoption">
                <div className="navbar">Review Adoption Requests </div>
              </Link>
            </li>
            <li>
              <Link to="/admin/review/surrender">
                <div className="navbar">Review Pet Surrender Requests </div>
              </Link>
            </li>
          </ul>
        </div>
      </div>

      <Switch>
        <Route exact path="/pets" component={PetTypesIndex} />
        <Route exact path="/pets/adopted/" component={AdoptedPetsIndex} />
        <Route exact path="/adoptions/new" component={NewPetForm} />
        <Route exact path="/pets/:species" component={AvailablePetsIndex} />
        <Route exact path="/pets/:species/:id" component={PetShowPage} />
        <Route exact path="/admin/review/adoption" component={ViewAdoptionForms} />
        <Route exact path="/admin/review/surrender" component={ViewSurrenderForm} />
        <Route exact path="/pending_applications" component={PendingApplications} />
      </Switch>
    </>
  );
};

export default Navbar;
