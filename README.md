# 🚀 OrangeHRM End-to-End QA Automation Framework

<div align="center">

### Enterprise-Level Software Testing Portfolio Project

**Selenium • TestNG • Cucumber • Jenkins • Excel Driven Testing • CI/CD**

![Java](https://img.shields.io/badge/Java-17-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.35.0-green)
![TestNG](https://img.shields.io/badge/TestNG-7.11.0-red)
![Cucumber](https://img.shields.io/badge/Cucumber-BDD-brightgreen)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![Jenkins](https://img.shields.io/badge/Jenkins-CI/CD-yellow)
![GitHub](https://img.shields.io/badge/GitHub-Version_Control-black)

</div>

---

# 📌 Project Overview

The OrangeHRM Automation Framework is a hybrid test automation framework developed using Java, Selenium WebDriver, TestNG, Cucumber BDD, Maven, Jenkins, and Excel-Driven Testing.

The framework was designed to simulate real-world QA Automation practices by covering the complete Software Testing Life Cycle (STLC) and Automation Testing Life Cycle (ATLC), including:

- Manual Testing
- Test Design & Documentation
- Selenium UI Automation
- Data-Driven Testing
- Cucumber BDD Automation
- Defect Management
- Reporting & Logging
- Jenkins CI/CD Integration
- GitHub Version Control

---

# 🎯 Project Objectives

- Perform End-to-End Testing of OrangeHRM
- Design and Execute Test Scenarios
- Create 120 Detailed Test Cases
- Implement Page Object Model (POM)
- Build Data-Driven Automation Framework
- Implement Cucumber BDD Framework
- Generate Professional Reports
- Integrate Automation with Jenkins
- Maintain Project using GitHub
- Demonstrate Industry QA Practices

---

# 🌐 Application Under Test

### OrangeHRM Demo Application

**URL**

https://opensource-demo.orangehrmlive.com

### Modules Automated

✅ Login

✅ Dashboard

✅ Admin

✅ PIM

✅ Leave

✅ Directory

✅ Recruitment

✅ Logout

---

# 🏗 Framework Architecture

```text
                     Jenkins CI/CD
                            │
                            ▼

                      Maven Build
                            │
                            ▼

                 Test Execution Layer
      ┌─────────────────┼─────────────────┐
      ▼                 ▼                 ▼

 Excel Runner      TestNG Suite      Cucumber BDD
      │                 │                 │
      └─────────────────┼─────────────────┘
                        ▼

                Scenario Executors
                        │
                        ▼

                 Page Object Model
                        │
                        ▼

                   UI Components
                        │
                        ▼

                  Utility Layer
      Config │ Excel │ Waits │ Retry │ Logs
                        │
                        ▼

                 Reporting Layer
      Extent Reports │ Screenshots │ Logs
```

---

# 📂 Project Structure

```text
OrangeHRM-Automation
│
├── src
│
├── src/test/java
│   │
│   ├── base
│   │   ├── BaseTest.java
│   │   └── DriverFactory.java
│   │
│   ├── components
│   │   └── LeftMenuComponent.java
│   │
│   ├── executor
│   │   ├── BaseExecutor.java
│   │   ├── LoginExecutor.java
│   │   ├── DashboardExecutor.java
│   │   ├── AdminExecutor.java
│   │   ├── PIMExecutor.java
│   │   ├── LeaveExecutor.java
│   │   ├── DirectoryExecutor.java
│   │   ├── RecruitmentExecutor.java
│   │   ├── LogoutExecutor.java
│   │   └── ScenarioExecutor.java
│   │
│   ├── listeners
│   │   ├── TestListener.java
│   │   ├── RetryAnalyzer.java
│   │   └── AnnotationTransformer.java
│   │
│   ├── models
│   │   ├── TestCase.java
│   │   ├── TestScenario.java
│   │   └── ScenarioResult.java
│   │
│   ├── pages
│   │   ├── LoginPage.java
│   │   ├── DashboardPage.java
│   │   ├── AdminPage.java
│   │   ├── PIMPage.java
│   │   ├── LeavePage.java
│   │   ├── DirectoryPage.java
│   │   └── RecruitmentPage.java
│   │
│   ├── reports
│   │   └── ExtentManager.java
│   │
│   ├── runners
│   │   └── TestRunner.java
│   │
│   ├── steps
│   │   ├── Hooks.java
│   │   ├── LoginSteps.java
│   │   ├── DashboardSteps.java
│   │   ├── AdminSteps.java
│   │   ├── PIMSteps.java
│   │   ├── LeaveSteps.java
│   │   ├── DirectorySteps.java
│   │   ├── RecruitmentSteps.java
│   │   └── LogoutSteps.java
│   │
│   ├── tests
│   │   ├── LoginTest.java
│   │   ├── PIMTest.java
│   │   └── ExcelDrivenRunner.java
│   │
│   └── utils
│       ├── ConfigReader.java
│       ├── ExcelUtil.java
│       ├── TestCaseReader.java
│       ├── PriorityUtil.java
│       ├── ElementActions.java
│       ├── WaitUtil.java
│       ├── ScreenshotUtil.java
│       ├── FailureManager.java
│       └── RandomDataUtil.java
│
├── src/test/resources
│   │
│   ├── config
│   │   └── config.properties
│   │
│   ├── features
│   │   ├── Login.feature
│   │   ├── Dashboard.feature
│   │   ├── Admin.feature
│   │   ├── PIM.feature
│   │   ├── Leave.feature
│   │   ├── Directory.feature
│   │   ├── Recruitment.feature
│   │   └── Logout.feature
│   │
│   ├── testdata
│   │   └── OrangeHRM_QA_Testing_Workbook_120cases.xlsx
│   │
│   ├── log4j2.xml
│   ├── testng.xml
│   └── testing-cucumber.xml
│
├── reports
├── logs
├── target
├── test-output
│
├── Jenkinsfile
├── pom.xml
└── README.md
```

---

# 🛠 Technology Stack

| Category | Technology |
|-----------|------------|
| Programming Language | Java 17 |
| Build Tool | Maven |
| UI Automation | Selenium WebDriver |
| Framework | TestNG |
| BDD Framework | Cucumber |
| Reporting | Extent Reports |
| Logging | Log4j2 |
| Data Driven Testing | Apache POI |
| Version Control | Git |
| Repository Management | GitHub |
| CI/CD | Jenkins |

---

# 🧪 Framework Features

### Selenium Automation

- Page Object Model (POM)
- Reusable Components
- Explicit Wait Strategy
- Screenshot Capture
- Retry Mechanism
- Config Driven Execution

### Excel Driven Framework

- Scenario Selection via Excel
- Priority Based Execution
- Centralized Test Data Management
- Automated Scenario Mapping

### Cucumber BDD

- Feature Files
- Step Definitions
- Hooks
- Scenario Execution
- BDD Reporting

### TestNG Framework

- Suite Execution
- Listeners
- Retry Logic
- Test Reporting

### Reporting

- Extent Reports
- Execution Logs
- Screenshots
- Pass/Fail Summary

### CI/CD

- Jenkins Integration
- Automated Builds
- Scheduled Execution
- Report Publishing

---

# 📊 Test Coverage

| Metric | Count |
|----------|---------|
| Test Scenarios | 40 |
| Test Cases | 120 |
| Modules Covered | 8 |
| Automation Framework | Selenium + TestNG |
| BDD Framework | Cucumber |
| Reporting | Extent Reports |
| CI/CD Tool | Jenkins |

---

# 🚀 Execution Commands

### Run Complete TestNG Suite

```bash
mvn clean test
```

### Run Cucumber Suite

```bash
mvn clean test -Pcucumber
```

### Execute Specific TestNG Suite

```bash
mvn test -DsuiteXmlFile=src/test/resources/testng.xml
```

---

# 📈 Generated Reports

The framework automatically generates:

- Extent Report
- Execution Logs
- Failure Screenshots
- TestNG Reports
- Cucumber Reports

Report Locations:

```text
reports/
logs/
test-output/
target/
```

---

# 🔄 CI/CD Workflow

```text
Developer Commit
        │
        ▼

GitHub Repository
        │
        ▼

Jenkins Trigger
        │
        ▼

Checkout Source Code
        │
        ▼

Maven Build
        │
        ▼

Execute Test Suite
        │
        ▼

Generate Reports
        │
        ▼

Publish Results
```

---

# 🎓 QA Concepts Demonstrated

- Software Testing Life Cycle (STLC)
- Automation Testing Life Cycle (ATLC)
- Page Object Model (POM)
- Data-Driven Testing
- Hybrid Framework Design
- BDD Automation
- Defect Management
- Reporting & Analytics
- Continuous Integration
- Agile Testing Practices

---

# 👨‍💻 Author

## Parth Gawli

QA Automation Engineer

### Skills Demonstrated

- Manual Testing
- Selenium WebDriver
- Java
- TestNG
- Cucumber
- Maven
- Jenkins
- Git & GitHub
- Excel Driven Automation
- Framework Design

---

# ⭐ About This Repository

This project was developed as a complete QA Automation Portfolio Project to demonstrate real-world testing practices, framework design principles, and automation engineering skills expected from QA Engineers, Automation Test Engineers, and SDET professionals.

If you found this project useful, consider giving it a ⭐ on GitHub.
