package com.peterczigany.transaction;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class TransactionRepositoryTest {

  @Autowired TransactionRepository repository;

  @Test
  void save() {
    assertThat(repository.findAll()).isEqualTo(Collections.emptyList());
  }
}
