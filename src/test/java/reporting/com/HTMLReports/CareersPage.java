package reporting.com.HTMLReports;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CareersPage extends DBUtilities {
	public CareersPage (WebDriver dr) {
		super(dr);
	}
	
	public void checkNegativeText(String arg1){
		String myXpath = PageFactory.initElements(driver, DBUtilities.class).xpathMakerContainsText(arg1);
		
		// check that the 'size' is 0
		//Assert.assertEquals(0, driver.findElement(By.xpath(myXpath)).getSize());
		try {
			Assert.assertTrue(driver.findElement(By.xpath(myXpath)).isDisplayed()); // an exception should be thrown here
			Assert.assertTrue(false); // this means there's an error; i.e. the text is found
		}
		catch (NoSuchElementException nsee) {
			// this means the text's found, which is what we want
			Assert.assertFalse(false);
		}
	}
}
