package testBases;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class RemoteConfigTestBase {
    @BeforeAll
    static void beforeAll() {
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
        Configuration.baseUrl = config.getbaseUrl();
        Configuration.pageLoadStrategy = "eager";
        Configuration.remote = config.getselenoidAddress();
        Configuration.browser = config.getbrowserName();
        Configuration.browserVersion = config.getbrowserVersion();
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");


        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();

        closeWebDriver();
    }
}

