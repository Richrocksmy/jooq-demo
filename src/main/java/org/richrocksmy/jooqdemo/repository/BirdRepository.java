package org.richrocksmy.jooqdemo.repository;

import org.jooq.DSLContext;
import org.richrocksmy.jooqdemo.repository.model.Bird;

import java.util.List;

public class BirdRepository {

  private final DSLContext dslContext;

  public BirdRepository(final DSLContext dslContext) { this.dslContext = dslContext;}

  List<Bird> findAllBirds() {

  }

  List<Bird> findAllBirdsByType(final String type) {

  }

}
