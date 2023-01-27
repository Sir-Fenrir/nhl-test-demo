package nl.quintor.db;

import nl.quintor.exception.CookingException;
import nl.quintor.model.Ingredient;
import nl.quintor.model.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is meant to represent a database. It stores ingredients and recipes, and we can query and mutate it in
 * some simple ways.
 */
public class TotallyRealDatabase {

    private final Map<String, Ingredient> ingredients = new HashMap<>();

    private final List<Recipe> recipes = new ArrayList<>();

    public Ingredient add(Ingredient ingredient) {
        if(ingredients.containsKey(ingredient.getName())) {
            ingredients.get(ingredient.getName()).add(ingredient.getAmount());
        } else {
            ingredients.put(ingredient.getName(), ingredient);
        }

        return ingredients.get(ingredient.getName());
    }

    public Ingredient use(Ingredient ingredient) {
        if(ingredients.containsKey(ingredient.getName())) {
            ingredients.get(ingredient.getName()).use(ingredient.getAmount());
        } else {
            throw new CookingException("We don't have any " + ingredient.getName() + "!");
        }

        return ingredients.get(ingredient.getName());
    }

    public Recipe addRecipe(Recipe recipe) {
        recipes.add(recipe);
        return recipe;
    }

    public List<Recipe> getRecipes() {
        return this.recipes;
    }

    public List<Ingredient> getIngredients() {
        return this.ingredients.values().stream().toList();
    }



}
