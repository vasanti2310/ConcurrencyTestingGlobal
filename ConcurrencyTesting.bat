cd..
cd..
D:

set projectpath=D:\Testing Team Automation\ConcurrancyTestingGlobal
cd %projectpath%
set classpath=%projectpath%\bin;%projectpath%\lib\*
java  org.testng.TestNG TestNG1.xml
pause