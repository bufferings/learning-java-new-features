import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

import static java.time.DayOfWeek.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JEP 361: Switch Expressions.
 *
 * @see <a href='https://openjdk.java.net/jeps/361'>https://openjdk.java.net/jeps/361</a>
 */
class Java14SwitchExpressions {

  int switchSample1(DayOfWeek dayOfWeek) {
    return switch (dayOfWeek) {
      case MONDAY, TUESDAY:
        yield 1;
      case WEDNESDAY, THURSDAY, FRIDAY:
        yield 2;
      case SATURDAY:
        yield 3;
      case SUNDAY:
        yield 4;
    };
  }

  int switchSample2(DayOfWeek dayOfWeek) {
    return switch (dayOfWeek) {
      case MONDAY, TUESDAY -> 1;
      case WEDNESDAY, THURSDAY, FRIDAY -> 2;
      case SATURDAY -> {
        System.out.println("Hello");
        yield 3;
      }
      case SUNDAY -> 4;
    };
  }

  @Test
  void testSwitchExpressions() {
    assertEquals(1, switchSample1(MONDAY));
    assertEquals(1, switchSample1(TUESDAY));
    assertEquals(2, switchSample1(WEDNESDAY));
    assertEquals(2, switchSample1(THURSDAY));
    assertEquals(2, switchSample1(FRIDAY));
    assertEquals(3, switchSample1(SATURDAY));
    assertEquals(4, switchSample1(SUNDAY));

    assertEquals(1, switchSample2(MONDAY));
    assertEquals(1, switchSample2(TUESDAY));
    assertEquals(2, switchSample2(WEDNESDAY));
    assertEquals(2, switchSample2(THURSDAY));
    assertEquals(2, switchSample2(FRIDAY));
    assertEquals(3, switchSample2(SATURDAY));
    assertEquals(4, switchSample2(SUNDAY));
  }
}
