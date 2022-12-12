package org.richrocksmy.jooqdemo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.richrocksmy.jooqdemo.controller.dto.BirdDto;
import org.richrocksmy.jooqdemo.repository.BirdRepository;
import org.richrocksmy.jooqdemo.repository.model.Bird;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BirdServiceTest {

  @Test
  public void shouldReturnAllBirds() {
    // Given
    BirdRepository birdRepository = mock(BirdRepository.class);
    Bird bird1 = getBird("canary");
    Bird bird2 = getBird("peacock");

    when(birdRepository.findAllBirds()).thenReturn(List.of(bird1, bird2));
    BirdService birdService = new BirdService(birdRepository);

    // When
    List<BirdDto> birdDtos = birdService.getBirds(Optional.empty());

    // Then
    assertThat(birdDtos).hasSize(2);
    assertThat(birdDtos).containsExactly(BirdDto.fromModel(bird1), BirdDto.fromModel(bird2));
  }

  @Test
  public void shouldReturnBirdsOfType() {
    // Given
    BirdRepository birdRepository = mock(BirdRepository.class);
    Bird bird = getBird("peacock");
    when(birdRepository.findAllBirdsByType("peacock")).thenReturn(List.of(bird));

    BirdService birdService = new BirdService(birdRepository);

    // When
    List<BirdDto> birdDtos = birdService.getBirds(Optional.of("peacock"));

    // Then
    assertThat(birdDtos).hasSize(1);
    assertThat(birdDtos).containsExactly(BirdDto.fromModel(bird));
  }

  private Bird getBird(final String type) {
    return new Bird(type);
  }
}
