import {admin} from "../../support/page/admin/admin_login";
import  {Congcuonthi1}  from "../../support/page/admin/Congcuonthi1";
import {Camnhankhachang} from "../../support/page/admin/QL_noidunganh/Camnhankhachang";
import { Bannerslider } from "../../support/page/admin/QL_noidunganh/Bannerslider";
import { QL_tintuc } from "../../support/page/admin/QL_tintuc";
import { QLthanhmenu } from "../../support/page/admin/QL_ThanhMenu";
import { QL_ThongBao } from "../../support/page/admin/QL_ThongBao";
import { QL_danhgia } from "../../support/page/admin/QL_Danhgia";
import { QL_VaiTro } from "../../support/page/admin/QL_VaiTro";

const objadmin = new admin()
const congcu = new Congcuonthi1()
const camnhankhachhang = new Camnhankhachang()
const bannerslider = new Bannerslider()
const Tintuc = new QL_tintuc
const Menu = new QLthanhmenu()
const ThongBao = new QL_ThongBao
const DanhGia = new QL_danhgia
const Vaitro = new QL_VaiTro


let datatest
beforeEach(() => {

    objadmin.Goto("/log_in");

 //get data          
    cy.fixture("example").then((data) => {
        datatest = data;
        objadmin
        .InpUsername(datatest.username)
        .InpPassword(datatest.password)  
        .ClickbuttonSubmit()    
    })

})

// describe('Test fllow',  () => {
    
//     it('test flow 1', () => {
//         //1
//         //cy.visit("/log_in")
//         // objadmin.loginWithUserNameAndPassword("Maidung", "wy2gQD^2G43NQw5")

//         // congcu.Congcuonthicheck()
//         //congcu.clcikonbuttonxoa()
//         //objadmin.openscreenadmin();
//         //cy.xpath("//btton[@type='submit']").click({force: true});
        
//         //2
//         // objadmin
//         //    .InpUsername(datatest.username)
//         //    .InpPassword(datatest.password)
//         //    .ClickbuttonSubmit()

//         congcu
//            .OpenCongCuOnThi()
//            .Selectpage('Hiển thị 20')
//            .ValidatefileterLoaiCongCu()
//            .Selectoptionfilter()
//            .Checkoptiondisplayed(datatest.Benthu3)
//            .ImpSearch(datatest.Datasearch)
//            .SelectCheckbox()
//            .Validatecheckbox()
//            .Status()
//            .VerifybtnDeletedEnbled()    
//            .OpenscreenDetail()
//            .OpentabGiacongcu()
//            .OpentabThongtindong()  
//            .OpentabGiaovien() 
//            .ViewGiaovien()     
//            .Waitdialog().ViewtabEnglish()
//            .Waitdialog().ViewtabKorea()
//            .Waitdialog().ClickBtnHuy()
//     })
// });


// describe('Case_2',  () => {
    
//     it('testcase 2', () => {
             

// //         camnhankhachhang
// //             .OpenQLnoidunganh()
// //             .Clickthemmoi()
// //             .InpTennguoidanhgia(datatest.Tennguoidanhgia)
// //             .Uploadimage('image/2.jpg')
// //             .validateuploaded(datatest.image)
// //             .validateicondelete()
// //             .InpChucvu(datatest.Chucvu)
// //             .Inpdanhgia(datatest.Danhgia)
// //             .ClickbtnLuu()
// //             .Verifytennguoidanhgia(datatest.Verifyten)
// //             .Clickiconedited()
// //             .E_tennguoidanhgia(datatest.E_tennguoidanhgia)
// //             //.ClickbtnLuu()
// //             .DeleceCamnhankhachang()
// //             .Verifytetextpopupdelete(datatest.Texpopupdelete)
// //             .Clickdongyxoa()

//         // bannerslider
//         //     .OpentabBanner()
//         //     .Checkcolortitle('color','rgb(0, 0, 0)')
//         //     .Clickbtncreate()
//         //     .Filldatatextbox(datatest.Bannername,datatest.LinkBannner)
//         //     .SelectLoaibanner()
//         //     .Uploadimage('image/2.jpg')
//         //     .Deleteimage()
//         //     .Uploadimage('image/12.jpeg')
//         //     .ClickbtnLuu()
//         //     .Checkfilterandsearch(datatest.Banner_textsearch)
//         //     .EditBanner()
//         //     .Deletebanner('font-size','16px')

//             Tintuc
//             .OpenscreenQLtintuc()
//             .Clickbtncreate()
//             .InpTieude(datatest.Tieudetintuc)
//             .InpMota(datatest.Motangantintuc)
//             .InpNoidung(datatest.Noidungtintuc)
//             .InpTukhoa(datatest.Tukhoatintuc)
//             //.InpUrl(datatest.URL)
//             .InpImage('image/2.jpg')
//             .InpTacgia(datatest.Tacgia)
//             .InpChuyenmuc(datatest.Chuyenmuc)
//             .Clickcheckbox()
//             .Clickbtnluu()
            
            
//     })
// });


// describe('case_3',() =>{

//     it('test flow 3', () => {
//         Menu
//         .OpenThanhMenu()
//         .ClickbtnThemmoi()
//         .InpTenmenu(datatest.Tenmenu)
//         .InpMenucha(datatest.Menucha)
//         .InpKieumenu(datatest.Kieumenu)
//         .CheckboxVitri()
//         .Uploadimage('image/2.jpg')
//         .ClickBtnluu()
//         .ClickiconEdit()
//         .Editedmenu(datatest.Edit_name)
//         .ClickBtnluu()
//         .DeletedMenu()
//     })

// })

    // describe('Test Thong Bao',() => {
        
    //     it('Thong Bao',() =>{

    //         ThongBao
    //           .OpenScrenThongBao()
    //           .CLickBtnThemMoi()
    //           .SelectTime('08/06/2023 13:51:43')
    //           .UploadImage('image/12.jpeg')
    //           .Tieudethongbao(datatest.Thongbao_tieude)
    //           .Noidungthongbao(datatest.Thongbao_noidung)
    //           .InpLink(datatest.Thongbao_link)
    //           .ClickBtnluu()
    //           .Filterstatus()
    //           .Inpsearch(datatest.Thongbao_tieude)
    //           .Xoa_all()
    //           .Verifytext_Popupxoa(datatest.Text_popup_xoa)
    //           .Click_btndongy()
    //           .Click_btnboloc()

    //     })
    // })

    // describe('Test QL_danhgia', () =>{
    //     it('Test QL_danhgia',() =>{

    //         DanhGia
    //         .Openscreendanhgia()
    //         .Clickbtn_Themmoi()
    //         .Select_inp_sanpham(datatest.Sanpham_danhgia)
    //         .Select_date(datatest.Date)
    //         .Inp_Hoten(datatest.HoTen_danhgia)
    //         .Inp_Email(datatest.Email)
    //         .Inp_phone(datatest.Phone)
    //         .Select_rate()
    //         .Inp_Noidung(datatest.Noidungdanhgia)
    //         .Upload_image("image/2.jpg")
    //         .ClickbtnLuu_Huy()
    //         .Serach_DanhGia(datatest.Search)
    //         .Edit_danhgia(datatest.Edit_HoTen_danhgia)
    //         .Serach_DanhGia(datatest.Search)
    //         .Delete_danhgia()
    //     })
    // })


    describe('Test QL_vaitro', () =>{
        it('Test QL_vaitro',() =>{
            Vaitro
            .Open_screen_QLvaitro()
            .Click_Btn_Themmoi()
            .Inp_Vaitro(`${datatest.Vaitro} ${Date.now()} ${GetTime()}`)
            .Dropdown_Trangthai(datatest.Vaitro_trangthai)
            .Select_checkbox()
            .Click_Btn_Luu()
            .Search_Thanhvien(datatest.Vaitro_Thanhvien)

        })
    })
// var time = GetTime()

// function GetTime() {
//     var currentime = new Date();
//     var datetime = currentime.getDate() + "-"+ currentime.getHours() + "_" + currentime.getMinutes() + "_" + currentime.getSeconds();
//     return datetime;
// }

const GetTime = () => {
    var currentime = new Date();
    var datetime = currentime.getDate() + "_" + currentime.getSeconds();
    return datetime;
}
