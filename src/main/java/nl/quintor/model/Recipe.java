package nl.quintor.model;

import java.util.List;

public class Recipe {
    @Override
    public String toString() {
        return "Recipe{" +
                "description='" + description + '\'' +
                '}';
    }

    private final String description;

    private final List<Ingredient> ingredients;

    public Recipe(String description, List<Ingredient> ingredients) {
        this.description = description;
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
