
export class getlist{
    
    constructor(){

    }
    APIgetlist(){
        let accesstoken = 'eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6Ik1haUR1bmciLCJlbWFpbCI6ImR1bmdudG1Adm1vZGV2LmNvbSIsInN1YiI6ImR1bmdudG1Adm1vZGV2LmNvbSIsImp0aSI6ImE4ZGI3MzAwLWM2OGYtNDczMy1hZmQ4LTA4YzJiZjAxZTM5ZiIsImlkIjoiZWM0YTAzYWYtNWMwNC00ZTM0LWJmMmMtZmU1OWNhMmVjNDIzIiwibmJmIjoxNjgxMjYzODk3LCJleHAiOjE2ODEyODU0OTcsImlhdCI6MTY4MTI2Mzg5N30.Iidz9ccAkRFLfbsPUBW-HUVPc40mX0gv77T9DV8HaS7e1q_rAZ7KEHTk0nM1_oOFNdATKQkgHQS-sGG2AcDyHw'
        
        let url1 = 'https://admin-swagger-dev.appigv.vmo.group/api/Account/list'

        let header1 ={
            'Authorization': 'Bearer '+ accesstoken
        }

        let body1 = {}

        cy.request({
            method: 'GET',
            url: url1,
            headers: header1,
            body: body1


        }).then((res)=>{
            expect(res.status).to.eq(200);
        }
        )
    }
}
