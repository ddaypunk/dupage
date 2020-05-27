# dupage
Java 14 Selenium Framework with SpringBoot

## Prerequisites
- [OpenJDK 14](https://adoptopenjdk.net/?variant=openjdk14&jvmVariant=hotspot)
- Code editor (the rest of this guide uses [IntelliJ Community Edition](https://www.jetbrains.com/idea/download/#section=mac))

## Setup in IntelliJ:
1. Setup [GitHub SSH key](https://help.github.com/en/github/authenticating-to-github/connecting-to-github-with-ssh)
2. Pull down this repo using SSH locally
3. Open IntelliJ
4. Click "Open or Import" option in IntelliJ Launcher
5. Locate the repo you pulled down
6. Select to open it's `build.gradle`
7. Click open as project
8. Allow gradle dependencies to be downloaded (progress bar is shown in IntelliJ)

## Project Struture
As in most Java projects, framework implementation will go in `src` directory and and unit tests of the framework (if needed) belong in `test` directory.

If added, Cucumber/RestAssured/etc test scripts/specs will also belong in the `test` directory.

## Running tests
There is a basic runner to run the context test in the /.run folder. If I am correct, this should appear in IntelliJ as a run option, but to check this I would need to reimport the project and see what happens. I will test this through a collaborator instead first.

This should appear in the upper right in IntelliJ next to a play button. It is setup to just run the one example SpringBoot test in Chrome browser. You can adjust the `selenium.browser` VM option to other browsers to run it in that browser. I have noticed that the first run seems to fail possibly due to webdriver manager downloading the needed driver. A second run seems to usually work though.
