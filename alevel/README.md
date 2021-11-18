## Android app with Appium

#### Requires:
Appium Java client  >= 6.1.0
Running instance of Appium server >= 1.7

#### Test Subject
Test application instagram.apk (added to /resources folder)

#### Functionality covered
1. Instagram - main screen and profile page actions

#### How To Run
mvn clean test -Dappium=appium_url  (by default for local runs -Dappium=http://127.0.0.1:4723/wd/hub)

default driver is UiAutomator2
