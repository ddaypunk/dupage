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
