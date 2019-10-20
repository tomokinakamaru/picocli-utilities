package com.github.tomokinakamaru.utility.picocli;

import picocli.CommandLine.IExitCodeExceptionMapper;

final class ExitCodeExceptionMapper implements IExitCodeExceptionMapper {

  static final ExitCodeExceptionMapper INSTANCE = new ExitCodeExceptionMapper();

  private ExitCodeExceptionMapper() {}

  @Override
  public int getExitCode(Throwable exception) {
    if (exception instanceof ExecutionError) {
      return ExitCode.get(exception.getCause().getClass());
    }
    return ExitCode.get(exception.getClass());
  }
}
