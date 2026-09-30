# SauceDemo Selenium Automation Framework

A Java-based UI automation framework built with **Selenium WebDriver, TestNG, Maven, and ExtentReports** for testing the SauceDemo web application.

The framework is structured using the **Page Object Model (POM)** and supports **parallel cross-browser execution**.

## Tech Stack

* **Java**
* **Selenium WebDriver**
* **TestNG**
* **Maven**
* **ExtentReports**
* **Git / GitHub**

## Framework Structure

```text
SauceDemoAutomation/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── factory/
│   │   │   │   └── DriverFactory.java
│   │   │   │
│   │   │   ├── pages/
│   │   │   │   ├── LoginPage.java
│   │   │   │   ├── ProductsPage.java
│   │   │   │   ├── CartPage.java
│   │   │   │   └── CheckoutPage.java
│   │   │   │
│   │   │   └── utils/
│   │   │       ├── WaitUtils.java
│   │   │       └── ConfigReader.java
│   │   │
│   │   └── resources/
│   │       └── config.properties
│   │
│   └── test/
│       └── java/
│           ├── data/
│           │   └── TestData.java
│           │
│           ├── listeners/
│           │   └── ExtentReportListener.java
│           │
│           └── tests/
│               ├── BaseTest.java
│               ├── LoginTests.java
│               ├── ProductTests.java
│               ├── CartTests.java
│               └── CheckoutTests.java
│
├── testng.xml
├── pom.xml
└── README.md
```

## Test Coverage

The framework currently covers the following areas:

### Login

* Valid login
* Invalid password
* Empty username validation

### Products

* Product page verification
* Product count verification
* Add product to cart
* Remove product from cart
* Product sorting

### Cart

* Verify added product
* Remove product
* Add multiple products

### Checkout

* Complete checkout flow
* First name validation
* Last name validation
* Postal code validation

Checkout validation scenarios are implemented using a **TestNG DataProvider**.

## Framework Features

### Page Object Model

Page-specific locators and actions are separated from test logic.

```text
Test → Page Object → Selenium WebDriver
```

This keeps the test classes focused on test scenarios while page classes handle UI interactions.

### Explicit Waits

Reusable explicit wait methods are centralized in `WaitUtils`.

Examples include:

* Element visibility
* Element clickability
* Element invisibility
* URL conditions

### Cross-Browser Execution

The framework supports:

* Chrome
* Firefox
* Edge

Browser selection is handled through TestNG parameters and `DriverFactory`.

### Parallel Execution

Chrome and Firefox test suites can run in parallel using TestNG.

The WebDriver instance is managed using `ThreadLocal<WebDriver>` so each execution thread gets its own driver instance.

### Data-Driven Testing

TestNG `@DataProvider` is used for checkout validation scenarios where the same test flow is executed with different input combinations.

### Reporting

ExtentReports generates an HTML execution report containing test results and execution status.

Report location:

```text
test-output/ExtentReport.html
```

## Running the Tests

### Prerequisites

Make sure the following are installed:

* Java
* Maven
* Git

Verify the installations:

```bash
java -version
mvn -version
git --version
```

### Run the TestNG Suite

From the project root:

```bash
mvn clean test
```

The Maven Surefire configuration executes the `testng.xml` suite.

## Browser Configuration

Browser execution is configured in `testng.xml`.

Example:

```xml
<test name="Chrome Tests">
    <parameter name="browser" value="chrome"/>
</test>

<test name="Firefox Tests">
    <parameter name="browser" value="firefox"/>
</test>
```

Additional browser configurations can be added through `DriverFactory`.

## Reporting

After execution, open:

```text
test-output/ExtentReport.html
```

The report provides an overview of the executed tests and their status.

## Application Under Test

The framework is built against:

**SauceDemo**

```text
https://www.saucedemo.com/
```

## Purpose

This project was built to practice and demonstrate practical UI automation concepts including:

* Selenium WebDriver
* TestNG test design
* Page Object Model
* Explicit waits
* Data-driven testing
* Cross-browser testing
* Parallel execution
* Maven test execution
* HTML test reporting

## Future Improvements

Potential additions to the framework include:

* Automatic failure screenshots
* Screenshot attachment to ExtentReports
* CI execution with GitHub Actions
* Environment-specific configuration
* More reusable test utilities
* Additional negative and edge-case scenarios
