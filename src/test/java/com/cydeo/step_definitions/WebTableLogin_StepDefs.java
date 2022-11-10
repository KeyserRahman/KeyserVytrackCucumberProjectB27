package com.cydeo.step_definitions;

import com.cydeo.pages.WebTableLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WebTableLogin_StepDefs {
    WebTableLoginPage webTableLoginPage = new WebTableLoginPage ();
    @Given("user is on the login page of web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
        Driver.getDriver ().get ( ConfigurationReader.getProperty ( "env" ) );
    }
    @When("user enters username {string}")
    public void user_enters_username(String username) {
         webTableLoginPage.inputUsername.sendKeys ( username );
    }
    @When("user enters password {string}")
    public void user_enters_password(String password) {
         webTableLoginPage.inputPassword.sendKeys ( password );
    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        webTableLoginPage.loginButton.click ();
    }
    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {
        System.out.println ( "from 1st scenario " + Driver.getDriver ( ).getCurrentUrl ( ) );
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("orders"));
    }


    @When("user enters username {string} password {string} and logins")
    public void user_enters_username_password_and_logins(String username, String password) {
        webTableLoginPage.login ( username, password );
        System.out.println ( "from 2nd scenario " + Driver.getDriver ( ).getCurrentUrl ( ) );
    }
}
