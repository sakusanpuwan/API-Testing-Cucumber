const { Given, When } = require("@cucumber/cucumber");

const baseURL = 'http://localhost:8080';
let responseData;
let statusCode;

Given('Execute Test Case {string}', async function (testname){
    console.log("----------------------------------------------------------------");
    console.log(`Executing Test Case ${testname}`);
})

When('Perform GET operation for endpoint {string} and verify status is {int} and get response', async function (endpoint,status){
    let getReponse = await performGETRequest(endpoint);
    console.log(responseData);
    console.log(statusCode);
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