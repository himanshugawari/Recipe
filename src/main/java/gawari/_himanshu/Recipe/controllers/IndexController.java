package gawari._himanshu.Recipe.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import gawari._himanshu.Recipe.model.Category;
import gawari._himanshu.Recipe.model.UnitOfMeasure;
import gawari._himanshu.Recipe.repositories.CategoryRepository;
import gawari._himanshu.Recipe.repositories.UnitOfMeasureRepository;

@Controller
public class IndexController {

	private final CategoryRepository categoryRepository;
	private final UnitOfMeasureRepository unitOfMeasureRepository;

	@Autowired
	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage() {
		Optional<Category> categoryOptional = categoryRepository.findByDescription("Fast Food");
		Optional<UnitOfMeasure> unitOfMeasureRepositoryOptional = unitOfMeasureRepository.findByDescription("Cup");

		System.out.println("Cat Id is: " + categoryOptional.get().getId());
		System.out.println("UOM Id is: " + unitOfMeasureRepositoryOptional.get().getId());

		return "index";
	}
}
