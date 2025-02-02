import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    public static String pageLoadStrategy = "none";
    @BeforeAll
    static void configureBrowser() {

//        WebDriverManager.chromedriver().driverVersion("132.0.6834.159").setup();
//        Configuration.browser = "chrome";
//        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
//        Configuration.timeout = 20000;
//        Configuration.pageLoadTimeout = 20000;
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        $("#userName").setValue("Jack Sparrow");
        $("#userEmail").setValue("JackSparrow@gmail.com");
        $("#currentAddress").setValue("I will not provide my address");
        $("#permanentAddress").setValue("Im sure i will not tell you where i am living");
        $("#submit").scrollIntoView(true).click();

        $("#output").shouldHave(text("Jack Sparrow"),text("JackSparrow@gmail.com"),
                text("I will not provide my address"),text("Im sure i will not tell you where i am living"));


    }
}
