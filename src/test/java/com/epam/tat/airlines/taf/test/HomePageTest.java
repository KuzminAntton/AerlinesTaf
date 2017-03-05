package com.epam.tat.airlines.taf.test;

import com.epam.tat.airlines.taf.bean.flight.FlightSearchParameters;
import com.epam.tat.airlines.taf.driver.DriverSingleton;
import com.epam.tat.airlines.taf.page.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

public class HomePageTest {
    private WebDriver driver;

    @BeforeClass
    public void setUpClass() {
        driver = DriverSingleton.getDriver();
    }

    @Test
    public void oneAdultCanCarryOnlyOneInfantTest() throws Exception {
        FlightSearchParameters params = new FlightSearchParameters();
        params.setAdultsAmount(1);
        params.setChildrenAmount(2);
        params.setInfantsAmount(2);
        params.setDeparture("Birmingham");
        params.setDestination("Barcelona");
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.findFlights(params);
        assertTrue(homePage.isAlertDisplayed());
    }

    @Test
    public void childCanNotTakeInfant() {
        FlightSearchParameters params = new FlightSearchParameters();
        params.setAdultsAmount(1);
        params.setChildrenAmount(0);
        params.setInfantsAmount(2);
        params.setDeparture("Birmingham");
        params.setDestination("Barcelona");
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.findFlights(params);
        assertTrue(homePage.isAlertDisplayed());
    }

    @AfterMethod
    public void tearDownMethod() {
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void tearDownClass() {
        DriverSingleton.closeDriver();
    }
}