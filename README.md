
<h1>Java 11 | Appium | TestNG | Maven | POM | Allure report | Integration with TMS Qase </h1>
<p>This is a sample Java 11 Adopt Open JDK | Android app with Appium | Default driver is UiAutomator2 |Selenium WebDriver | Maven | TestNG | project created in IntelliJ IDE, using Page Object Model and Generic Type.</p>
<p>Website <a href="https://dev.swisscows.com">https://dev.swisscows.com/</a>&nbsp;was used to create functional, API, and UI tests.</p>

<p><strong>pom.xml dependencies used:</strong></p>
<blockquote>
<dependencies>

        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.10.0</version>
        </dependency>

        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.7.0</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>io.appium</groupId>
            <artifactId>java-client</artifactId>
            <version>8.5.1</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>io.qameta.allure</groupId>
            <artifactId>allure-testng</artifactId>
            <version>2.20.1</version>
            <scope>test</scope>
        </dependency>

        <dependency>
            <groupId>io.qase</groupId>
            <artifactId>qase-testng</artifactId>
            <version>3.0.5</version>
            <scope>test</scope>
        </dependency>
    </dependencies>
</blockquote>
<h1>Setup the project and execute tests locally</h1>
<p>1. Install IntelliJ IDE:<br /><a href="https://www.jetbrains.com/help/idea/installation-guide.html">https://www.jetbrains.com/help/idea/installation-guide.html</a></p>
<p>2. Copy the HTTPS project link from the GitHub repository:&nbsp;<br /><a href="https://github.com/ant0d0v/SwisscowsDev.git">https://github.com/ant0d0v/SwisscowsDev.git</a></p>
<p>3. Clone a repository from the main menu:&nbsp;<br /><a title="https://www.jetbrains.com/help/idea/cloning-repository.html#clone_project_from_main_screen" href="https://www.jetbrains.com/help/idea/cloning-repository.html#clone_project_from_main_screen">https://www.jetbrains.com/help/idea/cloning-repository.html#clone_project_from_main_screen</a></p>
<p>4. Go to the resources package, and copy local.properties.TEMPLATE file. Paste it to the resources package, and re-name the new file as&nbsp;local.properties</p>
<p>5. Execute test class or single test by opening the Test class, right-clicking on the green triangle, and choosing Run</p>
<h1>How To Run</h1>
<p>1. mvn clean test -Dappium=appium_url  (by default for local runs -Dappium=http://127.0.0.1:4723/wd/hub)</p>

