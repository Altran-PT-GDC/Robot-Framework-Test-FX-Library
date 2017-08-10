/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altran.gdc.robotframework.testfxlibrary.keywords;

import javafx.application.Application;
import javafx.scene.Node;
import org.hamcrest.Matchers;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.service.support.WaitUntilSupport;

import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.concurrent.TimeoutException;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import static org.testfx.matcher.base.NodeMatchers.hasText;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

/**
 * @author pcosta
 */
@RobotKeywords
public class Misc {

    @Autowired
    private Logging LOG;

    /**
     * Launch Java FX application. <br>
     * The classname given must extend javafx.application.Application.<br>
     * ATENTTION: The class must be added to the classpath beforehand.
     *
     * @param className The name of the class that extends javafx.application.Application to be launched.
     */
    @RobotKeyword
    @ArgumentNames({"className"})
    public void launchApplication(String className) throws TimeoutException, ClassNotFoundException {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication((Class<? extends Application>) Class.forName(className));
        FxToolkit.showStage();
    }

    /**
     * Launch Java FX application from external JAR.<br>
     * The classname given must extend javafx.application.Application.<br>
     * ATENTTION: The JAR must be added to the classpath beforehand.
     *
     * @param applicationJAR The path of the JAR that contains the application
     *                       to be launched. The JAR must contain a JavaFX application with a class
     *                       that extends javafx.application.Application.
     * @param className      The name of the class im the JAR that extends
     *                       javafx.application.Application to be launched.
     */
    @RobotKeyword
    @ArgumentNames({"applicationJAR", "className"})
    public void launchJARApplication(String applicationJAR, String className) throws TimeoutException,
            IOException, ClassNotFoundException {
        FxToolkit.registerPrimaryStage();
        ClassLoader classLoader = loadClassesFromJar(applicationJAR);
        FxToolkit.setupApplication((Class<? extends Application>) classLoader.loadClass(className));
        FxToolkit.showStage();
    }

    private ClassLoader loadClassesFromJar(String applicationJAR) throws IOException, ClassNotFoundException {
        JarFile jarFile = null;
        URLClassLoader cl = null;

        try {
            jarFile = new JarFile(applicationJAR);
            Enumeration<JarEntry> e = jarFile.entries();

            URL[] urls = {new URL("jar:file:" + applicationJAR + "!/")};
            cl = URLClassLoader.newInstance(urls);

            while (e.hasMoreElements()) {
                JarEntry je = e.nextElement();
                if (je.isDirectory() || !je.getName().endsWith(".class")) {
                    continue;
                }
                // -6 because of .class
                String className = je.getName().substring(0, je.getName().length() - 6);
                className = className.replace('/', '.');
                LOG.info(className);
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
     */
    @RobotKeyword
    public void closeApplication() throws TimeoutException {
        FxToolkit.hideStage();
        FxToolkit.cleanupStages();
    }

    /**
     * Sleep. Pause the execution during a period
     *
     * @param milliseconds The number of millisenconds to pause the execution
     */
    @RobotKeyword
    @ArgumentNames({"milliseconds"})
    public void sleep(int milliseconds) {
        new FxRobot().sleep(milliseconds);
    }

    @RobotKeyword
    @ArgumentNames({"identifier", "timeout"})
    public void waitUntilElementIsVisible(String identifier, int timeout) {
        new WaitUntilSupport().waitUntil(getNode(identifier), Matchers.is(isVisible()), timeout);
    }

    @RobotKeyword
    @ArgumentNames({"identifier", "timeout"})
    public void waitUntilElementIsNotVisible(String identifier, int timeout) {
        new WaitUntilSupport().waitUntil(getNode(identifier), Matchers.not(isVisible()), timeout);
    }

    @RobotKeyword
    @ArgumentNames({"identifier", "textToValidate", "timeout"})
    public void waitUntilElementHasText(String identifier, String textToValidate, int timeout) {
        new WaitUntilSupport().waitUntil(getNode(identifier), hasText(textToValidate), timeout);
    }

    @RobotKeyword
    @ArgumentNames({"identifier", "timeout"})
    public void waitUntilElementIsDisabled(String identifier, int timeout) {
        new WaitUntilSupport().waitUntil(getNode(identifier), Matchers.is(isDisabled()), timeout);
    }

    @RobotKeyword
    @ArgumentNames({"identifier", "timeout"})
    public void waitUntilElementIsEnabled(String identifier, int timeout) {
        new WaitUntilSupport().waitUntil(getNode(identifier), Matchers.not(isDisabled()), timeout);
    }

    private Node getNode(String identifier) {
        return new FxRobot().lookup(identifier).query();
    }
}
