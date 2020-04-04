package com.indee.qa.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.indee.qa.base.StartUpPage;

public class TestUtil extends StartUpPage {

	public static final long PageLoadTimeout = 20;
	public static final long implicitWait = 20;

	public static void waitTillElementIsVisible(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void waitTillElementIsClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static boolean verifyLandedPage(WebElement element) {
		if (element.isDisplayed())
			return true;
		else {
			return false;
		}
	}

	public static String jsonReader(String jsonPath)
			throws JsonSyntaxException, JsonIOException, IOException {
		String s = FileUtils.readFileToString(new File(jsonPath),
				StandardCharsets.UTF_8);
		return s;
	}

}
