# Selenium Keyword Driven Framework
![Selenium Datadriven Framework](https://github.com/NisVek-Automation/NisVek-Automation/blob/main/JavaKeywordDriven.gif)

## Content
**[1. About](#about)**

**[2. Technologies](#technologies)**

**[3. Installation](#installation)**
  
  * [3.1 Prerequisite](#prerequisite)
  * [3.2 Plugins](#plugins)
  
**[4. Framework Structure](#framework-structure)**

**[5. Usage](#usage)**

**[6. Contributing](#contributing)**

**[7. Contributors](#contributors)**

  
## About
This Repository provides the basic testing framework to start the automation testing.


## Technologies
1. Selenium
2. Java
3. TestNG
4. Maven
5. log4j

## Installation

#### Prerequisite:

1. Java
2. Editor e.g. Eclipse
3. Maven

#### Plugins:

1. TestNG for Eclipse Plugin
2. Maven Integration for Eclipse

All set!!! Just download the Project folder...

## Framework Structure

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



	
## Usage

1. Download the Project folder

2. Compile

3. Open Command Prompt, navigate to Project folder. Use below Maven command to run test:

	To run:
	
		mvn clean verify

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## Contributors

Nisha Vekariya
