package reporting.com.HTMLReports;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import cucumber.api.DataTable;

public class DBUtilities extends XPathGenerator {
	
	//constructor
	public DBUtilities (WebDriver dr){
		super(dr);
	}
	 
	

	 

	 
	 
	
	 
	
	 
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//++++++++++++++++++++++++++++++++++FUNCTIONS OF OTHER PURPOSES++++++++++++++++++++++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 
	 
	 public void selectDropdownValue(String arg1, String arg2) throws InterruptedException
     {
   	  String myxpath= new DBUtilities(driver).xpathMakerContainsText(arg1);
   	  driver.findElement(By.xpath(myxpath)).click();
   	  
   	  String myxpath2= new DBUtilities(driver).xpathMakerById(arg2);
   	  driver.findElement(By.xpath(myxpath2)).click();
   	  
//   		
     }
	   
	 /***********************this is to hover over an element****************************/
	 public void hoverOverElement(String arg1, String arg2) throws InterruptedException
	 {
		DBUtilities createXpath = new DBUtilities(driver);
		String myXpath = createXpath.xpathMakerByClass(arg1);
		System.out.println("successfully dispays hint which was marked as infoicon before" +arg1);
		//String myXpath2 = createXpath.xpathMakerContainsText(arg2);
		 
		Assert.assertTrue(driver.findElement(By.xpath(myXpath)).isDisplayed()); 
		Actions action = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(myXpath));
		action.moveToElement(we).click().build().perform();
		 
		// check for message to appear when icon is hovered on
		Thread.sleep(1000);
		if(driver.getPageSource().contains(arg2)) {
			System.out.println("Text is present" +arg2);
		}
		else {
			System.out.println("Text is absent" +arg2);
		}
	 }
	 
	 public void hoverOverOnly(String arg1) throws InterruptedException {
		 Actions hover = new Actions(driver);
		 DBUtilities createXpath = new DBUtilities(driver);
		 String myXpath1 = createXpath.xpathMaker(arg1); 
		 WebElement we1 = driver.findElement(By.xpath(myXpath1));
		 Assert.assertTrue(we1.isDisplayed());
		 
		 hover.moveToElement(we1);
		 hover.build();
		 
		 Thread.sleep(5000);
		 
		 
	 }
	 
	 // function designed for DB Results dropdown menus that activate on hover
	 // ideally arg1 is the menu and arg2 is the menu item
	 public void hoverOverAndSelect(String arg1, String arg2) throws InterruptedException {
		 
		 // check that the thing to hover on exists first
		 DBUtilities createXpath = new DBUtilities(driver);
		 String myXpath1 = createXpath.xpathMakerBySpanID(arg1);  // simple xpath for now, menu
		 System.out.println(myXpath1);
		 String myXpath2 = createXpath.xpathMakerByLinkName(arg2); // menu item
		 System.out.println("successfully dispays hint which was marked as infoicon before" +arg1);	 
		 Assert.assertTrue(driver.findElement(By.xpath(myXpath1)).isDisplayed()); 
		 
		 Actions action = new Actions(driver);
		 WebElement we1 = driver.findElement(By.xpath(myXpath1)); // for args1
		 action.moveToElement(we1).click().build().perform();
		 WebElement we2 = driver.findElement(By.xpath(myXpath2));
		 action.moveToElement(we2).click().build().perform();

//		 WebElement we2 = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(myXpath2)));
		 
		 // // for args2
		 
//		 Assert.assertTrue(driver.findElement(By.xpath(myXpath2)).isDisplayed());
//		 action.click();
		 
//		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		 action.click();
//		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		 action.moveToElement(we2);
//		 action.click();
//		 action.perform();
//		 action.moveToElement(we2).build().perform();
//		 we2.click();
//		 action.moveToElement(we1).moveToElement(we2).click().build().perform();
//		 action.moveToElement(we1);
//		 Thread.sleep(5000);
//		 action.moveToElement(we2);
//		 action.click();
//		 action.perform();
		 
//		 Actions hoverOverRegistrar = action.moveToElement(we1);
//		 
//		 we2.click();
//		 hoverOverRegistrar.perform();
		 
	 }
	 
		 // move control to new window and check if the right url is opened
	 public void passControlToNewWindow(String arg1) {
		// It will return the parent window name as a String
		 String parent=driver.getWindowHandle();
		  
		 // This will return the number of windows opened by Webdriver and will return Set of St//rings
		 Set<String>s1=driver.getWindowHandles();
		  
		 // Now we will iterate using Iterator
		 Iterator<String> I1= s1.iterator();
		  
		 while(I1.hasNext())
		 {
		  
			 String child_window=I1.next();
			  
			 // Here we will compare if parent window is not equal to child window then we            will close
			  
			 if(!parent.equals(child_window)) {
				 driver.switchTo().window(child_window);
				 String newPageURL= driver.switchTo().window(child_window).getCurrentUrl();
				 System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++" +newPageURL);
				 Assert.assertEquals(arg1, newPageURL);
			 }
		 }
	 }
		 
	 // capture date and time

	 public String DNT(String[] args) {

		   DateFormat dateFormat = new SimpleDateFormat("ddMMYYYYHHmmss");
	   //get current date time with Calendar()
		   Calendar cal = Calendar.getInstance();
		   String datentime = dateFormat.format(cal.getTime());
		   return datentime;
	  }


	
	 //Check Dropdown value displayed by default	 
	 public static void uploadAnAttachmentFile() throws AWTException, InterruptedException
	 {
		 StringSelection ss = new StringSelection("C:\\Users\\HShori.DBRESULTS\\Desktop\\Jeetu Todos");
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
            // perform keystrokes
            Robot robot = new Robot();
            robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
            Thread.sleep(500);
            robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
            Thread.sleep(500);
            robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
            Thread.sleep(500);
            robot.keyPress(java.awt.event.KeyEvent.VK_V);
            Thread.sleep(500);
            robot.keyRelease(java.awt.event.KeyEvent.VK_V);
            Thread.sleep(500);
            robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
            Thread.sleep(500);
            robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
            Thread.sleep(500);
            robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
	 }


			 
	 public void generateException(String arg1)
	 {
		 System.out.println("********************************************************");
		 System.out.println("***************Element not displayed" +arg1 + "*********");
		 System.out.println("********************************************************");	 
	 }
	 
	 //this function is used for reporting
	 public void writeLog(String arg1) {
		 System.out.println(arg1+ " ** exist on screen");
	 }

			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
			 
}