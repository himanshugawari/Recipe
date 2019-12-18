package gawari._himanshu.Recipe.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gawari._himanshu.Recipe.converters.RecipeCommandToRecipe;
import gawari._himanshu.Recipe.converters.RecipeToRecipeCommand;
import gawari._himanshu.Recipe.model.Recipe;
import gawari._himanshu.Recipe.repositories.RecipeRepository;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeServiceImpl;

	@Mock
	RecipeRepository recipeRepository;

	@Mock
	RecipeToRecipeCommand recipeToRecipeCommand;

	@Mock
	RecipeCommandToRecipe recipeCommandToRecipe;

	@BeforeEach
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.recipeServiceImpl = new RecipeServiceImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
	}

	@Test
	public void testGetRecipe() throws Exception {

		Recipe recipe = new Recipe();
		HashSet<Recipe> recipeData = new HashSet<>();
		recipeData.add(recipe);

		when(recipeRepository.findAll()).thenReturn(recipeData);

		Set<Recipe> recipeSet = recipeServiceImpl.getRecipe();
		assertEquals(recipeSet.size(), 1);

		verify(recipeRepository, times(1)).findAll();
	}

	@Test
	public void getRecipeByIdTest() throws Exception {
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		Optional<Recipe> recipeOptional = Optional.of(recipe);

		when(recipeRepository.findById(any())).thenReturn(recipeOptional);

		Recipe recipeReturned = recipeServiceImpl.findById(1L);

		assertNotNull(recipeReturned, "Null recipe returned");
		verify(recipeRepository, times(1)).findById(any());
		verify(recipeRepository, never()).findAll();
	}
}
