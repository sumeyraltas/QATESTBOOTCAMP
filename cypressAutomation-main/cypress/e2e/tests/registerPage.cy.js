///<reference types="cypress" />

describe('Register Tests', () => {
    var uyeolButonu = "[id=\"chkRegister\"]";
    var firstNameDoldur = "[id=\"ctl00_PortalContent_TxtFirstName\"]";
    var lastNameDoldur = "[id=\"ctl00_PortalContent_TxtLastName\"]";

    var epostadoldur = "[id=\"ctl00_PortalContent_TxtEmailReg\"]";
    var passworddoldur = "[id=\"ctl00_PortalContent_TxtPasswordReg\"]";
    var tekrarpassworddoldur = "[id=\"ctl00_PortalContent_TxtPasswordConfirm\"]";

    var register = "[id=\"ctl00_PortalContent_BtnRegister\"]";
    var sozlesmekabulbutonu = "[id=\"ctl00_PortalContent_ChkUserContract\"]";

    it('Kullanıcı Olusturma', () => {
        cy.visit("https://www.kostebek.com.tr/login.aspx");
        cy.get(uyeolButonu).click();
        cy.get(firstNameDoldur).type("sumeyra");
        cy.get(lastNameDoldur).type("altas");
        cy.get(epostadoldur).type("sumeyraltas999@gmail.com")
        cy.get(passworddoldur).type("test123");
        cy.get(tekrarpassworddoldur).type("test123");
        cy.get(sozlesmekabulbutonu).click();
        cy.get(register).click();
        cy.visit("https://www.kostebek.com.tr/login.aspx?reqnew=1");
    })

    it('Hatalı Sıfre Ile Kullanıcı Olusturma', () => {
        cy.visit("https://www.kostebek.com.tr/login.aspx");
        cy.get(uyeolButonu).click();
        cy.get(firstNameDoldur).type("sumeyra");
        cy.get(lastNameDoldur).type("altas");
        cy.get(epostadoldur).type("sumeyraltas999@gmail.com")
        cy.get(passworddoldur).type("123");
        cy.get(tekrarpassworddoldur).type("123");
        cy.get(sozlesmekabulbutonu).click();
        cy.get(register).click();
        cy.get("[id=\"ctl00_PortalContent_TxtPasswordReg-error\"]").should("have.text", "En az 5 karakter girmelisiniz.");
    })

    it('Hatalı Eposta Ile Kullanıcı Olusturma', () => {
        cy.visit("https://www.kostebek.com.tr/login.aspx");
        cy.get(uyeolButonu).click();
        cy.get(firstNameDoldur).type("sumeyra");
        cy.get(lastNameDoldur).type("altas");
        cy.get(epostadoldur).type("sumeyraltas999")
        cy.get(passworddoldur).type("test123");
        cy.get(tekrarpassworddoldur).type("test123");
        cy.get(sozlesmekabulbutonu).click();
        cy.get(register).click();
        cy.get("[id=\"ctl00_PortalContent_TxtEmailReg-error\"]").should("have.text", "Lütfen geçerli e-posta adresi girin!");
    })
})