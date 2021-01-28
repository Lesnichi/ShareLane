
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTest {

    public static final String URL = "https://www.sharelane.com";
    public static final String URL_ZIP_CODE_FORM = "https://www.sharelane.com/cgi-bin/register.py";

    @Test
    public void CorrectZipCodeTest() {
        open(URL);
        $(By.xpath("//*[text()='ENTER']")).click();
        open(URL_ZIP_CODE_FORM);
        $(By.name("zip_code")).setValue("111").pressEnter();
        String result = $(By.cssSelector(".error_message")).getText();
        Assert.assertEquals(result, "Oops, error on page. ZIP code should have 5 digits");
        Selenide.closeWebDriver();
    }

    @Test
    public void InvalidZipCodeTest() {
        open(URL);
        $(By.xpath("//*[text()='ENTER']")).click();
        open(URL_ZIP_CODE_FORM);
        $(By.name("zip_code")).setValue("11111").pressEnter();
        Assert.assertTrue($(By.name("first_name")).setValue("Vlad").isDisplayed());
        Selenide.closeWebDriver();
    }

    @Test
    public void RegistrationFormTest1() {
        open(URL);
        $(By.xpath("//*[text()='ENTER']")).click();
        open(URL_ZIP_CODE_FORM);
        $(By.name("zip_code")).setValue("11111").pressEnter();
        $(By.name("first_name")).setValue("Vlad").pressTab();
        $(By.name("last_name")).setValue("Lesnichi").pressTab();
        $(By.name("email")).setValue("qwerty@q.com").pressTab();
        $(By.name("password1")).setValue("1111").pressTab();
        $(By.name("password2")).setValue("111");
        $(By.cssSelector("[value=Register]")).click();
        String result = $(By.cssSelector(".error_message")).getText();
        Assert.assertEquals(result, "Oops, error on page. Some of your fields have invalid data or email was previously used");
        Selenide.closeWebDriver();
    }

    @Test
    public void RegistrationFormTest2() {
        open(URL);
        $(By.xpath("//*[text()='ENTER']")).click();
        open(URL_ZIP_CODE_FORM);
        $(By.name("zip_code")).setValue("11111").pressEnter();
        $(By.name("first_name")).setValue("Vlad").pressTab();
        $(By.name("last_name")).setValue("Lesnichi").pressTab();
        $(By.name("email")).setValue("qwerty@q.com").pressTab();
        $(By.name("password1")).setValue("1111").pressTab();
        $(By.name("password2")).setValue("1111");
        $(By.cssSelector("[value=Register]")).click();
        String result = $(By.cssSelector(".confirmation_message")).getText();
        Assert.assertEquals(result, "Account is created!");
        Selenide.closeWebDriver();
    }
}