package org.richrocksmy.jooqdemo.repository;

import org.jooq.DSLContext;
import org.richrocksmy.jooqdemo.repository.model.Bird;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.richrocksmy.Tables.BIRD;

@Component
public class BirdRepository {

  private final DSLContext dslContext;

  public BirdRepository(final DSLContext dslContext) { this.dslContext = dslContext;}

  public List<Bird> findAllBirds() {
    return dslContext.select().from(BIRD).fetch().into(Bird.class);
  }

  public List<Bird> findAllBirdsByType(final String type) {
    return dslContext.select().from(BIRD).where(BIRD.TYPE.eq(type)).fetch().into(Bird.class);
  }

}
