# SauceDemo Selenium Automation

A Java-based Selenium automation framework for testing the [SauceDemo](https://www.saucedemo.com/) web application using Selenium WebDriver, TestNG, Maven, and Jenkins.

The framework follows the **Page Object Model (POM)** and supports cross-browser and parallel test execution.

## 🛠 Tech Stack

* **Java**
* **Selenium WebDriver**
* **TestNG**
* **Maven**
* **Jenkins**
* **ExtentReports**
* **Git & GitHub**
* **Page Object Model (POM)**

## 📁 Project Structure

```text
sauce-demo-automation/
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
│   │   │       ├── ConfigReader.java
│   │   │       └── WaitUtils.java
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
├── test-output/
├── pom.xml
├── testng.xml
└── README.md
```

## 🧪 Test Coverage

### Login

* Valid login
* Invalid password
* Empty username validation

### Products

* Verify products page
* Verify product count
* Verify page title
* Add product to cart
* Remove product from cart
* Product sorting

### Cart

* Verify added product
* Remove product from cart
* Add and verify multiple products

### Checkout

* Complete checkout flow
* First name validation
* Last name validation
* Postal code validation

Checkout validation scenarios use **TestNG DataProvider** for data-driven testing.

## 🏗 Framework Features

### Page Object Model

Page-specific locators and actions are separated from test classes.

For example:

```text
LoginTests
     ↓
LoginPage
     ↓
SauceDemo Login UI
```

This makes the framework easier to maintain when application elements change.

### Explicit Waits

Reusable explicit wait methods are implemented through `WaitUtils`.

The framework uses waits for conditions such as:

* Element visibility
* Element clickability
* Element invisibility
* URL changes

### Cross-Browser Testing

The framework supports:

* Chrome
* Firefox
* Edge

The browser is supplied through the TestNG XML configuration.

### Parallel Execution

Chrome and Firefox test suites can run in parallel using TestNG.

```xml
<suite parallel="tests" thread-count="2">
```

`ThreadLocal<WebDriver>` is used in `DriverFactory` to maintain separate WebDriver instances during parallel execution.

### Data-Driven Testing

TestNG `@DataProvider` is used for checkout validation scenarios.

This allows multiple input combinations to be executed using the same test method.

### Reporting

The framework uses **ExtentReports** to generate an HTML test report.

For failed tests, a Selenium screenshot is captured and embedded directly into the report.

### Configuration

Application configuration is maintained separately in:

```text
src/main/resources/config.properties
```

Example:

```properties
url=https://www.saucedemo.com/
```

## 🚀 Running Tests Locally

### Run the complete TestNG suite

```bash
mvn clean test
```

The Maven Surefire plugin executes the configured `testng.xml` suite.

### Run with a specific browser

Browser selection is controlled through TestNG parameters.

Example:

```xml
<parameter name="browser" value="chrome"/>
```

Supported values:

```text
chrome
firefox
edge
```

## 🔄 Jenkins CI

The project is integrated with Jenkins for continuous integration.

The current workflow is:

```text
Git push
    ↓
GitHub (master)
    ↓
Jenkins SCM Polling
    ↓
Maven
    ↓
TestNG
    ↓
Selenium WebDriver
    ↓
ExtentReports
    ↓
Jenkins archived report
```

Jenkins automatically checks the GitHub repository for changes and runs:

```bash
mvn clean test
```

A failed test causes the Jenkins build to be marked as **FAILURE**, while a successful test run results in a **SUCCESS** build.

## 📊 Test Execution

The framework is designed to demonstrate:

* Functional UI automation
* Regression testing
* Cross-browser testing
* Parallel execution
* Data-driven testing
* Explicit synchronization
* Test reporting
* Failure screenshots
* CI execution through Jenkins

## 🎯 Project Purpose

This project was built to practice and demonstrate practical Selenium automation framework development using Java and TestNG.

The focus is on creating a maintainable test structure rather than simply writing individual Selenium scripts.

## 🔮 Future Improvements

Possible future improvements include:

* Additional checkout and product validations
* More negative test scenarios
* API testing integration
* Improved test data management
* Additional CI/CD improvements
* Enhanced reporting and test execution dashboards
