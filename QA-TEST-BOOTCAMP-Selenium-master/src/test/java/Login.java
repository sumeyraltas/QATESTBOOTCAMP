
import io.qameta.allure.Step;
import org.example.Base.BaseTest;
import org.example.Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends BaseTest {
    LoginPage loginPage = new LoginPage();
    @Test(description = " Şifre Hatalı Kullanıcı Girişi")
    public void SifreAlaniBosKullaniciGirisiTest() {
        loginPage.epostaDoldur("sumeyraltas@gmail.com");
        loginPage.girisYap();
        sifreicinerrorMessageController("Zorunlu alan!");
    }

    @Test(description = " Eposta Hatalı Kullanıcı Girişi")
    public void EpostaHataliKullaniciGirisiTest() {
        loginPage.epostaDoldur("sumeyraltas11");
        loginPage.passwordDoldur("25805");
        loginPage.girisYap();
        epostaicinerrorMessageController("Lütfen geçerli e-posta adresi girin!");
    }


    @Test(description = "Başarılı Kullanıcı Girişi")
    public void BasariliKullaniciGirisiTest() {
        loginPage.epostaDoldur("sumeyraltas@gmail.com");
        loginPage.passwordDoldur("test123");
        loginPage.girisYap();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.kostebek.com.tr/login.aspx", "Redirected to an unexpected URL");
    }

    @Test(description = "Başarılı Kullanıcı Girişi")
    public void BasariliKullaniciCikisiTest() {
        loginPage.epostaDoldur("sumeyraltas@gmail.com");
        loginPage.passwordDoldur("test123");
        loginPage.girisYap();
        loginPage.cikisYap();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.kostebek.com.tr/", "Redirected to an unexpected URL");
    }
    @Step("Error Mesaj Kontrolü Lütfen geçerli e-posta adresi girin!")
    public void epostaicinerrorMessageController(String text){
        String value = driver.findElement(By.id("ctl00_PortalContent_TxtEmail-error")).getText();
        org.junit.Assert.assertEquals(value, text);
    }
    @Step("Error Mesaj Kontrolü Zorunlu alan!")
    public void sifreicinerrorMessageController(String text){
        String value = driver.findElement(By.id("ctl00_PortalContent_TxtPassword-error")).getText();
        org.junit.Assert.assertEquals(value, text);
    }
}
