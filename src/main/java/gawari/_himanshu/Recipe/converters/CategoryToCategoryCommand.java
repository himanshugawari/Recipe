package gawari._himanshu.Recipe.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import gawari._himanshu.Recipe.commands.CategoryCommand;
import gawari._himanshu.Recipe.model.Category;
import lombok.Synchronized;

@Component
public class CategoryToCategoryCommand implements Converter<Category, CategoryCommand> {

	@Synchronized
	@Nullable
	@Override
	public CategoryCommand convert(Category source) {
		if (source == null) {
			return null;
		}

		final CategoryCommand categoryCommand = new CategoryCommand();

		categoryCommand.setId(source.getId());
		categoryCommand.setDescription(source.getDescription());

		return categoryCommand;
	}
}
