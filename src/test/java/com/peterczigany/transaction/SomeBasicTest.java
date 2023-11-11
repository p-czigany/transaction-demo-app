package com.peterczigany.transaction;

import static com.peterczigany.transaction.initproject.InitProject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatException;

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
    assertThat(DummyClass.getOk()).isEqualTo("OK");
  }

  /** Checks boolean assertions. Trivial by design. */
  @Test
  @SuppressWarnings("java:S3415")
  void compareTheSameBoolean() {
    assertThat(true).isTrue();
  }

  @Test
  void testBooleanClassMethod() {
    assertThat(DummyClass.getTrue()).isTrue();
  }

  /** Checks exception assertions. Trivial by design. */
  @Test
  void assertThrowingAnException() {
    assertThatException()
        .isThrownBy(
            () -> {
              throw new Exception();
            });
  }

  @Test
  void testExceptionalClassMethod() {
    assertThatException().isThrownBy(DummyClass::getException);
  }

  @Test
  void testReachOuterClass() {
    assertThat(InitProject.getOk()).isEqualTo("OK");
  }

  private static class DummyClass {
    private static String getOk() {
      return "OK";
    }

    private static Boolean getTrue() {
      return true;
    }

    private static void getException() throws Exception {
      throw new Exception();
    }
  }
}

class InitProject {}
