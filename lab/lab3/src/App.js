import React, {Component} from 'react';
//import React from 'react';
import logo from './logo.svg';
import './App.css';
import {BrowserRouter as Router, Route} from "react-router-dom";
import {FrontendService} from "./repository/frontService"
import {Navbar} from './components/Header/navbar'
import {Details} from "./components/Ingredients/details";
import {IngredientList} from "./components/Ingredients/ingredientList";
import {NewIngredientForm} from "./components/Ingredients/createIngredient";
export class App extends Component {

  constructor(props, context) {
    super(props, context);
    this.state = {};
  }

  render() {
    const routing = (
        <Router>
          <Navbar/>
          <main role="main" className="mt-5">
            <div className="container">
              <Route path={"/ingredients"} exact render={
                () => <IngredientList/>
              }>
              </Route>
              <Route path={"/ingredients/new"} exact render={
                () => <NewIngredientForm clicked={this.onSubmit}/>
              }>
              </Route>
              <Route path={"/ingredients/edit/:name"} exact render={
                (props) => <NewIngredientForm clicked={this.onEdit} {...props}
                />
              }>
              </Route>
              <Route path={"/ingredients/:name/details"} exact render={
                (props) => <Details {...props}/>
              }>

              </Route>
            </div>
          </main>
        </Router>
    );
    return (
        <div className="App">
          {routing}
        </div>
    )
  }

  onSubmit = (event, data) => {
    event.preventDefault();
    FrontendService.addIngredient(data)
        .then( res => window.location.href = "http://localhost:3000/ingredients"
        )
        .catch(
            err => {
              alert(err.response.data);
            }
        );
  };

  onEdit = (event, data, oldName) => {
    event.preventDefault();
    FrontendService.updateIngredient(data, oldName).catch(
        error => {
          console.log(error);
        }
    );
    window.location.href = "http://localhost:3000/ingredients";
  }
}

export default App;

