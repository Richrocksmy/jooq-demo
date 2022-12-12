package org.richrocksmy.jooqdemo.controller.dto;

import org.richrocksmy.jooqdemo.repository.model.Bird;

public record BirdDto(String type) {

  public static BirdDto fromModel(final Bird bird) {
    return new BirdDto(bird.type);
  }
}
