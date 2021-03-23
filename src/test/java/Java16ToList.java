import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * [JDK-8180352] Add Stream.toList() method.
 *
 * @see <a href='https://bugs.openjdk.java.net/browse/JDK-8180352'>https://bugs.openjdk.java.net/browse/JDK-8180352</a>
 */
class Java16ToList {

  @Test
  void testToList() {
    List<String> list = Stream.of("a", "b").map(String::toUpperCase).toList();
    assertEquals("[A, B]", list.toString());
  }

}
