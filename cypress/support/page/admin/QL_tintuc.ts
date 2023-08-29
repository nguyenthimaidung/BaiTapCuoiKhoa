import { BasePage } from "../../Base/Base";

export class QL_tintuc extends BasePage  {

    qltintuc = "(//span[contains(text(),'Quản lý tin tức')])[1]"
    Btncreate = "//button[contains(text(),'Thêm mới')]"
    Tieude ="(//input[@placeholder='Tiêu đề bài viết'])[1]"
    Motangan = "(//textarea[@placeholder='Mô tả ngắn'])[1]"
    Noidung ="(//div[@class ='public-DraftStyleDefault-block public-DraftStyleDefault-ltr'])[1]"
    Tukhoa = "(//input[@name ='metaKeywords'])[1]"
    URL = "(//input[@name ='url'])[1]"
    Image = "(//input[@name ='image'])[1]"
    Tacgia = "(//input[@name ='author'])[1]"
    Chuyenmuc = "//div[@class = 'react-select__control css-yk16xz-control']"
    ChuyenmucInp = "//div[@class = 'react-select__input']"
    Tinnoibat ="(//span[@class ='sc-dVgrWH jTpdNt'])[1]"
    Trangchu = "(//span[@class ='sc-dVgrWH jTpdNt'])[2]"
    Hienthi = "(//span[@class ='sc-dVgrWH jTpdNt'])[3]"
    BtnLuu = "//button[contains(text(),'Lưu')]"


    OpenscreenQLtintuc (){
        this.ClickElement(this.qltintuc)
        return this
    }
//Thêm mới tin tức
    
    Clickbtncreate(){
        this.ClickElement(this.Btncreate)
        return this
    }

    InpTieude(tieude:string){
        this.InputElement(this.Tieude,tieude)
        return this
    }

    InpMota(mota:string){
        this.InputElement(this.Motangan,mota)
        return this
    }

    InpNoidung(noidung:string){
        this.InputElement(this.Noidung,noidung)
        return this
    }

    InpTukhoa(tukhoa:string){
        this.InputElement(this.Tukhoa,tukhoa)
        return this
    }

    InpUrl(url:string){
        this.InputElement(this.URL,url)
        return this
    }

    InpImage(image:string){
        this.Uploadfile(this.Image,image)
        return this
    }

    InpTacgia(tacgia:string){
        this.InputElement(this.Tacgia,tacgia)
        return this
    }

    InpChuyenmuc(chuyenmuc:string){
        this.ClickElement(this.Chuyenmuc)
        this.InputElement(this.ChuyenmucInp,chuyenmuc)
        return this
    }

    Clickcheckbox() {
        this.ClickElement(this.Tinnoibat)
        return this
    }   
 
    Clickbtnluu(){
        this.ClickElement(this.BtnLuu)
        return this
    }
    // Themmoitintuc(tieude:string, mota:string,noidung:string,tukhoa:string,url:string,image:string,tacgia:string,chuyenmuc:string){
    //     this.ClickElement(this.Btncreate)
    //     this.InputElement(this.Tieude,tieude)
    //     this.InputElement(this.Motangan,mota)
    //     this.InputElement(this.Noidung,noidung)
    //     this.InputElement(this.Tukhoa,tukhoa)
    //     this.InputElement(this.URL,url)
    //     this.Uploadfile(this.Image,image)
    //     this.InputElement(this.Tacgia,tacgia)
    //     this.ClickElement(this.Chuyenmuc)
    //     this.InputElement(this.Chuyenmuc,chuyenmuc)
    //     this.Checkbox(this.Tinnoibat)
    //     return this
    // }
}