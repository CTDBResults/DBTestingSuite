package reporting.com.HTMLReports;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.runtime.junit.Assertions;

public class DBCheckers extends DBUtilities {
	public DBCheckers (WebDriver dr) {
		super(dr);
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//++++++++++++++++++++++++++++++++++FUNCTIONS THAT CHECK+++++++++++++++++++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	 // following will take 2 args from cucumber and one from page and then compare both messages
	 public static void checkElement(String arg1, String arg2) {
		 Assert.assertEquals(arg1, arg2);
		 System.out.println("Successfully displayed element" +arg2 ); 
	 }
	 
	 // following will take 2 args both strings and then compare them, basically used for text on UI
	 public static void checkMessage(String arg1, String arg2) {
		 Assert.assertEquals(arg1, arg2);
		 System.out.println("Successfully displayed message" +arg2 );
	 }
	 
	 // following will check if the element exist on the screen
	 public void checkElementPresentMessage(String arg1){
		 System.out.println("***Page Element " + arg1.toUpperCase() +" is displayed successfully***");
	 }
	 	 // differnt from above this checks for webelement
	 
	 public void checkIfOnRightPage(String arg1) throws InterruptedException {
			System.out.println("****************Page Name*************************" +arg1);
			Thread.sleep(5000);
			String title = driver.getTitle();
			System.out.println("The page title is " +title);
			Assert.assertTrue(driver.getTitle().contains(arg1));
	 }
	 
	 public void checkDropDownDefaultValue(String arg2){
		 
			DBUtilities createXpath = new DBUtilities(driver);
			String myXpath = createXpath.xpathMakerContainsText(arg2);
			System.out.println("Successfully displays in combo box" + myXpath);
				
			Assert.assertTrue(driver.findElement(By.xpath(myXpath)).isDisplayed()); 
	 }
	 
	 public void checkForImage(String arg1){
		 DBUtilities createXpath = new DBUtilities(driver);
		 String myXpath = createXpath.xpathMakerByImageName(arg1);
		 Assert.assertTrue(driver.findElement(By.xpath(myXpath)).isDisplayed());
	 }
	 
	 public void checkPopUpMessage(String arg1)
	 {
		 String popUpMessage = driver.switchTo().alert().getText();
		 Assert.assertTrue(arg1, popUpMessage.equals(arg1));
	 }
	 
	 public void isTextPresent(String arg1) throws InterruptedException {
		 System.out.println(" ****" +arg1);
		 Thread.sleep(4000);
		 if(driver.getPageSource().contains(arg1)) {
		 	System.out.println("Text " +arg1+ "is present");
		 } 
		 else {
		 	System.out.println("Text " +arg1+ "NOT present");
		 }
	 }
	 
	 
	 public void checkUIElementTEXTIsDisplayed (String arg1) throws InterruptedException {
		  DBUtilities checkElementDisplayed = new DBUtilities(driver);
		  // String myxpath=checkElementDisplayed.xpathMaker(arg1);
		  String myxpath = checkElementDisplayed.xpathMakerContainsText(arg1);                                // keep an eye...changed because of 520
		  System.out.println("checking for text " +myxpath);
	
		  driver.getPageSource().contains(arg1);
		  Assert.assertTrue(" Varification failed as " +arg1 +"NOT FOUND",driver.getPageSource().contains(arg1));
		  //  Assert.assertTrue(" Varification failed as " +myxpath +"NOT FOUND",driver.findElement(By.xpath(myxpath)).isDisplayed());
	
		  if (driver.findElements(By.xpath(myxpath)).size() != 0){
			  System.out.println("Element is Present");
		  }
		  else
		  {
			  System.out.println("Element is Absent");
		  }
	}
	 
	 public void checkElementPresentOnScreen(DataTable table) throws InterruptedException {
			
		List<List<String>> data = table.raw();
		System.out.println(" value is ++" +data);
		for (int i = 1; i <data.size(); i++) {
			Thread.sleep(3000);
			String name = data.get(i).get(1);
			System.out.println(" and the name is+++++" +name);
//			if(name.equals("Current_Bill")
//					||name.equals("Pay")
//					||name.equals("Submit")
//					||name.equals("Cancel")
//					||name.equals("Date")
//					||name.equals("Activity")
//					||name.equals("Description")
//					||name.equals("Type")
//					||name.equals("Amount")
//					){
//				Thread.sleep(3000);
//				//DBUtilities createXpath = new DBUtilities(driver);
//				//String myxpath = createXpath.xpathMakerById(name);
//				String myxpath =	new DBUtilities(driver).xpathMakerById(name);
//				System.out.println(" and element............" +myxpath + "is displayed successfully");
//				Assert.assertTrue(" Varification failede as " +myxpath +"NOT FOUND",driver.findElement(By.xpath(myxpath)).isDisplayed());
//				
//			} 
//			else if(name.equals("About Us")||name.equals("People")||name.equals("Partners")){
//				String myxpath = new DBUtilities(driver).xpathMakerSpanContainsText(name);
//				System.out.println("*checking for*  " +myxpath); 
//				if(driver.findElements(By.xpath(myxpath)).size() != 0){
//					System.out.println("Element is Present");
//				}
//				else {
//					System.out.println("Element is Absent");
//				}
//				Thread.sleep(2000);
//				Assert.assertTrue(" Varification failede as " +myxpath +"NOT FOUND",driver.findElement(By.xpath(myxpath)).isDisplayed());
//			} 
//			

				
			String myxpath = new DBUtilities(driver).xpathMakerContainsText(name);
			System.out.println("*checking for*  " +myxpath); 
			try {
				Assert.assertTrue(driver.findElement(By.xpath(myxpath)).isDisplayed());
			}
			catch (AssertionError ae){
				ae.printStackTrace();
				myxpath = new DBUtilities(driver).xpathMakerSpanContainsText(name);
				System.out.println("*checking for*  " +myxpath); 
				Assert.assertTrue(driver.findElement(By.xpath(myxpath)).isDisplayed());
			}
			
			
			if(driver.findElements(By.xpath(myxpath)).size() != 0){
				System.out.println("Element is Present");
			}
			else {
				System.out.println("Element is Absent");
			}
			Thread.sleep(2000);
		}
		
	}
	 
	public void checkUIElementIsDisplayed (String arg1) throws InterruptedException{
	//  if (arg1.equals("Please wait while we retrieve your account...")|| arg1.equals("Please contact Simply Energy on 13 88 08 to set up your Direct Debit")){
		if (arg1.equals("Please wait while we retrieve your account...")){
			DBUtilities checkElementDisplayed = new DBUtilities(driver);
			String myxpath=checkElementDisplayed.xpathMakerSpanClass(arg1);
			Assert.assertTrue(driver.findElement(By.xpath(myxpath)).isDisplayed());  
	  
		}
		
		// for the copyright stuff

		else {
			DBUtilities checkElementDisplayed = new DBUtilities(driver);
			String myxpath=checkElementDisplayed.xpathMakerBySpanID(arg1);
			System.out.println("**" +myxpath);
			Thread.sleep(2000);
			Assert.assertTrue(" Varification failed as " +myxpath +"NOT FOUND",driver.findElement(By.xpath(myxpath)).isDisplayed());
	  
			if(driver.findElements(By.xpath(myxpath)).size() != 0){
				System.out.println("Element is Present"); 
			}
			else{
				System.out.println("Element is Absent");
			}
		}
	}
	
	public void checkURL(String arg1, boolean newtab) throws InterruptedException {

		if (newtab){
			String oldTab = driver.getWindowHandle();
			ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
			
			// TODO: find a way to avoid using hard-coded numbers
			
			driver.switchTo().window(tabs.get(1));
			
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL, arg1);
			driver.switchTo().window(tabs.get(0));
			
		}
		else {
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL, arg1);
		}
	}
	
	public void checkTitle(String arg1){
		Assert.assertTrue(driver.getTitle().contains(arg1));
	}
	
	public void checkCSSValue(String arg3, String arg1, String arg2){
		DBUtilities checkElementDisplayed = new DBUtilities(driver);
		String myxpath=checkElementDisplayed.xpathMakerContainsText(arg3);
		WebElement we1;
		String cssValue;
		try {
			we1 = driver.findElement(By.xpath(myxpath));
		}
		
		// if a text match fails, try an image...
		catch (NoSuchElementException nsee){
			System.err.println("Could not find a match for text! Now trying an image match...");
			myxpath = checkElementDisplayed.xpathMakerByImageName(arg3);
			we1 = driver.findElement(By.xpath(myxpath));
		}
		cssValue = we1.getCssValue(arg1);
		Assert.assertEquals(cssValue, arg2);
	}
	
	// there must be a way to refactor this...
	public void checkCSSValueByProperty(String arg3, String arg1, String arg2){
		DBUtilities checkElementDisplayed = new DBUtilities(driver);
		String myxpath=checkElementDisplayed.xpathMakerContainsId(arg3);
		WebElement we1;
		String cssValue;
		try {
			we1 = driver.findElement(By.xpath(myxpath));
		}
		// if a text match fails, try an image...
		catch (NoSuchElementException nsee){
			System.err.println("Could not find a match for id! Now trying an class match...");
			myxpath = checkElementDisplayed.xpathMakerContainsClass(arg3);
			we1 = driver.findElement(By.xpath(myxpath));
		}
		cssValue = we1.getCssValue(arg1);
		Assert.assertEquals(cssValue, arg2);
	}
		
}
	 
	

