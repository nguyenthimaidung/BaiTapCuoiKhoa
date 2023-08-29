//import { describe } from "mocha";
import { getlist } from "../../support/page/Test API/GetList";
import { Login } from "../../support/page/Test API/Login";
import {postaccount} from "../../support/page/Test API/Postaccount";


let testlogin = new Login
let List = new getlist
let account = new postaccount

describe('Test login',() => {
    it('Test login successfully',()=>{
        testlogin.Apilogin()
        //account.APIaddacount()
        //List.APIgetlist()
    })
})
