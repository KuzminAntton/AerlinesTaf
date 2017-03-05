package com.epam.tat.airlines.taf.test;

import com.epam.tat.airlines.taf.driver.DriverSingleton;
import com.epam.tat.airlines.taf.page.CarHirePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class CarHireTest {
    private WebDriver driver;
    private final static String CITY_OR_AIRPORT = "London";

    @BeforeClass
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @Test
    public void testHireCar() {
        CarHirePage carHirePage = new CarHirePage(driver);
        carHirePage.open();
        carHirePage.selectCityOrAirport(CITY_OR_AIRPORT);
        carHirePage.searchCar();
        assertTrue(carHirePage.isSelectCarEnabled());
    }

    @AfterClass
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}