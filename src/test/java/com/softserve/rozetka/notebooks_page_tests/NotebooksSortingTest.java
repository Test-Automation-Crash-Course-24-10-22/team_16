package com.softserve.rozetka.notebooks_page_tests;

import com.softserve.rozetka.pages.notebooks_page.NotebooksPage;
import com.softserve.rozetka.pages.notebooks_page.SortingContent;
import com.softserve.rozetka.runners.BaseRunnerForNotebooksPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NotebooksSortingTest extends BaseRunnerForNotebooksPage {

    @Test(priority = 1)
    public void checkSortingFromLowerToHigherPrice(){
        List<Integer> actualPrices = new NotebooksPage(driver)
                .getSortingContent()
                .selectLowerToHigherOption()
                .openPage()
                .getPrices();
        Assert.assertTrue(actualPrices.equals(actualPrices
                .stream()
                .sorted()
                .collect(Collectors.toList())));
    }
    @Test(priority = 2)
    public void checkSortingFromHigherToLowerPrice(){
        List<Integer> actualPrices = new SortingContent(driver)
                .selectHigherToLowerOption()
                .openPage()
                .getPrices();
        Assert.assertTrue(actualPrices.equals(actualPrices
                .stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())));
    }
}