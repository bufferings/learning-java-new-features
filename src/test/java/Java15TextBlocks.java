import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JEP 378: Text Blocks.
 *
 * @see <a href='https://openjdk.java.net/jeps/378'>https://openjdk.java.net/jeps/378</a>
 */
@SuppressWarnings("TextBlockMigration")
class Java15TextBlocks {

  @Test
  void testTextBlocks1() {
    String html1 = "<html>\n" +
        "    <body>\n" +
        "        <p>Hello, world</p>\n" +
        "    </body>\n" +
        "</html>\n";

    String html2 = """
        <html>
            <body>
                <p>Hello, world</p>
            </body>
        </html>
        """;

    assertEquals(html1, html2);
  }

  @Test
  void testTextBlocks2() {
    String query1 = "SELECT \"EMP_ID\", \"LAST_NAME\" FROM \"EMPLOYEE_TB\"\n" +
        "WHERE \"CITY\" = 'INDIANAPOLIS'\n" +
        "ORDER BY \"EMP_ID\", \"LAST_NAME\";\n";

    String query2 = """
        SELECT "EMP_ID", "LAST_NAME" FROM "EMPLOYEE_TB"
        WHERE "CITY" = 'INDIANAPOLIS'
        ORDER BY "EMP_ID", "LAST_NAME";
        """;

    assertEquals(query1, query2);
  }

  @Test
  void testTextBlocks3() {
    String source1 = """
        public void print(MyClass object) {
            System.out.println(Objects.toString(object));
        }
        """;

    String source2 = """
        public void print(%s object) {
            System.out.println(Objects.toString(object));
        }
        """.formatted("MyClass");

    assertEquals(source1, source2);
  }
}
