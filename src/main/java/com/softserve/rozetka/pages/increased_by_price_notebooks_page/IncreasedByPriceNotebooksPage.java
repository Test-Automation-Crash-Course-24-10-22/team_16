package com.softserve.rozetka.pages.increased_by_price_notebooks_page;

import com.softserve.rozetka.pages.BasePageWithHeaderAndProductsItems;
import org.openqa.selenium.WebDriver;
import java.util.List;


public class IncreasedByPriceNotebooksPage extends BasePageWithHeaderAndProductsItems {
    private static final String URL = "https://rozetka.com.ua/ua/notebooks/c80004/sort=cheap/";

    public IncreasedByPriceNotebooksPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public List<Integer> getIntegerPrices() {
        waitForUrlToBe(URL);
        return super.getIntegerPrices();
    }
}
