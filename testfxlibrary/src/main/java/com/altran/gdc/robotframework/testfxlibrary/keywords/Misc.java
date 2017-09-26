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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Window;
import org.python.google.common.collect.Iterables;
import org.python.jline.internal.Log;
import org.robotframework.javalib.annotation.*;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;
import java.util.List;
import java.util.concurrent.*;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import static java.net.URLClassLoader.newInstance;

/**
 * @author pcosta
 */
@RobotKeywords
public class Misc {

    private static final int CLASS_VALUE = 6;

    @Autowired
    private Logging log;

    /**
     * <b>Description:</b> This keyword launches JavaFX application. The classname
     * passed as <i>className</i> must extend javafx.application.Application.<br>
     * ATENTTION: The class must be added to the classpath beforehand.<br>
     *
     * @param className
     * : The name of the class that extends javafx.application.Application to be launched
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
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
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Start Application</td>
     *         <td>AnApplication</td>
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
     * <b>Description:</b> This keyword launches JavaFX application from external JAR.<br>
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
     *         <th>Parameter</th>
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
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Start Jar Application</td>
     *         <td>ajarfile.jar</td>
     *         <td>AnApplication</td>
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
     * <b>Description:</b> This keyword closes the JavaFX application. The primary stage is hidden and cleaned up.<br>
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
     * <b>Description:</b> This keyword pauses the execution during a period specified with <i>milliseconds</i>
     * in milliseconds.<br>
     *
     * @param seconds
     * : The number of secunds to pause the execution
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>seconds</td>
     *         <td>Yes</td>
     *         <td>int</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Sleep</td>
     *         <td>250</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"seconds"})
    public void sleep(int seconds) {

        new FxRobot().sleep(seconds, TimeUnit.SECONDS);
    }

    /**
     * <b>Description:</b> This keyword gets the Nth element from a component list specified
     * with <i>identifier</i>; <i>nthElement</i> identifies the index.<br>
     *
     * @param identifier
     * : The component to search
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
     *
     * @return
     *  The Nth component from the list
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>${component}=</td>
     *         <td>Get Nth Element</td>
     *         <td>idComponent02</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Node getNthElement(String identifier) {

        return getNode(identifier);
    }

    /**
     * <b>Description:</b> This keyword gets the inner component from a given component
     * specified with <i>identifier</i><br>
     *
     * @param identifier
     * : The name of the component that you are going to test
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
     *
     * @return
     *  The inner component of the provided component
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>${component}=</td>
     *         <td>Get Node Key</td>
     *         <td>idComponent02</td>
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

        return TestFxLibraryCommon.lookup(identifier);
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
        Set<Node> nodeList = TestFxLibraryCommon.lookup(identifier);
        return  Iterables.get(nodeList, nthElement);
    }

    /**
     * <b>Description:</b> This keyword gets an attribute value of a component.<br>
     *
     * @param identifier
     * : The component where you want to get the attribute
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
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>${method}=</td>
     *         <td>Get Component Attribute</td>
     *         <td>idComponent02</td>
     *         <td>attributeXYZ</td>
     *     </tr>
     * </table>
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

    /**
     * List the methods of a component
     *
     * @param identifier
     *          The component where you want to get the list of Methods
     */
    /**
     * <b>Description:</b> This keyword lists the methods of a component.<br>
     *
     * @param identifier
     * : The component identifier
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
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>${method}=</td>
     *         <td>List Component Methods</td>
     *         <td>idComponent02</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword()
    @ArgumentNames({"identifier"})
    public void listComponentMethods(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        Node node = getNode(identifier);

        try {
            Class clazz = Class.forName(node.getClass().getName());

            Object obj = clazz.newInstance();

            Method[] methods = obj.getClass().getMethods();

            for (int i=0; i < methods.length; i++){

                Log.info(methods[i].getName());
            }

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException  e) {
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword list components in context
     *
     * <br><br>
     * @return
     *  The list of components
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>${list}=</td>
     *         <td>List Components In Context</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword()
    public List<List<String>> listComponentsInContext(){
        List<List<String>> list = new ArrayList<>();
        try {

            List<String> mapComponents = new ArrayList<>();
            List<Window> windows = new FxRobot().listWindows();

            for(Window w : windows) {
                Scene scene = w.getScene();
                Parent p = scene.getRoot();
                list.add(getParents(p, mapComponents));
            }

        } catch (Exception e) {
            throw new TestFxLibraryFatalException(e);
        }

        return list;
    }

    private List<String> getParents(Parent parent, List<String> mapComponents){
        for (int i = 0; i < parent.getChildrenUnmodifiable().size() && parent.getChildrenUnmodifiable().size() > 1; i++) {
            if(parent.getChildrenUnmodifiable().get(i) instanceof Parent){
                Parent p = (Parent) parent.getChildrenUnmodifiable().get(i);
                mapComponents.add("Component: " + parent + " - Child: " + p + "\n");
                getParents(p, mapComponents);
            }
        }
        return mapComponents;
    }

    /**
     * <b>Description:</b> This keyword gets the inner component from a given component
     * specified with <i>identifier</i><br>
     *
     * @param identifier
     * : The name of the component that you are going to test
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
     *
     * @return
     *  The inner component of the provided component
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>${component}=</td>
     *         <td>Get Node Key</td>
     *         <td>idComponent02</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword()
    @ArgumentNames({"identifier"})
    public String getNodeAll(String identifier) {
        Set<Node> nodes = new FxRobot().lookup(identifier).queryAll();
        return nodes.toString();
    }
}
