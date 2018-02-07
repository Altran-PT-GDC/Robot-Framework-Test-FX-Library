# Robot-Framework-Test-FX-Library
Altran developed and open sourced a test library for Robot Framework to enable to create automated test scripts to test Java FX applications using the TestFX framework. 

## Getting Started

Clone repository to your machine.

```
git clone https://github.com/altranpt/Robot-Framework-Test-FX-Library.git
```

The TestFXLibrary.jar needs to be in the classpath during execution. The classpath configuration is key for the library to work properly, please ensure that it correctly configured.

The library JAR can be downloaded in [releases](https://github.com/Altran-PT-GDC/Robot-Framework-Test-FX-Library/releases).

### Tools to help component discovery

ScenicView - It will show all the component id's and properties for a JavaFX application. You can find more info about 
Scenic View [here](http://fxexperience.com/scenic-view/).

### Prerequisites

[Java JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

[Maven](https://maven.apache.org/)

[Robot Framework](https://github.com/robotframework/robotframework)

[Jython](http://www.jython.org/)

### Installing

First you will need to install maven and jython. You can check the instructions for Maven 
[here](https://maven.apache.org/install.html), for Robot Framework [here](http://robotframework.org/MavenPlugin/examples/javalibraries.html) and for Jython 
[here](https://wiki.python.org/jython/InstallationInstructions). This will enable you to run tests using Jybot.

Then you need to make sure that the Path is configured. See here how to do it 
[here](http://robotframework.org/robotframework/latest/RobotFrameworkUserGuide.html#configuring-path).

## Running the unit tests

To run unit test via Maven, you only need to execute this command in command line : 

```
mvn test
```

Remember that you need to execute the command on the folder where you have the project.

If you have added any keyword on the project, you will need to add the test script on the test folder to the correct 
test suite. 

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
* [RobotFramework](http://robotframework.org/MavenPlugin/examples/javalibraries.html) - To run phyton test cases in 
java projects
* [Monocle](https://mvnrepository.com/artifact/org.testfx/openjfx-monocle/1.8.0_20) - To run the library tests in 
headless mode.

## Contributing

We suggest [IntelIJ Community](https://www.jetbrains.com/idea/download/#section=windows) for code editing.

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull 
requests to us.

## Authors

* **Altran** - *Initial work* - [Altran Web Site](https://www.altran.com/us/en/)
* **João Gomes** - *Initial work* 
* **Sergio Lourenço** - *Initial work* 
* **Diogo Ribeiro** - *Initial work* 
* **Pedro Costa** - *Initial work* 


See also the list of [contributors](https://github.com/Altran-PT-GDC/Robot-Framework-Test-FX-Library/contributors) who participated in this project.

This project was developed with the support of [Sophia Genetics](http://www.sophiagenetics.com/)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
