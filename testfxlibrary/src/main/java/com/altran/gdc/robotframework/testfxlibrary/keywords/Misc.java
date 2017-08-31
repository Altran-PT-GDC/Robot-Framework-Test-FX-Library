/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.*;
import javafx.application.Application;
import javafx.scene.Node;
import org.awaitility.Awaitility;
import org.hamcrest.Matchers;
import org.python.google.common.collect.Iterables;
import org.robotframework.javalib.annotation.*;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.service.support.WaitUntilSupport;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.concurrent.*;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import static java.net.URLClassLoader.newInstance;
import static org.testfx.matcher.base.NodeMatchers.*;

/**
 * @author pcosta
 */
@RobotKeywords
public class Misc {

    private static final int CLASS_VALUE = 6;

    @Autowired
    private Logging log;

    /**
     * <b>Description:</b>This keyword launches JavaFX application. The classname
     * passed as argument must extend javafx.application.Application.<br>
     * ATENTTION: The class must be added to the classpath beforehand.<br>
     *
     * @param className
     * : The name of the class that extends javafx.application.Application to be launched
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>className</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"className"})
    public void startApplication(String className){
        TestFxLibraryValidation.validateArguments(className);

        try {
            FxToolkit.registerPrimaryStage();
            FxToolkit.setupApplication((Class<? extends Application>) Class.forName(className));
            FxToolkit.showStage();
        } catch (TimeoutException | ClassNotFoundException e) {
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b>This keyword launches Java FX application from external JAR.<br>
     * The classname given must extend javafx.application.Application.<br>
     * ATENTTION: The JAR must be added to the classpath beforehand.<br>
     *
     * @param applicationJAR
     * : The path of the JAR that contains the application to be launched
     * @param className
     * : The name of the class im the JAR that extends javafx.application. Application to be launched
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>applicationJAR</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>className</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"applicationJAR", "className"})
    public void startJARApplication(String applicationJAR, String className){
        try {
            FxToolkit.registerPrimaryStage();
            ClassLoader classLoader = loadClassesFromJar(applicationJAR);
            FxToolkit.setupApplication((Class<? extends Application>) classLoader.loadClass(className));
            FxToolkit.showStage();

        } catch (TimeoutException | ClassNotFoundException | IOException e) {
            throw  new TestFxLibraryFatalException(e);
        }

    }

    private ClassLoader loadClassesFromJar(String applicationJAR) throws IOException {
        JarFile jarFile = null;
        URLClassLoader cl = null;

        try {
            jarFile = new JarFile(applicationJAR);
            Enumeration<JarEntry> e = jarFile.entries();

            URL[] urls = {new URL("jar:file:" + applicationJAR + "!/")};
            cl = newInstance(urls);

            while (e.hasMoreElements()) {
                JarEntry je = e.nextElement();
                if (je.isDirectory() || !je.getName().endsWith(".class")) {
                    continue;
                }
                // -6 because of .class
                String className = je.getName().substring(0, je.getName().length() - CLASS_VALUE);
                className = className.replace('/', '.');
                log.info(className);
            }
        } finally {
            if (jarFile != null) {
                jarFile.close();
            }
            if (cl != null) {
                cl.close();
            }
        }
        return cl;
    }

    /**
     * <b>Description:</b>This keyword closes the Java FX application. The primary stage is hidden and cleaned up.<br>
     *
     * @throws TestFxLibraryFatalException
     *      If something goes wrong
     */
    @RobotKeyword
    public void closeApplication() {
        try {
            FxToolkit.hideStage();
            FxToolkit.cleanupStages();
        } catch (Exception e) {
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b>This keyword pauses the execution during the period defined in the argument
     * in milliseconds.<br>
     *
     * @param milliseconds
     * : The number of milliseconds to pause the execution
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>milliseconds</td>
     *         <td>Yes</td>
     *         <td>int</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"milliseconds"})
    public void sleep(int milliseconds) {
        new FxRobot().sleep(milliseconds);
    }

    /**
     * <b>Description:</b>This keyword implements a waiting period for an element to become visible within a
     * timeout passed as second argument.<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * @param timeout
     * : The time limit to complete the test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "timeout=20"})
    public void waitUntilElementIsVisible(String identifier, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateTimeout(timeout);

        try{

            new WaitUntilSupport().waitUntil(getNode(identifier), Matchers.is(isVisible()), timeout);

        } catch (IllegalArgumentException | NullPointerException e){

            throw new TestFxLibraryFatalException(e);

        }

    }

    /**
     * <b>Description:</b>This keyword implements a waiting period for an element to become visible within the default
     * timeout.<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilElementIsVisible(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilElementIsVisible(identifier, waitTimeout);

    }

    /**
     * <b>Description:</b>This keyword implements a waiting period for an element to disappear within
     * a timeout passed as second argument.<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * @param timeout
     * : The time limit to complete the test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "timeout=20"})
    public void waitUntilElementIsNotVisible(String identifier, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateTimeout(timeout);

        try{

            new WaitUntilSupport().waitUntil(getNode(identifier), Matchers.not(isVisible()), timeout);

        } catch (IllegalArgumentException | NullPointerException e){

            throw new TestFxLibraryFatalException(e);

        }
    }

    /**
     * <b>Description:</b>This keyword implements a waiting period for an element to disappear within the default
     * timeout.<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilElementIsNotVisible(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilElementIsNotVisible(identifier, waitTimeout);

    }

    /**
     * <b>Description:</b>This keyword implements a waiting period to verify if a given element passed as the first
     * argument contains a given text passed as the second argument. The waiting period is defined as the third
     * argument<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * @param textToValidate
     * : The Text you want to validate
     * @param timeout
     * : The time limit to complete the test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>textToValidate</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "textToValidate", "timeout=20"})
    public void waitUntilElementContains(String identifier, String textToValidate, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier, textToValidate);
        TestFxLibraryValidation.validateTimeout(timeout);

        try{

            new WaitUntilSupport().waitUntil(getNode(identifier), hasText(textToValidate), timeout);

        } catch (IllegalArgumentException | NullPointerException e){

            throw new TestFxLibraryFatalException(e);

        }
    }

    /**
     * <b>Description:</b>This keyword implements a waiting period to verify if a given element passed as the first
     * argument contains a given text passed as the second argument. The waiting period is default<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * @param textToValidate
     * : The Text you want to validate
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>textToValidate</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilElementContains(String identifier, String textToValidate) {

        TestFxLibraryValidation.validateArguments(identifier, textToValidate);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilElementContains(identifier, textToValidate, waitTimeout);

    }

    /**
     * <b>Description:</b>This keyword implements a waiting period to verify if a given element passed as the first
     * argument does not contains a given text passed as the second argument. The waiting period is defined as the
     * third argument<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * @param textToValidate
     * : The Text you want to validate
     * @param timeout
     * : The time limit to complete the test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameters</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>textToValidate</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "textToValidate", "timeout=20"})
    public void waitUntilElementDoesNotContains(String identifier, String textToValidate, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier, textToValidate);
        TestFxLibraryValidation.validateTimeout(timeout);

        try{

            new WaitUntilSupport().waitUntil(getNode(identifier), Matchers.not(hasText(textToValidate)), timeout);

        } catch (IllegalArgumentException | NullPointerException e){

            throw new TestFxLibraryFatalException(e);

        }
    }

    /**
     * <b>Description:</b>This keyword implements a waiting period to verify if a given element passed as the first
     * argument does not contains a given text passed as the second argument. The waiting period is default<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * @param textToValidate
     * : The Text you want to validate
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>textToValidate</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilElementDoesNotContains(String identifier, String textToValidate) {

        TestFxLibraryValidation.validateArguments(identifier, textToValidate);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilElementDoesNotContains(identifier, textToValidate, waitTimeout);

    }

    /**
     * <b>Description:</b>This keyword implements a waiting period to verify if a given element passed as the first
     * argument is disabled. The waiting period is defined as the second argument<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * @param timeout
     * : The time limit to complete the test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "timeout=20"})
    public void waitUntilElementIsDisabled(String identifier, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateTimeout(timeout);

        try{

            new WaitUntilSupport().waitUntil(getNode(identifier), Matchers.is(isDisabled()),timeout);

        } catch (IllegalArgumentException | NullPointerException e){

            throw new TestFxLibraryFatalException(e);

        }
    }

    /**
     * <b>Description:</b>This keyword implements a waiting period to verify if a given element passed as the first
     * argument is disabled. The waiting period is default<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilElementIsDisabled(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilElementIsDisabled(identifier, waitTimeout);

    }

    /**
     * <b>Description:</b>This keyword implements a waiting period to verify if a given element passed as the first
     * argument is enabled. The waiting period is defined as the second argument<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * @param timeout
     * : The time limit to complete the test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "timeout=20"})
    public void waitUntilElementIsEnabled(String identifier, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateTimeout(timeout);

        try{

            new WaitUntilSupport().waitUntil(getNode(identifier), Matchers.not(isDisabled()), timeout);

        } catch (IllegalArgumentException | NullPointerException e){

            throw new TestFxLibraryFatalException(e);

        }
    }

    /**
     * <b>Description:</b>This keyword implements a waiting period to verify if a given element passed as the first
     * argument is enabled. The waiting period is default<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilElementIsEnabled(String identifier) {

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilElementIsEnabled(identifier, waitTimeout);
    }

    /**
     * <b>Description:</b>This keyword implements a waiting period to verify if a given element with text passed
     *  as the first argument is enabled. The waiting period is defined as the second argument<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * @param timeout
     * : The time limit to complete the test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "timeout=20"})
    public void waitUntilPageContains(String identifier, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateTimeout(timeout);

        try{

            Awaitility.setDefaultTimeout(timeout, TimeUnit.SECONDS);
            Awaitility.await().until(() -> getNode(identifier) != null);

        } catch (IllegalArgumentException | NullPointerException e){

            throw new TestFxLibraryFatalException(e);

        }
    }

    /**
     * <b>Description:</b>This keyword implements a waiting period to verify if a given element with text passed
     *  as the first argument is enabled. The waiting period is default<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilPageContains(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilPageContains(identifier, waitTimeout);

    }

    /**
     * <b>Description:</b>This keyword implements a waiting period to verify if a given element with text passed
     *  as the first argument is deleted from the application. The waiting period is defined as the
     *  second argument<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * @param timeout
     * : The time limit to complete the test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "timeout=20"})
    public void waitUntilPageDoesNotContains(String identifier, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateTimeout(timeout);

        try{

            Awaitility.setDefaultTimeout(timeout, TimeUnit.SECONDS);
            Awaitility.await().until(() -> getNode(identifier) == null);

        } catch (IllegalArgumentException | NullPointerException e){

            throw new TestFxLibraryFatalException(e);

        }
    }

    /**
     * <b>Description:</b>This keyword implements a waiting period to verify if a given element with text passed
     *  as the first argument is deleted from the application. The waiting period is default<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeywordOverload
    public void waitUntilPageDoesNotContains(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilPageDoesNotContains(identifier, waitTimeout);

    }

    /**
     * <b>Description:</b>This keyword implements a waiting period to verify if a given element passed
     *  as the first argument is created and present on the application. The waiting period is defined as the
     *  second argument<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * @param timeout
     * : The time limit to complete the test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "timeout=20"})
    public void waitUntilPageContainsElement(String identifier, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateTimeout(timeout);

        if (identifier.startsWith("#")) {
            try{

                Awaitility.setDefaultTimeout(timeout, TimeUnit.SECONDS);
                Awaitility.await().until(() -> getNode(identifier) != null);

            } catch (IllegalArgumentException | NullPointerException e){

                throw new TestFxLibraryFatalException(e);

            }
        } else {
            final String changedIdentifier = "#" + identifier;
            try {

                Awaitility.setDefaultTimeout(timeout, TimeUnit.SECONDS);
                Awaitility.await().until(() -> getNode(changedIdentifier) != null);

            } catch (IllegalArgumentException | NullPointerException e) {

                throw new TestFxLibraryFatalException(e);

            }
        }
    }

    /**
     * <b>Description:</b>This keyword implements a waiting period to verify if a given element passed
     * as the argument is created and present on the application. The waiting period is default<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilPageContainsElement(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        String changedIdentifier = null;

        if (identifier.substring(0) != "#") {
            changedIdentifier = "#" + identifier;
        }

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilPageContainsElement(changedIdentifier, waitTimeout);

    }

    /**
     * <b>Description:</b>This keyword implements a waiting period to verify if a given element passed
     * as the first argument is deleted from the application. The waiting period is defined as the
     * second argument<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * @param timeout
     * : The time limit to complete the test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "timeout=20"})
    public void waitUntilPageDoesNotContainElement(String identifier, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateTimeout(timeout);

        if (identifier.startsWith("#")) {
            try{

                Awaitility.setDefaultTimeout(timeout, TimeUnit.SECONDS);
                Awaitility.await().until(() -> getNode(identifier) == null);

            } catch (IllegalArgumentException | NullPointerException e){

                throw new TestFxLibraryFatalException(e);

            }
        } else {
            final String changedIdentifier = "#" + identifier;
            try {

                Awaitility.setDefaultTimeout(timeout, TimeUnit.SECONDS);
                Awaitility.await().until(() -> getNode(changedIdentifier) == null);

            } catch (IllegalArgumentException | NullPointerException e) {

                throw new TestFxLibraryFatalException(e);

            }
        }
    }

    /**
     * <b>Description:</b>This keyword implements a waiting period to verify if a given element passed
     * as the argument is deleted from the application. The waiting period is default<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilPageDoesNotContainElement(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        String changedIdentifier = null;

        if (identifier.substring(0) != "#") {
            changedIdentifier = "#" + identifier;
        }

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilPageDoesNotContainElement(changedIdentifier, waitTimeout);

    }

    /**
     * <b>Description:</b>This keyword gets the Nth element from a node list<br>
     *
     * @param identifier
     * : The node to search
     * @param nthElement
     * : The index of the element to return from the list
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>nthElement</td>
     *         <td>Yes</td>
     *         <td>int</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     * <br>
     * @return
     * : The Nth node from the list
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Return</th>
     *         <th>Values</th>
     *     </tr>
     *     <tr>
     *         <td>node</td>
     *         <td>string</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "nthElement"})
    public Node getNthElement(String identifier, int nthElement) {
        return getNode(identifier, nthElement);
    }

    /**
     * <b>Description:</b>This keyword gets the inner element from a given node passed as argument<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * <br><br>
     * <table summary ="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     * <br>
     * @return
     * : The inner element of the provided node
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Return</th>
     *         <th>Values</th>
     *     </tr>
     *     <tr>
     *         <td>element</td>
     *         <td>string</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public String getNodeKey(String identifier) {
        Node node = getNode(identifier);
        String key = node.toString();
        TestFXLibraryCache.getIstance().put(key, node);
        return key;
    }

    public Node getNode(String identifier) {
        return new FxRobot().lookup(identifier).query();
    }

    /**
     * Get NTH element from a Node list
     *
     * @param identifier
     *      The node to search
     * @param nthElement
     *      The index of the element to return from the list
     * @return
     *      The Node
     */
    public Node getNode(String identifier, int nthElement) {
        Set<Node> nodeList = new FxRobot().lookup(identifier).queryAll();
        return  Iterables.get(nodeList, nthElement);
    }

    public void defaultWait(long timeout) throws IOException {
        try {
            new WaitUntilSupport().wait(timeout);
        } catch (InterruptedException e) {
            log.error("Error!");
        }
    }

    /**
     * <b>Description:</b>This keyword gets an attribute value of an element.<br>
     *
     * @param identifier
     * : The node where you want to get the attribute
     * @param attribute
     * : The method name of the attribute that you want
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>attribute</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * @return
     * : Attribute value in a string
     */
    @RobotKeyword()
    @ArgumentNames({"identifier" , "attribute"})
    public String getComponentAtrribute(String identifier, String attribute) {

        TestFxLibraryValidation.validateArguments(identifier, attribute);

        Node node = getNode(identifier);

        try {
            Class clazz = Class.forName(node.getClass().getName());

            Object obj = clazz.newInstance();
            Method m = obj.getClass().getMethod(attribute);
            Object o = m.invoke(obj);

            return o.toString();

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new TestFxLibraryFatalException(e);
        }
    }
}
