# Robot-Framework-Test-FX-Library

TestFX Library is a Robot Framework library based in Java to test Java FX applications.

## Getting Started

Clone repository to your machine.

```
git clone [repository]
```

The TestFXLibrary.jar needs to be in the class path during execution.

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

Then you need to make sure that the Path is configured. See [here](http://robotframework.org/robotframework/latest/RobotFrameworkUserGuide.html#configuring-path) how to do it.

## Running the tests

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
* **João Gomes** - *Initial work* - [GitHub Profile](https://github.com/jdagomes)
* **Sergio Lourenço** - *Initial work* - [LinkedIn Profile](https://www.linkedin.com/in/s%C3%A9rgio-louren%C3%A7o-7425094/)
* **Diogo Ribeiro** - *Initial work* - [LinkedIn Profile](https://www.linkedin.com/in/diogo-ribeiro-530863a8/)

See also the list of [contributors](https://github.com/Altran-PT-GDC/Robot-Framework-Test-FX-Library/contributors) who participated in this project.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
