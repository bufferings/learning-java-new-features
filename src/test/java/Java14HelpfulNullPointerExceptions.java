import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * JEP 358: Helpful NullPointerExceptions.
 *
 * @see <a href='https://openjdk.java.net/jeps/358'>https://openjdk.java.net/jeps/358</a>
 */
@SuppressWarnings({"ConstantConditions", "ResultOfMethodCallIgnored"})
class Java14HelpfulNullPointerExceptions {

  @Test
  void testHelpfulNullPointerExceptions() {
    NullPointerException npe = assertThrows(NullPointerException.class, () -> {
      Object o = null;
      o.toString();
    });
    assertEquals("Cannot invoke \"Object.toString()\" because \"o\" is null", npe.getMessage());
  }
}
