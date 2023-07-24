Feature: API test cases for Bank API endpoint health check

@HealthCheck
Scenario: perform health check - return all customers
    Given Execute Test Case "Bank API Health Check 001 : Perform Health Check - Return All Customers"
    When Perform GET operation for endpoint "/bank-api/customer/all" and verify status is 200 and get response

@HealthCheck
Scenario: perform health check - return customer by fullname
    Given Execute Test Case "Bank API Health Check 002 : Perform Health Check - Return Customer By Full Name"
    Given Customer firstname is "John" and secondname is "Doe"
    When Perform GET operation for endpoint "/bank-api/customer/name" and verify status is 200 and get response

@HealthCheck
Scenario: perform health check - return customer by secondname
    Given Execute Test Case "Bank API Health Check 003 : Perform Health Check - Return Customer By Second Name"
    Given Customer firstname is "" and secondname is "Doe"
    When Perform GET operation for endpoint "/bank-api/customer/name" and verify status is 200 and get response

@HealthCheck
Scenario: perform health check - return customer by ID
    Given Execute Test Case "Bank API Health Check 004 : Perform Health Check - Return Customer By ID"
    Given Customer ID is "64bc0aabd31b687f5c6effdd"
    When Perform GET operation for endpoint "/bank-api/customer/{id}" and verify status is 200 and get response

@HealthCheck
Scenario: perform health check - post new customer
    Given Execute Test Case "Bank API Health Check 005 : Perform Health Check - Post New Customer"
    Given Customer firstname is "Bruce" and secondname is "Wayne" and email is "BruceWayne@wayne.com" and deposit is 1000000
    When Perform POST operation for endpoint "/bank-api/customer" and verify status is 201 and get response
