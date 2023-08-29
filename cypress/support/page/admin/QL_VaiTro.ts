import { BasePage } from "../../Base/Base";

export class QL_VaiTro extends BasePage {
    Open_QL_vaitro ="//a//span[contains(text(),'Quản lý vai trò')]"
    Btn_Themmoi ="//button[contains(text(),'Thêm mới')]"
    Textbox_vaitro = "//input[@placeholder ='Vai trò']"
    Trangthai = "//div[@class='ant-select-selector']"
    Select_trangthai = "//div[contains(text(),'TT')]"
    Checkbox_ALL ="//div[@class= 'sc-eqrNMX fnEhMr']//input[@type='checkbox']"
    Btn_Luu = "//button[@type = 'submit']"
    Btn_themthanhvien = "//button[contains(text(),'Thêm thành viên')]"
    Search_email ="//input[@placeholder ='Tìm kiếm theo ID, Họ và tên và Email...']"
    Select_User ="(//td//input[@type='checkbox'])[1]"
    Btn_themvaovaitro ="//button[contains(text(),'Thêm vào vai trò')]"


    Open_screen_QLvaitro (){
        this.ClickElement(this.Open_QL_vaitro)
        return this
    }

    Click_Btn_Themmoi(){
        this.ClickElement(this.Btn_Themmoi)
        return this
    }

    Inp_Vaitro(vaitro:string){
        this.InputElement(this.Textbox_vaitro,vaitro)
        return this 
    }

    Dropdown_Trangthai(trangthai:string){
        this.ClickElement(this.Trangthai)
        this.ClickElement(this.Select_trangthai.replace("TT",trangthai))
        return this
    }

    Select_checkbox(){
        this.ClickElement(this.Checkbox_ALL)
        return this
    }

    Click_Btn_Luu(){
        this.ClickElement(this.Btn_Luu)
        return this
    }

    Search_Thanhvien(thanhvien:string){
        this.ClickElement(this.Btn_themthanhvien)
        this.InputElement(this.Search_email,thanhvien)
        this.ClickElement(this.Select_User)
        this.ClickElement(this.Btn_themvaovaitro)
        this.Sleep()
        return this
    }



}