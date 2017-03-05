package com.epam.tat.airlines.taf.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected final WebDriver driver;

    public abstract void open();

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}