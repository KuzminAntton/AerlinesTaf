package com.epam.tat.airlines.taf.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarHirePage extends AbstractPage {
    private final String HOME_URL = "https://monarch.co.uk/";

    @FindBy(xpath = "//div[@class='looking-for']/ul/li[5]/label/span")
    private WebElement buttonHireCar;

    @FindBy(xpath = " //div[@id='cars-container']/a/span")
    private WebElement buttonFindCars;

    @FindBy(xpath = "//*[@id='ct_s1_pickup_loc']")
    private WebElement typeCityOrAirport;

    @FindBy(xpath = "//*[@id='ui-id-1']/li[2]")
    private WebElement selectFromAutoComplete;

    @FindBy(id = "ct_s1_pickup_date")
    private WebElement dateFrom;

    @FindBy(xpath = " //*[@id='ui-datepicker-div']/button/span")
    private WebElement buttonCloseCalendar;

    @FindBy(id = "ct_s1_dropoff_date")
    private WebElement dateTo;

    @FindBy(id = "ct_s1_search_button")
    private WebElement buttonSearch;

    @FindBy(xpath = "//*[@id='ct-availability-list']//button")
    private WebElement buttonSelect;

    public CarHirePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void open() {
        driver.get(HOME_URL);
        buttonHireCar.click();
        buttonFindCars.click();
    }

    public void selectCityOrAirport(String nameCityOrAirport) {
        typeCityOrAirport.sendKeys(nameCityOrAirport);
        selectFromAutoComplete.click();
    }

    public void searchCar() {
        dateFrom.click();
        buttonCloseCalendar.click();
        dateTo.click();
        buttonCloseCalendar.click();
        buttonSearch.click();
    }

    public boolean isSelectCarEnabled() {
        return buttonSelect.isEnabled();
    }
}