# QAWorksTest
Project description:
This project is to automate E.ggtimer.com Countdowm timer and check timer is working fine.

Chrome Version= C:\chromedriver\chromedriver.exe.exe

Gecko Driver Path= C:\geckodriver\geckodriver.exe

(I have an updated firefox version hence I have to use geckodriver,otherwise for older version of firefox we no need
to use geckodriver)

Instructions to run and build code:

1. Clone git repository (Repository URL: https://github.com/Tushard8/QAWorksTest.git) using git clone
2. Open "AppAutomation" project with IntelliJ IDE. You can use other IDE like eclipse as well. I have developed this in
IntelliJ using Maven project.
3. To run the project you can use either of below options:
    - Run it through IntelliJ terminal using command--> mvn clean install
    - Run it through RunnerTest utility
    - Run it through ContactUs.feature by right click on Scenario and using Run scenario option
    - Run it through Intellij->Maven Project->Lifecycle->install
4. Once the test run finished you can refer the report generated under target->cucumber-html-reports

Note: All dependencies are included in project
