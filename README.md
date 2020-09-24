# project-selenium-webdriver

## Running  all test classes
* ```mvn clean test```

## Running a Single Test Class
* ```mvn -Dtest=com.jhurtado.seleniumwebdriver.redmine.RedmineLoginTest test```

## Running Cucumber Test with a subset of scenarios tagged
* ```mvn clean test -Dcucumber.filter.tags="@E2E"```
    
## Cross Browser
Mac OS and Linux
 * ```export browserName=firefox```

Windows
 * ```set browserName=firefox```
 
Running Test
 * ```mvn clean test```
 
## Reporting Allure
* ```mvn clean install```

## Selenium Grid commands

###Hub
* ```java -jar selenium-server-standalone-3.141.59.jar -role hub -hubConfig hub_config.json```
###Node
* ```java -Dwebdriver.gecko.driver=<YOUR_ABSOLUTE_PATH>/geckodriver -Dwebdriver.chrome.driver=<YOUR_ABSOLUTE_PATH>/chromedriver -jar selenium-server-standalone-3.141.59.jar -role node -nodeConfig web_nodes_mac.json```