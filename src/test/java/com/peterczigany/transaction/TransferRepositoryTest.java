package com.peterczigany.transaction;

import static org.assertj.core.api.Assertions.assertThat;

import com.peterczigany.transaction.model.Transfer;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class TransferRepositoryTest {

  @Autowired TransferRepository repository;

  @Test
  void findAll() {
    repository.save(
        new Transfer(
            UUID.randomUUID(),
            "someTestSender",
            "someTestRecipient",
            BigDecimal.TEN,
            LocalDateTime.now()));

    Iterable<Transfer> returnedTransfers = repository.findAll();
    assertThat(returnedTransfers.iterator().hasNext()).isTrue();
  }
}
