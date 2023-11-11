package com.peterczigany.transaction.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.peterczigany.transaction.model.Transaction;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class TransactionTest {

  @Test
  void create() {
    Transaction transaction =
        new Transaction(
            null,
            "Alice The Sender",
            "Bruce The Recipient",
            BigDecimal.valueOf(100000.0),
            LocalDateTime.of(2045, 1, 1, 0, 0, 0, 0));
    assertThat(transaction.getSender()).isEqualTo("Alice The Sender");
    assertThat(transaction.getRecipient()).isEqualTo("Bruce The Recipient");
    assertThat(transaction.getAmount()).isEqualTo(BigDecimal.valueOf(100000.0));
    assertThat(transaction.getLocalDateTime()).isEqualTo(LocalDateTime.of(2045, 1, 1, 0, 0, 0, 0));
  }
}
