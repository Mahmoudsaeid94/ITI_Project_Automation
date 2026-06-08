# Automation Exercise Web Automation Framework
![Java](https://img.shields.io/badge/Java-21-orange)

![Selenium](https://img.shields.io/badge/Selenium-4.x-green)

![TestNG](https://img.shields.io/badge/TestNG-7.x-red)

## 📌 Project Overview

This project is a scalable Selenium WebDriver automation framework developed for the Automation Exercise e-commerce website.

The framework automates critical business workflows including user registration, authentication, product management, shopping cart operations, checkout, and payment processing.

It follows industry-standard automation practices and is designed to be maintainable, reusable, scalable, and easy to integrate with CI/CD pipelines.

## 🎯 Objectives

- Automate critical business workflows.
- Reduce manual regression testing effort.
- Improve test coverage and execution efficiency.
- Detect defects early in the software development lifecycle.
- Provide detailed execution reports and test evidence.
- Enable cross-browser test execution.
- Support continuous integration and continuous testing.
 
  ## 🛠️ Tech Stack

| Technology | Usage |
|------------|------------|
| Java 21 | Programming Language |
| Selenium WebDriver | UI Automation |
| TestNG | Test Framework |
| Maven | Dependency Management |
| Allure Reports | Test Reporting |
| Log4j | Logging |
| JSON | Test Data Management |
| GitHub | Version Control |
| GitHub Actions | CI/CD |

Framework Architecture

### Design Patterns

- Page Object Model (POM)
- Factory Pattern
- Driver Abstraction Pattern
 
Project Structure

```text
├── src
    ├── main
    │   ├── resources)
    │   │   ├── waits.properties
    │   │   ├── seleniumGrid.properties
    │   │   ├── video.properties
    │   │   ├── META-INF
    │   │   │   └── services
    │   │   │   │   └── org.testng.ITestNGListener
    │   │   ├── allure.properties
    │   │   ├── environment.properties
    │   │   ├── webapp.properties
    │   │   └── log4j2.properties
    │   └── java
    │   │   ├── drivers
    │   │       ├── WebDriverProvider.java
    │   │       ├── UITest.java
    │   │       ├── AbstractDriver.java 
    │   │       ├── Browser.java 
    │   │       ├── SafariFactory.java 
    │   │       ├── GUIDriver.java 
    │   │       ├── FirefoxFactory.java
    │   │       ├── ChromeFactory.java 
    │   │       └── EdgeFactory.java 
    │   │   ├── pages
    │   │       ├── apiTesting.java
    │   │       ├── testCases.java
    │   │       ├── contactUs.java
    │   │       ├── deleteAccount.java
    │   │       ├── logout.java
    │   │       ├── PaymentPage.java 
    │   │       ├── ProductDetailsPage.java 
    │   │       ├── cartPage.java 
    │   │       ├── components
    │   │       │   └── NavigationBarComponent.java 
    │   │       ├── SignupPage.java 
    │   │       ├── productsPage.java
    │   │       ├── SignupLoginPage.java 
    │   │       └── CheckOutPage.java
    │   │   ├── utils
    │   │       ├── OSUtils.java
    │   │       ├── TimeManager.java
    │   │       ├── TerminalUtils.java 
    │   │       ├── report
    │   │       │   ├── AllureEnvironmentManager.java 
    │   │       │   ├── AllureConstants.java 
    │   │       │   ├── AllureAttachmentManager.java 
    │   │       │   ├── AllureReportGenerator.java
    │   │       │   └── AllureBinaryManager.java 
    │   │       ├── logs
    │   │       │   └── LogsManager.java
    │   │       ├── WaitManager.java 
    │   │       ├── actions
    │   │       │   ├── BrowserActions.java 
    │   │       │   ├── AlertActions.java 
    │   │       │   ├── FrameActions.java 
    │   │       │   └── ElementActions.java 
    │   │       └── dataReader
    │   │       │   ├── PropertyReader.java 
    │   │       │   └── JsonReader.java 
    │   │   ├── validations
    │   │       ├── Verification.java 
    │   │       ├── Validation.java 
    │   │       └── BaseAssertion.java 
    │   │   ├── media
    │   │       ├── ScreenshotsManager.java 
    │   │       └── ScreenRecordManager.java 
    │   │   ├── FileUtilss
    │   │       └── FileUtils.java
    │   │   └── listeners
    │   │       └── TestNGListeners.java 
    └── test
    │   ├── resources
    │       └── test-data
    │       │   ├── ProductDetails-data.json
    │       │   ├── Login-data.json
    │       │   ├── Cart-data.json 
    │       │   ├── CheckOut-data.json 
    │       │   ├── Register-data.json
    │       │   ├── Products-data.json 
    │       │   └── Payment-data.json 
    │   └── java
    │       └── tests
    │           ├── BaseTest.java
    │           ├── ProductDetailsTest.java 
    │           ├── CartTest.java 
    │           ├── LoginTest.java 
    │           ├── ProductsTest.java 
    │           ├── CheckOutTest.java
    │           ├── RegisterTest.java 
    │           └── PaymentTest.java 
├── automationExercise.eml
├── .github
    └── workflows
---

## 🚀 Framework Features

### Test Automation

- Functional Testing
- Regression Testing
- End-to-End Testing
- Negative Testing
- Cross-Browser Testing

### Reporting & Monitoring

- Allure Reports
- Screenshots on Failure
- Screen Recording
- Execution Logs

### Test Data Management

- External JSON Test Data
- Reusable Test Data Files

### Browser Support

- Chrome
- Firefox
- Edge
- Safari

---
Automated Test Coverage

### Account Management

- User Registration
- Existing Email Validation
- Invalid Registration Validation
- User Login
- Invalid Login Validation

### Product Management

- Search Products
- Search By Category
- Product Details Verification
- Product Review Validation

### Shopping Cart

- Add Product To Cart
- Remove Product From Cart
- Verify Cart Content

### Checkout

- Checkout Workflow Validation

### Payment

- End-to-End Payment Workflow

---

## 📊 Latest Execution Summary

| Metric | Result |
|----------|----------|
| Total Tests | 26 |
| Passed | 24 |
| Failed | 1 |
| Broken | 1 |
| Pass Rate | 92.3% |
| Execution Time | 1m 52s |

---

## 📈 Reporting

The framework generates detailed execution reports using Allure Reports.

Generated artifacts include:

- Test Execution Results
- Screenshots
- Logs
- Execution Timeline
- Failure Analysis

---

## 🔄 CI/CD Pipeline

GitHub Actions is used to automate test execution.

### Pipeline Flow

1. Checkout Source Code
2. Setup Java Environment
3. Install Dependencies
4. Execute TestNG Suites
5. Generate Allure Results
6. Upload Test Artifacts

### Benefits

- Faster Feedback
- Automated Regression Testing
- Early Defect Detection
- Improved Quality Assurance Process

---

## ▶️ Running Tests

### Run All Tests

```bash
mvn clean test
```

### Generate Allure Report

```bash
allure serve allure-results
```

---

## 📋 Test Deliverables

- Automation Framework
- TestNG Suites
- Allure Reports
- Execution Logs
- Screenshots
- Screen Recordings

---

## 🔮 Future Enhancements

- Selenium Grid Integration
- Docker Support
- Parallel Execution Optimization
- API Automation Integration
- Database Validation Layer

---

## 👨‍💻 Author

Mahmoud Saeid

QA Automation Engineer

GitHub:
https://github.com/Mahmoudsaeid94

LinkedIn:
https://www.linkedin.com/in/mahmoud-saeid-qc



    │   └── All test Pipeline .yml (300 tokens)
└── pom.xml (1700 tokens)
