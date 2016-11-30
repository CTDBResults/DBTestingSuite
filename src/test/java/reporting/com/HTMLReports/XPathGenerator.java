package reporting.com.HTMLReports;

import org.openqa.selenium.WebDriver;

public class XPathGenerator {

	 WebDriver driver = null;

	//constructor
	 public XPathGenerator (WebDriver dr){
			this.driver = dr;
	 }
	 
	 
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//++++++++++++++++++++++++++++++++++TEXT XPATHS++++++++++++++++++++++++++++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 
	 // searches through all text nodes
	 public String xpathMaker(String buttonName)
	 {
		String xpath = "//*[text()='"+buttonName+"']";
		 return xpath;
	 }
	 
	 public String xpathMakerBySpanID(String buttonName)
	 {
		String xpath = "//span[text()='"+buttonName+"']";
		            
		 return xpath;
	 }
	 
	 public String xpathMakerSpanContainsText(String buttonName)
	 {
		String xpath = "//span[contains(text(),'"+buttonName+"')]";
		 return xpath;
	 }
	 
	 public String xpathMakerContainsText(String buttonName)
	 {
		String xpath = "//*[contains(text(),'"+buttonName+"')]";
		 return xpath;
	 }
	 public String xpathMakerByLinkName(String arg1){
		 String xpath = "//a[contains(text(), '" + arg1 +"' )]";
		 return xpath;
	 }
	 
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//++++++++++++++++++++++++++++++++++ID XPATHS++++++++++++++++++++++++++++++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 
	 public String xpathMakerById(String buttonName)
	 {
		String xpath = "//*[@id = '"+buttonName+"']";
		System.out.println("Button found*** " +xpath);
		 return xpath;
	  }
	 public String xpathMakerContainsId(String buttonName)
	 {
		String xpath = "//*[contains(@id, '"+buttonName+"')]";
		System.out.println("Button found*** " +xpath);
		 return xpath;
	 }
	 public String xpathMakerForInputField(String fieldName)
	 {
		String xpath = "//*[@id='"+fieldName+"']";
		System.out.println(" its " +xpath);
		 return xpath;

	 }
	 
	 public String xpathMakerByInputId(String arg1)
	 {
		  String xpath = "//input[contains(@id, '"+arg1+"')]";
		System.out.println("Element found*** " +xpath);
		 return xpath;
	 }
	 
	 public String xpathMakerByTextAreaId(String arg1)
	 {
		  String xpath = "//textarea[contains(@id, '"+arg1+"')]";
		System.out.println("Element found*** " +xpath);
		 return xpath;
	 }
	 
	 public String xpathMakerById1AndId2(String arg1,String arg2)
	 {
		String xpath = "//*[contains(@id, '"+arg1+"')][contains(@id, '"+arg2+"')]";
		
		System.out.println(" its " +xpath);
		 return xpath;
	 }
	 
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//++++++++++++++++++++++++++++++++++CLASS XPATHS+++++++++++++++++++++++++++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	 
	
	//span[@class='nav-selection']
	 public String xpathMakerSpanClass(String buttonName)
	    {
		String xpath = "//span[@class='"+buttonName+"']";
		 return xpath;
	    }
	 // for input fields with input id
	 
	 public String xpathMakerByClass(String buttonName)
	    {
		//*[@class = 'InfoTooltip OSInline']
		String xpath = "//*[@class ='"+buttonName+"']";
		 return xpath;
	    }
	 
	 public String xpathMakerContainsClass(String buttonName)
	    {
		//*[@class = 'InfoTooltip OSInline']
		String xpath = "//*[contains(@class, '"+buttonName+"')]";
		 return xpath;
	    }
	 
	//xpath creation by ClassName
	public String xpathMakerByTextInClass(String text)
	{
			String xpath = "//*[contains(@class, '"+text+"')]";
			
			 return xpath;
	}
	
	
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//++++++++++++++++++++++++++++++++++OTHER XPATHS+++++++++++++++++++++++++++++++++++++++++++++
	//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++	
	
	 
	 //xpath creation by type
	 public String xpathMakerByType(String name)
	 {
		String xpath = "//*[@type ='"+name+"']";
		 return xpath;
	 }

	 public String xpathMakerByImageName(String arg1){
		 //String xpath = "//img[@src=\"/*/*/#{'" + arg1 + "'}\"]";
		 //String xpath = "//img[@src='" + arg1 + "']";
		 String xpath = "//img[contains(@src, '" + arg1 + "')]";
		 System.out.println(xpath);
		 return xpath;
	 }
	 
	 
	
}
