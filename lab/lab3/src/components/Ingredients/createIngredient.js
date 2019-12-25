import React from "react";
import {FrontendService} from "../../repository/frontService";

export class NewIngredientForm extends React.Component {

    constructor(props, context) {
        super(props, context);
        this.state = {
            name: '',
            amount: '',
            veggie: false,
            spicy: false,
            isNameValid: false,
            isAmountValid: false
        };
        this.handleNameChange = this.handleNameChange.bind(this);
        this.handleAmountChange = this.handleAmountChange.bind(this);
        this.handleSpicyChange = this.handleSpicyChange.bind(this);
        this.handleVeggieChange = this.handleVeggieChange.bind(this);
    }


    componentDidMount() {
        if (this.props.match.params.name) {
            const promise = FrontendService.fetchIngredient(this.props.match.params.name);
            promise.then(
                response => {
                    this.setState(() => {
                        return {
                            name: response.data.name,
                            amount: response.data.amount,
                            veggie: response.data.veggie,
                            spicy: response.data.spicy,
                            isNameValid: true,
                            isAmountValid: true
                        }
                    })
                }
            )
        }
    }

    render() {
        return (
            <div className="row">
                <form className="card p-3"
                      onSubmit={event => this.props.clicked(event, this.state, this.props.match.params.name)}
                >
                    <h4 className="text-upper text-left">Add/Edit Ingredient</h4>
                    <div className="form-group row">
                        <label htmlFor="ingredient" className="col-sm-4 offset-sm-1 text-left">Ingredient name</label>
                        <div className="col-sm-6">
                            <input type="text"
                                   className="form-control"
                                   id="ingredient"
                                   placeholder="Ingredient name"
                                   name="name"
                                   value={this.state.name}
                                   onChange={this.handleNameChange}
                            />
                        </div>
                    </div>
                    <div className="form-group row">
                        <label htmlFor="amount" className="col-sm-4 offset-sm-1 text-left">Amount</label>
                        <div className="col-sm-6">
                            <input type="text"
                                   className="form-control"
                                   id="amount"
                                   placeholder="Amount"
                                   name="amount"
                                   value={this.state.amount}
                                   onChange={this.handleAmountChange}
                            />
                        </div>
                    </div>
                    <div className="form-group row">
                        <label htmlFor="veggie" className="col-sm-4 offset-sm-1 text-left">Veggie</label>
                        <div className="col-sm-6 col-xl-4">
                            <input type="checkbox"
                                   className="form-control"
                                   id="veggie"
                                   name="veggie"
                                   checked={this.state.veggie}
                                   value={this.state.veggie}
                                   onChange={this.handleVeggieChange}
                            />
                        </div>
                    </div>

                    <div className="form-group row">
                        <label htmlFor="spicy" className="col-sm-4 offset-sm-1 text-left">Spicy</label>
                        <div className="col-sm-6 col-xl-4">
                            <input type="checkbox"
                                   className="form-control"
                                   id="spicy"
                                   name="spicy"
                                   checked={this.state.spicy}
                                   value={this.state.spicy}
                                   onChange={this.handleSpicyChange}
                            />
                        </div>
                    </div>

                    <div className="form-group row">
                        <div
                            className="offset-sm-1 col-sm-3  text-center">
                            <button
                                type={"submit"}
                                className="btn btn-primary text-upper"
                                disabled={!(this.state.isNameValid && this.state.isAmountValid)}
                            >
                                Save
                            </button>
                        </div>
                        <div
                            className="offset-sm-1 col-sm-3  text-center">
                            <button
                                className="btn btn-warning text-upper">
                                Reset
                            </button>
                        </div>
                        <div
                            className="offset-sm-1 col-sm-3  text-center">
                            <button
                                className="btn btn-danger text-upper">
                                Cancel
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        );
    }

    handleNameChange = (e) => {
        this.setState({
            name: e.target.value,
            isNameValid: e.target.value.length <= 50 && e.target.value.length > 0
        });
    };

    handleAmountChange = (e) => {
        this.setState({
            amount: e.target.value,
            isAmountValid: e.target.value.length <= 50 && e.target.value.length > 0
        });
    };

    handleSpicyChange = (e) => {
        this.setState({
            spicy: e.target.checked
        });
    };

    handleVeggieChange = (e) => {
        this.setState({
            veggie: e.target.checked
        });
    };
}