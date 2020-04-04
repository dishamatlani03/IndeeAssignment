package com.indee.qa.tests;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.indee.qa.base.StartUpPage;
import com.indee.qa.pages.HomePage;
import com.indee.qa.utils.TestUtil;

public class HomePageTests extends StartUpPage {

	HomePage homePage;
	Map<String, String> testData;
	Gson gson;

	public HomePageTests() {
		super();
	}

	@BeforeClass
	public void setup() {
		initialization();
		homePage = new HomePage();
		testData = new HashMap<String, String>();
		gson = new Gson();

	}

	@Test
	public void verifyColorsAndFlow() {
		try {

			ArrayList<Object> actualData = new ArrayList<Object>();
			ArrayList<Object> expectedData = new ArrayList<Object>();

			// converting testData into a map to ease the use
			testData = gson.fromJson(TestUtil.jsonReader(prop.getProperty("jsonPath")),Map.class);

			homePage.searchProduct(testData.get("searchText"));

			actualData.add(homePage.verifyColorVariantsUnderSimpleMobile(testData.get("color1"), testData.get("productType")));
			expectedData.add(true);

			actualData.add(homePage.verifyColorVariantsUnderSimpleMobile(testData.get("color2"), testData.get("productType")));
			expectedData.add(true);

			// moving to product page
			homePage.clickOnProductWithText(testData.get("color1"));

			// to enter zip code and continue
			homePage.enterZipCode(testData.get("zipCode"));

			// proceeding to checkout
			homePage.proceed();

			// verifying the login page
			actualData.add(TestUtil.verifyLandedPage(homePage.txtEmail));
			expectedData.add(true);

			assertThat(actualData, is(expectedData));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass
	public void tearDown() {
		TestUtil.quitDriver();
	}

}
