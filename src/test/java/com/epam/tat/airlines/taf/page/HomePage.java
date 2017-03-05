package com.epam.tat.airlines.taf.page;

import com.epam.tat.airlines.taf.bean.flight.FlightSearchParameters;
import com.epam.tat.airlines.taf.exception.InvalidDataException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends AbstractPage {
    private static final String HOME_URL = "http://www.monarch.co.uk/";

    @FindBy(xpath = "//div[contains(@class, 'single-city')]//div[contains(@class, 'departure-airport')]//div[contains(@class, 'dropdown')]")
    private WebElement departureDropdown;

    @FindBy(xpath = "//div[contains(@class, 'single-city')]//div[contains(@class, 'destination-airport')]//div[contains(@class, 'dropdown')]")
    private WebElement destinationDropdown;

    @FindBy(xpath = "//div[contains(@class, 'adults')]//div[contains(@class, 'btn-group')]")
    private WebElement adultsBtnGroup;

    @FindBy(xpath = "//div[contains(@class, 'infants')]//div[contains(@class, 'dropdown')]")
    private WebElement infantsDropdown;

    @FindBy(xpath = "//div[@id='flights-container']//a[@data-method='Flights']")
    private WebElement buttonFindFlights;

    @FindBy(xpath = "//div[contains(@class, 'validation') and contains(@data-method, 'Flights')]//div[@class='modal-dialog']")
    private WebElement alertMessage;

    @FindBy(xpath = "//div[contains(@class, 'children')]//div[contains(@class, 'dropdown')]")
    private WebElement childrenDropdown;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void open() {
        driver.get(HOME_URL);
    }

    public void findFlights(FlightSearchParameters params) {
        selectFrom(params.getDeparture());
        selectTo(params.getDestination());
        selectAdults(params.getAdultsAmount());
        selectChildren(params.getChildrenAmount());
        selectInfants(params.getInfantsAmount());
        buttonFindFlights.click();
    }

    public boolean isAlertDisplayed() {
        try {
            (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(alertMessage));
        } catch (TimeoutException e) {
            return false;
        }
        return true;
    }

    private void selectAdults(int amount) {
        adultsBtnGroup.findElement(By.linkText(amount + "")).click();
    }

    private void selectChildren(int amount) {
        childrenDropdown.findElement(By.xpath("//a[@data-name='Children']")).click();
        childrenDropdown.findElement(By.linkText(amount + "")).click();
    }

    private void selectFrom(String departure) {
        departureDropdown.findElement(By.xpath("//a[@data-name='OriginAirport']")).click();
        List<WebElement> departureList = departureDropdown.findElements(By.linkText(departure));
        if (departureList.size() == 0) {
            throw new InvalidDataException("Unknown departure airport.");
        }
        departureList.get(0).click();
    }

    private void selectInfants(int amount) {
        infantsDropdown.findElement(By.xpath("//a[@data-name='Infants']")).click();
        infantsDropdown.findElement(By.linkText(amount + "")).click();
    }

    private void selectTo(String destination) {
        destinationDropdown.findElement(By.xpath("//a[@data-name='DestinationAirport']")).click();
        List<WebElement> destinationList = destinationDropdown.findElements(By.linkText(destination));
        if (destinationList.size() == 0) {
            throw new InvalidDataException("Unknown destination airport.");
        }
        destinationList.get(0).click();
    }
}