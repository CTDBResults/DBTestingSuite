package reporting.com.HTMLReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage extends DBUtilities {


	public HomePage(WebDriver dr) {
		super(dr);
		
	}

	public void navigateTo(String arg1)  {
		if (arg1.equals("DBResults")){
			driver.get("https://dbresults.com.au");

		} 
		else if(arg1.equals("SelfServeCloud")){
			driver.get("https://test.dbresults.com.au/selfservecloud");
		}
	    else if(arg1.equals("SelfServePortal")) {           // this is for semi-automated tests as the link will be coming from the received mail
        //following is for SIT
	    	driver.get("http://selfserveportal.com/");
	    }

		
	}
	
	
}
