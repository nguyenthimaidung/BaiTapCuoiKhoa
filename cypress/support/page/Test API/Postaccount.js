export class postaccount{
    
    constructor(){

    }
    APIaddacount(){
        let accesstoken = 'eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJ1bmlxdWVfbmFtZSI6Ik1haUR1bmciLCJlbWFpbCI6ImR1bmdudG1Adm1vZGV2LmNvbSIsInN1YiI6ImR1bmdudG1Adm1vZGV2LmNvbSIsImp0aSI6IjBhOTU0MzFkLWFlZjgtNDc2OC05ZTE1LWY0ODI5M2FlZjZiMyIsImlkIjoiZWM0YTAzYWYtNWMwNC00ZTM0LWJmMmMtZmU1OWNhMmVjNDIzIiwibmJmIjoxNjgxMjg5MzUxLCJleHAiOjE2ODEzMTA5NTEsImlhdCI6MTY4MTI4OTM1MX0.GD2bEg1IAAilva_sR7tWYs3H71cvdPG2qS_GeWfTiZrc0oK6Qz3INxLom2iyrRbBVxZGWNsmgaHwPFxjv2-Vdg'
        cy.request({
            method: 'POST',
            url: 'https://admin-swagger-dev.appigv.vmo.group/api/Account',
            headers: {
                'Authorization': 'Bearer ' + accesstoken
            
            },
            body: {
                "userName": "Thanh1252331qw11",
                "firstName": "Nguyen5nnnqw11",
                "lastName": "Thanh233qw452",
                "email": "12342452432wq3e@gmail.com",
                "phoneNumber": "0387458652",
                "birthday": "2023-04-12T06:57:49.311Z",
                "isActive": true,
                "fullName": "NguyenThanh2542qw34111",
                "groupIds": ["3AB42B76-88C3-4C64-8122-8921C8A0CB13"]
            }
        }).then((res) => {
            expect(res.status).to.eq(200);}
        )
    }
}
