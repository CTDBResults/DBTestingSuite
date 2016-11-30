Feature: DB Website testing file	
			
@db_done
Scenario Outline: DWP-71
		Given I want to login to portal "<PortalName>"
		And I see text "Newsroom" displayed
		Then I click on "Newsroom"
		Then I check I have gone to the URL "<Link>"
		
	Examples:
		| PortalName | Link |
		| DBResults | https://dbresults.com.au/newsroom/?StartIndex=0 |
	
@db_done
Scenario Outline: DWP-80: News article title
	Given I want to login to portal "<PortalName>"
	And I see text "Newsroom" displayed
	And I click on "Newsroom"
	And I check I have gone to the URL "<Link>"
	Then I check that object with class "card-link btn " exists
	Then I click on object with class "card-link btn "
	Then I check that object with class "section-title" exists
	Then I check that object of class "section-title" has CSS property "color" with value "rgba(32, 72, 123, 1)"

	
	Examples:
		| PortalName | Link |
		| DBResults | https://dbresults.com.au/newsroom/?StartIndex=0 |
		
@db_done
Scenario Outline: DWP-88: News article title
	Given I want to login to portal "<PortalName>"
	And I see text "Newsroom" displayed
	And I click on "Newsroom"
	And I check I have gone to the URL "<Link>"
	Then I check that object with class "card-link btn " exists
	Then I click on object with class "card-link btn "
	Then I check that object with class "section-title" exists
	Then I check that object of class "section-title" has CSS property "color" with value "rgba(32, 72, 123, 1)"

	
	Examples:
		| PortalName | Link |
		| DBResults | https://dbresults.com.au/newsroom/?StartIndex=0 |
		
@db_done
Scenario Outline: DWP-86: Article Image
	Given I want to login to portal "<PortalName>"
	And I see text "Newsroom" displayed
	And I click on "Newsroom"
	Then I check that object with class "<buttonClass>" exists
	Then I click on object with class "<buttonClass>"
	Then I check that object with class "<ImageClass>" exists
	Then I check that object of class "<ImageClass>" has CSS property "width" with value "899.969px"
	Examples:
		| PortalName | buttonClass | ImageClass |
		| DBResults | card-link btn | image-media |
		
@db_done
Scenario Outline: DWP-186: No results found Search Page
	Given I want to login to portal "<PortalName>"
		Then I click on object with class "<SearchClass>"
		And I check that object with id "<SearchId>" exists
		Then I click on object with id "<SearchId>"
		Then I enter input as "asfihasuilfgasliudfgaslidfgsdfafasdfasdfsadfvasdf"
		Then I hit Enter
		Then I wait for "5" seconds
		Then I see text "No results found for your current search term" displayed
		Then I see text "Try searching again by using different or more general keywords and check for spelling errors" displayed
	Examples:
		| PortalName | SearchClass | SearchId |
		| DBResults  | fa fa-fw fa-search | search-text |
		
@db_done
Scenario Outline: DWP-187: Search bar on Search Results page
	Given I want to login to portal "<PortalName>"
		Then I click on object with class "<SearchClass>"
		Then I click on object with id "<SearchId>"
		Then I enter input as "Test Input"
		Then I hit Enter
		Then I wait for "5" seconds
		Then I check that object with class "search-text-result" exists
	Examples:
		| PortalName | SearchClass | SearchId |
		| DBResults  | fa fa-fw fa-search | search-text |
		
@db_done
Scenario Outline: DWP-252: Create People page
	Given I want to login to portal "<PortalName>"
	And I click on "Who We Are"
	Then "<Item>" is displayed as "<ItemName>"
		| Item  | ItemName |
		| Item1 | About Us |
		| Item2 | People   |
		| Item3 | Partners |
	And I click on "People" 
	# menu options in DB results are presented as spans
	Then I wait for "2" seconds
	Then I check I have gone to the URL "<URL>" 
	Examples:
		| PortalName | URL |
		| DBResults  | https://dbresults.com.au/People.aspx	|

@db	
Scenario Outline: DWP-252: Create People page
	Given I want to login to portal "<PortalName>"
	Then I see text "Newsroom" displayed
	Then I see text "What We Do" displayed
	And I click on "What We Do"
	Then "<Item>" is displayed as "<ItemName>"
		| Item  | ItemName  | 
		| Item1 | Projects  |
		| Item2 | Services  |
	Then I see text "Who We Are" displayed
	And I click on "Who We Are"
	Then "<Item>" is displayed as "<ItemName>"
		| Item  | ItemName |
		| Item1 | About Us |
		| Item2 | People   |
		| Item3 | Partners |
	Then I see text "Careers" displayed
	Then I see text "Contact" displayed
	Examples:
		| PortalName |
		| DBResults  |

		