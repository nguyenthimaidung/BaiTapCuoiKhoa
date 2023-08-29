import { BasePage } from "../../../Base/Base";

export class Bannerslider extends BasePage{

    QLnoidunganh = "//span[contains(text(),'Quản lý nội dung ảnh')]"
    TabBanner = "//a[contains(text(),'Banner, slider')]"
    Btncreate ="//div[@class ='sc-FsWDG ktnmF']//button[contains(text(),'Thêm mới')]"
    Bannername ="//input[@placeholder = 'Tên Banner, Slider']"
    LoaiBaner ="//span[@class ='ant-select-selection-search']//input[@id= 'type']"
    selectloaibanner ="//div[contains(text(),'Banner chi tiết tin tức')]"
    ImageBanner = "//input[@id ='upload']"
    Icondeleteinmage ="//span[@class ='sc-dWhrIX fCiahv lnr lnr-trash']"
    LinkBanner = "//input[@id ='linkUrl']"
    BtnLuu ="//p[contains(text(),'Lưu')]"
    FilterBanner ="//div[@class ='ant-select-selector']"
    SelectBanner ="//div[@title ='Banner chi tiết tin tức']"
    Title ="//p[contains(text(),'Quản lý banner/ slider')]"
    TextboxSearch = "//input[@placeholder = 'Tìm kiếm theo tên banner/ slider']"
    Icon_edit="(//div[@class='sc-gOqtQ jXGOEd']//span[@class='lnr lnr-pencil'])[1]"
    Selectcheckbox ="(//input[@class='cursor-pointer'])[1]"
    BtnDeleted ="//button[contains(text(),'Xóa')]"
    Text_popupdelete ="//p[@class='sc-llcuoN enUkPx']"
    Btnsubmitdeleted = "//button[contains(text(),'Đồng ý')]"
    Drop1 = "//tbody[@data-rbd-droppable-id='banner-list']/tr[1]"
    drop2 = "//tbody[@data-rbd-droppable-id='banner-list']/tr[2]"


    OpentabBanner(){
        this.ClickElement(this.TabBanner)
        return this
    }

    Checkcolortitle(value_1:string, value_2:string){
        this.Checkcolor(this.Title,value_1,value_2)
        return this
    }

 //Create Banner, Slider

    Clickbtncreate(){
        this.waitForElementIsVisible(this.Btncreate)
        this.waitforElementEnable(this.Btncreate)
        this.ClickElement(this.Btncreate)
        return this
    }

    Filldatatextbox(Bannername:string,LinkBanner:string){
        this.InputElement(this.Bannername,Bannername)
        this.InputElement(this.LinkBanner,LinkBanner)
        return this
    }

    SelectLoaibanner(){
        this.ClickElement(this.LoaiBaner)
        this.ClickElement(this.selectloaibanner)
        return this
    }

    Uploadimage(image:string){
        this.Uploadfile(this.ImageBanner,image)
        this.Sleep()
        return this
    }

    Deleteimage(){
        this.ClickElement(this.Icondeleteinmage)
        return this
    }

    ClickbtnLuu(){
        this.ClickElement(this.BtnLuu)
        this.Sleep()
        return this
    }

    Checkfilterandsearch (datasearch:string){
        this.ClickElement(this.FilterBanner)
        this.ClickElement(this.SelectBanner)
        this.InputElement(this.TextboxSearch,datasearch)
        this.Sleep()
        return this
    }
//Update banner
    EditBanner(){
        this.ClickElement(this.Icon_edit)
        this.Cleardata(this.LinkBanner)
        this.ClickElement(this.BtnLuu)
        this.Sleep()
        return this
    }

//Deleted banner
    Deletebanner(value1:string, value2:string){
        this.ClickElement(this.Selectcheckbox)
        this.ClickElement(this.BtnDeleted)
        this.gettext(this.Text_popupdelete)
        this.Checkcolor(this.Text_popupdelete,value1, value2)
        this.ClickElement(this.Btnsubmitdeleted)
        return this
    }

    DragAndDropElement() {
        cy.xpath(this.drop2).drag(this.Drop1);
    }

    
}