package nl.quintor.service;

import nl.quintor.db.TotallyRealDatabase;
import nl.quintor.model.Ingredient;
import nl.quintor.model.Recipe;

import java.util.ArrayList;
import java.util.List;

/**
 * In this class we can see which recipes we have the ingredients for in our totally real database.
 */
public class RecipeFinder {

    private final TotallyRealDatabase database;

    public RecipeFinder(TotallyRealDatabase database) {
        this.database = database;
    }

    public List<Recipe> allPossibleRecipes() {
        return this.findPossibleRecipes(this.database.getRecipes(), this.database.getIngredients());
    }

    private List<Recipe> findPossibleRecipes(List<Recipe> recipes, List<Ingredient> ingredients) {

        List<Recipe> options = new ArrayList<>();

        for (Recipe r : recipes){

            List<Ingredient> availableIngredients = new ArrayList<>();

            for (Ingredient required : r.getIngredients()) {

                for (Ingredient available : ingredients) {

                    if (required.getName().equals(available.getName())
                    && required.getAmount() <= available.getAmount()) {
                        availableIngredients.add(required);
                    }

                }

            }

            if(availableIngredients.size() == r.getIngredients().size()) {
                options.add(r);
            }

        }
        return options;
    }

}
