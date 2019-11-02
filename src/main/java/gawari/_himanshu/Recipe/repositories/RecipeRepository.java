package gawari._himanshu.Recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import gawari._himanshu.Recipe.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
