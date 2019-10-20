package com.github.tomokinakamaru.utility.picocli;

final class ExecutionError extends RuntimeException {

  ExecutionError(Throwable t) {
    super(t);
  }
}
