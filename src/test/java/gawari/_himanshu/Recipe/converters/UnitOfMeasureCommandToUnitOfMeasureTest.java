package gawari._himanshu.Recipe.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import gawari._himanshu.Recipe.commands.UnitOfMeasureCommand;
import gawari._himanshu.Recipe.model.UnitOfMeasure;

public class UnitOfMeasureCommandToUnitOfMeasureTest {

	public static final String DESCRIPTION = "description";
	public static final Long LONG_VALUE = new Long(1L);

	UnitOfMeasureCommandToUnitOfMeasure converter;

	@BeforeEach
	public void setUp() throws Exception {
		converter = new UnitOfMeasureCommandToUnitOfMeasure();

	}

	@Test
	public void testNullParamter() throws Exception {
		assertNull(converter.convert(null));
	}

	@Disabled
	@Test
	public void testEmptyObject() throws Exception {
		assertNotNull(converter.convert(new UnitOfMeasureCommand()));
	}

	@Test
	public void convert() throws Exception {
		// given
		UnitOfMeasureCommand command = new UnitOfMeasureCommand();
		command.setId(LONG_VALUE);
		command.setDescription(DESCRIPTION);

		// when
		UnitOfMeasure uom = converter.convert(command);

		// then
		assertNotNull(uom);
		assertEquals(LONG_VALUE, uom.getId());
		assertEquals(DESCRIPTION, uom.getDescription());

	}

}