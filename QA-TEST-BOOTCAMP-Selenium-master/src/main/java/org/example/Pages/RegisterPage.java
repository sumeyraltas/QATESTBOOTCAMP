package org.example.Pages;

import io.qameta.allure.Step;
import org.example.Base.BaseTest;
import org.openqa.selenium.By;

public class RegisterPage extends BaseTest {
    @Step("Fırst Name Doldurulur")
    public void firstNameDoldur(String text){
        driver.findElement(By.id("ctl00_PortalContent_TxtFirstName")).sendKeys(text);
    }
    @Step("Last Name Doldurulur")
    public void lastNameDoldur(String text){
        driver.findElement(By.id("ctl00_PortalContent_TxtLastName")).sendKeys(text);
    }

    @Step("E-posta Doldurulur")
    public void epostaDoldur(String text){
        driver.findElement(By.id("ctl00_PortalContent_TxtEmailReg")).sendKeys(text);
    }

    @Step("Password Doldurulur")
    public void passwordDoldur(String text){
        driver.findElement(By.id("ctl00_PortalContent_TxtPasswordReg")).sendKeys(text);
    }

    @Step("Tekrar Password Doldurulur")
    public void tekrarPasswordDoldur(String text){
        driver.findElement(By.id("ctl00_PortalContent_TxtPasswordConfirm")).sendKeys(text);
    }

    @Step("Sözleşme Kabul Butonuna Tıklanır")
    public void sozlesmekabulbutonu(){
        driver.findElement(By.id("ctl00_PortalContent_ChkUserContract")).click();
    }

    @Step("Üye Ol Tıklanır")
    public void register(){
        driver.findElement(By.id("ctl00_PortalContent_BtnRegister")).click();
    }

}

