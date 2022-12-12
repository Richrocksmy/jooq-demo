package org.richrocksmy.jooqdemo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BirdController {

  @GetMapping("/birds")
  @ResponseStatus(HttpStatus.OK)
  public List<String> getPeacocks() {
     return Collections.emptyList();
   }
}
