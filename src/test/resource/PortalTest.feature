Feature: Testing Suite for the SelfServePortal website. See bottom of file for user stories not done and their reasons.

#Sample Feature Definition Template
@ssp_done
Scenario Outline: DRSP-1: As a product owner, I want to remove the link to LinkedIn page on the footer of the website
	Given I want to login to portal "<PortalName>"
	Then I see "LinkedIn" not displayed
	
	Examples:
		| PortalName      | 
		| SelfServePortal |

@ssp_done
Scenario Outline: DRSP-2: As a product owner, I want the Footer sections of the each page on the website to contain links to associated privacy and terms of use agreements
	Given I want to login to portal "<PortalName>"
	And I see text "<PageName1>" displayed
	Then I click on "<PageName1>"
	Then I check I have gone to the URL "<URL1>"
	And I see text "<PageName2>" displayed
	Then I click on "<PageName2>"
	Then I check I have gone to the URL "<URL2>"
	And I see text "<Text1>" displayed
	
	Examples:
		| PortalName      | PageName1 | URL1                                | PageName2    | URL2                              | Text1 																																				 | 
		| SelfServePortal | Privacy   | http://selfserveportal.com/privacy/ | Terms of Use | http://selfserveportal.com/terms/ | This SelfServeMe website is owned and operated by SelfServeMe and SelfServeMe |

@ssp_done
Scenario Outline: DRSP-3: As a product owner, I want the SelfServePortal company logo to be displayed at the top left hand side of the site
	  Given I want to login to portal "<PortalName>"
		Then I see the image "<ImageName>"
    Examples: 
      | PortalName      | ImageName                 |
      | SelfServePortal | selfserver_logo.png       |

@ssp_done
Scenario Outline: DRSP-6: 	As a product owner, I want the correct email configuration to be implemented when a user is utilising the Get in Touch function.
		Given I want to login to portal "<PortalName>"
		And I click on "submit" 
		Then I see text "<ErrorMessage1>" displayed
		Then I see "<ErrorMessage2>" not displayed
		And I enter then details as
			| Fields  | Value         |
			| Name    | TESTName      |
		And I click on "submit"
		Then I see text "<ErrorMessage1>" displayed
		Then I see "<ErrorMessage2>" not displayed
		And I enter then details as
			| Fields  | Value         |
			| Name    | TESTName      |
			| Email   | TEST			    |
		And I click on "submit" 
		Then I see text "<ErrorMessage1>" displayed
		Then I see text "<ErrorMessage2>" displayed
		And I enter then details as
			| Fields  | Value         |
			| Name    | TESTName      |
			| Email   | TEST 					|
			| Message | <TestMessage> |
		And I click on "submit" 
		Then I see text "<ErrorMessage2>" displayed
		Then I see "<ErrorMessage1>" not displayed
		And I enter then details as
			| Fields  | Value         |
			| Name    | TESTName      |
			| Company | TESTComp      |
			| Email   | TEST@TEST.com |
			| Phone   | 00000000      |
			| Message | <TestMessage> |
		And I click on "submit" 
		Then I wait for "3" seconds
		Then I see "<ErrorMessage1>" not displayed
		Then I see "<ErrorMessage2>" not displayed
		Then I see text "Your message has been sent." displayed
    Examples: 
      | PortalName      | PageName1 | PageName2 | TestMessage 						  | ErrorMessage1                       | ErrorMessage2              |
      | SelfServePortal | Products  | Benefits  | Sent by automated Testing | Please fill in the mandatory fields | Please enter a valid email |

@ssp_done
Scenario Outline: DRSP-8: As a product owner, I want the tab description for the Services page and the Projects page to show Products and Benefits respectively.
		Given I want to login to portal "<PortalName>"
		And I see text "<PageName1>" displayed
		Then I click on "<PageName1>"
		Then I check I have gone to the URL "<URL1>"
		And I see text "<PageName2>" displayed
		Then I click on "<PageName2>"
		Then I check I have gone to the URL "<URL2>"
    Examples: 
      | PortalName      | PageName1 | URL1                                 | PageName2 | URL2                                 |
      | SelfServePortal | Products  | http://selfserveportal.com/products/ | Benefits  | http://selfserveportal.com/benefits/ |
	
@ssp_done
Scenario Outline: DRSP-9: As a product owner, I want the company name on tabs in the browser to be listed as SelfServePortal
		Given I want to login to portal "<PortalName>"
    Then I see the page tab title includes "SelfServePortal"
    Examples:
			| PortalName      | 
			| SelfServePortal |

@ssp_done
Scenario Outline: DRSP-14: 	As a product owner, I want the correct email configuration to be implemented when a user is utilising the "Apply Now" function on the Careers page
		Given I want to login to portal "<PortalName>"
		Then I click on "Careers"
		Then I check I have gone to the URL "<URL1>"
		And I see text "Careers at SelfServePortal" displayed
		And I see text "<buttonName>" displayed

    Examples: 
      | PortalName      | URL1                                | buttonName |
      | SelfServePortal | http://selfserveportal.com/careers/ | Apply Now  |

@ssp_done
Scenario Outline: DRSP-16: As a product owner, I want to change the page title on both the Services page and the Projects page to Products and Benefits respectively
		Given I want to login to portal "<PortalName>"
		And I see text "<PageName1>" displayed
		Then I click on "<PageName1>"
		Then I check I have gone to the URL "<URL1>"
		And I see text "<Text1>" displayed
		And I see text "<PageName2>" displayed
		Then I click on "<PageName2>"
		Then I check I have gone to the URL "<URL2>"
		And I see text "<Text2>" displayed
    Examples: 
      | PortalName      | PageName1 | Text1        | URL1                                 | PageName2 | Text2        | URL2                                 |
      | SelfServePortal | Products  | Our Products | http://selfserveportal.com/products/ | Benefits  | Our Benefits | http://selfserveportal.com/benefits/ |
		
@ssp_done
  Scenario Outline: DRSP-19: As a product owner, I want the footer of each page of the website to contain a copyright for the SelfServePortal website
    Given I want to login to portal "<PortalName>"
    Then I see the copyright logo displayed
    Then I see text "SelfServeMe 2016" displayed
    Examples:	
    	| PortalName      |
    	| SelfServePortal |
 @ssp_done
  Scenario Outline: DRSP-23: As a product owner, I want the correct SelfServe.Cloud logo to be displayed on the partners page
    Given I want to login to portal "<PortalName>"
    And I see text "<PageName1>" displayed
		Then I click on "<PageName1>"
    Then I see the image "<ImageName>"
    Examples:	
    	| PortalName      | PageName1 | ImageName             | 
    	| SelfServePortal | Partners  | SSC_Logo_-_300dpi.png |

@ssp_done
  Scenario Outline: DRSP-26/22: As a product owner, I want the OutSystems logo on the partners page to be the latest one.
    Given I want to login to portal "<PortalName>"
    And I see text "<PageName1>" displayed
		Then I click on "<PageName1>"
    Then I see the image "<ImageName>"
    Examples:	
    	| PortalName      | PageName1 | ImageName                  | 
    	| SelfServePortal | Partners  | OutSystems_logo_colour.png |
    	
# <<< USER STORIES NOT DONE >>>

#DRSP-4: 	As a user, I want the websites search function to search the SelfServePortal website for key terms. (There is no search function on the production version of the website)
#DRSP-5: As a product owner, I want any article shared by a user on LinkedIn to contain the SelfServe Portal logo. (Cannot test this. The SelfServePortal logo is not appearing on the popup; the link to the image is needed for testing)
#DRSP-7: As a product owner, I want the image displayed in the tab section of the web browser to be a smaller version of the SelfServePortal logo. (Cannot access the favicon with Selenium) 
#DRSP-10: As a product owner, I want to implement a filter that ensures Google Analytics does not measure traffic on the dev/test sites (Do not have access to Google Analytics)

#DRSP-11: As a product owner, I want to have a dedicated email address to receive information from Google Analytics (No access to Google Analytics) 
#DRSP-12: As a product owner, I want to have a Google Site Search license for the SelfServePortal website. (No access to the license) 
#DRSP-15: As a product owner, I want the correct email configuration to be implemented when a user wants to download a whitepaper. (Opens an external app, cannot access with Selenium). 
#DRSP-20: As a product owner, I want to make sure Google Analytics is tracking the SelfServe Portal website (No access to Google Analytics)

#DRSP-24: As a product owner, I want to update images on the Careers page. (Can’t do this with Selenium)
#DRSP-25: As a product owner, I want to update images in some of the Case Studies (Can’t do this with Selenium)


#All Tasks were also left undone.


