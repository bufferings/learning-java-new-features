import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * JEP 394: Pattern Matching for instanceof.
 *
 * @see <a href='https://openjdk.java.net/jeps/394'>https://openjdk.java.net/jeps/394</a>
 */
@SuppressWarnings("ConstantConditions")
class Java16PatternMatchingForInstanceof {

  @Test
  void testInstanceof1() {
    Object o = "";
    if (o instanceof String s) {
      assertTrue(s.isEmpty());
      return;
    }
    fail("ここには来ないよ");
  }

  @Test
  void testInstanceof2() {
    Object o = "";
    if (!(o instanceof String s)) {
      throw new AssertionError("ここには来ないよ");
    }
    // ここでも s が使える
    assertTrue(s.isEmpty());
  }

}
