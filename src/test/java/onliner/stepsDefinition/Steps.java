package onliner.stepsDefinition;

import framework.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import onliner.pageObject.pages.CatalogPage;
import onliner.pageObject.pages.MainPage;
import onliner.pageObject.pages.TvPage;

import java.io.IOException;

public class Steps extends BaseTest{
    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();
    TvPage tvPage = new TvPage();

    @Before
    public static void brwSetUp() throws IOException {
        setUp();
    }
    @After
    public static void tearDown() {
        finish();
    }

    @Given("^I'm not signed in user on the main page and navigate to the Catalogue page$")
    public void navigateToCatalogPage() {
        mainPage.checkPage();
        mainPage.getMainMenu().selectMainNavigationOption("Каталог");
    }

    @When("^I click on the catalog menu option 'Электроника', electronic aside list 'Телевидение и видео' and select 'Телевизоры'$")
    public void navigateToTvsPage() {
        catalogPage.checkPage();
        catalogPage.getCatalogMenu().selectCatalogListOption("Электроника");
        catalogPage.getCatalogMenu().selectElectronicOption("Телевидение и видео");
        catalogPage.getCatalogMenu().selectTvAndVideoOption("Телевизоры");
    }

    @And("^I select manufacturer as (.*)$")
    public void selectBrand(String brand) {
        tvPage.checkPage();
        tvPage.selectManufacturer(brand);
    }

    @And("^I set max price as (.*)$")
    public void setMaxPrice(String priceMax) {
        tvPage.setMaxPrice(priceMax);
    }

    @And("^I set min (.*) diagonal$")
    public void setMinDiagonal(String diagonalMin) {
        tvPage.setMinDiagonal(diagonalMin);
    }

    @And("^I set max (.*) diagonal$")
    public void setMaxDiagonal(String diagonalMax) {
        tvPage.setMaxDiagonal(diagonalMax);
    }

    @And("^I select screen resolution as (.*)$")
    public void selectDiagonalResolution(String diagonalResolution) {
        tvPage.selectResolution(diagonalResolution);
    }

    @Then("^I see the list of products that match by (.*), (.*), (.*) and (.*) diagonal, (.*)$")
    public void verifySearchResults(String priceMax, String brand, String diagonalMin, String diagonalMax, String diagonalResolution) {
        tvPage.checkProductsPrice(priceMax);
        tvPage.checkProductsBrand(brand);
        tvPage.checkProductsDiagonal(diagonalMin, diagonalMax);
        tvPage.checkProductsResolution(diagonalResolution);
    }
}