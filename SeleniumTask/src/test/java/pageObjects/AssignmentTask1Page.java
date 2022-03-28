package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AssignmentTask1Page {

    public WebDriver driver;

    public AssignmentTask1Page(WebDriver driver)
    {
        this.driver=driver;
    }



    private By radioBtn = By.xpath("//input[@value='radio2']");
    private By countryDropDown = By.xpath("//input[@id='autocomplete']");
    private By dropDown=By.xpath("//select[@id='dropdown-class-example']");
    private By nameField=By.name("enter-name");
    private By alertBtn=By.id("alertbtn");
    private By amount=By.cssSelector(".tableFixHead td:nth-child(4)");
    private By totAmount=By.cssSelector(".totalAmount");


    public WebElement getRadioButton() {

        return driver.findElement(radioBtn);
    }

    public WebElement getCountryDropDown() {
         return driver.findElement(countryDropDown);
    }

    public WebElement getDropDown() {

        return driver.findElement(dropDown);
    }

    public void sendNameField(String name) {
         driver.findElement(nameField).sendKeys(name);
    }

    public void clickAlertButton() {
        driver.findElement(alertBtn).click();

    }

    public List<WebElement> getAmount() {
        return driver.findElements(amount);
    }

    public String getTotAmount() {
        return driver.findElement(totAmount).getText();

    }
    public String getTitle()
    {
        return driver.getTitle();
    }
}
