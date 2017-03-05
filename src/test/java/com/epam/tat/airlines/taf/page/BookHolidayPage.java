package com.epam.tat.airlines.taf.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHolidayPage extends AbstractPage {

    private static final String HOME_URL = "http://www.monarch.co.uk/";
    private static final String DEFAULT_COUNTRY = "Balearic";
    private static final String MONEY_SIGN_UK = "£";
    private static final int MONTH_NUMBER = 3;

    @FindBy(linkText = "Holidays")
    private WebElement buttonHoliday;

    @FindBy(xpath = "//div[@class='dropdown destination']//input[@id='SelectDestinationLabel']")
    private WebElement selectDestination;

    @FindBy(xpath = "//div[@class='dropdown destination']//a[@id='ui-id-4']")
    private WebElement selectPlace;

    @FindBy(xpath = "//div[@class='adults']//a[1]")
    private WebElement adultsDropdown;

    @FindBy(xpath = "//div[@class='adults']//li[4]")
    private WebElement selectAdultsQuantity;

    @FindBy(xpath = "//div[@class='date-holder']//button[@class='ui-datepicker-trigger']")
    private WebElement buttonDataWindow;

    @FindBy(xpath = "//td[@data-month='" + MONTH_NUMBER + "']/a")
    private WebElement selectData;

    @FindBy(xpath = "//div[@id='holidays-container']/a/span")
    private WebElement buttonFindHolidays;

    @FindBy(xpath = "//div[@class='search-paging']//form[@id='SortResultsTop']//p[@class='totalResults']")
    private WebElement quantityOfHolidays;

    @FindBy(xpath = "//div[@class='price-details']//dd[@class='headline-price']")
    private WebElement dividedPrice;

    @FindBy(xpath = "//div[@class='price-details']//dt[@class='total-price']/span")
    private WebElement totalPrice;



    public BookHolidayPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void open() {
        driver.get(HOME_URL);
    }

    private void setAdultsQuantity(int quantity) {
        adultsDropdown.click();
        selectAdultsQuantity.click();
    }

    public void setSittingsForHolidays() {
        open();
        selectHolidaysTab();
        setDestinationSittings();
        setAdultsQuantity(4);
        selectData();
        findHolidays();
        System.out.println(getQuantityOfHolidays());

        double p1 = getDividedPrice();
        double p2 = getTotalPrice();

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p2/2);
        System.out.println(p1==(p2/2));
    }

    private void setDestinationSittings() {
        selectDestination.sendKeys(DEFAULT_COUNTRY);
        selectDestination.sendKeys(" ");
        selectPlace.click();

    }

    private void selectData() {
        buttonDataWindow.click();
        selectData.click();
    }

    private void findHolidays() {
        buttonFindHolidays.click();
    }

    private int getQuantityOfHolidays() {
        String [] holidays = quantityOfHolidays.getText().split(" ");

        int quantity = Integer.parseInt(holidays[0]);

        return quantity;
    }

    private void selectHolidaysTab() {
        buttonHoliday.click();
    }

    private Double getDividedPrice() {
        String price = dividedPrice.getText().replaceAll(MONEY_SIGN_UK,"");
        Double p = Double.parseDouble(price);

        return p;
    }

    private Double getTotalPrice() {
        String price = totalPrice.getText().replaceAll(MONEY_SIGN_UK,"");
        Double p = Double.parseDouble(price);

        return p;
    }

}
