package gawari._himanshu.Recipe.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;


public class CategoryTest {

	Category category;

	@Before
	public void setUp() {
		category = new Category();
	}

	@Test
	public void testGetId() throws Exception {
		Long idValue = 4L;
		category.setId(idValue);
		assertEquals(idValue, category.getId());
	}

	@Test
	public void testGetDescription() throws Exception {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRecipes() throws Exception {
		fail("Not yet implemented");
	}

}
