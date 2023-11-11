package com.peterczigany.transaction;

import static org.assertj.core.api.Assertions.assertThat;

import com.peterczigany.transaction.model.Transaction;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
class TransactionRepositoryTest {

  @Autowired TransactionRepository repository;

  @Test
  void findAll() {
    assertThat(repository.findAll()).isEqualTo(Collections.emptyList());
  }

  @Test
  @Sql("/data-test.sql")
  void findAllBetweenGivenTimes() {
    List<Transaction> returnedTransactions =
        findByLocalDateTimeBetween(
            LocalDateTime.of(2024, 1, 2, 0, 0), LocalDateTime.of(2024, 1, 3, 0, 0));
    assertThat(returnedTransactions).hasSize(2);
  }
}
