Feature: Some feature


	@wip
	Scenario Outline: DB Results Dropdown Menu test
		Given I want to login to portal "<PortalName>"
		And I click on "Who We Are"
		Then "<Item>" is displayed as "<ItemName>"
			| Item  | ItemName |
			| Item1 | About Us |
			| Item2 | People   |
			| Item3 | Partners |
		And I click on "About Us" 
		#menu options in DB results are presented as spans
		Then I wait for "2" seconds
		
		Examples:
			| PortalName |
			| DBResults  |
		
		
		#Then I hover over "Who We Are" and select "About Us"
		#Then I hover over "Who We Are"
		#hen I see "Projects" displayed
#		Then I hover on "dropdown_top" to verify "Projects" is displayed
		

  
  #Scenario Outline: As a product owner, I want the correct SelfServe.Cloud logo / OutSystems Logo to be displayed on the partners page (DRSP-22 / DRSP-23)
    #Given I want to login to portal "SelfServePortal"
    #And I click on "<PageName>"
    #Then I see the image "<ImageName>"
#
    #Examples: 
      #|  PageName | ImageName               |
      #|  Partners | selfserver_logo.png?316 |
      #|	 Partners | OutSystems_logo_colour.png?w=200 |

  #Scenario Outline: DCSSP-117,167,754 : Goals and Targets setting,verification and removal.
    #Given I want to login to portal "<PortalName>"
    #
      #| Item  | ItemName         |
      #| Item1 | Mandatory Fields |
      #| Item1 | Sign In          |
      #| Item1 | Forgot Password? |
      #| Item1 | Create Account   |
    #And I enter then details as
      #| Fields        | Value      |
      #| UserNameInput | <UserName> |
      #| PasswordInput | <Password> |
    #And I hit Enter
    #And I click on "Usage"
    #Then "<Item>" is displayed as "<ItemName>"
      #| Item  | ItemName        |
      #| Item1 | Usage History   |
      #| item1 | Goals & Targets |
    #And I click on "Goals & Targets"
    #Then I check I am on "Goals and Targets" page
    #Then "<Item>" is displayed as "<ItemName>"
      #| Item  | ItemName        |
      #| Item3 | Goals & Targets |
      #| Item4 | Starter         |
      #| Item6 | Saver           |
      #| Item7 | Eco             |
      #| Item7 | Custom          |
    #
    #Then I see "This goal will be applied for the next 12 months. Your goal traker will reset to the selected goal. Are you sure you want to update your goals?" displayed on popup and I click "OK"
    #Then I see "5% Starter Goal" displayed
     #And I click on "Sign Out"
    #And I check I am on "Login" page
    #And I enter then details as
      #| Fields        | Value      |
     #| UserNameInput | <UserName> |
      #| PasswordInput | <Password> |
    #And I hit Enter
    #And I check I am on "Dashboard" page
    #And I click on "Usage"
    #And I click on "Goals & Targets"
    #Then I check I am on "Goals and Targets" page
    #Then I see "5% Starter Goal" displayed
    #And I click on "MenuIcon"
    #And I click on "Remove Goal"
    #Then I see "Are you sure you want to remove your savings goal?" displayed on popup and I click "OK"
    #Then I see "Goal removed successfully." displayed
#
    #Examples: 
      #| PortalName | UserNameField | PasswordField | UserName | Password   |
      #| CSS        | UserNameInput | PasswordInput | Michael  | Dbresults1 |
