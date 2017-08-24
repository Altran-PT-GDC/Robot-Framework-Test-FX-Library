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
     * Launch Java FX application. <br>
     * The classname given must extend javafx.application.Application.<br>
     * ATENTTION: The class must be added to the classpath beforehand.
     *
     * @param className
     *          The name of the class that extends javafx.application.Application to be launched.
     */
    @RobotKeyword
    @ArgumentNames({"className"})
    public void launchApplication(String className){
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
     * Launch Java FX application from external JAR.<br>
     * The classname given must extend javafx.application.Application.<br>
     * ATENTTION: The JAR must be added to the classpath beforehand.
     *
     * @param applicationJAR
     *          The path of the JAR that contains the application
     *          to be launched. The JAR must contain a JavaFX application with a class
     *          that extends javafx.application.Application.
     * @param className
     *          The name of the class im the JAR that extends
     *          javafx.application.Application to be launched.
     */
    @RobotKeyword
    @ArgumentNames({"applicationJAR", "className"})
    public void launchJARApplication(String applicationJAR, String className){
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
     * Closes the Java FX application.
     * The primary stage is hidden and cleaned-up.
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
     * Sleep. Pause the execution during a period
     *
     * @param milliseconds
     *          The number of millisenconds to pause the execution
     */
    @RobotKeyword
    @ArgumentNames({"milliseconds"})
    public void sleep(int milliseconds) {
        new FxRobot().sleep(milliseconds);
    }

    /**
     * Wait until an element is visible
     *
     * @param identifier
     *          The name of the element that you are going to test
     * @param timeout
     *          The limit time to complete the test
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
     * Wait until an element is visible with the default timeout
     *
     * @param identifier
     *          The name of the element that you are going to test
     */
    @RobotKeywordOverload
    public void waitUntilElementIsVisible(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilElementIsVisible(identifier, waitTimeout);

    }

    /**
     * Wait until an element is not visible
     *
     * @param identifier
     *          The name of the element that you are going to test
     * @param timeout
     *          The limit time to complete the test
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
     * Wait until an element is not visible with the default timeout
     *
     * @param identifier
     *         The name of the element that you are going to test
     */
    @RobotKeywordOverload
    public void waitUntilElementIsNotVisible(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilElementIsNotVisible(identifier, waitTimeout);

    }

    /**
     * Wait until an element has some text on it
     *
     * @param identifier
     *          The name of the element that you are going to test
     * @param textToValidate
     *          The Text you want to validate
     * @param timeout
     *          The limit time to complete the test
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
     * Wait until an element has some text on it with the default timeout
     *
     * @param identifier
     *          The name of the element that you are going to test
     * @param textToValidate
     *          The Text you want to validate
     */
    @RobotKeywordOverload
    public void waitUntilElementContains(String identifier, String textToValidate) {

        TestFxLibraryValidation.validateArguments(identifier, textToValidate);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

            waitUntilElementContains(identifier, textToValidate, waitTimeout);

    }

    /**
     *
     * Wait until an element has some text on it
     *
     * @param identifier
     *          The name of the element that you are going to test
     * @param textToValidate
     *          The Text you want to validate
     * @param timeout
     *          The limit time to complete the test
     *
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
     * Wait until an element has some text on it with the default timeout
     *
     * @param identifier
     *          The name of the element that you are going to test
     * @param textToValidate
     *          The Text you want to validate
     */
    @RobotKeywordOverload
    public void waitUntilElementDoesNotContains(String identifier, String textToValidate) {

        TestFxLibraryValidation.validateArguments(identifier, textToValidate);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

            waitUntilElementDoesNotContains(identifier, textToValidate, waitTimeout);

    }

    /**
     * Wait until an element is disable
     *
     * @param identifier
     *          The name of the element that you are going to test
     * @param timeout
     *          The limit time to complete the test
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
     * Wait until an element is disable with the default timeout
     *
     * @param identifier
     *          The name of the element that you are going to test
     */
    @RobotKeywordOverload
    public void waitUntilElementIsDisabled(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

            waitUntilElementIsDisabled(identifier, waitTimeout);

    }

    /**
     * Wait until an element is enable
     *
     * @param identifier
     *          The name of the element that you are going to test
     * @param timeout
     *          The limit time to complete the test
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
     * Wait until an element is enable with the default timeout
     *
     * @param identifier
     *          The name of the element that you are going to test
     */
    @RobotKeywordOverload
    public void waitUntilElementIsEnabled(String identifier) {

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilElementIsEnabled(identifier, waitTimeout);
    }

    /**
     * Wait until an element with text is created and present on the application
     *
     * @param identifier
     *          The name of the element that you are going to test
     * @param timeout
     *          The limit time to complete the test
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
     * Wait until an element with text is created and present on the application with the default timeout
     *
     * @param identifier
     *          The name of the element that you are going to test
     */
    @RobotKeywordOverload
    public void waitUntilPageContains(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilPageContains(identifier, waitTimeout);

    }

    /**
     * Wait until an element with text is deleted from the application
     *
     * @param identifier
     *          The name of the element that you are going to test
     * @param timeout
     *          The limit time to complete the test
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
     * Wait until an element with text is deleted from application with the default timeout
     *
     * @param identifier
     *          The name of the element that you are going to test
     */
    @RobotKeywordOverload
    public void waitUntilPageDoesNotContains(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilPageDoesNotContains(identifier, waitTimeout);

    }

    /**
     * Wait until an element is created and present on the application
     *
     * @param identifier
     *          The name of the element that you are going to test
     * @param timeout
     *          The limit time to complete the test
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
     * Wait until an element is created and present on the application with the default timeout
     *
     * @param identifier
     *          The name of the element that you are going to test
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
     * Wait until an element is deleted from the application
     *
     * @param identifier
     *          The name of the element that you are going to test
     * @param timeout
     *          The limit time to complete the test
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
     * Wait until an element is deleted from application with the default timeout
     *
     * @param identifier
     *          The name of the element that you are going to test
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
     * Get NTH element from a Node list
     *
     * @param identifier
     *      The node to search
     * @param nthElement
     *      The index of the element to return from the list
     * @return
     *      The Node
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "nthElement"})
    public Node getNthElement(String identifier, int nthElement) {
        return getNode(identifier, nthElement);
    }

    /**
     * * Get the inner element from a node
     *
     * @param identifier
     *          The name of the element that you are going to test
     *
     * @return
     *          The inner element key
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public String getNodeKey(String identifier) {
        Node node = getNode(identifier);
        String key = node.toString();
        TestFXLibraryCache.getIstance().put(key, node);
        return key;
    }

    private Node getNode(String identifier) {
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
    private Node getNode(String identifier, int nthElement) {
        Set<Node> nodeList = new FxRobot().lookup(identifier).queryAll();
        return  Iterables.get(nodeList, nthElement);
    }

    /**
     * Set the default timeout of Wait Until Support wait method
     *
     * @param timeout
     *          The limit time to complete the test
     * @throws IOException
     */
    @RobotKeyword()
    @ArgumentNames({"timeout"})
    public void defaultWait(long timeout) throws IOException {
        try {
            new WaitUntilSupport().wait(timeout);
        } catch (InterruptedException e) {
            log.error("Error!");
        }
    }

    /**
     *  Get an attribute value of an element
     *
     * @param identifier
     *          The node where you want to get the attribute
     * @param attribute
     *          The method name of the attribute that you want
     * @return
     *          The attribute value in a String
     *
     */

    @RobotKeyword()
    @ArgumentNames({"identifier" , "attribute"})
    public String getNodeAtrribute(String identifier, String attribute) {

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
