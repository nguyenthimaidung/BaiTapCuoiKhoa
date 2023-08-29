import { BasePage } from "../../Base/Base";

export class QL_ThongBao extends BasePage {

    OpenQL_thongbao = "//a[@class ='sc-ejMzOU dOgLAc']//span[contains(text(),'Quản lý thông báo')]"
    BtnThemMoi = "//button[contains (text(),'Thêm mới')]"
    Datetimepicker ="//input[@placeholder ='dd/mm/yyyy hh:mm:ss']"
    Now = "//a[@class='ant-picker-now-btn']"
    Image = "//input[@name='image']"
    Tieude_VN ="//input[@name='title-vi-VN']"
    btn_OK = "//span[text()='OK']"
    Noidung_VN = "//textarea[@name='description-vi-VN']"
    Link_VN = "//input[@name='linkUrl-vi-VN']"
    BtnLuu = "//button[contains(text(),'Lưu')]"
    Timkiemthongbao = "//input[@placeholder ='Tìm kiếm theo Tiêu đề thông báo']"
    Filtertrangthai ="//span[@class='ant-select-selection-search']"
    Selectoption = "//div[contains(text(),'Chưa gửi')]"
    Checkboxall = "//th//div//input[@type ='checkbox']"
    BtnXoa = "//button[contains(text(),'Xóa')]"
    Text_Popup_xoa = "//p[@class ='sc-llcuoN enUkPx']"
    BtnDongy ="//button[contains(text(),'Đồng ý')]"
    BtnBoloc = "//button[contains(text(),'Bỏ lọc')]"

    OpenScrenThongBao(){
        this.ClickElement(this.OpenQL_thongbao)
        return this
    }

    CLickBtnThemMoi(){
        this.ClickElement(this.BtnThemMoi)
        return this
    }

    SelectTime(time:string){
        this.InputElement(this.Datetimepicker,time)
        this.ClickElement(this.btn_OK)
        return this
    }

    // SelectTime(){
    //     this.ClickElement(this.Datetimepicker)
    //     this.waitForElementIsVisible(this.Datetimepicker)
    //     this.ClickElement(this.Now)
    //     this.Sleep
    //     return this
    // }

    UploadImage(image:string){
        this.Uploadfile(this.Image,image)
        this.Sleep
        return this
    }

    Tieudethongbao(tieude:string){
        this.InputElement(this.Tieude_VN,tieude)
        return this
    }

    Noidungthongbao(noidung:string){
        this.InputElement(this.Noidung_VN,noidung)
        return this
    }

    InpLink(link:string){
        this.InputElement(this.Link_VN,link)
        return this
    }

    ClickBtnluu(){
        this.ClickElement(this.BtnLuu)
        return this
    }

    Filterstatus(){
        this.ClickElement(this.Filtertrangthai)
        this.ClickElement(this.Selectoption)
        return this
    }

    Inpsearch(text: string){
        this.InputElement(this.Timkiemthongbao,text)
        this.Sleep()
        return this
    }

    Xoa_all(){
    this.Checkbox(this.Checkboxall)
    this.ClickElement(this.BtnXoa)
    return this
    }

    Verifytext_Popupxoa(value:string){
        this.ValidateText(this.Text_Popup_xoa,value)
        return this
    }

    Click_btndongy(){
        this.ClickElement(this.BtnDongy)
        return this
    }

    Click_btnboloc(){
        this.ClickElement(this.BtnBoloc)
        return this
    }

}