package com.peterczigany.transaction;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SomeBasicTest {

  /** Checks the testing framework. Method empty by design. */
  @Test
  @SuppressWarnings("java:S2699")
  void emptyTestMethod() {}

  /** Checks asserting. Trivial by design. */
  @Test
  void compareTheSameString() {
    String exampleString = "some dummy string";
    assertThat(exampleString).isEqualTo("some dummy string");
  }

  @Test
  void testStringClassMethod() {
    DummyClass dummyClass = new DummyClass();
    String classMethodReturnString = dummyClass.getOk();
    assertThat(classMethodReturnString).isEqualTo("OK");
  }

  /** Checks boolean assertions. Trivial by design. */
  @Test
  @SuppressWarnings("java:S3415")
  void compareTheSameBoolean() {
    assertThat(true).isTrue();
  }

  @Test
  void testBooleanClassMethod() {
    DummyClass dummyClass = new DummyClass();
    Boolean classMethodReturnBoolean = dummyClass.getTrue();
    assertThat(classMethodReturnBoolean).isTrue();
  }

  private static class DummyClass {
    private String getOk() {
      return "OK";
    }
  }
}
