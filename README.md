# SauceDemo Selenium Automation

A Selenium WebDriver automation framework built using Java, TestNG, Maven, and the Page Object Model (POM) to test the SauceDemo e-commerce application.

The framework covers login, product management, cart operations, and checkout workflows, with support for data-driven testing, cross-browser execution, parallel testing, and ExtentReports.

## Tech Stack

- Java
- Selenium WebDriver
- TestNG
- Apache Maven
- Page Object Model (POM)
- ExtentReports
- Jackson JSON
- Apache POI
- Jenkins
- Git and GitHub

## Framework Features

- Page Object Model for maintainable test automation
- Functional and input-validation testing
- Explicit waits using `WebDriverWait`
- ThreadLocal WebDriver management for parallel execution
- Cross-browser testing with Chrome, Firefox, and Edge
- TestNG parameters and DataProviders
- JSON-based test data
- Excel-based test data
- Automatic failure screenshots
- ExtentReports test execution reporting
- Maven-based test execution
- Jenkins CI integration

## Project Structure

```text
SauceDemo-Selenium-Automation/
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
│   │   │       ├── ConfigReader.java
│   │   │       ├── JsonDataReader.java
│   │   │       └── ExcelDataReader.java
│   │   │
│   │   └── resources/
│   │       └── config.properties
│   │
│   └── test/
│       ├── java/
│       │   ├── data/
│       │   │   └── TestData.java
│       │   │
│       │   ├── listeners/
│       │   │   └── ExtentReportListener.java
│       │   │
│       │   └── tests/
│       │       ├── BaseTest.java
│       │       ├── LoginTests.java
│       │       ├── ProductTests.java
│       │       ├── CartTests.java
│       │       └── CheckoutTests.java
│       │
│       └── resources/
│           └── testdata/
│               ├── loginData.json
│               └── checkoutData.xlsx
│
├── testng.xml
├── checkouttest.xml
├── pom.xml
└── README.md
```

## Prerequisites

Before running the automation tests, ensure the following are installed:

- **Java JDK** — compatible with the Java version configured in `pom.xml`
- **Apache Maven** — for dependency management and test execution
- **Git** — for cloning the repository
- **Chrome, Firefox, or Edge** — a supported browser
- An internet connection to access SauceDemo and download Maven dependencies when needed

Verify Java and Maven installation:

```powershell
java -version
mvn -version
```

## Getting Started

### 1. Clone the repository

```powershell
git clone https://github.com/ravimodiya/SauceDemo-Selenium-Automation.git
```

### 2. Navigate to the project directory

```powershell
cd SauceDemo-Selenium-Automation
```

### 3. Run the automated tests

Use the Maven commands described in the next section.

## Running Tests

The framework uses TestNG XML suite files to configure test execution. The `suiteXmlFile` system property specifies which suite Maven should run.

### Run the complete test suite

```powershell
mvn clean test "-DsuiteXmlFile=testng.xml"
```

This command cleans previous build output and executes the main TestNG suite.

### Run checkout tests only

```powershell
mvn clean test "-DsuiteXmlFile=checkouttest.xml"
```

This command executes the checkout test suite.

### Understanding the Maven command

| Command | Purpose |
|---|---|
| `mvn` | Executes Maven |
| `clean` | Removes previous build output |
| `test` | Runs the configured tests |
| `-DsuiteXmlFile=testng.xml` | Selects the main TestNG suite |
| `-DsuiteXmlFile=checkouttest.xml` | Selects the checkout suite |

## Test Coverage

### Login

- Verify successful login
- Validate incorrect passwords
- Validate empty username input
- Perform data-driven login testing using JSON test data

### Products

- Verify the products page
- Verify product count
- Verify product names
- Test product sorting
- Add products to the cart
- Remove products from the cart

### Cart

- Verify added products
- Verify multiple cart items
- Remove products from the cart
- Verify cart item count

### Checkout

- Validate checkout workflows
- Verify first name is required
- Verify last name is required
- Verify postal code is required
- Perform data-driven checkout testing using Excel test data

## Test Data Management

The framework supports external test data to improve test maintainability and reduce hardcoded test inputs.

### JSON Test Data

Login test data is maintained in:

```text
src/test/resources/testdata/loginData.json
```

Jackson JSON is used to support JSON-based test data handling.

### Excel Test Data

Checkout validation data is maintained in:

```text
src/test/resources/testdata/checkoutData.xlsx
```

Apache POI is used to read Excel test data.

Example checkout validation scenarios:

| First Name | Last Name | Postal Code | Expected Validation |
|---|---|---|---|
| Empty | Test | 395001 | First Name is required |
| Ravi | Empty | 395001 | Last Name is required |
| Ravi | Test | Empty | Postal Code is required |

These scenarios validate required checkout fields using negative test cases.

## Browser Configuration

The framework supports the following browsers:

- Google Chrome
- Mozilla Firefox
- Microsoft Edge

Browser selection is configured through TestNG parameters.

Example:

```xml
<parameter name="browser" value="chrome"/>
```

Use the appropriate browser parameter in the relevant TestNG configuration to select the browser for execution.

Ensure the browser and its supported driver setup are available in the execution environment.

## Parallel Execution

The main TestNG suite supports parallel execution across tests.

Example configuration:

```xml
<suite name="SauceDemo Suite"
       parallel="tests"
       thread-count="2">
```

The framework uses `ThreadLocal<WebDriver>` to maintain separate WebDriver instances for parallel test execution.

This approach helps isolate browser sessions and reduces interference between concurrently running tests.

## Reporting

ExtentReports is used to generate test execution reports.

Reporting features include:

- Test execution status
- Failure details and exception information
- Screenshots captured automatically when a test fails
- Additional failure diagnostics recorded by the TestNG listener

The reporting logic is managed by:

```text
src/test/java/listeners/ExtentReportListener.java
```

After test execution, check the report output path configured in the listener to locate the generated HTML report.

The exact report filename and output directory depend on the current ExtentReports configuration.

## Jenkins Integration

The framework can be integrated with Jenkins to run automated tests as part of a CI pipeline.

### Example CI workflow

```text
GitHub Repository
       |
       v
     Jenkins
       |
       v
      Maven
       |
       v
     TestNG
       |
       v
Selenium WebDriver
       |
       v
 Test Execution
       |
       v
   ExtentReports
```

### Example Jenkins test command

```powershell
mvn clean test "-DsuiteXmlFile=testng.xml"
```

Jenkins can be configured to:

- Check out the GitHub repository
- Execute the Maven test suite
- Record test execution results
- Archive the generated ExtentReports HTML report as a build artifact

The Jenkins job must have the required Java, Maven, browser, and test environment configured.

## Design Approach

The framework follows the Page Object Model to separate responsibilities across different components.

- **Page classes:** Encapsulate page interactions and reusable UI operations.
- **Test classes:** Contain test scenarios and assertions.
- **Driver factory:** Manages WebDriver initialization and browser instances.
- **Utilities:** Provide reusable waits, configuration reading, and test data handling.
- **Test data:** Stores external JSON and Excel test inputs.
- **TestNG listener:** Handles test execution reporting and failure screenshots.

This separation improves readability, maintainability, and reusability as the framework grows.

## Future Improvements

Potential enhancements include:

- API automation using REST Assured
- Database validation
- Headless browser execution
- Expanded negative and boundary test coverage
- Improved CI/CD pipeline configuration
- Enhanced reporting and test result summaries

## Author

**Ravi Modiya**

- GitHub: [ravimodiya](https://github.com/ravimodiya)
- Automation Project: [SauceDemo Selenium Automation](https://github.com/ravimodiya/SauceDemo-Selenium-Automation)

