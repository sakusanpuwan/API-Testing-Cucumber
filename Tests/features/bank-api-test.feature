Feature: API test cases for Bank API endpoint health check

@HealthCheck
Scenario: perform health check - return all customers
    Given Execute Test Case "Bank API Health Check 001 : Perform Health Check - Return All Customers"
    When Perform GET operation for endpoint "/bank-api/customer" and verify status is 200 and get response