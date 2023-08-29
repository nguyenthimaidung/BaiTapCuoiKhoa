import { BasePage } from "../../Base/Base";

export class QLthanhmenu extends BasePage {

    OpenQL_thanhmenu = "//span[contains(text(),'Quản lý thanh Menu')]"
    Btncreate = "//button[contains(text(),'Thêm mới')]"
    Tenmenu = "(//input[@placeholder='Tên menu'])[1]"
    Menucha = "(//div[@class='css-b8ldur-Input'])[1]"
    Kieumenu = "(//div[@class='css-b8ldur-Input'])[2]"
    Vitri_menuduoi = "(//label[@class='sc-hDXZEW fWCoUK'])[1]"
    Vitri_Homepage = "(//label[@class='sc-hDXZEW fWCoUK'])[2]"
    Vitri_menutren = "(//label[@class='sc-hDXZEW fWCoUK'])[3]"
    Image = "//input[@name='image']"
    BtnLuu = "//button[contains(text(),'Lưu')]"
    Icon_edit = "//td[contains(text(),'--- Tên menu 1')]//ancestor:: tr[@class ='bg-gray']//td//span[@class ='lnr lnr-pencil']"
    Edit_name = "//input[@name ='name-vi-VN']"
    Icon_delete ="//td[contains(text(),'--- Nguyễn Thị Mai Dung')]//ancestor:: tr[@class ='bg-gray']//td//span[@class ='lnr lnr-trash']"
    Btndelete = "//button[contains (text(),'Đồng ý')]"


    OpenThanhMenu(){
        this.ScollElement(this.OpenQL_thanhmenu)
        this.ClickElement(this.OpenQL_thanhmenu)
        return this
    }

    ClickbtnThemmoi(){
        this.ClickElement(this.Btncreate)
        return this
    }

    InpTenmenu(tenmenu:string){
        this.InputElement(this.Tenmenu,tenmenu)
        return this
    }

    InpMenucha(menucha:string){
        this.InputElement(this.Menucha,menucha)
        return this
    }

    InpKieumenu(kieumenu:string){
        this.InputElement(this.Kieumenu,kieumenu)
        return this
    }

    CheckboxVitri(){
        this.ClickElement(this.Vitri_Homepage)
        return this
    }

    Uploadimage(image:string){
        this.Uploadfile(this.Image,image)
        return this
    }

    ClickBtnluu(){
        this.ClickElement(this.BtnLuu)
        this.Sleep()
        return this
    }

    ClickiconEdit(){
        this.ClickElement(this.Icon_edit)
        return this
    }

    Editedmenu(value:string){
        this.InputElement(this.Edit_name,value)
        return this
    }

    DeletedMenu(){
        this.ClickElement(this.Icon_delete)
        this.ClickElement(this.Btndelete)
    }
 
}
