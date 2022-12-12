package org.richrocksmy.jooqdemo.repository;

import org.richrocksmy.jooqdemo.repository.model.Bird;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface BirdRepository extends CrudRepository<Bird, UUID> {

  List<Bird> findAllBirds();

  List<Bird> findAllBirdsByType(final String type);
}
