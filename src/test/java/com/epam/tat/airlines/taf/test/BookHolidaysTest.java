package com.epam.tat.airlines.taf.test;


import com.epam.tat.airlines.taf.driver.DriverSingleton;
import com.epam.tat.airlines.taf.page.BookHolidayPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BookHolidaysTest {
    private BookHolidayPage bookHolidayPage;
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @Test
    public void checkQuantityOfHolidays() {
        bookHolidayPage = new BookHolidayPage(driver);

        bookHolidayPage.setSittingsForHolidays();
    }

    @AfterTest
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
