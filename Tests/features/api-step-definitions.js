const { Given, When } = require("@cucumber/cucumber");

const baseURL = 'http://localhost:8080';
let responseData;
let statusCode;
let firstname;
let secondname;
let ID;
let email;
let deposit;

Given('Execute Test Case {string}', async function (testname){
    console.log("----------------------------------------------------------------");
    console.log(`Executing Test Case ${testname}`);
})


Given('Customer firstname is {string} and secondname is {string}', async function (inputFirstName,inputSecondName) {
    firstname = inputFirstName;
    secondname = inputSecondName;
})

Given('Customer ID is {string}', async function (string){
    ID = string;
})

Given('Customer firstname is {string} and secondname is {string} and email is {string} and deposit is {int}', async function(inputFirstName,inputSecondName,inputEmail,inputDeposit) {
    firstname = inputFirstName;
    secondname = inputSecondName;
    email = inputEmail;
    deposit = inputDeposit;
})

When('Perform GET operation for endpoint {string} and verify status is {int} and get response', async function (endpoint,status){
    if (endpoint.includes('name') && firstname.length != 0 && secondname.length != 0) {
        endpoint += `?firstName=${firstname}&secondName=${secondname}`;
    } else if (endpoint.includes('name') && firstname.length == 0 && secondname.length != 0){
        endpoint += `?secondName=${secondname}`;
    }

    if (endpoint.includes('{id}')) {
        endpoint = endpoint.replace('{id}',ID);
    }

    console.log(`Performing GET request for endpoint: ${endpoint}`);
    let getReponse = await performGETRequest(endpoint);
    console.log(responseData);


    if (status == statusCode) {
        console.log(`Status ${status} is verified`);
    } else{
        console.log(`Incorrect status ${statusCode} is obtained`);
    }
})

When('Perform POST operation for endpoint {string} and verify status is {int} and get response', async function (endpoint,status){
    newCustomer = {
        "firstName": firstname,
        "secondName": secondname,
        "email": email,
        "deposit": deposit
    }
    console.log(`Performing POST request for endpoint: ${endpoint}`);
    let postReponse = await performPOSTRequest(endpoint,newCustomer);
    
    console.log(responseData);

    if (status == statusCode) {
        console.log(`Status ${status} is verified`);
    } else{
        console.log(`Incorrect status ${statusCode} is obtained`);
    }

})

async function performGETRequest(endpoint){
    try {
        const response = await fetch(`${baseURL}${endpoint}`);
        const data = await response.json();
        responseData = data;
        statusCode = response.status
    } catch (error) {
        console.log(error);
    }
}

async function performPOSTRequest(endpoint,newCustomer){
    try {
        const response = await fetch(`${baseURL}${endpoint}`,{
            method:"POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(newCustomer)
    });
        const data = await response.json();
        responseData = data;
        statusCode = response.status
    } catch (error) {
        console.log(error);
    }
}

