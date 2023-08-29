import { BasePage } from "../../Base/Base"
export class admin extends BasePage{

    // constructor () {
        
    // }
   
    username = '//input[@name="username"]'
    password = '//input[@name="password"]'
    buttonSubmit = '//button[@type="submit"]'

    Goto(text: string) {
        this.goto(text);
        return this;
     }

    InpUsername(value:string){
        this.InputElement(this.username, value)
        return this
    }

    InpPassword(value:string){
        this.InputElement(this.password, value)
        return this
    }

    ClickbuttonSubmit(){
        this.ClickElement(this.buttonSubmit)
        return this
    }
    // userName() {
    //     return cy.xpath('//input[@name="username"]')
        
    // }

    // passWord() {
    //     return cy.xpath('//input[@name="password"]')
    // }

    // btnSubmit() {
    //     return cy.xpath('//button[@type="submit"]')
    // }

    // loginWithUserNameAndPassword(username, password) {
    //     this.userName().type(username)
    //     this.passWord().type(password)
    //     this.btnSubmit().click({force: true})
    // }

    
}
    

