import React from "react";
import {FrontendService} from "../../repository/frontService";
import {IngredientRow} from "./ingredientRow";
import {Link} from "react-router-dom";

export class IngredientList extends React.Component {

    constructor(props, context) {
        super(props, context);
        this.state = {
            ingredients: [],
            filtered: [],
            term: ''
        };
        this.handleFilter = this.handleFilter.bind(this);
    }

    componentDidMount() {
        const promise = FrontendService.fetchIngredients();
        let responseData;
        promise.then((data) => {
            responseData = data.data;
            this.setState({
                ingredients: responseData,
                filtered: responseData
            });
        });
    }

    onDelete = (event, name) => {
        const promise = FrontendService.deleteIngredient(name);
        promise.then(
            this.setState((oldState) => {
                return {
                    ingredients: oldState.ingredients.filter(i => i.name !== name),
                    filtered: oldState.ingredients.filter(i => i.name !== name)
                }
            })
        )
    };

    handleFilter = (e) => {
        const term = e.target.value;
        console.log(term);
        this.setState((old) => {
            return {
                term: term
            }
        });
        if(term){
            this.setState((oldState) => {
                return {
                    filtered: oldState.ingredients.filter(it => it.name.indexOf(term) !== -1)
                }
            })
        } else {
            this.setState((oldState) => {
                return {
                    filtered: oldState.ingredients
                }
            })
        }

    };

    render() {
        const ingredientRows = [];
        this.state.filtered.map((ingredient, index) =>
            ingredientRows.push(
                <IngredientRow value={ingredient}
                               key={ingredient.name}
                               handleDelete={this.onDelete}
                />
            )
        );

        return (
            <div className="row">
                <input className={'form-control'}
                       name={'term'}
                       value={this.state.term}
                       onChange={this.handleFilter}
                />
                <h4 className="text-upper text-left">Ingredients</h4>
                <div className="table-responsive">
                    <table className="table tr-history table-striped small">
                        <thead>
                        <tr>
                            <th scope="col">Name</th>
                            <th scope="col">Amount</th>
                            <th scope="col">Spicy</th>
                            <th scope="col">Veggie</th>
                            <th scope="col">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        {ingredientRows}
                        </tbody>
                    </table>
                </div>
                <Link to={"/ingredients/new"} className="btn btn-outline-secondary">
                    <span><strong>Add new ingredient</strong></span>
                </Link>
            </div>
        )
    }
}