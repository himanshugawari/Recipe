package gawari._himanshu.Recipe.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import gawari._himanshu.Recipe.model.Recipe;
import gawari._himanshu.Recipe.repositories.RecipeRepository;

public class RecipeServiceImplTest {

	RecipeServiceImpl recipeServiceImpl;

	@Mock
	RecipeRepository recipeRepository;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		this.recipeServiceImpl = new RecipeServiceImpl(this.recipeRepository);
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

}
