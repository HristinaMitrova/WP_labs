import axios from '../custom-axios/axios'

export const FrontendService = {
    fetchIngredients: async () => {
        return await axios.get("/ingredients");
    },

    addIngredient: async (ingredient) => {
        const dataToSend = JSON.stringify(ingredient);
        return await axios.post("/ingredients", dataToSend);
    },

    updateIngredient: async (ingredient, oldName) => {
        const dataToSend = JSON.stringify(ingredient);
        return await axios.patch(`/ingredients/${oldName}`, dataToSend);
    },

    fetchIngredient: async (ingredientName) => {
        console.log(ingredientName);
        return await axios.get(`/ingredients/${ingredientName}`);
    },

    deleteIngredient: async (name) => {
        return await axios.delete(`/ingredients/${name}`)
    },

    fetchPizzasForIngredient: async (name) => {
        return await axios.get(`/ingredients/${name}/pizzas`)
    }
};