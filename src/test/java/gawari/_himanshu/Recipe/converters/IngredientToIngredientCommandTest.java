package gawari._himanshu.Recipe.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gawari._himanshu.Recipe.commands.IngredientCommand;
import gawari._himanshu.Recipe.model.Ingredient;
import gawari._himanshu.Recipe.model.Recipe;
import gawari._himanshu.Recipe.model.UnitOfMeasure;

public class IngredientToIngredientCommandTest {

	public static final Recipe RECIPE = new Recipe();
	public static final BigDecimal AMOUNT = new BigDecimal("1");
	public static final String DESCRIPTION = "Cheeseburger";
	public static final Long UOM_ID = new Long(2L);
	public static final Long ID_VALUE = new Long(1L);

	IngredientToIngredientCommand converter;

	@BeforeEach
	public void setUp() throws Exception {
		converter = new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());
	}

	@Test
	public void testNullConvert() throws Exception {
		assertNull(converter.convert(null));
	}

	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new Ingredient()));
	}

	@Test
	public void testConvertNullUOM() throws Exception {
		// given
		Ingredient ingredient = new Ingredient();
		ingredient.setId(ID_VALUE);
		ingredient.setRecipe(RECIPE);
		ingredient.setAmount(AMOUNT);
		ingredient.setDescription(DESCRIPTION);
		ingredient.setUom(null);
		// when
		IngredientCommand ingredientCommand = converter.convert(ingredient);
		// then
		assertNull(ingredientCommand.getUnitOfMeasure());
		assertEquals(ID_VALUE, ingredientCommand.getId());
		// assertEquals(RECIPE, ingredientCommand.get);
		assertEquals(AMOUNT, ingredientCommand.getAmount());
		assertEquals(DESCRIPTION, ingredientCommand.getDescription());
	}

	@Test
	public void testConvertWithUom() throws Exception {
		// given
		Ingredient ingredient = new Ingredient();
		ingredient.setId(ID_VALUE);
		ingredient.setRecipe(RECIPE);
		ingredient.setAmount(AMOUNT);
		ingredient.setDescription(DESCRIPTION);

		UnitOfMeasure uom = new UnitOfMeasure();
		uom.setId(UOM_ID);

		ingredient.setUom(uom);
		// when
		IngredientCommand ingredientCommand = converter.convert(ingredient);
		// then
		assertEquals(ID_VALUE, ingredientCommand.getId());
		assertNotNull(ingredientCommand.getUnitOfMeasure());
		assertEquals(UOM_ID, ingredientCommand.getUnitOfMeasure().getId());
		// assertEquals(RECIPE, ingredientCommand.get);
		assertEquals(AMOUNT, ingredientCommand.getAmount());
		assertEquals(DESCRIPTION, ingredientCommand.getDescription());
	}
}