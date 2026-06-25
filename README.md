# Automation Exercise Web Automation Framework

![Java](https://img.shields.io/badge/Java-21-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.x-green)
![TestNG](https://img.shields.io/badge/TestNG-7.x-red)

---

## 📌 Project Overview

This is a scalable UI Test Automation Framework built using Selenium WebDriver for the Automation Exercise e-commerce application.

The framework is designed to validate end-to-end business workflows such as user registration, login, product browsing, cart operations, and checkout flows.

It follows industry-standard automation practices and is built to ensure maintainability, reusability, scalability, and easy integration with CI/CD pipelines.

---

## 🎯 Objectives

- Automate critical UI business workflows
- Improve regression testing efficiency
- Enhance test coverage across key user journeys
- Detect UI defects early in the SDLC
- Support continuous integration and automated test execution

---

## 🛠️ Tech Stack

| Layer | Technology | Purpose |
|------|------------|----------|
| Programming Language | Java 21 | Core development language |
| UI Automation | Selenium WebDriver | Web UI test automation |
| Test Framework | TestNG | Test execution and management |
| Build Tool | Maven | Dependency management and build |
| Reporting | Allure Reports | Test execution reporting and visualization |
| Logging | Log4j | Logging and debugging support |
| Test Data | JSON | External test data management |
| Version Control | Git & GitHub | Source code versioning and collaboration |
| CI/CD | GitHub Actions | Automated test execution pipeline |

---

## 🏗️ Framework Architecture

The framework is designed using modular and scalable architecture principles
to ensure high maintainability, reusability, and separation of concerns across all layers.

### Design Patterns
- Page Object Model (POM)
- Factory Pattern (Driver initialization)
- Driver Abstraction Pattern (Cross-browser support)

---

## 📁 Project Structure

The framework follows a layered architecture:

### Core Layers

- **pages** → Page Object Model classes representing UI pages
- **tests** → TestNG test classes containing test scenarios
- **utils** → Reusable utilities (waits, OS tools, actions, readers, etc.)
- **drivers** → WebDriver factory and browser configuration
- **listeners** → TestNG listeners for reporting and execution hooks
- **validations** → Assertion and verification layer
- **dataReader** → JSON and property file readers
- **media** → Screenshot and screen recording utilities

---

## 🚀 Framework Features

- Page Object Model (POM) implementation
- Modular and reusable framework structure
- Cross-browser test execution support
- Data-driven testing using JSON files
- Centralized logging using Log4j
- Screenshot capture on test failure
- Screen recording for failed test cases
- Advanced Allure reporting with attachments
- CI/CD integration with GitHub Actions

---

## 🧪 Automated Test Coverage

### Account Management
- User Registration (valid/invalid scenarios)
- Login validation (positive/negative cases)
- Existing email validation

### Product Management
- Product search functionality
- Product details verification
- Category-based filtering

### Shopping Cart
- Add product to cart
- Remove product from cart
- Cart content validation

### Checkout
- Checkout workflow validation

### Payment
- End-to-end payment flow validation

---

## 📊 Execution Summary (Sample)

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

The framework uses Allure Reports for detailed execution reporting.

Reports include:
- Test execution status
- Screenshots for failures
- Logs and execution details
- Timeline visualization
- Failure analysis

---

## 🔄 CI/CD Pipeline

GitHub Actions is used to automate test execution.

### Pipeline Flow

1. Checkout source code
2. Setup Java environment
3. Install dependencies (Maven)
4. Execute TestNG test suite
5. Generate Allure report
6. Publish execution artifacts

### Benefits
- Automated regression execution
- Faster feedback cycle
- Early defect detection
- Improved software quality assurance

---

## ▶️ How to Run Tests

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



