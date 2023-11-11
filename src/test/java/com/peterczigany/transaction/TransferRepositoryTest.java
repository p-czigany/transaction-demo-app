package com.peterczigany.transaction;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest

class TransferRepositoryTest {

  @Autowired TransferRepository repository;

  @Test
  void findAll() {
    assertThat(repository.findAll()).isEqualTo(Collections.emptyList());
  }
}
