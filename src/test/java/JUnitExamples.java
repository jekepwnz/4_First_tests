import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class JUnitExamples {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Its done before all tests");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("    Some action before each test");
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
