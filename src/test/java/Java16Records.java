import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JEP 395: Records.
 *
 * @see <a href='https://openjdk.java.net/jeps/395'>https://openjdk.java.net/jeps/395</a>
 */
@SuppressWarnings("SpellCheckingInspection")
class Java16Records {

  record FullName(String firstName, String lastName) {}

  @Test
  void testRecords() {
    var fullName = new FullName("Mitsuyuki", "Shiiba");

    assertEquals("Mitsuyuki", fullName.firstName());
    assertEquals("Shiiba", fullName.lastName());
    assertEquals("FullName[firstName=Mitsuyuki, lastName=Shiiba]", fullName.toString());
  }

}
