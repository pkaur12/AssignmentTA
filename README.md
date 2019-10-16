# AssignmentTA

Task: To write a test to verify the menu items of www.teachaway.com

Strategy:
For this task I have built a framework based on Page Object Mode with Page Factory. 
I have created a Maven project and used Java to write the script.
For data I have used Data Provider in TestNG. Also I have used Log4j which is used to note the steps in console and under target folder.
In terms of OOPS concept and java, I have used inheritance, static key words, Constructors etc.

I have created an object repository in the class HomePageObjects. In this page class, you will find the WebElements of Teachaway homepage menu, along with Page methods which perform operations on those WebElements. Using this pattern all the locators load at once which would improve the performance of our suite.
Aside from this, you would also find two test classes. First is the BaseTest class which contains before and after scenarios that need to be run before and after each class. The other test class is HomePageTests class which contains all my test cases.
Finally a DataProvider class which contains the set of data to be run for each test.
The motivation behind using this model is that it helps make the code more readable, maintainable, and reusable. The separation of UI from our tests makes our code cleaner and easier to understand. Moreover, on making the object repository independent of test cases, we can use the same repository with different tools.

In terms of my test cases for verifying the menu bar, I have run the following high level test cases:
- Assert the presence of logo
- Assert presence of tabs and buttons in header
- Assertion on the URL of header tabs and buttons
Note: We could assert the status code for the URL after login as of now it is giving 403.

Run Test:
Import the project in eclipse
Open HomePageTests class present in src/test/java/functionalTestCases, right click > Run As > Testng Test
