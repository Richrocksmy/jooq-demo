package org.richrocksmy.jooqdemo.service;

import org.richrocksmy.jooqdemo.controller.dto.Bird;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BirdService {

  public List<Bird> getBirds(final Optional<String> birdType) {
    return birdType.map(this::getBirdsByType).orElseGet(this::getAllBirds);
  }

  private List<Bird> getAllBirds() {
    return Collections.emptyList();
  }
  
  private List<Bird> getBirdsByType(final String birdType) {
    return Collections.emptyList();
  }
}
