package nl.quintor;

import nl.quintor.db.TotallyRealDatabase;
import nl.quintor.model.Ingredient;
import nl.quintor.model.Recipe;
import nl.quintor.service.RecipeFinder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Ingredient ui = new Ingredient("ui", 10, "stuk");
        Ingredient knoflook = new Ingredient("knoflook", 10, "teen");
        Ingredient gember = new Ingredient("gember", 100, "gram");
        Ingredient kokosmelk = new Ingredient("kokosmelk", 1, "Liter");
        Ingredient bloemkool = new Ingredient("bloemkool", 1, "stuk");

        Recipe curry = new Recipe("Een curry", List.of(ui, knoflook, gember, kokosmelk, bloemkool));
        Recipe curry2 = new Recipe("Een andere curry", List.of(ui, new Ingredient("knoflook", 50, "teen"), gember, kokosmelk, bloemkool));

        TotallyRealDatabase totallyRealDatabase = new TotallyRealDatabase();
        RecipeFinder recipeFinder = new RecipeFinder(totallyRealDatabase);

        totallyRealDatabase.add(ui);
        totallyRealDatabase.add(knoflook);
        totallyRealDatabase.add(gember);
        totallyRealDatabase.add(kokosmelk);
        totallyRealDatabase.add(bloemkool);

        totallyRealDatabase.addRecipe(curry);
        totallyRealDatabase.addRecipe(curry2);


        System.out.println(recipeFinder.allPossibleRecipes());



    }
}
