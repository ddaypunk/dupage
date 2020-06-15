# dupage [![Gitpod Ready-to-Code](https://img.shields.io/badge/Gitpod-Ready--to--Code-blue?logo=gitpod)](https://gitpod.io/#https://github.com/ddaypunk06/dupage) 
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
There is a basic runner to run the context test in the `/.run` folder. If I am correct, this should appear in IntelliJ as a run option, but to check this I would need to reimport the project and see what happens. I will test this through a collaborator instead first.

This should appear in the upper right in IntelliJ next to a play button. It is setup to just run the one example SpringBoot test in Chrome browser. You can adjust the `selenium.browser` VM option to other browsers to run it in that browser. I have noticed that the first run seems to fail possibly due to webdriver manager downloading the needed driver. A second run seems to usually work though.

## Contributing to the repo using git (branching and all that jazz)
There are many ways to do this, and ask me if you need some ideas on how to setup git. The normal flow will be as below (using git command line). If you know how to, you can also use a git GUI for this like the one in IntelliJ or others like Git Kraken.

1. Using terminal, please fetch and pull down the main branch: `git fetch origin && git checkout origin/main`.
2. Then create a named dev branch locally: `git checkout -b your-named-branch`. This will create a development branch locally for you to work off of.
3. Make your changes in IntelliJ
4. In terminal, `git add .` will add all of your changes to stage (ready to be committed)
5. Then commit the changes `git commit -m "message to explain what was changed"`
6. Then push changes to github `git push -u origin your-named-branch`
7. After some git magic, git should give you a link to make a pull request to the repo, click this
8. Target the main branch, from your-named-branch, provide some details, and tag people you want to review it
9. Once approved by a team member, you can click the arrow on the merge button and set to squash and merge. This will merge all of your changes into one commit message and then merge it to main.

Please ask me to show you how to do things directly in IntelliJ. It will be easier to explain
