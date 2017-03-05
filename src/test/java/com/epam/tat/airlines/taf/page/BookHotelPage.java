package com.epam.tat.airlines.taf.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookHotelPage extends AbstractPage {
    private static final String HOME_URL = "http://www.monarch.co.uk/";

    @FindBy(linkText = "Hotels")
    private WebElement buttonHotels;

    @FindBy(xpath = "//div/a[@class='hero-banner-link']")
    private WebElement selectOffers;

    @FindBy(xpath = "//div[@class='basic-content']//td[4]/a")
    private WebElement selectShowMoreInfo;

    @FindBy(xpath = "//div//a[@class='btn-primary btn-go']/span")
    private WebElement buttonMoreDetails;

    @FindBy(xpath = "//div//button[@id='btn-book-now']/span")
    private WebElement buttonBookNow;

    @FindBy(xpath = "//div//h1[@id='floatswitcher']")
    private WebElement isBooked;

    public BookHotelPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void open() {
        driver.get(HOME_URL);
    }

    public void bookHotel() {
        selectHotels();
        selectOffers();
        searchHotel();
        buttonBook();
    }

    private void selectHotels() {
        buttonHotels.click();
    }

    private void selectOffers() {
        selectOffers.click();
    }

    private void searchHotel() {
        selectShowMoreInfo.click();
        (new WebDriverWait(driver, 30)).until(ExpectedConditions.elementToBeClickable(buttonMoreDetails));
        buttonMoreDetails.click();
    }

    private void buttonBook() {
        buttonBookNow.click();
    }

    public boolean isBooked() {
        return isBooked.isDisplayed();
    }
}
