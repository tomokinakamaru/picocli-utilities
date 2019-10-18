package com.github.tomokinakamaru.picocli.utility;

import java.util.HashMap;
import java.util.Map;
import picocli.CommandLine;

@CommandLine.Command(
    exitCodeOnSuccess = ExitCode.SUCCESS,
    exitCodeOnUsageHelp = ExitCode.USAGE_HELP,
    exitCodeOnVersionHelp = ExitCode.VERSION_HELP,
    versionProvider = VersionProvider.class)
public abstract class AbstractEntryPoint implements Runnable {

  static final Map<Class<? extends Throwable>, Integer> exitCodes = new HashMap<>();

  @CommandLine.Option(
      names = {"-h", "--help"},
      usageHelp = true,
      description = "Display this help message")
  private boolean usageHelpRequested = false;

  @CommandLine.Option(
      names = {"-v", "--version"},
      versionHelp = true,
      description = "Display version info")
  private boolean versionInfoRequested = false;

  protected static <E> void main(E entryPoint, String[] args) {
    System.exit(execute(entryPoint, args));
  }

  protected static <E> int execute(E entryPoint, String... args) {
    return new CommandLine(entryPoint)
        .setExitCodeExceptionMapper(ExitCodeExceptionMapper.INSTANCE)
        .execute(args);
  }
}
