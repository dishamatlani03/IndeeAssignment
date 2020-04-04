package com.indee.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.indee.qa.base.StartUpPage;
import com.indee.qa.utils.TestUtil;

public class HomePage extends StartUpPage {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input[id='twotabsearchtextbox']")
	public WebElement txtSearch;

	@FindBy(xpath = "//input[@value='Go']")
	public WebElement btnGo;

	@FindBy(xpath = "//span[text()='Featured']")
	public WebElement btnforSecSearchPage;

	@FindBy(xpath = "//span[contains(text(),'Qty')]")
	public WebElement btnForProdPageSearch;

	@FindBy(css = "div[id*='deliveryShortLine'] span")
	public WebElement btnDeliver;

	@FindBy(xpath = "//input[contains(@id,'ZipUpdateInput')]")
	public WebElement txtUpdateZip;

	@FindBy(xpath = "//span[contains(@id,'ZipUpdate-announce')]//preceding::input[1]")
	public WebElement btnApply;

	@FindBy(xpath = "//span[contains(@id,'ConfirmClose-announce')]//following::input[@id='GLUXConfirmClose']")
	public WebElement btnContinue;

	@FindBy(xpath = "//input[@id='add-to-cart-button']")
	public WebElement btnAddToCart;

	@FindBy(xpath = "//button[contains(text(),'No Thanks') and contains(@id,'NoCoverage')]")
	public WebElement btnSkip;

	@FindBy(xpath = "//a[contains(text(),'Proceed')]")
	public WebElement btnProceed;

	@FindBy(xpath = "//input[@id='ap_email']")
	public WebElement txtEmail;

	public void searchProduct(String prodName) {
		TestUtil.waitTillElementIsVisible(txtSearch);
		txtSearch.sendKeys(prodName);
		TestUtil.waitTillElementIsClickable(btnGo);
		btnGo.click();
		TestUtil.waitTillElementIsVisible(btnforSecSearchPage);

	}

	public boolean verifyColorVariantsUnderSimpleMobile(String color,
			String text) {
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + text + "')]"));
		for (WebElement e : list) {
			String s = e.getText();
			if (s.contains(color))
				return true;
		}
		return false;
	}

	public void clickOnProductWithText(String color) {
		driver.findElement(By.xpath("//span[contains(text(),'" + color + "')]")).click();
		TestUtil.waitTillElementIsVisible(btnForProdPageSearch);
	}

	public void enterZipCode(String zipcode) {
		btnDeliver.click();
		TestUtil.waitTillElementIsVisible(txtUpdateZip);
		txtUpdateZip.sendKeys(zipcode);
		TestUtil.waitTillElementIsVisible(btnApply);
		btnApply.click();
		TestUtil.waitTillElementIsVisible(btnContinue);
		btnContinue.click();
	}

	public void proceed() {
		TestUtil.waitTillElementIsVisible(btnAddToCart);
		btnAddToCart.click();
		TestUtil.waitTillElementIsVisible(btnSkip);
		btnSkip.click();
		TestUtil.waitTillElementIsVisible(btnProceed);
		btnProceed.click();
		TestUtil.waitTillElementIsVisible(txtEmail);
	}
}
