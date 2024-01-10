package org.example.Pages;

import io.qameta.allure.Step;
import org.example.Base.BaseTest;
import org.openqa.selenium.By;

public class LoginPage extends BaseTest {
    @Step("Usename alanına metın gırısı sağlanır")
    public void epostaDoldur(String text){
        driver.findElement(By.name("ctl00$PortalContent$TxtEmail")).sendKeys(text);
    }
    @Step("Password alanına metın gırısı sağlanır")
    public void passwordDoldur(String password){
        driver.findElement(By.name("ctl00$PortalContent$TxtPassword")).sendKeys(password);
    }
    @Step("Gırıs Yap Buttonuna tıklanır")
    public void girisYap(){
        driver.findElement(By.id("ctl00_PortalContent_BtnLogin")).click();
    }
    @Step("Çıkış Yap Buttonuna tıklanır")
    public void cikisYap(){
        driver.findElement(By.cssSelector("[href=\"/logoff.aspx\"]")).click();
    }
    @Step("Regıster Buttonuna tıklanır")
    public void uyeolButonu(){
        driver.findElement(By.id("chkRegister")).click();
    }

}

