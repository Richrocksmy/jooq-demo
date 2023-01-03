package org.richrocksmy.jooqdemo.service;

import org.jooq.DSLContext;
import org.richrocksmy.jooqdemo.controller.dto.BirdDto;
import org.richrocksmy.jooqdemo.repository.BirdRepository;
import org.richrocksmy.jooqdemo.repository.model.Bird;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BirdService {

  private final BirdRepository birdRepository;

  public BirdService(final BirdRepository birdRepository) { this.birdRepository = birdRepository;}
  }

  public List<BirdDto> getBirds(final Optional<String> birdType) {
    return birdType.map(this::getBirdsByType).orElseGet(this::getAllBirds).stream()
        .map(BirdDto::fromModel)
        .toList();
  }

  private List<Bird> getAllBirds() {
    return birdRepository.findAllBirds();
  }
  
  private List<Bird> getBirdsByType(final String birdType) {
    return birdRepository.findAllBirdsByType(birdType);
  }
}
