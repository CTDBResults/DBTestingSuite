Feature: Testing suite for the self serve cloud

  @linkedin_test
  Scenario Outline: DRSC-1/12: As a user, I want to be sent to the SelfServe.Cloud LinkedIn page when clicking a link/button in Footer of each page
    Given I want to login to portal "<PortalName>"
    #Then I see text "LinkedIn" displayed
    Then I wait for "3" seconds
    Then I click on "LinkedIn"
    And I check I have gone to the URL "<URL>" in a new tab

    #Then I hover over "Who We Are"
    #Then I see "Projects" displayed
    #		Then I hover on "dropdown_top" to verify "Projects" is displayed
    Examples: 
      | PortalName     | URL                                              |
      | SelfServeCloud | https://www.linkedin.com/company/selfserve.cloud |

  @ssc_done
  Scenario Outline: DRSC-2: As a product owner, I want the company name on tabs in the browser to be listed as SelfServe.Cloud
    Given I want to login to portal "<PortalName>"
    Then I see the page tab title displayed as "SelfServe.Cloud"

    Examples: 
      | PortalName     |
      | SelfServeCloud |

  @ssc_done
  Scenario Outline: DRSC-3: As a product owner, I want the SelfServe.Cloud company logo to be displayed at the top left hand side of the site
    Given I want to login to portal "<PortalName>"
    Then I see the image "<ImageName>"

    Examples: 
      | PortalName     | ImageName             |
      | SelfServeCloud | SSCLogoResizedPNG.png |

  @ssc_done
  Scenario Outline: DRSC-5: As a product owner, I want the footer section of the the website to contain links to associated privacy and terms of use agreements
    Given I want to login to portal "<PortalName>"
    And I click on "<PageName>"
    Then I check I have gone to the URL "<PageLink>"

    Examples: 
      | PortalName     | PageName     | PageLink                                                                                 |
      | SelfServeCloud | Privacy      | https://test.dbresults.com.au/selfservecloud/Privacy.aspx?(Not.Licensed.For.Production)= |
      | SelfServeCloud | Terms of Use | https://test.dbresults.com.au/selfservecloud/Terms.aspx?(Not.Licensed.For.Production)=   |


@ssc
	Scenario Outline: DRSP-9: As a user, I want the websites search function to search the SelfServePortal website for key terms
		Given I want to login to portal "<PortalName>"
		Then I click on object with class "fa fa-search"
		And I check that object with id "search-text" exists
		Then I click on object with id "search-text"
		Then I enter input as "Test"
		Then I hit Enter
		Then I wait for "5" seconds
		Then I see text "Search results for" displayed
	
	Examples:
			| PortalName | 
			| SelfServeCloud |

  @ssc_done
  Scenario Outline: DRSC-20: As a product owner, I want the footer of each page of the website to contain a copyright for the SelfServe.Cloud website
    Given I want to login to portal "<PortalName>"
    Then I see the copyright logo displayed
    | PortalName     | ImageName                  |
    
    
  @ssc
  Scenario Outline: DRSC-24/25: 	As a product owner, I want the logos on the Partners page to be centered over their corresponding text. As a product owner, I want to replace the logo in the menu header with the navy version
    Given I want to login to portal "<PortalName>"
		Then I see the image "<ImageName>"
    Then I check that "<ImageName>" has CSS property "width" with value "120px"
    Examples: 
      | PortalName     | ImageName                  |
      | SelfServeCloud | SSCLogoResizedPNG.png      |
      


  @ssc_done
  Scenario Outline: DRSC-27: As a product owner, I want to replace the 'No items to show' text on the Our Projects page with 'Coming Soon'
    Given I want to login to portal "<PortalName>"
    And I click on "Projects"
    Then I see "Coming Soon" displayed

    Examples: 
      | PortalName     |
      | SelfServeCloud |

  @ssc_done
  Scenario Outline: DRSC-29: 	As a product owner, I want to increase the size of the About Us Summary text (to 30px)
    Given I want to login to portal "<PortalName>"
    And I click on "About Us"
    Then I check that "<Text>" has CSS property "font-size" with value "30px"

    Examples: 
      | PortalName     | Text                                                                                                                      |
      | SelfServeCloud | SelfServe.Cloud is a digital product company focused on strengthening behavioral interaction between the utility industry |

  @ssc_done
  Scenario Outline: DRSC-30: 	As a product owner, I want the body text on the About Us page to match the Summary text, but one step smaller (24px)
    Given I want to login to portal "<PortalName>"
    And I click on "About Us"
    Then I check that "<Text>" has CSS property "font-size" with value "24px"
    Then I check that "<Text2>" has CSS property "font-size" with value "30px"

    Examples: 
      | PortalName     | Text                                                | Text2                                                                                        |
      | SelfServeCloud | SelfServe.Cloud encompasses a world-class team with | SelfServe.Cloud is a digital product company focused on strengthening behavioral interaction |

  @ssc_done
  Scenario Outline: DRSC-31: 	As a product owner, I want the logos on the Partners page to be centered over their corresponding text
    Given I want to login to portal "<PortalName>"
    And I click on "Partners"
    Then I check that "<ImageName>" has CSS property "text-align" with value "center"

    Examples: 
      | PortalName     | ImageName                  |
      | SelfServeCloud | OutSystems_logo_colour.png |
      | SelfServeCloud | Oracle-logo.png?           |
      | SelfServeCloud | dbr1.jpg                   |

  @ssc_done
  Scenario Outline: DRSC-32: 	As a product owner, I want the Graduate Program section of the Careers page to be removed
    Given I want to login to portal "<PortalName>"
    And I click on "Partners"
    Then I see "Graduate Program" not displayed

    Examples: 
      | PortalName     |
      | SelfServeCloud |

  @ssc_done
  Scenario Outline: DRSC-36: 	As a product owner, I want the OutSystems logo on the partners page to be the latest one.
    Given I want to login to portal "<PortalName>"
    And I click on "Partners"
    Then I see the image "<ImageName>"

    Examples: 
      | PortalName     | ImageName                  |
      | SelfServeCloud | OutSystems_logo_colour.png |
