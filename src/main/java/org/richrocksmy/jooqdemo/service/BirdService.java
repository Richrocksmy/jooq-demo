package org.richrocksmy.jooqdemo.service;

import org.richrocksmy.jooqdemo.controller.dto.Bird;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BirdService {

  public List<Bird> getAllBirds() {
    return Collections.emptyList();
  }

  public List<Bird> getBirdsByType(final String birdType) {
    return Collections.emptyList();
  }
}
