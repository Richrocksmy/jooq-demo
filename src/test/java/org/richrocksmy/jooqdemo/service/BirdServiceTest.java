package org.richrocksmy.jooqdemo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.richrocksmy.jooqdemo.controller.dto.Bird;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class BirdServiceTest {

  @Test
  public void shouldReturnAllBirds() {
    // Given
    BirdService birdService = new BirdService();

    // When
    List<Bird> birds = birdService.getAllBirds();

    // Then
    assertThat(birds).hasSize(0);
  }

  @Test
  public void shouldReturnBirdsOfType() {
    // Given
    BirdService birdService = new BirdService();

    // When
    List<Bird> birds = birdService.getBirdsByType("peacock");

    // Then
    assertThat(birds).hasSize(0);
  }
}
