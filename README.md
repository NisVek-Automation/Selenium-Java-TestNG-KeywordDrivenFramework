# Selenium Keyword Driven Framework
![Selenium Datadriven Framework](https://github.com/NisVek-Automation/NisVek-Automation/blob/main/readmeResources/JavaKeywordDriven.gif)

Don't forget to give this project a ⭐
<div align="center">

[![Status](https://img.shields.io/badge/status-active-success.svg)]()
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](/LICENSE)

</div>

## 📝 Table of Contents

- [About](#about)
- [Features](#features)
- [Technologies](#technologies)
- [Installation](#installation)
- [Dependencies](#dependencies)
- [Getting Started](#getting_started)
- [Framework Structure](#framework-structure)
- [Contributing](#contributing)
- [Authors](#author)

---

## 🕹 About <a name = "about"></a>

<p align="left"> 
This Repository provides the basic testing keyword driven framework to start the UI automation testing.
</p>

---
## 🖥️ Technologies <a name = "technologies"></a>

- [Selenium](https://www.selenium.dev/)
- [Java](https://www.java.com/en/)
- [TestNG](https://testng.org/doc/)
- [Maven](https://maven.apache.org/)
- [log4j](https://logging.apache.org/log4j/2.x/)

---

## ⚙️ Installation <a name = "installation"></a>

#### 🎯 Prerequisite:

- [Java](https://www.java.com/en/download/help/index_installing.html) - Programming language
- [Eclipse](https://www.eclipse.org/downloads/) - Editor
- [Maven](https://maven.apache.org/index.html) - Software project Management tool

#### 🔌 Plugins:

- [TestNG for Eclipse Plugin](https://testng.org/doc/eclipse.html)
- [Maven Integration for Eclipse](https://marketplace.eclipse.org/content/maven-integration-eclipse-luna-and-newer)


All set!!! Just download the Project folder...

---

## 🔁 Dependencies <a name = "dependencies"></a>

Automation framework dependancies are mentioned in the <b>POM.xml</b> file, and are not limited to.

---
## 👩‍💻 Getting Started <a name = "getting_started"></a>

How to use this framework?
- Clone the repository to your workspace.

```sh
git clone https://github.com/NisVek-Automation/Selenium-Java-TestNG-KeywordDrivenFramework.git
```

- Run the TestNG.xml file. You can even run as mvn test which will trigger the TestNG.xml

---

## 🏗️ Framework Structure <a name = "framework-structure"></a>

<p>
<details><summary>src/main/java</summary><br>
  
<h3>src/main/java/nisha/config</h3>
  
| Files     | Description |
| ---         | ---       |
| Keywords | This class contains all the keywords which required for testing         |


<h3>src/main/java/nisha/enums</h3>
  
| Files     | Description |
| ---         | ---       |
| OperatingSystems |  Represents Operating System enum        |
| Browsers     | Represents Browsers enum  |
  
<h3>src/main/java/nisha/resources</h3>
  
| Files     | Description |
| ---         | ---       |
| log4jproperties |  Properties for log4j         |
| TestCaseData.xlsx     |  Data driven testing data for each testcases  |
| TestSuite.xlsx    |  Suite setting with testcase detailed steps for that suite  |
  
  
<h3>src/main/java/nisha/utilities</h3>
  
| Files     | Description |
| ---         | ---       |
| ConstantHelper    | Represents Project and framework specific property/constant values  |
| ExcelSheetHelper | Represents the excelsheet functionality helper class         |
| LoggerHelper    | Represents the Logger functionality helper class   |
| ReadObjectHelper    | Represents the excelsheet functionality helper class    |
| ReportHelper     | This class helps to write the execution report   |
  
</details>
</p>

<p>
<details><summary>src/test/java</summary><br>
    This package contains all the application under testcases.
  
  <h3>src/test/java/TestCases</h3>
  
| Files     | Description |
| ---         | ---       |
| BaseTest |  Represent TestCases Parent class        |
| LoginProcess     |  Represent TestCases for Login process.  |
| SearchProcess    |  Represent TestCases for search process  |
</details>
</p>


## 💬 Contributing <a name = "contributing"></a>

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

---

## ✍️ Author <a name = "author"></a>

- [@NisVek-Automation](https://www.linkedin.com/in/nisha-vekariya/) - Nisha Vekariya
