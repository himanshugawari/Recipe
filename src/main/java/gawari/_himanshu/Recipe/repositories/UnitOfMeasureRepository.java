package gawari._himanshu.Recipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import gawari._himanshu.Recipe.model.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	Optional<UnitOfMeasure> findByDescription(String description);

}
