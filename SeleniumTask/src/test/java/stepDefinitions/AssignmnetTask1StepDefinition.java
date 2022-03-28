package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pageObjects.AssignmentTask1Page;
import utils.TestContextSetup;

import java.util.List;

public class AssignmnetTask1StepDefinition {

    public WebDriver driver;
    public AssignmentTask1Page rahulPage;
    TestContextSetup testContextSetup;
    int sum,total;

    public AssignmnetTask1StepDefinition(TestContextSetup testContextSetup)
    {


        this.testContextSetup=testContextSetup;
        this.rahulPage = testContextSetup.pageObjectManager.getRahulShettyPage();
        this.driver= rahulPage.driver;
    }

    @Given("User is on Rahul Shetty page")
    public void user_is_on_rahul_shetty_page() {
        Assert.assertTrue(rahulPage.getTitle().contains("Practice Page"));

    }
    @When("user select radio button")
    public void user_select_radio_button() {
        // Write code here that turns the phrase above into concrete actions
        rahulPage.getRadioButton().click();

    }

    @When("user select {string} from dropdown")
    public void user_select_from_dropdown(String country) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        rahulPage.getCountryDropDown().sendKeys(country);
        Thread.sleep(2000);
        rahulPage.getCountryDropDown().sendKeys(Keys.DOWN);
        Thread.sleep(2000);
        rahulPage.getCountryDropDown().sendKeys(Keys.ENTER);

    }

    @When("user enter {string} in the textfield")
    public void user_enter_in_the_textfield(String name) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        rahulPage.sendNameField(name);

       // throw new io.cucumber.java.PendingException();
    }

    @When("user select {string} from dropdownExample")
    public void user_select_a_value_From_dropdownExample(String value) throws InterruptedException {
        Select dropDown=new Select(rahulPage.getDropDown());
        dropDown.selectByValue(value);
        Thread.sleep(10000);
    }

    @When("sum all price in Web Table")
    public void sum_all_price_in_Web_Table()
    {
        sum=0;
        List<WebElement> amount= rahulPage.getAmount();   // Write code here that turns the phrase above into concrete actions
        for(int i=0;i<amount.size();i++)
        {
            sum=sum+Integer.parseInt(amount.get(i).getText());
        }
        System.out.println(sum);
       // throw new io.cucumber.java.PendingException();
    }

    @Then("verify sum of all rows is equal to the sum which has given")
    public void verify_sum_of_all_rows_is_equal_to_the_sum_which_has_given() {
        // Write code here that turns the phrase above into concrete actions


        String a=rahulPage.getTotAmount().split(":")[1].trim();
        System.out.println(a);
        total=Integer.parseInt(rahulPage.getTotAmount().split(":")[1].trim());
        System.out.print(sum);

       /* if(sum==total)
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertFalse(false);
        }*/
        Assert.assertEquals(sum, total);
      //  throw new io.cucumber.java.PendingException();
    }

    @Then("verify the radio button has clicked")
    public void verify_the_radio_button_has_clicked()
    {
        Assert.assertTrue(rahulPage.getRadioButton().isSelected());
    }

    @Then("verify the {string} is set in the dropdown")
    public void verify_the_is_set_in_the_dropdown(String country) throws InterruptedException {
        Thread.sleep(2000);
        System.out.print(rahulPage.getCountryDropDown().getAttribute("value"));


        Assert.assertEquals(rahulPage.getCountryDropDown().getAttribute("value"),country);


    }

    @Then("verify the {string} got selected")
    public void verify_got_selected(String valueDropDown) {

        System.out.print(rahulPage.getDropDown().getAttribute("value"));
        Assert.assertEquals(rahulPage.getDropDown().getAttribute("value"),valueDropDown);

    }

    @Then("get the text from alert box")
    public void get_the_text_from_alert_box() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        rahulPage.clickAlertButton();
        Thread.sleep(2000);
       Alert alert=driver.switchTo().alert();
       String alertMsg=alert.getText().toString();
       System.out.println(alertMsg);




    }



    @Then("click ok button")
    public void click_ok_button() throws InterruptedException {

        driver.switchTo().alert().accept();


    }
    @Then("close the browser")
    public void close_the_browser() {
        // Write code here that turns the phrase above into concrete actions
        driver.close();

    }

}
