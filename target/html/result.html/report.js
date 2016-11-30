$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resource/CloudTest.feature");
formatter.feature({
  "line": 1,
  "name": "Testing suite for the self serve cloud",
  "description": "",
  "id": "testing-suite-for-the-self-serve-cloud",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "DRSC-1/12: As a user, I want to be sent to the SelfServe.Cloud LinkedIn page when clicking a link/button in Footer of each page",
  "description": "",
  "id": "testing-suite-for-the-self-serve-cloud;drsc-1/12:-as-a-user,-i-want-to-be-sent-to-the-selfserve.cloud-linkedin-page-when-clicking-a-link/button-in-footer-of-each-page",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@linkedin_test"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I want to login to portal \"\u003cPortalName\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "comments": [
    {
      "line": 6,
      "value": "#Then I see text \"LinkedIn\" displayed"
    }
  ],
  "line": 7,
  "name": "I wait for \"3\" seconds",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I click on \"LinkedIn\"",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I check I have gone to the URL \"\u003cURL\u003e\" in a new tab",
  "keyword": "And "
});
formatter.examples({
  "comments": [
    {
      "line": 11,
      "value": "#Then I hover over \"Who We Are\""
    },
    {
      "line": 12,
      "value": "#Then I see \"Projects\" displayed"
    },
    {
      "line": 13,
      "value": "#\t\tThen I hover on \"dropdown_top\" to verify \"Projects\" is displayed"
    }
  ],
  "line": 14,
  "name": "",
  "description": "",
  "id": "testing-suite-for-the-self-serve-cloud;drsc-1/12:-as-a-user,-i-want-to-be-sent-to-the-selfserve.cloud-linkedin-page-when-clicking-a-link/button-in-footer-of-each-page;",
  "rows": [
    {
      "cells": [
        "PortalName",
        "URL"
      ],
      "line": 15,
      "id": "testing-suite-for-the-self-serve-cloud;drsc-1/12:-as-a-user,-i-want-to-be-sent-to-the-selfserve.cloud-linkedin-page-when-clicking-a-link/button-in-footer-of-each-page;;1"
    },
    {
      "cells": [
        "SelfServeCloud",
        "https://www.linkedin.com/company/selfserve.cloud"
      ],
      "line": 16,
      "id": "testing-suite-for-the-self-serve-cloud;drsc-1/12:-as-a-user,-i-want-to-be-sent-to-the-selfserve.cloud-linkedin-page-when-clicking-a-link/button-in-footer-of-each-page;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5637462034,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "DRSC-1/12: As a user, I want to be sent to the SelfServe.Cloud LinkedIn page when clicking a link/button in Footer of each page",
  "description": "",
  "id": "testing-suite-for-the-self-serve-cloud;drsc-1/12:-as-a-user,-i-want-to-be-sent-to-the-selfserve.cloud-linkedin-page-when-clicking-a-link/button-in-footer-of-each-page;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@linkedin_test"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I want to login to portal \"SelfServeCloud\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "comments": [
    {
      "line": 6,
      "value": "#Then I see text \"LinkedIn\" displayed"
    }
  ],
  "line": 7,
  "name": "I wait for \"3\" seconds",
  "keyword": "Then "
});
formatter.step({
  "line": 8,
  "name": "I click on \"LinkedIn\"",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "I check I have gone to the URL \"https://www.linkedin.com/company/selfserve.cloud\" in a new tab",
  "matchedColumns": [
    1
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "SelfServeCloud",
      "offset": 27
    }
  ],
  "location": "StepImpe.i_want_to_login_to_portal(String)"
});
formatter.result({
  "duration": 4495593852,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3",
      "offset": 12
    }
  ],
  "location": "StepImpe.i_wait_for_seconds(String)"
});
formatter.result({
  "duration": 3000583094,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "LinkedIn",
      "offset": 12
    }
  ],
  "location": "StepImpe.i_click_on(String)"
});
formatter.result({
  "duration": 2167296875,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "https://www.linkedin.com/company/selfserve.cloud",
      "offset": 32
    }
  ],
  "location": "StepImpe.i_check_i_have_gone_to_the_url_in_a_new_tab(String)"
});
formatter.result({
  "duration": 1216402857,
  "status": "passed"
});
formatter.after({
  "duration": 38613,
  "status": "passed"
});
});