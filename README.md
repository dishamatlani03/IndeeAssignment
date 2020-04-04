#Indee Assignment for Automation testing

This is a hybrid framework with PageFactory design pattern, a maven project where input is taken from josn and testNG is used for execution and control of tests

Explanation of each file of the framework:
  1. com.indee.qa.base.StartUpPage.java is the base class of all classes where Webdriver is declared, browser is selected and config.properties file is loaded
  2. com.indee.qa.utils.TestUtil.java is a class having various generic utility methods, used during the test - common for all modules
  3. com.indee.qa.pages.HomePage.java - since it follows POM page factory design, so HomePage class contains all webElements used in the test and methods for various actions
  4. src/main/resources/testData/HomePage.json - As the input is taken from json, this json file contains all the key value paired input elements used to provide during tests
  5. src/main/resources/config.properties - This is properties file, which is used to provide the browser, url and other initial properties
  6. com.indee.qa.tests.HomePageTests - Test class which has the test method of execution, @beforeClass annotation method used  initializing the objects and afterClass method for closing the browser
