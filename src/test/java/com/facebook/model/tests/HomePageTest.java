package com.facebook.model.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.facebook.model.pages.HomePage;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;

import org.joda.time.DateTime;
import org.joda.time.DateTime.Property;
import org.joda.time.DateTimeFieldType;
import org.testng.annotations.DataProvider;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import io.codearte.jfairy.producer.person.Person.Sex;

public class HomePageTest extends BaseTest {

	@Test(dataProvider = "getData")
	public void verifySignUpOfFacebookAccount(String firstname, String surname, String emailaddress, String password,
			String date, String month, String year, String gender) throws IOException {
		HomePage homePage = new HomePage(driver);
		homePage.setFirstName(firstname);
		homePage.setLastName(surname);
		homePage.setEmailAddress(emailaddress);
		homePage.setPassword(password);
		homePage.setDateOfBirth("day", date);
		homePage.setDateOfBirth("month", month);
		homePage.setDateOfBirth("year", year);
		homePage.setGender(gender, "", "");
		homePage.clickSignUpButton();

	}

	@DataProvider
	public Object[][] getData() {

		Object[][] data = new Object[1][8];

		Fairy fairy = Fairy.create();
		Person person = fairy.person();

		data[0][0] = person.getFirstName();
		data[0][1] = person.getLastName();
		data[0][2] = person.getEmail();
		data[0][3] = person.getPassword();
		data[0][4] = String.valueOf(person.getDateOfBirth().getDayOfMonth());
		data[0][5] = String.valueOf(person.getDateOfBirth().getMonthOfYear());
		data[0][6] = String.valueOf(person.getDateOfBirth().getYear());
		data[0][7] = person.getSex().toString();

		return data;
	}

}
