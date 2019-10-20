package sample;

import com.github.tomokinakamaru.utility.picocli.AbstractEntryPoint;
import com.github.tomokinakamaru.utility.picocli.ExitCode;
import picocli.CommandLine;

public final class EntryPoint extends AbstractEntryPoint {

  static {
    ExitCode.set(XException.class, 100);
  }

  @CommandLine.Option(names = {"-x"})
  private boolean x;

  @CommandLine.Option(names = {"-y"})
  private boolean y;

  private EntryPoint() {}

  public static void main(String[] args) {
    main(new EntryPoint(), args);
  }

  public static int execute(String... args) {
    return execute(new EntryPoint(), args);
  }

  @Override
  public void main() {
    if (x) {
      throw new XException();
    }

    if (y) {
      throw new YException();
    }

    System.out.println("Hello!");
  }
}
