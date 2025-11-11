package com.playwrightTraditional;

import java.nio.file.Paths;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import com.microsoft.playwright.options.AriaRole;

class AIGeneratedTest {

    @DisplayName("DePaul University Bookstore - Complete Shopping Flow Test")
    @Test
    void depaulBookstoreCompleteTest() {
        try (Playwright playwright = Playwright.create()) {
            // Launch browser in non-headless mode
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                    .setHeadless(false));

            // Create browser context with video recording
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setRecordVideoDir(Paths.get("videos/"))
                    .setRecordVideoSize(1280, 720));

            Page page = context.newPage();

            // Step 1: Navigate to DePaul bookstore
            page.navigate("https://depaul.bncollege.com/");

            // Step 2: Search for "earbuds" and press Enter
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).fill("earbuds");
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Search")).press("Enter");

            // Wait for search results to load
            page.waitForLoadState();

            // Step 3: Filter by brand "JBL"
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("brand")).click();
            // Click the first JBL checkbox
            page.locator(".facet__list.js-facet-list.js-facet-top-values > li > form > label > .facet__list__label > .facet__list__mark > .facet-unchecked > svg").first().click();

            // Step 4: Filter by color "Black"
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Color")).click();
            // Click the first Black checkbox
            page.locator("#facet-Color > .facet__values > .facet__list > li > form > label > .facet__list__label > .facet__list__mark > .facet-unchecked > svg").first().click();

            // Step 5: Filter by price "Over $50"
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Price")).click();
            // Click the "Over $50" checkbox (4th item in the price list)
            page.locator("li:nth-child(4) > form > label > .facet__list__label > .facet__list__mark > .facet-unchecked > svg").first().click();

            // Step 6: Click on the product link "JBL Quantum True Wireless"
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("JBL Quantum True Wireless")).click();

            // Step 7: Assert that heading contains full product name
            assertThat(page.getByLabel("main").getByRole(AriaRole.HEADING))
                    .containsText("JBL Quantum True Wireless Noise Cancelling Gaming Earbuds- Black");

            // Assert that page contains price "$149.98"
            assertThat(page.getByLabel("main")).containsText("$149.98");

            // Step 8: Add item to cart
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Add to cart")).click();

            // Step 9: Assert cart shows "1 Items"
            assertThat(page.locator("#headerDesktopView")).containsText("1 items");

            // Step 10: Click cart icon to go to shopping cart page
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Cart 1 items")).click();

            // Step 11: Assert page heading is "Your Shopping Cart"
            assertThat(page.getByLabel("main")).containsText("Your Shopping Cart");

            // Step 12: Enter promo code "TEST" and apply it
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Promo Code")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Enter Promo Code")).fill("TEST");
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Apply Promo Code")).click();

            // Assert that a message appears stating the code is not valid
            assertThat(page.locator("#js-voucher-result")).containsText("The coupon code entered is not valid.");

            // Step 13: Click "PROCEED TO CHECKOUT"
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Proceed To Checkout")).first().click();

            // Step 14: On login page, click "Proceed as Guest"
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Proceed As Guest")).click();

            // Step 15: Fill in contact information fields with test data
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name (required)")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("First Name (required)")).fill("John");

            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name (required)")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Last Name (required)")).fill("Doe");

            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email address (required)")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email address (required)")).fill("john.doe@test.com");

            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone Number (required)")).click();
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Phone Number (required)")).fill("3125551234");

            // Step 16: Click "CONTINUE"
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();

            // Step 17: On pickup information page, click "CONTINUE"
            page.waitForLoadState();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue")).click();

            // Step 18: On payment information page, click "< BACK TO CART" link
            page.waitForLoadState();
            page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Back to cart")).click();

            // Step 19: In shopping cart, delete the product from the cart
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Remove product JBL Quantum")).click();

            // Step 20: Assert that heading now says "Your cart is empty"
            assertThat(page.getByLabel("main")).containsText("Your cart is empty");

            // Close context and browser
            context.close();
            browser.close();
        }
    }
}
