package com.facebook.model.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setFirstName(String firstname) {
		driver.findElement(By.name("firstname")).sendKeys(firstname);
	}

	public void setLastName(String surname) {
		driver.findElement(By.name("lastname")).sendKeys(surname);
	}

	public void setEmailAddress(String emailaddress) {
		driver.findElement(By.id("u_0_q")).sendKeys(emailaddress);
		driver.findElement(By.name("reg_email_confirmation__")).sendKeys(emailaddress);
	}

	public void setPassword(String password) {
		driver.findElement(By.name("reg_passwd__")).sendKeys(password);
	}

	public void setDateOfBirth(String locator, String value) {
		Select s = new Select(driver.findElement(By.id(locator)));
		s.selectByValue(value);
	}

	public void setGender(String gender, String preferredPronoun, String customGender) {
		if (gender == "MALE") {
			driver.findElement(By.cssSelector("input[value='2']")).click();
		} else if (gender == "FEMALE") {
			driver.findElement(By.cssSelector("input[value='1']")).click();
		} else {
			driver.findElement(By.cssSelector("input[value='-1']")).click();
			Select s = new Select(driver.findElement(By.name("preferred_pronoun")));
			s.selectByVisibleText(preferredPronoun);
			driver.findElement(By.name("custom_gender")).sendKeys(customGender);
		}
	}

	public void clickSignUpButton() {
		driver.findElement(By.id("u_0_15")).click();
	}
}
