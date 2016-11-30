package runnerAndSteps;


import java.sql.DriverManager;
import java.util.IllegalFormatConversionException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import reporting.com.HTMLReports.CareersPage;
import reporting.com.HTMLReports.DBCheckers;
import reporting.com.HTMLReports.DBClickOrPress;
import reporting.com.HTMLReports.DBComparers;
import reporting.com.HTMLReports.DBUtilities;
import reporting.com.HTMLReports.HomePage;
//import reporting.com.HTMLReports.AccountFinancialHistorypage;
//import reporting.com.HTMLReports.BillingHistoryPage;
//import reporting.com.HTMLReports.DBUtilities;
//import reporting.com.HTMLReports.ForgotYourPasswordPage;
//import reporting.com.HTMLReports.GoalsAndTargetsPage;

//import reporting.com.HTMLReports.LandingPage;
//import reporting.com.HTMLReports.MakeAPaymentPage;

public class StepImpe {
 //********************************************** following is before and after *****************************************
	WebDriver driver;
	private String bolt;
	static String Capture;
	
	@Before()
	  public void startUp() {
//	    driver = new FirefoxDriver();
//	    driver.manage().window().maximize();

	    // the location of the driver is been changed to match with remote server setting.....  HS
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\CTang\\Documents\\chromedriver.exe");
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    
	}
		// **************disable to leave browser open***************************************

	@After()
		  public void tearDown() {	
		    driver.quit();
		  }
	//******************************************************************************   
	    
//	@Given("^I am \"(.*?)\"$")
//	public void i_am(String arg1) throws Throwable {
//		System.out.println("Hello I am hungry");
//	} 
	
   
	    // for Chrome driver
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Automation Tools\\Drivers\\chromedriver.exe");
//		driver = new ChromeDriver();
//	    driver.manage().window().maximize();
//	
	    
	    // for IE
//		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Automation Tools\\Drivers\\IEDriverServer.exe");
//		driver = new ChromeDriver();
//	    driver.manage().window().maximize();
	    
	
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//++++++++++++++++++++++++COMMANDS THAT INTERACT+++++++++++++++++++++++++++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@And("^I click on \"(.*?)\"$")
	public void i_click_on(String arg1) throws Throwable {
		// give time for page loading
		
		Thread.sleep(1000);
		DBUtilities createXpath = new DBUtilities(driver);
		String myxpath = createXpath.xpathMaker(arg1);
		System.out.println("Clicking on " +myxpath);
		try {
			Assert.assertTrue(driver.findElement(By.xpath(myxpath)).isDisplayed());
		}
		catch (AssertionError ae){
			
			try { // try contains text
				System.out.println("Failed exact text match. Now trying containing text match.");
				myxpath = createXpath.xpathMakerContainsText(arg1);
				System.out.println("Clicking on " +myxpath);
				Assert.assertTrue(driver.findElement(By.xpath(myxpath)).isDisplayed());
			}
			catch (AssertionError ae2) {// try span
				System.out.println("Failed containing text match. Now trying span match.");
				myxpath = createXpath.xpathMakerSpanContainsText(arg1);
				System.out.println("Clicking on " +myxpath);
				Assert.assertTrue(driver.findElement(By.xpath(myxpath)).isDisplayed());
			}
		}
		System.out.println(myxpath + " assertion success!");
		driver.findElement(By.xpath(myxpath)).click();
		Thread.sleep(1000);
		//driver.findElement(By.xpath(myxpath)).click();
			
	}
	
	@And("^I hit Enter$")
    public DBUtilities I_hit_Enter() throws InterruptedException
	{
		PageFactory.initElements(driver, DBClickOrPress.class).hitEnter();
		Thread.sleep(1000);
		
		 return PageFactory.initElements(driver, DBUtilities.class);
	}
	
	@And("^I hit Tab$")
    public DBUtilities I_hit_Tab() throws InterruptedException
	{
		PageFactory.initElements(driver, DBClickOrPress.class).hitTab();
		Thread.sleep(1000);
		
		 return PageFactory.initElements(driver, DBUtilities.class);
	}
	
	@And("^I enter then details as$")
	public void I_enter_then_details_as(DataTable table) throws Throwable {

     PageFactory.initElements(driver, DBClickOrPress.class).enterCucumbertableValuesInUI(table);
	 Thread.sleep(2000);
		
	}

	@And("^I enter then details as new$")
	public void enterCucumberTableValuesInUI(DataTable table) throws InterruptedException{
		PageFactory.initElements(driver, DBClickOrPress.class).enterCucumbertableValuesInUI(table);
		
	}
	
	// this is for checking checkbox
	@Given("^I click on \"(.*?)\" checkbox$")
	public void i_click_on_checkbox(String arg1) throws Throwable {
     PageFactory.initElements(driver, DBClickOrPress.class).checkBoxClick(arg1);
	}
	
	@Given("^I select \"(.*?)\" from \"(.*?)\"$")
	public void i_select_from(String arg1, String arg2) throws Throwable {
		if (arg1.equals("SetGoal")){
			String myxpath = PageFactory.initElements(driver, DBUtilities.class).xpathMakerById1AndId2(arg1, arg2);
			driver.findElement(By.xpath(myxpath)).click();
		}
		else {
			PageFactory.initElements(driver, DBUtilities.class).selectDropdownValue(arg1, arg2);
		}
	}
	
	
	@Then("^I click on object with id \"(.*?)\"$")
	public void i_click_on_object_with_id(String arg1) throws Throwable {
		DBUtilities createXpath = new DBUtilities(driver);
		String myxpath = createXpath.xpathMakerById(arg1);
		driver.findElement(By.xpath(myxpath)).click();
	}
	
	@Then("^I click on object with class \"(.*?)\"$")
	public void i_click_on_object_with_class(String arg1) throws Throwable {
		DBUtilities createXpath = new DBUtilities(driver);
		String myxpath = createXpath.xpathMakerContainsClass(arg1);
		driver.findElement(By.xpath(myxpath)).click();
	}
	// check for field text and text boxes
	
	@Then("^I enter input as \"(.*?)\"$")
	public void i_enter_input_as(String arg1) throws Throwable {
		 Actions action = new Actions(driver); 
		 action.sendKeys(arg1).build().perform();
	}
	
	@Then("^I switch to the next window$")
	public void i_switch_to_the_next_window() throws Throwable {
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
	}
	
	// check for field text and text boxes
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//++++++++++++++++++++++++COMMANDS THAT CHECK/VERIFY++++++++++++++++++++++++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	@Then("^I see the image \"(.*?)\"$") 
	public void i_should_see_the_image(String arg1) throws Throwable{
		//PageFactory.initElements(driver, DBCheckers.class).checkForImage(arg1);
		PageFactory.initElements(driver, DBCheckers.class).checkForImage(arg1); ;
	}
	
	@Then("^I Check \"(.*?)\" contains \"(.*?)\"$")
	public void i_Check_contains(String arg1, String arg2) throws Throwable {
		DBUtilities createXpath = new DBUtilities(driver);
		String myxpath = createXpath.xpathMakerById(arg1);
		System.out.println(myxpath);
		String elementToBeSearched = StepImpe.Capture;
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%" +elementToBeSearched);
		DBCheckers t1 = new DBCheckers(driver);
	    t1.isTextPresent(elementToBeSearched);
	}
	
	@Then("^I will see message \"(.*?)\"$")    // this is just a workaround for the temp para coming in
	public void i_will_see_message(String arg1) throws Exception {
		
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),arg1)]")).isDisplayed());
		System.out.println("Message sucessfully displayed as " +arg1);
		Thread.sleep(5000);
	}
	
	@Given("^I check I am on \"(.*?)\" page$")
	public void i_check_I_am_on_page(String arg1) throws Throwable {
	PageFactory.initElements(driver, DBCheckers.class).checkIfOnRightPage(arg1); 
		  
		  System.out.println(" on correct page " +arg1);
	}
	
	@Then("^I check I have gone to the URL \"(.*?)\"$")
	public void i_check_i_have_gone_to_the_url(String arg1) throws Throwable{
		PageFactory.initElements(driver, DBCheckers.class).checkURL(arg1, false);
	}
	
	@Then("^I check I have gone to the URL \"(.*?)\" in a new tab$")
	public void i_check_i_have_gone_to_the_url_in_a_new_tab(String arg1) throws Throwable{
		PageFactory.initElements(driver, DBCheckers.class).checkURL(arg1, true);
	}
	
	@Then("^I verify the \"(.*?)\" count is \"(.*?)\" to \"(.*?)\"$")
	public void i_verify_the_count_is_to(String arg1, String arg2, int arg3) throws Throwable {
		PageFactory.initElements(driver, DBComparers.class).readAndCompareTableRows(arg1, arg2, arg3);
	 
	}
	
	@Then("^I see text \"(.*?)\" displayed$")
	public void i_see_text_displayed(String arg1) throws Throwable {
		DBCheckers AU = PageFactory.initElements(driver, DBCheckers.class);
      Thread.sleep(1000);
      AU.checkUIElementTEXTIsDisplayed(arg1);
	}
	
	
	//check i am on right page
	
	@Then("^I see the page tab title displayed as \"(.*?)\"$")
	public void i_see_page_tab_title_displayed_as(String arg1) throws Throwable{
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, arg1);
	}
	
	@Then("^I see the page tab title includes \"(.*?)\"$")
	public void i_see_page_tab_title_includes(String arg1) throws Throwable{
		String actualTitle = driver.getTitle();
		Assert.assertTrue(actualTitle.indexOf(arg1) != -1);
	}
	
	
	@Then("^\"(.*?)\" is displayed as \"(.*?)\"$")
	public void is_displayed_as(String arg1, String arg2, DataTable table) throws Throwable {
//		if(arg2.equals("Checkbox")
//				||arg2.equals("I'm not a robot")
//				||arg2.equals("recaptcha-anchor")){
//			PageFactory.initElements(driver, LandingPage.class).checkElementPresentOnScreen(table);
//		}else{
		PageFactory.initElements(driver, DBCheckers.class).checkElementPresentOnScreen(table);
		}
//	}
	
	@Then("^I see \"(.*?)\" displayed$")
	public void i_see_and_displayed(String arg1) throws Throwable {
    PageFactory.initElements(driver, DBCheckers.class).checkUIElementIsDisplayed(arg1);

	}
	
	@Then("^I see \"(.*?)\" not displayed$")
	public void i_see_text_not_displayed(String arg1) throws Throwable {
		PageFactory.initElements(driver, CareersPage.class).checkNegativeText(arg1);

	}
	
	@Then("^the graph for \"(.*?)\" is displayed$")
	public void the_graph_for_is_displayed(String arg1) throws Throwable {
		DBUtilities createXpath = new DBUtilities(driver);
		String myxpath = createXpath.xpathMakerById(arg1);
		driver.findElement(By.xpath(myxpath)).click();
	}
	
	@Then("^I see the copyright logo displayed$")
	public void i_see_the_copyright_logo_displayed() throws Throwable{
		DBUtilities checkElementDisplayed = new DBUtilities(driver);
		String myxpath2 = checkElementDisplayed.xpathMakerByTextInClass("glyphicon-copyright-mark");
		Assert.assertTrue(driver.findElement(By.xpath(myxpath2)).isDisplayed());  
		
	}
	
	@Then("^I check that \"(.*?)\" has CSS property \"(.*?)\" with value \"(.*?)\"$")
	public void i_check_that_has_css_property_with_value(String arg3, String arg1, String arg2) throws Throwable{
		PageFactory.initElements(driver, DBCheckers.class).checkCSSValue(arg3, arg1, arg2);
	}
	
	@Then("^I check that object of id \"(.*?)\" has CSS property \"(.*?)\" with value \"(.*?)\"$")
	public void i_check_that_object_of_id_has_css_property_with_value(String arg3, String arg1, String arg2) throws Throwable{
		PageFactory.initElements(driver, DBCheckers.class).checkCSSValueByProperty(arg3, arg1, arg2);
	}
	
	@Then("^I check that object of class \"(.*?)\" has CSS property \"(.*?)\" with value \"(.*?)\"$")
	public void i_check_that_object_of_class_has_css_property_with_value(String arg3, String arg1, String arg2) throws Throwable{
		PageFactory.initElements(driver, DBCheckers.class).checkCSSValueByProperty(arg3, arg1, arg2);
	}
	
	
	
	@Then("^I check that object with id \"(.*?)\" exists") 
	public void i_check_that_object_with_id_exists(String arg1) throws Throwable {
		DBUtilities checkElementDisplayed = new DBUtilities(driver);
		String myxpath = checkElementDisplayed.xpathMakerById(arg1);
		Assert.assertTrue(driver.findElement(By.xpath(myxpath)).isDisplayed());  
		
	}
	
	@Then("^I check that object with class \"(.*?)\" exists") 
	public void i_check_that_object_with_class_exists(String arg1) throws Throwable {
		DBUtilities checkElementDisplayed = new DBUtilities(driver);
		String myxpath = checkElementDisplayed.xpathMakerContainsClass(arg1);
		Assert.assertTrue(driver.findElement(By.xpath(myxpath)).isDisplayed());  
		
	}
	
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//++++++++++++++++++++++++COMMANDS THAT COMPARE++++++++++++++++++++++++++++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
	
	
	@Then("^I compare \"(.*?)\" to \"(.*?)\"$")
	public void i_compare_to(String arg1, String arg2) throws Throwable {
		DBComparers compareValues = PageFactory.initElements(driver, DBComparers.class);
		compareValues.compareValueOneToValueTwo(arg1, arg2);
	}
	// compare 2 values
	@Then("^I verify \"(.*?)\" is \"(.*?)\" then \"(.*?)\"$")
	public void i_verify_is_then(String arg1, String arg2, String arg3) throws Throwable {
	   DBUtilities val1 = new DBUtilities(driver);
	   String a = val1.xpathMakerById(arg1);
	   String currentValue1 = driver.findElement(By.xpath(a)).getText();
	   System.out.println(currentValue1);
	   String b = val1.xpathMakerById(arg3);
	   String currentValue2 = driver.findElement(By.xpath(b)).getText();
	   System.out.println(currentValue2);

	   DBComparers compareAccountTotalToServiceTotal = new DBComparers(driver);
	   String result = compareAccountTotalToServiceTotal.compare2DollarValues(currentValue1, currentValue2);
		
	   Assert.assertTrue(result.contains(arg2));
		
	}
//	    
	@Then("^I compare \"(.*?)\" to \"(.*?)\" to check if variation is displayed correctly$")
	public void i_compare_to_to_check_if_variation_is_displayed_correctly(String arg1, String arg2) throws Throwable {
		DBComparers compareValues = PageFactory.initElements(driver, DBComparers.class);
		compareValues.compareValueOneToValueTwo(arg1, arg2);
	}
	
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//++++++++++++++++++++++++OTHER COMMANDS+++++++++++++++++++++++++++++++++++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
	@Given("^I capture \"(.*?)\"$")
	public String i_capture(String arg1) throws Throwable {
		

			
			DBUtilities createXpath = new DBUtilities(driver);
			String myxpath = createXpath.xpathMakerContainsId(arg1);
			System.out.println(myxpath);
			
			WebElement xyz = driver.findElement(By.xpath(myxpath));
			StepImpe.Capture= xyz.getText();
			System.out.println("the payment id is " +Capture);
			return Capture;
  
	}

	
//	//*************************************************************************************************************************
//	
	
	@Given("^I want to login to portal \"(.*?)\"$")
	public void i_want_to_login_to_portal(String arg1) throws Throwable {
		HomePage home = PageFactory.initElements(driver, HomePage.class);
		home.navigateTo(arg1);	
	}

	
	@Then("^I hover only on \"(.*?)\"$" )
	public void i_hover_on(String arg1) throws Throwable {
    PageFactory.initElements(driver, DBUtilities.class).hoverOverOnly(arg1);
 
	}
	
	@Then("^I hover on \"(.*?)\" to verify \"(.*?)\" is displayed$")
	public void i_hover_on_to_verify_is_displayed(String arg1, String arg2) throws Throwable {
    PageFactory.initElements(driver, DBUtilities.class).hoverOverElement(arg1, arg2);
 
	}
	
	// for DBResults dropdown menus
	@Then("^I hover over \"(.*?)\" and select \"(.*?)\"$")
	public void i_hover_over_and_select(String arg1, String arg2) throws Throwable{
		PageFactory.initElements(driver, DBUtilities.class).hoverOverAndSelect(arg1, arg2);
	}

	

//
//	//*********************************************** read popup message********************************************
	@Then("^I see \"(.*?)\" displayed on popup and I click \"(.*?)\"$")
	public void i_see_displayed_on_popup_and_I_click(String arg1, String arg2) throws Throwable {
    Thread.sleep(2000);
		PageFactory.initElements(driver, DBCheckers.class).checkPopUpMessage(arg1);
		PageFactory.initElements(driver, DBClickOrPress.class).clickOnPopUP(arg2);

	}

//	// ******************************************************* new page is launched*********************************************
	@Then("^a new page \"(.*?)\" is launched$")                 
	public void a_new_page_is_launched(String arg1) throws Throwable {
    String URL = driver.getCurrentUrl();
     System.out.println(URL);
     new DBUtilities(driver).passControlToNewWindow(arg1);
    
  
		}

	@When("^I view the left hand panel of screen$")
	public void i_view_the_left_hand_panel_of_screen() throws Throwable {
	System.out.println("Checking UI Elements on LHS of screen");
	Thread.sleep(10000);
	}

	// check the dropdown displays expected
	@Then("^\"(.*?)\" displays \"(.*?)\" by default$")
	public void displays_by_default(String arg1, String arg2) throws Throwable {
		PageFactory.initElements(driver, DBCheckers.class).checkDropDownDefaultValue(arg2);

	}

//	//*****************************************************************************************
//	//**********************************************PAYMENT WINDOW*****************************
//	//*****************************************************************************************
	@Then("^a new \"(.*?)\" window is open$")
	public void a_new_window_is_open(String arg1) throws Throwable {
	 // to do... add test once bug is fixed.
	}
	
//	
//	//*****************************************************************************************
//	//**********************************************DATA BASE CONNECTION***********************
//	//*****************************************************************************************
	

	
	@Given("^I want to connect to Webservice$")
	public void i_want_to_connect_to_Webservice() throws Throwable {
	
	}


//	//*****************************************************************************************
//	//**********************************************PDF FILE ***********************
//	//*****************************************************************************************
//	
	
	@Then("^I see a pdf document with name \"(.*?)\" generated$")
	public void i_see_a_pdf_document_with_name_generated(String arg1) throws Throwable {
     System.out.println("Yes******************* pdf is open");
     DBUtilities moveControlToNewWindow = new DBUtilities(driver);
     moveControlToNewWindow.passControlToNewWindow(arg1);
     
	}
	
	
	// generic waiting function, can be used for sites that auto-direct in case of fast crawling
	@Then("^I wait for \"(.*?)\" seconds$")
	public void i_wait_for_seconds(String arg1) throws IllegalFormatConversionException, InterruptedException{
		Thread.sleep(Integer.parseInt(arg1) * 1000);
	}

	



}