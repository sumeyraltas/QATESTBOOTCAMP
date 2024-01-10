///<reference types="cypress" />

describe('Login Tests', () => {
  
    var  epostadoldur = "[name=\"ctl00$PortalContent$TxtEmail\"]";
    var  passworddoldur = "[name=\"ctl00$PortalContent$TxtPassword\"]";
    var  girisYap = "[id=\"ctl00_PortalContent_BtnLogin\"]";
    var  cikisYap = "[href=\"/logoff.aspx\"]";
      
    it('Başarılı Kullanıcı Girişi ile Ürün Sepete Eklenir ve Satın Al Butonuna Tıklanarak Adres Bilgilerim Kısmına Yönlendirilir', () => {
     cy.visit("https://www.kostebek.com.tr/login.aspx");
     cy.get(epostadoldur).type("sumeyraltas@gmail.com")
     cy.get(passworddoldur).type("test123");
     cy.get(girisYap).click();
     cy.visit("https://www.kostebek.com.tr/yesil-baby-yoda-kolaj-kisa-cuzdan");
     cy.get("[class=\"btn btn-lg btn-primary btn-cart w100\"]").click();
     cy.visit("https://www.kostebek.com.tr/store/shoppingcart.aspx");
     cy.get("[id=\"btn-complate-order\"]").click();
    })


})