import { BasePage } from "../../../Base/Base";

export class Camnhankhachang extends BasePage{

    QLnoidunganh = "//span[contains(text(),'Quản lý nội dung ảnh')]"
    TabBanner = "//a[contains(text(),'Banner, slider')]"
    Iconedit = "(//div[@class = 'sc-jEPKcg kECrTJ']//span[@style ='font-size: 1rem;'])[1]"
    Btncreate = "//div[@class ='sc-ivajeS eSFYHi']//button[contains(text(),'Thêm mới')]"
    Popupcreate = "//div[@class ='modal-dialog']"
    Tennguoidanhgia = "//input[@placeholder ='Tên người đánh giá']"
    E_tendanhgia = "//input[@id='name']"
    UploadImage = "//input[@type='file']"
    Uploadedimage = "//div[@class ='upload_row']//p"
    Icondeleteimage ="//div[@class ='upload_row']//span"
    Chuvu = "(//input[@placeholder ='Nhập chức vụ'])[3]"
    Danhgia = "(//textarea[@placeholder ='Nhập đánh giá'])[3]"
    BtnLuu = "//button[@type='submit']"
    Verifyten ="(//tr/td)[1]"
    Icondeletecamnhankhachhang = "(//span[@class ='lnr lnr-trash'])[1]"
    Texpopuptdelete = "//p[@class ='sc-llcuoN enUkPx']"
    Btndongyxoa = "//button[contains(text(),'Đồng ý')]"

    OpenQLnoidunganh (){
        this.ScollElement(this.QLnoidunganh)
        this.ClickElement(this.QLnoidunganh)
        this.Sleep()
        return this
    }

    Clickthemmoi (){
        this.ClickElement(this.Btncreate)
        this.Sleep()
        return this
    }

    InpTennguoidanhgia (value:string){
        this.waitForElementIsVisible(this.Tennguoidanhgia)
        this.waitforElementEnable(this.Tennguoidanhgia)
        this.InputElement(this.Tennguoidanhgia,value)
        return this
    }

    Uploadimage(value:string){
        this.Uploadfile(this.UploadImage,value)
        this.Sleep()
        return this       
    }

    InpChucvu(value:string){
        this.waitForElementIsVisible(this.Chuvu)
        this.waitforElementEnable(this.Chuvu)
        this.InputElement(this.Chuvu,value)
        return this
    }

    Inpdanhgia(value:string){
        this.waitForElementIsVisible(this.Danhgia)
        this.waitforElementEnable(this.Danhgia)
        this.InputElement(this.Danhgia,value)
        return this
    }

    validateuploaded(value:string){
        this.ValidateText(this.Uploadedimage,value)
        return this
    }

    validateicondelete(){
        this.waitForElementIsVisible(this.Icondeleteimage)
        return this
    }

    ClickbtnLuu(){
        this.ClickElement(this.BtnLuu)
        return this
    }

    Verifytennguoidanhgia(value: string){
        this.ValidateText(this.Verifyten,value)
        this.Sleep()
        return this
    }

    Clickiconedited(){
        this.ClickElement(this.Iconedit)
        return this
    }

    E_tennguoidanhgia(value:string){
        this.waitForElementIsVisible(this.E_tendanhgia)
        this.waitforElementEnable(this.E_tendanhgia)
        this.InputElement(this.E_tendanhgia,value)
        this.Sleep()
        return this
    }  

    DeleceCamnhankhachang(){
        this.ClickElement(this.Icondeletecamnhankhachhang)
        return this
    }

    Verifytetextpopupdelete(value:string){
        this.ValidateText(this.Texpopuptdelete,value)
        return this
    }

    Clickdongyxoa(){
        this.ClickElement(this.Btndongyxoa)
        return this
    }




}
