package org.srinivas.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

public class HomePage {

    private WebDriver driver;

    //Locators

    private By homePageLocator = By.xpath("//h1[@class='logo']//img");
    private By reqrestableLocator = By.xpath("//*[@id='console']");

    private By reqreskeyLocator = By.xpath("//div[@class ='endpoints']");

    private By supprtbuttonLocator = By.xpath("//a[contains(text(), 'Support ReqRes')]");
    private By supportpageHeader = By.xpath("//h2[contains(text(), 'Support')]");
    private By supportoptiononetimeLocator = By.xpath("//label[contains(text(), 'One-time payment ($)')]");
    private By supportoptionmonthlyLocator = By.xpath("//label[contains(text(), 'Monthly support ($5/month)')]");
    private By upgradeLocator = By.xpath("//button[contains(text(), 'Upgrade')]");

public HomePage(WebDriver driver){
    this.driver = driver;
}

public boolean checkHomepageImage(){
    return driver.findElement(homePageLocator).isDisplayed();
}

public boolean checkReqResTable(){
        return driver.findElement(reqrestableLocator).isDisplayed();
    }

    public boolean checkReqResKeys(){
        return driver.findElement(reqreskeyLocator).isDisplayed();
    }
public boolean validateRequestResponseCodes(String optionText){
    boolean result;

// Find and click on the option
        String xpathExpr;
        xpathExpr = String.format("//a[contains(text(), '%s')]", optionText);
        WebElement option = By.xpath(xpathExpr).findElement(driver);
        option.click();

        System.out.println("Key pressed: " + optionText);

// Get the option name
        String optionName = option.getText();
        String expectedDataField1 = null;
        String expectedDataField2 = null;

        switch (optionName) {
            case "LIST USERS":
                expectedDataField1 = "/api/users?page=2";
                expectedDataField2 = "200";
                break;
            case "SINGLE USER":
                expectedDataField1 = "/api/users/2";
                expectedDataField2 = "200";
                break;
            case "SINGLE USER NOT FOUND":
                expectedDataField1 = "/api/users/23";
                expectedDataField2 = "404";
                break;
            case "LIST <RESOURCE>":
                expectedDataField1 = "/api/unknown";
                expectedDataField2 = "200";
                break;
            case "SINGLE <RESOURCE>":
                expectedDataField1 = "/api/unknown/2";
                expectedDataField2 = "200";
                break;
            case "SINGLE <RESOURCE> NOT FOUND":
                expectedDataField1 = "/api/unknown/23";
                expectedDataField2 = "404";
                break;
            case "CREATE":
                expectedDataField1 = "/api/users";
                expectedDataField2 = "201";
                break;
            case "DELETE":
                expectedDataField1 = "/api/users/2";
                expectedDataField2 = "204";
                break;
            case "REGISTER - SUCCESSFUL":
                expectedDataField1 = "/api/register";
                expectedDataField2 = "200";
                break;
            case "REGISTER - UNSUCCESSFUL":
                expectedDataField1 = "/api/register";
                expectedDataField2 = "400";
                break;
            case "LOGIN - SUCCESSFUL":
                expectedDataField1 = "/api/login";
                expectedDataField2 = "200";
                break;
            case "LOGIN - UNSUCCESSFUL":
                expectedDataField1 = "/api/login";
                expectedDataField2 = "400";
                break;
            case "DELAYED RESPONSE":
                expectedDataField1 = "/api/users?delay=3";
                expectedDataField2 = "200";
                break;
            default:
                System.out.println("Expected option: " + optionName + "  is not listed");
                break;
        }

// Get the actual data values from the webpage
        WebElement dataField1 = driver.findElement(By.xpath("//div[@class='request']//span"));
        String actualDataField1 = dataField1.getText();
        WebElement dataField2 = driver.findElement(By.xpath("//div[@class='response']//span"));
        String actualDataField2 = dataField2.getText();


// Compare the expected and actual data values
        if (actualDataField1.equals(expectedDataField1) && actualDataField2.equals(expectedDataField2)) {
            System.out.println("Test passed");
result =true;
        } else {
            System.out.println("Test failed");
            result =false;
        }
return result;

    }


    public boolean validateReqResCodes(){

        // Define the list of items to verify
        String[] itemsToVerify = {
                "List users",
                "Single user",
                "Single user not found",
                "List <resource>",
                "Single <resource>",
                "Single <resource> not found",
                "Create",
                "Delete",
                "Register - successful",
                "Register - unsuccessful",
                "Login - successful",
                "Login - unsuccessful",
                "Delayed response"
        };

        // Verify the presence of each item
        boolean allItemsVerified = verifyAllItems(driver, itemsToVerify);

        // Close the browser
        driver.quit();

        // Return the verification status
        System.out.println("All items verified: " + allItemsVerified);
        return allItemsVerified;

    }



    private static boolean verifyAllItems(WebDriver driver, String[] itemsToVerify) {
        for (String item : itemsToVerify) {
            WebElement element = driver.findElement(By.xpath("//*[contains(text(), '" + item + "')]"));
            if (element == null) {
                System.out.println("Element '" + item + "' is not present.");
                return false;
            } else {
                System.out.println("Element '" + item + "' is present.");
            }
        }
        return true;
    }


public boolean checkSupportButton(){
        return driver.findElement(supprtbuttonLocator).isDisplayed();
}
public void clickonSupportbutton(){
    WebElement supportbutton = driver.findElement(supprtbuttonLocator);
    supportbutton.click();
}

public boolean checkSupportpageHeader(){
        return driver.findElement(supportpageHeader).isDisplayed();
}
public boolean checkSupportoptiononetime(){
        return driver.findElement(supportoptiononetimeLocator).isDisplayed();
}
public boolean checksupportoptionmonthly(){
        return driver.findElement(supportoptionmonthlyLocator).isDisplayed();
}

public boolean checkUpgradeoption(){
        return driver.findElement(upgradeLocator).isDisplayed();
}

}

