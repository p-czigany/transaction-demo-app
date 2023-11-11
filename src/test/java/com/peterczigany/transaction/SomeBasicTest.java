package com.peterczigany.transaction;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SomeBasicTest {

  /** Checks the testing framework. Method empty by design. */
  @Test
  @SuppressWarnings("java:S2699")
  void emptyTestMethod() {}

  @Test
  void compareTheSameString() {
    String exampleString = "some dummy string";
    assertThat(exampleString).isEqualTo("some dummy string");
  }
}
