
const URL = "https://admin-swagger-dev.appigv.vmo.group/api/"
let datatest
beforeEach(() => {
    cy.fixture("example").then((data) => {
        datatest = data;
    })

})

export class Login {
    static accessToken;
    static userID;
    constructor() { }

    //Login

    Apilogin() {
        // let accessToken = ""
        cy.request({

            method: 'POST',
            url: `${URL}Auth/login`,
            Headers: {},
            body: {
                "userName": datatest.username,
                "password": datatest.password
            }

        }).then((res) => {
            expect(res.status).to.eq(200);

        })
            // get list 
            .then((res) => {
                this.accessToken = res.body.token
                cy.request({
                    method: 'GET',
                    url: 'https://admin-swagger-dev.appigv.vmo.group/api/Account/list',
                    headers: {
                        'Authorization': 'Bearer ' + this.accessToken
                    },
                    body: {}
                }).then((res) => {
                    expect(res.status).to.eq(200);
                })
            })
            //Post account

            .then((res) => {
                let curentUserName = "Dung" + this.getCurrentTime();
                //accessToken = res.body.token
                //let userID;
                cy.request({
                    method: 'POST',
                    url: 'https://admin-swagger-dev.appigv.vmo.group/api/Account',
                    headers: {
                        'Authorization': 'Bearer ' + this.accessToken
                    },
                    body: {
                        "userName": curentUserName,
                        "firstName": "Nguyen" + this.getCurrentTime(),
                        "lastName": "dieulinh" + this.getCurrentTime(),
                        "email": "test" + this.getCurrentTime() + "@gmail.com",
                        "phoneNumber": "0387438652",
                        "birthday": "2023-04-12T06:57:49.311Z",
                        "isActive": true,
                        "fullName": "tester" + this.getCurrentTime(),
                        "groupIds": ["3AB42B76-88C3-4C64-8122-8921C8A0CB13"]
                    }
                }).then((res) => {
                    expect(res.status).to.eq(200);
                })

                    //getID
                    .then((res) => {
                        //console.log(res);
                        this.userID = res.body
                        cy.request({
                            method: 'GET',
                            url: 'https://admin-swagger-dev.appigv.vmo.group/api/Account/' + this.userID,
                            headers: {
                                'Authorization': 'Bearer ' + this.accessToken
                            }
                        }).then((res) => {
                            const data = res.body;
                            expect(res.status).to.eq(200);
                            expect(res.body).to.property("userName", curentUserName)
                            // expect(data).to.have.property("email", "1234e@gmail.com")
                        })
                    })
                    //Put account
                    .then((res) => {
                        //const userId = res.body
                        cy.request({
                            method: 'PUT',
                            url: 'https://admin-swagger-dev.appigv.vmo.group/api/Account/' + this.userID,
                            headers: {
                                'Authorization': 'Bearer ' + this.accessToken
                            },
                            body: {
                                "fullName": "ngocmai1" + this.getCurrentTime(),
                                "phoneNumber": "0444555598",
                            },
                        }).then((res) => {
                            const data = res.body;
                            expect(res.status).to.eq(200);

                        })
                    })
                    //Delete account

                    .then(() => {
                        cy.request({
                            method: 'DELETE',
                            url: 'https://admin-swagger-dev.appigv.vmo.group/api/Account/' + this.userID,
                            headers: {
                                'Authorization': 'Bearer ' + this.accessToken
                            },
                        }).then((res) => {
                            expect(res.status).to.eq(200)
                        })
                    })

            })
            .then((res) => {
                cy.request({
                    method: 'DELETE',
                    url: 'https://admin-swagger-dev.appigv.vmo.group/api/Account/multiple',
                    params: {
                        'ids': 'e85f7b78-7e21-4ebf-b3f2-e518a38d4413',
                        'ids': 'b8749704-bf9c-40aa-82ca-0f2b9d6e6695',
                    },
                    headers: {
                        'Authorization': 'Bearer ' + this.accessToken

                    }
                }).then(() => {
                    expect(res.status).to.eq(200)
                })

            })

    }

    //27_16_13_10
    getCurrentTime() {
        var currentDate = new Date();
        var dateTime = currentDate.getDate() + "_" + currentDate.getHours() + "_" + currentDate.getMinutes() + "_" + currentDate.getSeconds();
        return dateTime;
    }
}


