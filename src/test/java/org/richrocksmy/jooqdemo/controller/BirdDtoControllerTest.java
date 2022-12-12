package org.richrocksmy.jooqdemo.controller;

import org.junit.jupiter.api.Test;
import org.richrocksmy.jooqdemo.service.BirdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BirdController.class)
public class BirdDtoControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private BirdService birdService;

  @Test
  void shouldReturnAllBirds() throws Exception {
    when(birdService.getBirds(Optional.empty())).thenReturn(Collections.emptyList());
    mockMvc
        .perform(
            get("/api/v1/birds")
                .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  void shouldReturnFilteredBirds() throws Exception {
    when(birdService.getBirds(Optional.of("peacock"))).thenReturn(Collections.emptyList());
    mockMvc
        .perform(
            get("/api/v1/birds")
                .queryParam("birdType", "peacock")
                .contentType(MediaType.APPLICATION_JSON))
        .andDo(print())
        .andExpect(status().isOk());
  }
}
