/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.python.google.common.collect.Iterables;
import org.python.jline.internal.Log;
import org.robotframework.javalib.annotation.*;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import org.testfx.toolkit.PrimaryStageFuture;

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
    private static final int MILLISECONDS = 1000;
    private static final String ATTRIBUTES_STRING = "Attributes";
    private static final String KEY = "APP_";
    private static final String METHODS_STRING = "Methods";


    @Autowired
    private Logging log;

    /**
     * <b>Description:</b> This keyword launches JavaFX application. The classname
     * passed as <i>className</i> must extend javafx.application.Application.<br>
     * ATENTTION: The class must be added to the classpath beforehand.<br>
     *
     * @param className
     * : The name of the class that extends javafx.application.Application to be launched
     * @param distinctiveName
     * : The name to identify the session of the application
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
     *     <tr>
     *         <td>distinctiveName</td>
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
     *         <td>Application1</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"className" , "distinctiveName=null", "*args=null"})
    public void startApplication(String className, String distinctiveName, String... args){

        TestFxLibraryValidation.validateArguments(className, distinctiveName);

        final Stage[] stage = {null};
        try {
            int size = new FxRobot().listTargetWindows().size();
            if(size == 0) {
                FxToolkit.registerPrimaryStage();
                FxToolkit.setupApplication((Class<? extends Application>) Class.forName(className), args);
                FxToolkit.showStage();
                TestFXLibraryCache.getIstance().put(KEY + distinctiveName, FxToolkit.toolkitContext().getPrimaryStageFuture());
            } else {
                FxToolkit.registerStage(() -> {
                    stage[0] = new Stage();
                    return stage[0];
                });
                FxToolkit.setupApplication((Class<? extends Application>) Class.forName(className), args);
                FxToolkit.showStage();
                TestFXLibraryCache.getIstance().put(KEY + distinctiveName, stage[0]);
            }

        } catch (TimeoutException | ClassNotFoundException e) {
            throw new TestFxLibraryFatalException(e);
        }
    }

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
    @RobotKeywordOverload
    public void startApplication(String className){
        TestFxLibraryValidation.validateArguments(className);

        startApplication(className, " ");

    }

    /**
     * <b>Description:</b> This keyword launches JavaFX application from external JAR.<br>
     * The classname given must extend javafx.application.Application.<br>
     * IMPORTANT: The JAR must be added to the classpath beforehand.<br>
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
    public void sleep(float seconds) {

        int convertedInt = (int)(seconds * MILLISECONDS);
        new FxRobot().sleep(convertedInt);
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

    /**
     * Search if the specific Node exists.
     *
     * @param identifier
     *      The id of the Node to search.
     *
     * @return
     *      The Node.
     */
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
     * Attribute value in a string
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
    public String getComponentAttribute(String identifier, String attribute) {

        TestFxLibraryValidation.validateArguments(identifier, attribute);

        Object obj = getNode(identifier);

        try {
            Method m = obj.getClass().getMethod(attribute);
            Object o = m.invoke(obj);

            return o.toString();

        } catch ( IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new TestFxLibraryFatalException(e);
        }
    }

     /**
     *
     * @param identifier
     * : The component identifier
     * @return
     * : The component method list
     * @throws IOException
     * : Instantiation Exception
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
    public String listComponentMethods(String identifier) throws IOException {
        HashMap<String,List<String>> list = new HashMap<>();

        TestFxLibraryValidation.validateArguments(identifier);

        Node node = getNode(identifier);

        try {
            Class clazz = Class.forName(node.getClass().getName());

            Object obj = clazz.newInstance();

            Method[] methods = obj.getClass().getMethods();

            List<String> attr = new ArrayList<>();
            List<String> methodsList = new ArrayList<>();

            list.put(ATTRIBUTES_STRING, attr);
            list.put(METHODS_STRING, methodsList);
            for (Method method : methods) {

                try {
                    getComponentAttribute(identifier, method.getName());
                    attr.add(method.getName());
                } catch (Exception e) {
                    Log.debug(String.format("The %s is not attribute", identifier), e);
                    methodsList.add(method.getName());
                }
            }

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException  e) {
            throw new TestFxLibraryFatalException(e);
        }
        return list.toString();
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

    /**
     * Get Parents from component.
     *
     * @param parent
     *      The root parent to check if contains more components.
     * @param mapComponents
     *      List of components search to add more.
     * @return
     *      The List of components
     */
    private List<String> getParents(Parent parent, List<String> mapComponents){
        for (int i = 0; i < parent.getChildrenUnmodifiable().size() && parent.getChildrenUnmodifiable().size() > 1; i++) {
            if(parent.getChildrenUnmodifiable().get(i) instanceof Parent){
                Parent p = (Parent) parent.getChildrenUnmodifiable().get(i);
                mapComponents.add(String.format("Component: %s - Child: %s \\n", parent, p));
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

    /**
     * <b>Description:</b> Switch application if more than one is running.
     * @param application
     * : The name of the application to request the focus
     * @return
     * : A list of applications
     * <br><br>
     * <table summary ="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>application</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Switch Application</td>
     *         <td>my application</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword()
    @ArgumentNames({"application"})
    public List<String> switchApplication(String application){
        Stage stage;
        List<String> listAppKey = new ArrayList<>();

        Object obj = TestFXLibraryCache.getIstance().get(application);

        if(obj == null){
            for (String key : TestFXLibraryCache.getIstance().getMap().keySet()) {
                if(key != null && key.startsWith(KEY) && !" ".equals(key.split("_")[1])){
                    listAppKey.add(key);
                }
            }
        } else {
            if(obj instanceof PrimaryStageFuture){
                try {
                    stage = ((PrimaryStageFuture) obj).get();
                } catch (Exception e) {
                    throw new TestFxLibraryNonFatalException(e);
                }
            } else {
                stage = (Stage) obj;
            }

            Platform.runLater(stage::requestFocus);
        }

        return listAppKey;

    }
}
