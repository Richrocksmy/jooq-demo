package org.richrocksmy.jooqdemo.controller;

import org.richrocksmy.jooqdemo.controller.dto.BirdDto;
import org.richrocksmy.jooqdemo.service.BirdService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BirdController {

  private final BirdService birdService;

  public BirdController(final BirdService birdService) {
    this.birdService = birdService;
  }

  @GetMapping("/birds")
  @ResponseStatus(HttpStatus.OK)
  public List<BirdDto> getBirds(@RequestParam final Optional<String> birdType) {
    return birdService.getBirds(birdType);
   }
}
