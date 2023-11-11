package com.peterczigany.transaction;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.peterczigany.transaction.model.Transfer;
import com.peterczigany.transaction.repository.TransferRepository;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

class TransferControllerTest {
  @MockBean private TransferRepository repository;

  @Autowired private TransferController controller;

  @Autowired private MockMvc mockMvc;

  @Test
  void getTransfersBetweenTimes() throws Exception {
    List<Transfer> transfers = List.of(new Transfer(), new Transfer());
    Mockito.when(repository.findByLocalDateTimeBetween(any(), any())).thenReturn(transfers);

    mockMvc
        .perform(
            get("/api/transactions/")
                .param("firstTime", "2024-01-01T00:01")
                .param("lastTime", "2024-01-02T00:00")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$", hasSize(2)));
  }
}
