In order to run the tests, the following has to be done:

1) Make sure Java is installed on your computer
2) Install Maven globally on your computer (of course no need to do this if it's already installed)
3) Download the repository (https://github.com/exerciseaccount/javarestassured.git)
4) Go to the main project directory (that would be /javarestassured, and inside of it you should see the pom.xml file among others)
5) Execute the following commands (one at the time):
mvn clean
mvn compile
mvn test

Side notes:

-I could not find any documentation to search repositories by author (though this option is indeed available when searching for commits), so I used the search repositories by user instead.
-I chose to use Java with the REST Assured libraries for this project.
-I set up a the Extent Reporter tool, so reports will be available as an HTML file called "ExtentReportsTestNG" on the target/surefire-reports
-The API Rate Limit resets 30-60 seconds, and that's the timeframe required to run the first test. If the test suite is run more than once per minute, most likely the first test case will fail due to this (all the others should work, though)


These are the 5 test cases I chose to automate:


1) API Rest Rate Limit Validation
2) Default search results for Tetris search ascending order
3) Pagination search results for tetris with a 100 results
4) Results for tetris using a specific user
5) Results for tetris using a specific language


Unix: 2 years

SDLC management tools
Jira: 5 years
ALM: 0
Writing automated tests
Watir: 1 year, and that was a very very long time ago
API testing: 3 years

Git/GitHub: 5 years

