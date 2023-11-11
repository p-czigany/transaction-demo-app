package com.peterczigany.transaction.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class TransferTest {

  @Test
  void create() {
    Transfer transfer =
        new Transfer(
            null,
            "Alice The Sender",
            "Bruce The Recipient",
            BigDecimal.valueOf(100000.0),
            LocalDateTime.of(2045, 1, 1, 0, 0, 0, 0));
    assertThat(transfer.getSender()).isEqualTo("Alice The Sender");
    assertThat(transfer.getRecipient()).isEqualTo("Bruce The Recipient");
    assertThat(transfer.getAmount()).isEqualTo(BigDecimal.valueOf(100000.0));
    assertThat(transfer.getLocalDateTime()).isEqualTo(LocalDateTime.of(2045, 1, 1, 0, 0, 0, 0));
  }
}
