package onliner.stepsDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import onliner.pageObject.pages.CatalogPage;
import onliner.pageObject.pages.MainPage;
import onliner.pageObject.pages.TvPage;

import java.io.IOException;

import static framework.ScreenshotMaker.takeScreenshot;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.Allure.step;


public class Steps {
    MainPage mainPage = new MainPage();
    CatalogPage catalogPage = new CatalogPage();
    TvPage tvPage = new TvPage();

    @Given("^I'm on the main page and navigate to the Catalogue page$")
    public void navigateToCatalogPage() throws IOException {
        mainPage.checkPage();
        step("Verify that Initial page is opened");
        addAttachment("Initial page", takeScreenshot());
        mainPage.getHeader().selectMainNavigationOption("Каталог");
        step("Navigate to Catalog page");
    }

    @When("^I click on the catalog menu option 'Электроника', electronic aside list 'Телевидение и видео' and select 'Телевизоры'$")
    public void navigateToTvsPage() throws IOException {
        catalogPage.checkPage();
        step("Verify that Catalog page is opened");
        catalogPage.getCatalogMenu().selectCatalogMenuOption("Электроника");
        step("Select Electronic option");
        addAttachment("Электроника", takeScreenshot());
        catalogPage.getCatalogMenu().selectSubMenuOption("Телевидение и видео");
        step("Select TV and video option");
        addAttachment("Телевидение и видео", takeScreenshot());
        catalogPage.getCatalogMenu().selectAsideListOption("Телевизоры");
        step("Select TVs option");
        addAttachment("Телевизоры", takeScreenshot());
    }

    @And("^I select manufacturer as (.*)$")
    public void selectBrand(String brand) throws IOException {
        tvPage.checkPage();
        step("Verify that TVs page is opened");
        tvPage.selectManufacturer(brand);
        step("Select brand");
        addAttachment("Brand", takeScreenshot());
    }

    @And("^I set max price as (.*)$")
    public void setMaxPrice(String priceMax) {
        tvPage.setMaxPrice(priceMax);
        step("Set max price");
    }

    @And("^I set min (.*) diagonal$")
    public void setMinDiagonal(String diagonalMin) {
        tvPage.setMinDiagonal(diagonalMin);
        step("Set min diagonal");
    }

    @And("^I set max (.*) diagonal$")
    public void setMaxDiagonal(String diagonalMax) {
        tvPage.setMaxDiagonal(diagonalMax);
        step("Set max diagonal");
    }

    @And("^I select screen resolution as (.*)$")
    public void selectDiagonalResolution(String diagonalResolution) {
        tvPage.selectResolution(diagonalResolution);
        step("Select diagonal resolution");
    }

    @Then("^I see the list of products that match by (.*), (.*), (.*) and (.*) diagonal, (.*)$")
    public void verifySearchResults(String priceMax, String brand, String diagonalMin, String diagonalMax, String diagonalResolution) {
        tvPage.checkProductsPrice(priceMax);
        step("Check prices");
        tvPage.checkProductsBrand(brand);
        step("Check brand");
        tvPage.checkProductsDiagonal(diagonalMin, diagonalMax);
        step("Check min-max diagonal");
        tvPage.checkProductsResolution(diagonalResolution);
        step("Check resolution");
    }
}