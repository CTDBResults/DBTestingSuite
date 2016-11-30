package reporting.com.HTMLReports;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.DataTable;

public class DBClickOrPress extends DBUtilities {
	public DBClickOrPress(WebDriver dr){
		super(dr);
	}
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//++++++++++++++++++++++++FUNCTIONS THAT CLICK OR PRESS BUTTONS+++++++++++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	// action performed on element(coming as arg)
		 public void actionPerformedClick (String arg1) {
			 System.out.println("Successfully displayed Link" +arg1 );
			 System.out.println("Clicking on " +arg1.toUpperCase());	 
		 }

		 public void hitEnter() {
			 Actions action = new Actions(driver); 
			 action.sendKeys(Keys.ENTER).build().perform();
			 //action.sendKeys(Keys.RETURN);
		 }
		 
		 public void clickOnPopUP(String arg1) throws InterruptedException
		 {
			 if(arg1.equals("OK")){
			 	Thread.sleep(5000);
				driver.switchTo().alert().accept();
				System.out.println("Clicking " +arg1 +" on PopUp");
			 }
			 else if(arg1.equals("Cancel")){
				Thread.sleep(5000);
				driver.switchTo().alert().dismiss();
				System.out.println("Clicking " +arg1 +" on PopUp");
			 }
		 }
		 
		 public void enterCucumbertableValuesInUI (DataTable table) throws InterruptedException 
		 {
		
			List<List<String>> data = table.raw();
			
			for (int i = 1; i <data.size(); i++){
				String name = data.get(i).get(1);
				System.out.println("The table length is .." +data.size());
				
				DBUtilities createXpath = new DBUtilities(driver);
				String myXpath = createXpath.xpathMakerByInputId(data.get(i).get(0));
				try {
					Assert.assertTrue(driver.findElement(By.xpath(myXpath)).isDisplayed());
				}
				// in case the field is a textarea instead of an input
				catch (NoSuchElementException nsee){
					myXpath = createXpath.xpathMakerByTextAreaId(data.get(i).get(0));
					Assert.assertTrue(driver.findElement(By.xpath(myXpath)).isDisplayed());
				}
				driver.findElement(By.xpath(myXpath)).clear();
				Thread.sleep(500);
				driver.findElement(By.xpath(myXpath)).sendKeys(data.get(i).get(1));
				System.out.println("Entering value in table " +myXpath +"as" +name);  
			}
				
		 }
		 
		 public void checkBoxClick(String arg1){
			 DBUtilities createXpath = new DBUtilities(driver);
			 String myxpath =  createXpath.xpathMakerByType(arg1);
		     driver.findElement(By.xpath(myxpath)).click();
			 
		}

		public void hitTab() {
			 Actions action = new Actions(driver); 
			 action.sendKeys(Keys.TAB).build().perform();
		}
}
