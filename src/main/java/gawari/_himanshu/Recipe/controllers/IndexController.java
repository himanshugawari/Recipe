package gawari._himanshu.Recipe.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import gawari._himanshu.Recipe.services.RecipeService;

@Controller
public class IndexController {

	private final RecipeService recipeService;

	@Autowired
	public IndexController(RecipeService recipeService) {
		super();
		this.recipeService = recipeService;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage(Model model) {
		model.addAttribute("recipes", recipeService.getRecipe());
		return "index";
	}
}
