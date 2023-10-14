
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;


public class TestForm {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com/";

        //Опционально, для отладки
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen =true;

    }

    @Test
    void fillTestForm() {

        open("automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Andrey");
        $("#lastName").setValue("Siluyanov");
        $("#userEmail").setValue("Siluyan_and@mail.ru");
        $x("//label[@for='gender-radio-1']").click();
        $("#userNumber").setValue("9011111111");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOptionContainingText("March");
        $(".react-datepicker__year-select").selectOptionContainingText("1991");
        $(".react-datepicker__day--005").click();
        $("#subjectsInput").setValue("Maths");
        $("#react-select-2-option-0").click();
        $("[for=hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFromClasspath("b.jpg");
        $("#currentAddress").setValue("Russia Yaroslavl");
        $("#state").click();
        $x("//*[.='NCR']").click();
        $("#city").click();
        $x("//*[.='Delhi']").click();
        $("#submit").click();

        //Проверка текста
        $(".modal-content").shouldHave(text("Andrey Siluyanov"));
        $(".modal-content").shouldHave(text("Siluyan_and@mail.ru"));
        $(".modal-content").shouldHave(text("Male"));
        $(".modal-content").shouldHave(text("9011111111"));
        $(".modal-content").shouldHave(text("05 March,1991"));
        $(".modal-content").shouldHave(text("Maths"));
        $(".modal-content").shouldHave(text("Sports"));
        $(".modal-content").shouldHave(text("b.jpg"));
        $(".modal-content").shouldHave(text("Russia Yaroslavl"));
        $(".modal-content").shouldHave(text("NCR Delhi"));
    }
}