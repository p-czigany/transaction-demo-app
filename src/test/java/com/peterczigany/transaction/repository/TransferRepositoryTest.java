package com.peterczigany.transaction.repository;

import static org.assertj.core.api.Assertions.assertThat;

import com.peterczigany.transaction.model.Transfer;
import com.peterczigany.transaction.repository.TransferRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class TransferRepositoryTest {

  @Autowired
  TransferRepository repository;

  @Test
  void findAll() {
    repository.save(
        new Transfer(
            UUID.randomUUID(),
            "someTestSender",
            "someTestRecipient",
            BigDecimal.TEN,
            LocalDateTime.of(2024, 1, 1, 0, 0)));

    Iterable<Transfer> returnedTransfers = repository.findAll();
    assertThat(returnedTransfers.iterator().hasNext()).isTrue();
  }

  @Test
  void findAllInTimeRange() {
    repository.save(createDummyTransferForTime(LocalDateTime.of(2024, 1, 1, 0, 0)));
    repository.save(createDummyTransferForTime(LocalDateTime.of(2024, 1, 1, 0, 1)));
    repository.save(createDummyTransferForTime(LocalDateTime.of(2024, 1, 2, 0, 0)));
    repository.save(createDummyTransferForTime(LocalDateTime.of(2024, 1, 2, 0, 1)));

    List<Transfer> returnedTransfers =
        repository.findByLocalDateTimeBetween(
            LocalDateTime.of(2024, 1, 1, 0, 1), LocalDateTime.of(2024, 1, 2, 0, 0));

    assertThat(returnedTransfers).hasSize(2);
  }

  private Transfer createDummyTransferForTime(LocalDateTime localDateTime) {
    return new Transfer(
        UUID.randomUUID(), "someTestSender", "someTestRecipient", BigDecimal.TEN, localDateTime);
  }
}
