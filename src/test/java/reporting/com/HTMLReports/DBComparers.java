package reporting.com.HTMLReports;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DBComparers extends DBUtilities {
	public DBComparers (WebDriver dr) {
		super(dr);
	}
	
	 //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 //++++++++++++++++++++++++++++++++++FUNCTIONS THAT COMPARE++++++++++++++++++++++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 
	
	public void readAndCompareTableRows(String arg1, String arg2 ,int arg3)
	 {
		 System.out.println("Balley balley ni taur ni punjabban di");
		 DBUtilities createXpath = new DBUtilities(driver);
		 String myXpath = createXpath.xpathMakerByTextInClass(arg1);
		
		 System.out.println("So the xpath for table is " +myXpath);
		// List<WebElement> rows = driver.findElements(By.xpath(myXpath));
		 List<WebElement> rows = driver.findElements(By.xpath(myXpath));
		 System.out.println("Balley balley ni taur ni punjabban di Total number of rows :"+ rows.size());
			 
	 }
	 
	 public String compare2DollarValues(String value1,  String value2){
		    
	    	String result;
	    	System.out.println(""+value1);
	    	System.out.println(""+value1);
	    	
			String newValue1 = value1.replaceAll("[^\\d.]+", "");
			System.out.println(" its "+newValue1);
			double intnewValue1 = Double.parseDouble(newValue1);
			System.out.println(" its**************************** "+intnewValue1);
			String newValue2 = value2.replaceAll("[^\\d.]+", "");
			System.out.println(" its "+newValue2);
			double intnewValue2 = Double.parseDouble(newValue2);
			System.out.println(" its*********************** "+intnewValue2);
	    		
			if(intnewValue1<=intnewValue2){
				System.out.println("Service total is Less then account total");
				result  = "Service total is Less then account total";
			}
			else {
				System.out.println("Service total is ***********MORE******** then account total");
				result = "Service total is ***********MORE******** then account total";
			}
				
	    		return result;
	 }
	 
	 public void compareValueOneToValueTwo(String arg1, String arg2){
  	  
  	  
		DBUtilities createXpath = new DBUtilities(driver);
		String myxpath = createXpath.xpathMakerContainsId(arg1);
		String currentBill = driver.findElement(By.xpath(myxpath)).getText();
		
		
		String myxpath2 = createXpath.xpathMakerContainsId(arg2);
		String lastBill = driver.findElement(By.xpath(myxpath2)).getText();
		System.out.println(lastBill);
		
		
		String newCurrentBill = currentBill.replaceAll("[^\\d.]+", "");
		//System.out.println(" its "+newCurrentBill);
		double intnewCurrentBill = Double.parseDouble(newCurrentBill);
		System.out.println(" its**************************** "+intnewCurrentBill);
		String newLastBill = lastBill.replaceAll("[^\\d.]+", "");
		//System.out.println(" its "+newLastBill);
		double intnewLastBill = Double.parseDouble(newLastBill);
		System.out.println(" its*********************** "+intnewLastBill);

  		//if val1<val2
  		if (intnewCurrentBill<intnewLastBill) {
  			DBUtilities createXpath3 = new DBUtilities(driver);
      		String myxpath3 = createXpath3.xpathMakerSpanClass("fa fa-fw fa-caret-down");
      	 //driver.findElement(By.xpath(myxpath3)).getText();
      		Assert.assertTrue(driver.findElement(By.xpath(myxpath3)).isDisplayed());
      	 
  			System.out.println("*******************it should be greeen and arrow is pointing down**************");
  		}
  		else if(intnewCurrentBill>intnewLastBill) {
  			System.out.println("*****************it should be red and arrow is pointing up*****************");
  			DBUtilities createXpath4 = new DBUtilities(driver);
      		String myxpath4 = createXpath4.xpathMakerSpanClass("fa fa-fw fa-caret-up");
      		Assert.assertTrue(driver.findElement(By.xpath(myxpath4)).isDisplayed());
  		}
	
    }
}
