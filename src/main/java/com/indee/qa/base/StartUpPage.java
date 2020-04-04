package com.indee.qa.base;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.indee.qa.utils.TestUtil;

public class StartUpPage {

	public static WebDriver driver;
	public static Properties prop;

	public StartUpPage() {
		try {
			prop = new Properties();
			prop.load(StartUpPage.class.getClassLoader().getResourceAsStream(
					"config.properties"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"G:\\chromedriver\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts()
				.pageLoadTimeout(TestUtil.PageLoadTimeout, TimeUnit.SECONDS);
		driver.manage().timeouts()
				.implicitlyWait(TestUtil.implicitWait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

	public static void quitDriver() {
		driver.quit();
	}
}