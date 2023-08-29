
import { slice } from "../../../../node_modules/cypress/types/lodash/index";
import { BasePage } from "../../Base/Base";

export class QL_danhgia extends BasePage {

    Open_Qldanhgia = "//a//span[contains(text(),'Quản lý đánh giá')]"
    Btn_Themmoi = "//button[contains(text(),'Thêm mới')]"
    Sanpham = "//div[contains(text(),'Chọn khóa học')]/../.."
    Option_Sanpham = "//div[contains(text(), 'sanpham')]"
    HoTen = "//input[@name = 'fullName']"
    Date = "//input[@placeholder= 'MM/DD/YY']"
    Selectdate = "//div[@aria-label = 'date']"
    Email = "//input[@name= 'email']"
    Phonenumber = "//input[@name= 'phoneNumber']"
    Rate_star = "//div[@aria-posinset= '4']"
    Noidungdanhgia = "//textarea[@name= 'content']"
    Image = "//input[@type= 'file']"
    Btn_Luu = "//button[contains(text(),'Lưu')]"
    Btn_Huy = "//button[contains(text(),'Hủy')]"
    Textbox_Search = "//input[@placeholder ='Tìm kiếm theo tên người dùng, Email, SĐT']"
    Icon_edit = "(//span[@class='lnr lnr-pencil'])[1]"
    Icon_delete = "(//span[@class='lnr lnr-trash'])[1]"
    Btn_Dongy ="//button[contains(text(),'Đồng ý')]"


    Openscreendanhgia(){
        this.ClickElement(this.Open_Qldanhgia)
        return this
    }

    Clickbtn_Themmoi(){
        this.ClickElement(this.Btn_Themmoi)
        return this
    }

    Select_inp_sanpham(sanpham:string){
        this.ClickElement(this.Sanpham)
        // this.ChangeValueInDropdown(this.Inpsanpham,sanpham)
        this.ClickElement((this.Option_Sanpham.replace("sanpham", sanpham)))
        return this
    }

    Inp_Hoten(hoten:string){
        this.InputElement(this.HoTen,hoten)
        return this
    }

    Select_date(time:string){
        this.ClickElement(this.Date)
        this.ClickElement(this.Selectdate.replace("date",time))
        return this
    }

    Inp_Email(email:string){
        this.InputElement(this.Email,email)
        return this
    }

    Inp_phone(phone:string){
        this.InputElement(this.Phonenumber,phone)
        return this
    }

    Select_rate(){
        this.ClickElement(this.Rate_star)
        return this
    }

    Inp_Noidung(noidung:string){
        this.InputElement(this.Noidungdanhgia,noidung)
        return this
    }

    Upload_image(image){
        this.Uploadfile(this.Image,image)
        this.Sleep()
        return this
    }

    ClickbtnLuu_Huy(){
        this.ClickElement(this.Btn_Luu)
        this.Sleep()
        this.ClickElement(this.Btn_Huy)
        return this
    }

    Serach_DanhGia(danhgia:string){
        this.InputElement(this.Textbox_Search,danhgia)
        this.Sleep()
        return this
    }

    Edit_danhgia(edit_hoten:string){
        this.ScollElement(this.Icon_edit)
        this.ClickElement(this.Icon_edit)
        this.Sleep()
        this.InputElement(this.HoTen,edit_hoten)
        this.ClickElement(this.Btn_Luu)
        return this
    }

    Delete_danhgia(){
        this.ClickElement(this.Icon_delete)
        this.ClickElement(this.Btn_Dongy)
    }
}