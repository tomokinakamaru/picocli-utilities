package com.github.tomokinakamaru.picocli.utility;

import picocli.CommandLine.IExitCodeExceptionMapper;

final class ExitCodeExceptionMapper implements IExitCodeExceptionMapper {

  static final ExitCodeExceptionMapper INSTANCE = new ExitCodeExceptionMapper();

  private ExitCodeExceptionMapper() {}

  @Override
  public int getExitCode(Throwable exception) {
    return ExitCode.get(exception.getClass());
  }
}
