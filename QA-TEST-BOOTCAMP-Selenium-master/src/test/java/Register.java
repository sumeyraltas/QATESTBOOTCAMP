
import org.example.Base.BaseTest;
import org.example.Pages.LoginPage;
import org.example.Pages.RegisterPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Register extends BaseTest {
    LoginPage loginPage = new LoginPage();
    RegisterPage registerPage = new RegisterPage();
    @Test(description = "Kullanıcı Olusturma")
    public void KullaniciOlusturmaTest() {
        loginPage.uyeolButonu();
        registerPage.firstNameDoldur("Sümeyra");
        registerPage.lastNameDoldur("Altaş");
        registerPage.epostaDoldur("sumeyraltas1@gmail.com");
        registerPage.passwordDoldur("test123");
        registerPage.tekrarPasswordDoldur("test123");
        registerPage.sozlesmekabulbutonu();
        registerPage.register();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.kostebek.com.tr/login.aspx?reqnew=1", "Redirected to an unexpected URL");
    }
    @Test(description = "Kayıtlı olan kullanıcı ile kullanıcı Olusturma")
    public void OlanKullaniciIleKullaniciOlusturmaTest() {
        loginPage.uyeolButonu();
        registerPage.firstNameDoldur("Sümeyra");
        registerPage.lastNameDoldur("Altaş");
        registerPage.epostaDoldur("sumeyraltas1@gmail.com");
        registerPage.passwordDoldur("test123");
        registerPage.tekrarPasswordDoldur("test123");
        registerPage.sozlesmekabulbutonu();
        registerPage.register();
        String value = driver.findElement(By.cssSelector("[class=\"alert alert-danger\"]")).getText();
        org.junit.Assert.assertEquals(value, "Üye kayıt başarısız oldu!\n" +
                "Bu e-posta adresine ait üye zaten kayıtlı!");
    }
    @Test(description = "Hatalı Sıfre Ile Kullanıcı Olusturma")
    public void HataliSifreKullaniciOlusturma() {
        loginPage.uyeolButonu();
        registerPage.firstNameDoldur("Sümeyra");
        registerPage.lastNameDoldur("Altaş");
        registerPage.epostaDoldur("sumeyraltas@gmail.com");
        registerPage.passwordDoldur("123");
        registerPage.tekrarPasswordDoldur("123");
        registerPage.sozlesmekabulbutonu();
        registerPage.register();
        String value = driver.findElement(By.id("ctl00_PortalContent_TxtPasswordReg-error")).getText();
        org.junit.Assert.assertEquals(value, "En az 5 karakter girmelisiniz.");
    }
    @Test(description = "Uyumsuz Sıfre Ile Kullanıcı Olusturma")
    public void UyumsuzSifreKullaniciOlusturma() {
        loginPage.uyeolButonu();
        registerPage.firstNameDoldur("Sümeyra");
        registerPage.lastNameDoldur("Altaş");
        registerPage.epostaDoldur("sumeyraltasxxxxxxxxx@gmail.com");
        registerPage.passwordDoldur("111111");
        registerPage.tekrarPasswordDoldur("22222");
        registerPage.sozlesmekabulbutonu();
        registerPage.register();
        String value = driver.findElement(By.cssSelector("[class=\"alert alert-danger\"]")).getText();
        org.junit.Assert.assertEquals(value, "Girmiş olduğunuz şifreler eşleşmiyor");
    }
    @Test(description = "Hatalı Eposta Ile Kullanıcı Olusturma")
    public void HataliEpostaKullaniciOlusturma() {
        loginPage.uyeolButonu();
        registerPage.firstNameDoldur("Sümeyra");
        registerPage.lastNameDoldur("Altaş");
        registerPage.epostaDoldur("sumeyraltas");
        registerPage.passwordDoldur("test123");
        registerPage.tekrarPasswordDoldur("test123");
        registerPage.sozlesmekabulbutonu();
        registerPage.register();
        String value = driver.findElement(By.id("ctl00_PortalContent_TxtEmailReg-error")).getText();
        org.junit.Assert.assertEquals(value, "Lütfen geçerli e-posta adresi girin!");

    }
    @Test(description = "Sözleşme Kabul Butonuna Tıklamadan Kullanıcı Olusturma")
    public void SozlesmeKabulButonunaTiklamadanKullaniciOlusturmaTest() {
        loginPage.uyeolButonu();
        registerPage.firstNameDoldur("Sümeyra");
        registerPage.lastNameDoldur("Altaş");
        registerPage.epostaDoldur("sumeyraltassxxxxx@gmail.com");
        registerPage.passwordDoldur("test123");
        registerPage.tekrarPasswordDoldur("test123");
        registerPage.register();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertFalse(currentUrl.equals("https://www.kostebek.com.tr/login.aspx"), "URL is not the expected one.");
    }
}
