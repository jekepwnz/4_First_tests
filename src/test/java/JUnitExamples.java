import org.junit.jupiter.api.*;

public class JUnitExamples {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Its done before all tests");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("    Some action before each test");
    }
    @AfterEach
    void afterEach() {
        System.out.println("        Message after each test");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("All tests done");
    }


    @Test
    void firstTest() {
        System.out.println("        There is the first test");
    }
    @Test
    void secondTest() {
        System.out.println("        There is second test");
    }

}
