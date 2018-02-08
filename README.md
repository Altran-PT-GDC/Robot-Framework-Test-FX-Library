# Robot Framework TestFX Library

Altran developed and open sourced a test library for Robot Framework to enable to create automated test scripts to test Java FX applications using the TestFX framework. 


## Introduction

Our library is based in [TestFX](https://github.com/TestFX/TestFX) a simple and clean testing framework for JavaFX with fluent and clean API that uses Junit.

The goal of the TestFX Library, is to wrap the main features of TestFX in a Robot Framework library that could be easy to use.


## Getting Started

1. Install Robot Framework
2. Install Jython
3. Download TestFXLibrary.jar
4. Add the JavaFX application under test and TestFXLibrary.jar to the classpath
5. Create a Robot Framework script
6. Run the test with Jybot!

### Download

The library JAR can be downloaded in [releases](https://github.com/Altran-PT-GDC/Robot-Framework-Test-FX-Library/releases).

### Classpath

In order to execute the library and the application in Robot Framework, you need to add both application under test and TestFX library jars to CLASSPATH.

### Import

Import TestFxLibrary in Robot Framework:

    *** Settings ***
    Library TestFXLibrary


### Example Test Case

    *** Settings ***
    Library TestFXLibrary

    *** My Test Case ***

    Start Application   testapp.FxApplication
    Click On Component  \#buttonId
    Select From List View By Text   \#listViewId    Example Text
    Close Application
    
    
NOTICE: If your using an id (eg. #id) as locator you must escape the hash sign (eg. \\#id)


### Keyword Documentation

You can find the keywords documentation [here](https://cdn.rawgit.com/Altran-PT-GDC/Robot-Framework-Test-FX-Library/585ec941/docs/TestFXLibrary.html)


### WIKI

For more information visit this repository [Wiki](https://github.com/Altran-PT-GDC/Robot-Framework-Test-FX-Library/wiki).


### Tools to help component discovery

ScenicView - It will show all the component id's, locators and properties for a JavaFX application. You can find more info about Scenic View [here](http://fxexperience.com/scenic-view/).


### Prerequisites for running tests

[Robot Framework](https://github.com/robotframework/robotframework)

[Jython](http://www.jython.org/)


### Installing

First you will need to Robot Framework and jython, for Robot Framework [here](http://robotframework.org/MavenPlugin/examples/javalibraries.html) and for Jython 
[here](https://wiki.python.org/jython/InstallationInstructions). This will enable you to run tests using Jybot.

Then you need to make sure that the Path is configured. See here how to do it 
[here](http://robotframework.org/robotframework/latest/RobotFrameworkUserGuide.html#configuring-path).


# TestFX Library for Developers 

This is an open source project, if you are developer you can clone this project, change the code, compile it, etc. And, of course we're realy open for contribuition. New fetures, additional keywords, bug reports and documentation are welcome!

The library is writen in Java and the tests for the library are writen in Robot Framework, that run against a sample JavaFX application.

## Prerequisites

Besides Robot Framework and Jython we have the following additional prerequisites: 

[Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

[Maven](https://maven.apache.org/) 


## Cloning the TextFXLibrary project

Clone repository to your machine.

```
git clone https://github.com/altranpt/Robot-Framework-Test-FX-Library.git
```


## Running the library unit tests

To run unit test via Maven, you only need to execute this command in command line : 

```
mvn test
```

Remember that you need to execute the command on the folder where you have the project.

If you have added any keyword on the project, you will need to add the test script on the test folder to the correct 
test suite. 


## Compiling

If you want to compile the project without running the tests you must execute the command in command line:

```
mvn install -Dmaven.test.skip=true
```

If you want to run the tests in a headless environment you must to execute the command in command line:

```
mvn clean test -Dtestfx.robot=glass -Dglass.platform=Monocle -Dmonocle.platform=Headless -Dprism.order=j2d
```


## Deployment

Once you've configured your repository deployment information correctly deploying your project's artifact will only 
require invocation of the deploy phase of the build:

```
mvn deploy
```


## Built With

* [Java 8](http://www.oracle.com/technetwork/java/javase/overview/java8-2100321.html) - Java version.
* [Maven](https://maven.apache.org/) - Dependency Management
* [TestFX](https://github.com/TestFX/TestFX) - The JavaFX test framework
* [RobotFramework](http://robotframework.org/MavenPlugin/examples/javalibraries.html) - To run phyton test cases in 
java projects
* [Monocle](https://mvnrepository.com/artifact/org.testfx/openjfx-monocle/1.8.0_20) - To run the library tests in 
headless mode.


## Contributing

We suggest [IntelIJ Community](https://www.jetbrains.com/idea/download/#section=windows) for code editing.

Please read [CONTRIBUTING.md](https://github.com/Altran-PT-GDC/Robot-Framework-Test-FX-Library/blob/master/testfxlibrary/CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull 
requests to us.


## Authors

* **Altran** - *Initial work* - [Altran Web Site](https://www.altran.com/us/en/)
* **João Gomes** - *Initial work* 
* **Sergio Lourenço** - *Initial work* 
* **Diogo Ribeiro** - *Initial work* 
* **Pedro Costa** - *Initial work* 


See also the list of [contributors](https://github.com/Altran-PT-GDC/Robot-Framework-Test-FX-Library/contributors) who participated in this project.

This project was developed with the support and contribution of [Sophia Genetics](http://www.sophiagenetics.com/)


## License

This project is licensed under the MIT License - see the [LICENSE.md](https://github.com/Altran-PT-GDC/Robot-Framework-Test-FX-Library/blob/master/testfxlibrary/LICENSE.md) file for details.


