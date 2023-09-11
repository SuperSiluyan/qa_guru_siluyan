import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TestForm {
    @Test
    void FillTestForm() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize="1920x1080";
        Configuration.holdBrowserOpen = true;

        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("Andrey");
        $("[id=lastName]").setValue("Siluyanov");
        $("[id=userEmail]").setValue("Siluyan_and@mail.ru");
        $x("//label[@for='gender-radio-1']").click();
        $("[id=userNumber]").setValue("9011111111");
        $("[id=dateOfBirthInput]").click();
        $("[class='react-datepicker__month-select']").selectOptionContainingText("March");
        $("[class='react-datepicker__year-select']").selectOptionContainingText("1991");
        $("[class='react-datepicker__day react-datepicker__day--005']").click();
        $("[id='subjectsInput']").setValue("Maths");
        $("[id=react-select-2-option-0]").click();
        $("[for=hobbies-checkbox-1]").click();
        $("[id=uploadPicture]").sendKeys("C:\\b.jpg");
        $("[id=currentAddress]").setValue("Russia Yaroslavl");
       ///$x("//class[contains@text()='State']").click();
       $("[id=state]").click();
        $x("//*[.='NCR']").click();
        $("[id=city]").click();
        $x("//*[.='Delhi']").click();
        $("[id=submit]").click();

       $("[class=modal-content]").shouldHave(text("Andrey Siluyanov"));
        $("[class=modal-content]").shouldHave(text("Siluyan_and@mail.ru"));
        $("[class=modal-content]").shouldHave(text("Male"));
        $("[class=modal-content]").shouldHave(text("9011111111"));
        $("[class=modal-content]").shouldHave(text("05 March,1991"));
        $("[class=modal-content]").shouldHave(text("Maths"));
        $("[class=modal-content]").shouldHave(text("Sports"));
        $("[class=modal-content]").shouldHave(text("b.jpg"));
        $("[class=modal-content]").shouldHave(text("Russia Yaroslavl"));
        $("[class=modal-content]").shouldHave(text("NCR Delhi"));










    }
}