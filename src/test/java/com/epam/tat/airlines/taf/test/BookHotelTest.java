package com.epam.tat.airlines.taf.test;

import com.epam.tat.airlines.taf.driver.DriverSingleton;
import com.epam.tat.airlines.taf.page.BookHotelPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BookHotelTest {
    private BookHotelPage bookHotelPage;
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @Test
    public void oneCanBookHotel() {
        bookHotelPage = new BookHotelPage(driver);
        bookHotelPage.open();
        bookHotelPage.bookHotel();
        Assert.assertTrue(bookHotelPage.isBooked());
    }

    @AfterTest
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}