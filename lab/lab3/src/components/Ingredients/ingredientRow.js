import React from "react";
import {Link} from "react-router-dom";

export const IngredientRow = (props) => {

    return (
        <tr>
            <td scope="col">{props.value.name}</td>
            <td scope="col">{props.value.amount}</td>
            <td scope="col">{props.value.spicy ? "true" : "false"}</td>
            <td scope="col">{props.value.veggie ? "true" : "false"}</td>
            <td scope="col">
                <Link to={`/ingredients/edit/${props.value.name}`} className="btn btn-sm btn-secondary">
                    <span className="fa fa-edit"/>
                    <span><strong>Edit</strong></span>
                </Link>
                <button className="btn btn-sm btn-outline-secondary "
                        onClick={event => props.handleDelete(event, props.value.name)}
                >
                    <span className="fa fa-remove"/>
                    <span><strong>Remove</strong></span>
                </button>
                <Link to={`/ingredients/${props.value.name}/details`} className="btn btn-sm btn-outline-dark">
                    <span><strong>Details</strong></span>
                </Link>
            </td>
        </tr>
    )
};