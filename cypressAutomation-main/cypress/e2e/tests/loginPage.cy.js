///<reference types="cypress" />

describe('Login Tests', () => {
  
    var  epostadoldur = "[name=\"ctl00$PortalContent$TxtEmail\"]";
    var  passworddoldur = "[name=\"ctl00$PortalContent$TxtPassword\"]";
    var  girisYap = "[id=\"ctl00_PortalContent_BtnLogin\"]";
    var  cikisYap = "[href=\"/logoff.aspx\"]";
      
    it('Başarılı Kullanıcı Girişi', () => {
     cy.visit("https://www.kostebek.com.tr/login.aspx");
     cy.get(epostadoldur).type("sumeyraltas@gmail.com")
     cy.get(passworddoldur).type("test123");
     cy.get(girisYap).click();
     cy.visit("https://www.kostebek.com.tr/login.aspx");
    })

    it('Eposta Hatalı Kullanıcı Girişi', () => {
        cy.visit("https://www.kostebek.com.tr/login.aspx");
        cy.get(epostadoldur).type("sumeyraltas")
        cy.get(passworddoldur).type("test123");
        cy.get(girisYap).click();
     })

    it('Şifre Hatalı Kullanıcı Girişi', () => {
        cy.visit("https://www.kostebek.com.tr/login.aspx");
        cy.get(epostadoldur).type("sumeyraltas@gmail.com")
        cy.get(girisYap).click();
        cy.get("[id=\"ctl00_PortalContent_TxtPassword-error\"]").should("have.text","Zorunlu alan!");
    })
})