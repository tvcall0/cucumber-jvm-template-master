package step_definitions;

import static org.testng.AssertJUnit.assertEquals;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.math.NumberUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BlankStepDefs {

	public WebDriver driver;
	public String answerBoxText = "";
	public String blueButtonText = "";

	public BlankStepDefs() {
		driver = Hooks.driver;
	}

	@Then("^I check blue button text$")
	public void i_check_blue_button_text() throws Throwable {
		By by = By.xpath("//a[@class='button']");

		Thread.sleep(2000);

		blueButtonText = driver.findElement(by).getText();

		boolean flag = false;

		List<String> list = Arrays.asList("qux", "foo", "bar", "baz");

		if (list.get(0).equals(blueButtonText) | list.get(1).equals(blueButtonText) | list.get(2).equals(blueButtonText)
				| list.get(3).equals(blueButtonText)) {
			flag = true;
		}

		assertEquals(true, flag);
	}

	@Then("^I check loading bar$")
	public void i_check_loading_bar() throws Throwable {
		By by = By.xpath("//img[@src='/img/ajax-loader.gif']");

		boolean flag = false;

		if (driver.findElement(by).isDisplayed()) {
			flag = true;
		}

		assertEquals(true, flag);
	}

	@Then("^I click blue button$")
	public void i_click_blue_button() throws Throwable {
		By by = By.xpath("//a[@class='button']");
		driver.findElement(by).click();
	}

	@Then("^I click check box 1$")
	public void i_click_check_box_1() throws Throwable {
		By by = By.xpath("(//input[@type='checkbox'])[1]");
		driver.findElement(by).click();
	}

	@Then("^I click check box 2$")
	public void i_click_check_box_2() throws Throwable {
		By by = By.xpath("(//input[@type='checkbox'])[2]");
		driver.findElement(by).click();
	}

	@Then("^I click login button$")
	public void i_click_login_button() throws Throwable {
		By by = By.xpath("//button[@type='submit']");
		driver.findElement(by).click();
	}

	@Then("^I click start button$")
	public void i_click_start_button() throws Throwable {
		By by = By.xpath("//div[@id='start']//button");
		driver.findElement(by).click();
	}

	@When("^I enter invalid password$")
	public void i_enter_invalid_password() throws Throwable {
		By by = By.id("password");
		driver.findElement(by).click();
		driver.findElement(by).sendKeys("INVALID-PASSWORD");
	}

	@When("^I enter invalid username$")
	public void i_enter_invalid_username() throws Throwable {
		By by = By.id("username");
		driver.findElement(by).click();
		driver.findElement(by).sendKeys("INVALID-USERNAME");
	}

	@When("^I open auth website$")
	public void i_open_auth_website() throws Throwable {
		driver.get("https://the-internet.herokuapp.com/login");
	}

	@When("^I open challenging dom website$")
	public void i_open_challenging_dom_website() throws Throwable {
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
	}

	@When("^I open check boxes website$")
	public void i_open_check_boxes_website() throws Throwable {
		driver.get("https://the-internet.herokuapp.com/checkboxes");
	}

	@When("^I open dynamic loading website$")
	public void i_open_dynamic_loading_website() throws Throwable {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
	}

	@When("^I open seleniumframework website$")
	public void i_open_seleniumframework_website() throws Throwable {
		driver.get("http://www.seleniumframework.com");
	}

	@Then("^I validate title and URL$")
	public void i_print_title_and_URL() throws Throwable {
		assertEquals("Selenium Framework | Selenium, Cucumber, Ruby, Java et al.", driver.getTitle());
		assertEquals("http://www.seleniumframework.com/", driver.getCurrentUrl());
	}

	@Then("^I validate table data$")
	public void i_validate_table_data() throws Throwable {
		By by = By.xpath("//td");

		List<WebElement> webElementList = driver.findElements(by);

		boolean flag = false;
		for (WebElement webElement : webElementList) {
			if (!webElement.getText().isEmpty()) {
				if (webElement.getText().equals("Definiebas4")) {
					flag = true;
					break;
				}
			}
		}
		assertEquals(true, flag);
	}

	@Then("^I verify check box 1 is checked$")
	public void i_verify_check_box_1_is_checked() throws Throwable {
		By by = By.xpath("(//input[@type='checkbox'])[1]");

		boolean flag = false;

		if (driver.findElement(by).isSelected()) {
			flag = true;
		}

		assertEquals(true, flag);

	}

	@Then("^I verify check box 2 is checked$")
	public void i_verify_check_box_2_is_checked() throws Throwable {
		By by = By.xpath("(//input[@type='checkbox'])[2]");

		boolean flag = false;

		if (driver.findElement(by).isSelected()) {
			flag = true;
		}

		assertEquals(true, flag);

	}

	@Then("^I verify check box 2 is unchecked$")
	public void i_verify_check_box_2_is_unchecked() throws Throwable {
		By by = By.xpath("(//input[@type='checkbox'])[2]");

		boolean flag = false;

		if (!driver.findElement(by).isSelected()) {
			flag = true;
		}

		assertEquals(true, flag);

	}

	@Then("^I verify error message is displayed$")
	public void i_verify_error_message_is_displayed() throws Throwable {
		By by = By.xpath("//div[@data-alert][@id='flash'][contains(text(),'Your username is invalid!')]");

		boolean flag = false;

		if (driver.findElement(by).isDisplayed()) {
			flag = true;
		}

		assertEquals(true, flag);

	}

	@Then("^I verify the number in the answer box$")
	public void i_verify_the_number_in_the_answer_box() throws Throwable {
		By by = By.xpath("(//script)[7]");

		answerBoxText = driver.findElement(by).getAttribute("innerHTML");
		answerBoxText = answerBoxText.substring(answerBoxText.lastIndexOf("strokeText"));
		answerBoxText = answerBoxText.substring(answerBoxText.indexOf(":") + 1, answerBoxText.lastIndexOf("'"));
		answerBoxText = answerBoxText.trim();

		boolean flag = false;

		if (NumberUtils.isNumber(answerBoxText)) {
			flag = true;
		}

		assertEquals(true, flag);

	}

	@Then("^I verify the updated number in the answer box$")
	public void i_verify_the_updated_number_in_the_answer_box() throws Throwable {
		By by = By.xpath("(//script)[7]");

		Thread.sleep(2000);

		String temp = answerBoxText;
		answerBoxText = driver.findElement(by).getAttribute("innerHTML");
		answerBoxText = answerBoxText.substring(answerBoxText.lastIndexOf("strokeText"));
		answerBoxText = answerBoxText.substring(answerBoxText.indexOf(":") + 1, answerBoxText.lastIndexOf("'"));
		answerBoxText = answerBoxText.trim();

		boolean flag = false;

		if (NumberUtils.isNumber(answerBoxText)) {
			flag = true;
		}

		if (answerBoxText.equals(temp)) {
			flag = false;
		}

		assertEquals(true, flag);

	}

	@Then("^I wait and check global greeting$")
	public void i_wait_and_check_global_greeting() throws Throwable {
		By by = By.xpath("//div[@id='finish']//h4[text()='Hello World!']");

		Thread.sleep(7000);

		boolean flag = false;

		if (driver.findElement(by).isDisplayed()) {
			flag = true;
		}

		assertEquals(true, flag);
	}
}
