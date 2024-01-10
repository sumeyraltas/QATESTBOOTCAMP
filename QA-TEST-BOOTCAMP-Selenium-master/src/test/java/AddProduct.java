import io.qameta.allure.Step;
import org.example.Base.BaseTest;
import org.example.Pages.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProduct extends BaseTest {
    LoginPage loginPage = new LoginPage();
    @Test(description = "Başarılı Kullanıcı Girişi ile Ürün Sepete Eklenir ve Satın Al Butonuna Tıklanarak Adres Bilgilerim Kısmına Yönlendirilir")
    public void BasariliSepeteUrunEkleveAdresBilgilerineUlasTest() {
        loginPage.epostaDoldur("sumeyraltas@gmail.com");
        loginPage.passwordDoldur("test123");
        loginPage.girisYap();
        driver.get("https://www.kostebek.com.tr/yesil-baby-yoda-kolaj-kisa-cuzdan");
        urunEkle();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "https://www.kostebek.com.tr/store/checkoutp1.aspx", "Redirected to an unexpected URL");

    }
    @Step("Sepete ürün eklenir ve satın al butonuna tıklanır")
    public void urunEkle(){
        driver.findElement(By.cssSelector("[class=\"btn btn-lg btn-primary btn-cart w100\"]")).click();
        driver.get("https://www.kostebek.com.tr/store/shoppingcart.aspx");
        driver.findElement(By.id("btn-complate-order")).click();
    }
}
