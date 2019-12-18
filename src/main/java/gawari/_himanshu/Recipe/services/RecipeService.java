package gawari._himanshu.Recipe.services;

import java.util.Set;

import gawari._himanshu.Recipe.commands.RecipeCommand;
import gawari._himanshu.Recipe.model.Recipe;

public interface RecipeService {
	Set<Recipe> getRecipe();

	Recipe findById(Long l);

	RecipeCommand saveRecipeCommand(RecipeCommand command);

}
