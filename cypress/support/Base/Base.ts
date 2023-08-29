//import'@cypress/xpath'
export class BasePage {

    goto(path = '') {
        cy.visit(path);
    }

    ClealCookies() {
        cy.clearCookies();
    }

    getlocator(selector: string) {
        return cy.xpath(selector, { timeout: 10000, force: true });
    }

    // getmutillocatiol(text:string) {
    //     return cy.xpath('//div[@title="' + text + '"]')}

    ClickElement(selector: string) {
        this.getlocator(selector).click({ force: true })
    }

    InputElement(selector: string, text: string) {
        this.getlocator(selector).clear({force: true});
        this.getlocator(selector).type(text, {force: true});
    }

    InputElementToDivTag(selector: string, text: string) {
        this.getlocator(selector).then(($div) => {
            $div[0].textContent = text;
          });
    }

    ChangeValueInDropdown(selector: string, text: string) {
        this.getlocator(selector).invoke('text', text)
    }

    setValueLocator(selector: string, nameAttribute: string, value: string) {
        this.getlocator(selector)
            .invoke('attr', nameAttribute, value)
            .should('have.attr', nameAttribute, value)
    }

    ScollElement(selector: string) {
        this.getlocator(selector).scrollIntoView();
    }

    ValidateText(selector: string, value: string) {
        this.getlocator(selector).should('have.text', value);
    }

    ValidateDisable(selector: string) {
        this.getlocator(selector).should('be.disabled')
    }

    waitforElementEnable(selector: string) {
        this.getlocator(selector).should('be.enabled')
    }

    waitForElementIsVisible(selector: string) {
        return this.getlocator(selector).should('be.visible');
    }

    Cleardata(selector: string) {
        this.getlocator(selector).clear()
    }

    Uploadfile(selector: string, value: string) {
        this.getlocator(selector).attachFile(value)
    }

    Selectdropdow(selector: string, Option) {
        this.getlocator(selector).select(Option)
    }

    Checkbox(selector: string) {
        this.getlocator(selector).check({ focus: true })
    }

    Checkboxchecked(selector: string) {
        this.getlocator(selector).should("be.checked")
    }

    Checkcolor(selector: string, value1: string, value2: string) {
        this.getlocator(selector).should('have.css', value1, value2)
    }

    ValidatedataBlank(selector: string) {
        this.getlocator(selector).should('hava.value', '')
    }

    gettext(selector: string): string {
        let textelement: string;
        this.getlocator(selector)
            .invoke('text')
            .then((text: string) => {
                textelement = text
            })
        return textelement;
    }


    Sleep() {
        cy.wait(3000)
        return this
    }





}
