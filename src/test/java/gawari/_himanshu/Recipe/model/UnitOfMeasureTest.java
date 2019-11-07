package gawari._himanshu.Recipe.model;


import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UnitOfMeasureTest {

	UnitOfMeasure category;

	@Before
	public void setUp() {
		category = new UnitOfMeasure();
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
