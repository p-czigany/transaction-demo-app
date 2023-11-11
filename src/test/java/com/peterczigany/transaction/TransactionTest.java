package com.peterczigany.transaction;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class TransactionTest {

  @Test
  void create() {
    Transaction transaction =
        new Transaction(
            null, "Alice The Sender", "Bruce The Recipient", BigDecimal.valueOf(100000.0));
    assertThat(transaction.getSender()).isEqualTo("Alice the Sender");
  }
}
