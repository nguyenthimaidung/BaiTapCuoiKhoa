//import'@cypress/xpath'

import { BasePage } from "../../Base/Base"
export class Congcuonthi1 extends BasePage{


    // opencongcuonthi() {

    //     return cy.xpath ('//span[contains(text(),"Quản lý Công cụ ôn thi")]')
    // }
    // // clickoncheckbox() {

    // //     return cy.xpath('(//td/input)[4]')
    // // }

    // filterloaicongcu() {
    //     return cy.xpath('//span[@class="ant-select-selection-placeholder"]')
    // }

    // selectoption(){
    //     return cy.xpath('//div[@title="Bên thứ 3"]')
    // }

    // selectoption1(){
    //     return cy.xpath('//div[@title="Tất cả"]')
    // }

    // selectoption2(){
    //     return cy.xpath('//div[@title="Thi thử"]')
    // }

    // selectoption3(text:string) {
    //     return cy.xpath('//div[@title="' + text + '"]')
    // }

    // checkoptionselected () { 
    //     return cy.xpath('//span[@class="ant-select-selection-item"]');
    // }
    
    // // btnDeleteDeactiveStatus() {
    // //     return cy.xpath('//span[contains(text(),"Dừng hoạt động")]//ancestor::tr[@class="cursor-pointer bg-gray"]//td//span[@class="lnr lnr-trash"]')
    // // }

    // // clcikonbuttonxoa(){

    // //     return cy.xpath('//button[contains(text(),"Xóa")]')
    // // }

    
    // Congcuonthicheck() {
    //     this.opencongcuonthi().click({force: true})
    //     this.filterloaicongcu().click({force: true})
    //     this.selectoption3('Bên thứ 3').scrollIntoView().click({force:true})
    //     this.checkoptionselected().should('have.text','Bên thứ 3')
    // }
     OpenscreenCongCuOnThi='//span[contains(text(),"Quản lý Công cụ ôn thi")]'
     FileterLoaiCongCu = '//span[@class="ant-select-selection-placeholder"]'
     SelectOption  = '//div[@title="Bên thứ 3"]'
     Checkdisplayoption ='//span[@class="ant-select-selection-item"]'
     SerachCongCuOnThi ='//input[@placeholder = "Tìm kiếm theo Tên công cụ và Mã công cụ"]'
     ClickCheckbox ="(//td/input)[2]"
     Clickcheckbox1 = "(//td/input)[1]"
     Clickcheckbox2 = "(//th/input)[1]"
     BTNdeleted ="//button[contains(text(),'Xóa')]"
     Openscrendetail = "((//tr)[3])/td[2]" 
     OpenGiacongcu = "//a[contains(text(),'Giá công cụ')]"     //(//div/a)[3]
     OpenThongtindong = "//a[contains(text(),'Thông tin động')]"   //(//div/a)[3]
     OpenGiaoVien = "//a[contains(text(),'Giáo viên')]"   //(//div/a)[4]
     IconviewGiaovien = "//div[@class ='sc-culdNh iMeagA']//span[@class='anticon anticon-eye']"
     Dialog = "//div[@class='modal-dialog']"
     ViewEnglist = "//div[@class='modal-content']//a[contains(text(),'English')]"
     ViewKorea = "//div[@class='modal-content']//a[contains(text(),'한국인')]"
     BtnHuy = "//div[@class ='modal-content']//button[@type ='button']"
     Changestatus = "(//td/span)[2]"
     Selectstatus = "(//span[@class='sc-dWSiPC nQayI dropdown'])[2]"
     Page = "//select [@name = 'select']"


    OpenCongCuOnThi(){
        this.ClickElement(this.OpenscreenCongCuOnThi);
        return this
    }

    ValidatefileterLoaiCongCu(){
        this.ClickElement(this.FileterLoaiCongCu)
        return this
    }

    Selectoptionfilter(){
        this.ClickElement(this.SelectOption)
        return this
    }

    Checkoptiondisplayed(value:string){
        this.ValidateText(this.Checkdisplayoption,value)
        return this
    }

    ImpSearch(value:string){
        this.ClickElement(this.SerachCongCuOnThi)
        this.waitForElementIsVisible(this.SerachCongCuOnThi)
        this.InputElement(this.SerachCongCuOnThi,value)
        this.Sleep()
        return this
    }  

    SelectCheckbox(){
        this.Checkbox(this.ClickCheckbox)
        this.Checkbox(this.Clickcheckbox1)
        return this
    }

    VerifybtnDeletedEnbled(){
        this.waitforElementEnable(this.BTNdeleted)
        return this
    }

    VerifywhenCleardata(){
        this.waitforElementEnable(this.SerachCongCuOnThi)
        return this
    }

    Verifycheckbox(){
        this.Checkboxchecked(this.ClickCheckbox)
    }
    
    OpenscreenDetail(){
        this.ClickElement(this.Openscrendetail)
        return this
    }

    OpentabGiacongcu(){
        this.ClickElement(this.OpenGiacongcu)
        this.waitForElementIsVisible(this.OpenGiacongcu)
        this.Sleep()
        return this
    }

    OpentabThongtindong(){
        this.ClickElement(this.OpenThongtindong)
        this.waitForElementIsVisible(this.OpenThongtindong)
        this.Sleep()
        return this
    }

    OpentabGiaovien(){
        this.ClickElement(this.OpenGiaoVien)
        this.waitForElementIsVisible(this.OpenGiaoVien)
        this.Sleep()
        return this
    }

    ViewGiaovien(){
        this.ClickElement(this.IconviewGiaovien)
        this.waitForElementIsVisible(this.IconviewGiaovien)
        return this
    } 

    Waitdialog(){
        this.waitForElementIsVisible(this.Dialog)
        return this
    }

    ViewtabEnglish(){
        this.ClickElement(this.ViewEnglist)
        this.waitForElementIsVisible(this.ViewEnglist)
        this.Sleep()
        return this
       }

    ViewtabKorea(){
        this.ClickElement(this.ViewKorea)
        this.waitForElementIsVisible(this.ViewKorea)
        this.Sleep()
        return this
       }

    ClickBtnHuy(){
        this.ClickElement(this.BtnHuy)
        return this
    }

    Status(){
        this.ScollElement(this.Changestatus)
        this.ClickElement(this.Changestatus)
        this.ClickElement(this.Selectstatus)
        this.Sleep()
        return this
    }

    Validatecheckbox(){
        this.Checkboxchecked(this.ClickCheckbox)
        this.Checkboxchecked(this.Clickcheckbox1)
        this.Checkboxchecked(this.Clickcheckbox2)
        return this
    }

    Selectpage(option:string){
        this.Selectdropdow(this.Page,option)
        this.Sleep()
        return this
    }


}

export default Congcuonthi1;
