
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormTest {

    @Test
    public void ZipCodeTest() {
        open("https://www.sharelane.com");
        $(By.xpath("//*[text()='ENTER']")).click();
        open("https://www.sharelane.com/cgi-bin/register.py");
        $(By.name("zip_code")).setValue("111").pressEnter();
        By result = By.cssSelector(".error_message");
        Assert.assertEquals(result, By.cssSelector(".error_message"));
    }

    @Test
    public void RegistrationFormTest1() {
        open("https://www.sharelane.com");
        $(By.xpath("//*[text()='ENTER']")).click();
        open("https://www.sharelane.com/cgi-bin/register.py");
        $(By.name("zip_code")).setValue("11111").pressEnter();
        $(By.name("first_name")).setValue("Vlad").pressTab();
        $(By.name("last_name")).setValue("Lesnichi").pressTab();
        $(By.name("email")).setValue("qwerty@q.com").pressTab();
        $(By.name("password1")).setValue("1111").pressTab();
        $(By.name("password2")).setValue("1111");
        $(By.cssSelector("[value=Register]")).click();
        By result = By.cssSelector(".error_message");
        Assert.assertEquals(result, By.cssSelector(".error_message"));
    }

    @Test
    public void RegistrationFormTest2() {
        open("https://www.sharelane.com");
        $(By.xpath("//*[text()='ENTER']")).click();
        open("https://www.sharelane.com/cgi-bin/register.py");
        $(By.name("zip_code")).setValue("11111").pressEnter();
        $(By.name("first_name")).setValue("Vlad").pressTab();
        $(By.name("last_name")).setValue("Lesnichi").pressTab();
        $(By.name("email")).setValue("qwerty@q.com").pressTab();
        $(By.name("password1")).setValue("1111").pressTab();
        $(By.name("password2")).setValue("1111");
        $(By.cssSelector("[value=Register]")).click();
        By result = By.cssSelector(".confirmation_message");
        Assert.assertEquals(result, By.cssSelector(".confirmation_message"));
    }
}
