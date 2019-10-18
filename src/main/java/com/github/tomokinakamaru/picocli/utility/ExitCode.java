package com.github.tomokinakamaru.picocli.utility;

import java.util.HashMap;
import java.util.Map;
import picocli.CommandLine;

public final class ExitCode {

  public static final int SUCCESS = 0;

  public static final int UNKNOWN = 1;

  public static final int USAGE_HELP = 0;

  public static final int VERSION_HELP = 0;

  private static Map<Class<? extends Throwable>, Integer> map = new HashMap<>();

  static {
    map.put(CommandLine.ParameterException.class, 2);
  }

  private ExitCode() {}

  public static int get(Class<? extends Throwable> clazz) {
    if (map.containsKey(clazz)) {
      return map.get(clazz);
    }
    for (Class<? extends Throwable> t : map.keySet()) {
      if (t.isAssignableFrom(clazz)) {
        return map.get(t);
      }
    }
    return UNKNOWN;
  }

  public static void set(Class<? extends Throwable> clazz, int code) {
    map.put(clazz, code);
  }
}
