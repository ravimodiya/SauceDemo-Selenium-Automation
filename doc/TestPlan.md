# SauceDemo — Test Plan

## 1. Project Overview

**Project:** SauceDemo Web Application
**Testing Project:** Selenium Automation Framework
**Application Under Test:** https://www.saucedemo.com/
**Test Approach:** Manual testing and UI automation
**Status:** In progress

## 2. Objectives

* Verify core user workflows, including login, product browsing, cart management and checkout.
* Validate positive and negative scenarios.
* Verify product sorting, cart contents and checkout validation.
* Automate repeatable regression scenarios using Selenium WebDriver and Java.
* Produce execution results and defect evidence.

## 3. Scope of Testing

### In Scope

* Authentication and login validation
* Product listing and sorting
* Adding and removing products from the cart
* Cart item verification
* Checkout information validation
* Checkout completion
* Browser compatibility for configured browsers
* Regression testing of implemented workflows

### Out of Scope

* Production database validation
* Payment gateway integration with real payment details
* Security penetration testing
* Load and performance testing
* Backend API testing unless separately implemented

## 4. Test Approach

* Manual exploratory testing to identify unexpected behavior.
* Functional testing of key user workflows.
* Negative testing using invalid or missing input.
* Regression testing after application or framework changes.
* Automated UI tests using Selenium WebDriver, Java and TestNG.
* Data-driven testing using JSON, Excel and a database-backed test-data provider.

## 5. Test Environment

* Operating system: Windows
* Language: Java
* Automation: Selenium WebDriver
* Test runner: TestNG
* Build tool: Maven
* Reporting: ExtentReports
* Browsers: Chrome, Firefox and Edge, subject to availability
* CI execution: Jenkins

## 6. Entry Criteria

* Application is accessible.
* Test environment and browser are available.
* Required dependencies are configured.
* Test data is available.
* Test cases have defined expected results.

## 7. Exit Criteria

* Planned test cases have execution results recorded.
* Critical failures have been investigated.
* Defects and unresolved risks are documented.
* Test results and known limitations are summarized.

## 8. Risks and Mitigations

| Risk                          | Mitigation                                                   |
| ----------------------------- | ------------------------------------------------------------ |
| Timing-related UI failures    | Use explicit waits and stable locators                       |
| Test data changes             | Maintain data in controlled test-data sources                |
| Browser-specific behavior     | Execute the configured browser suites                        |
| Unstable external application | Record environment issues separately from confirmed defects  |
| Parallel test interference    | Use isolated WebDriver instances and review shared resources |

## 9. Deliverables

* Test plan
* Test scenarios and detailed test cases
* Requirements traceability matrix
* Defect reports
* Automated test framework
* Test execution summary and reports

## 10. Approval

This document describes the planned testing approach. Execution status and release recommendations must be based on actual recorded test results.
