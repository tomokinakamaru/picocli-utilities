import com.github.tomokinakamaru.utility.picocli.ExitCode;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;
import sample.EntryPoint;
import sample.XException;

final class TestEntryPoint {

  @Test
  void test1() {
    assert EntryPoint.execute("-h") == ExitCode.USAGE_HELP;
  }

  @Test
  void test2() {
    assert EntryPoint.execute("-v") == ExitCode.VERSION_HELP;
  }

  @Test
  void test3() {
    assert EntryPoint.execute("-x") == ExitCode.get(XException.class);
  }

  @Test
  void test4() {
    assert EntryPoint.execute("-y") == ExitCode.UNKNOWN;
  }

  @Test
  void test5() {
    assert EntryPoint.execute() == ExitCode.SUCCESS;
  }

  @Test
  void test6() {
    assert EntryPoint.execute("a") == ExitCode.get(CommandLine.ParameterException.class);
  }
}
