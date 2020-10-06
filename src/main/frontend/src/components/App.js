import React from "react"
import { Route, BrowserRouter, Redirect } from "react-router-dom"
import Navbar from "./Navbar"

const App = props => {
  return (
    <BrowserRouter>
      <Route path="/pets" component={Navbar} />
      <Route exact path="/">
        <Redirect to="/pets" />
      </Route>
    </BrowserRouter>
  )
}

export default App
