package gawari._himanshu.Recipe.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import gawari._himanshu.Recipe.commands.RecipeCommand;
import gawari._himanshu.Recipe.converters.RecipeCommandToRecipe;
import gawari._himanshu.Recipe.converters.RecipeToRecipeCommand;
import gawari._himanshu.Recipe.model.Recipe;
import gawari._himanshu.Recipe.repositories.RecipeRepository;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceIT {

	public static final String NEW_DESCRIPTION = "New Description";

	@Autowired
	RecipeService recipeService;

	@Autowired
	RecipeRepository recipeRepository;

	@Autowired
	RecipeCommandToRecipe recipeCommandToRecipe;

	@Autowired
	RecipeToRecipeCommand recipeToRecipeCommand;

	@Transactional
	@Test
	public void testSaveOfDescription() throws Exception {
		// given
		Iterable<Recipe> recipes = recipeRepository.findAll();
		Recipe testRecipe = recipes.iterator().next();
		RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

		// when
		testRecipeCommand.setDescription(NEW_DESCRIPTION);
		RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(testRecipeCommand);

		// then
		assertEquals(NEW_DESCRIPTION, savedRecipeCommand.getDescription());
		assertEquals(testRecipe.getId(), savedRecipeCommand.getId());
		assertEquals(testRecipe.getCategory().size(), savedRecipeCommand.getCategories().size());
		assertEquals(testRecipe.getIngredient().size(), savedRecipeCommand.getIngredients().size());
	}
}