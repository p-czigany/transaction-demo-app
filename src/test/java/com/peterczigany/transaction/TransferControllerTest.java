package com.peterczigany.transaction;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import com.peterczigany.transaction.model.Transfer;
import com.peterczigany.transaction.repository.TransferRepository;
import java.time.LocalDateTime;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class TransferControllerTest {
  @Mock private TransferRepository repository;
  @InjectMocks private TransferController controller;

  @Test
  void getTransfersBetweenTimes() throws Exception {
    List<Transfer> transfers = List.of(new Transfer(), new Transfer());
    Mockito.when(repository.findByLocalDateTimeBetween(any(), any())).thenReturn(transfers);

    assertThat(
            controller.getTransactionsInTimeInterval(
                LocalDateTime.parse("2024-01-01T00:01"), LocalDateTime.parse("2024-01-02T00:00")))
        .isEqualTo(transfers);
  }
}
