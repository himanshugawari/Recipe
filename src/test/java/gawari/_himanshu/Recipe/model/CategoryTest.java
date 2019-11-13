package gawari._himanshu.Recipe.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CategoryTest {

	Category category;

	@BeforeEach
	public void setUp() {
		category = new Category();
	}

	@Test
	public void testGetId() throws Exception {
		Long idValue = 4L;
		category.setId(idValue);
		assertEquals(idValue, category.getId());
	}

}
