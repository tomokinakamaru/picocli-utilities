package com.github.tomokinakamaru.picocli.utility;

final class ExecutionError extends RuntimeException {

  ExecutionError(Throwable t) {
    super(t);
  }
}
