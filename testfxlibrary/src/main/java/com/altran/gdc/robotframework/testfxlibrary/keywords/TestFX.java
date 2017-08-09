/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altran.gdc.robotframework.testfxlibrary.keywords;

import java.io.IOException;
import static java.lang.System.out;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.function.Predicate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import javafx.application.Application;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.VerticalDirection;
import javafx.scene.Node;
import javafx.scene.input.KeyCode;
import static org.hamcrest.Matchers.contains;

import org.hamcrest.Matchers;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

import static org.hamcrest.core.Is.is;
import static org.testfx.api.FxAssert.verifyThat;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkit;
import static org.testfx.matcher.base.NodeMatchers.hasText;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isEnabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;
import static org.testfx.matcher.base.NodeMatchers.hasChild;
import org.testfx.robot.Motion;

import org.testfx.service.support.WaitUntilSupport;


@RobotKeywords
public class TestFX {

    /**
     * Launch Java FX application. <br>
     * The classname given must extend javafx.application.Application.<br>
     * ATENTTION: The class must be added to the classpath beforehand.
     *
     * @param className 
     *            The name of the class that extends javafx.application.Application to be launched.
     */
    @RobotKeyword
    @ArgumentNames({"className"})
    public void launchApplication(String className)
            throws Exception {
        FxToolkit.registerPrimaryStage();
        FxToolkit.setupApplication((Class<? extends Application>) Class.forName(className));
        FxToolkit.showStage();
    }

    /**
     * Launch Java FX application from external JAR.<br>
     * The classname given must extend javafx.application.Application.<br>
     * ATENTTION: The JAR must be added to the classpath beforehand.
     *
     * @param applicationJAR 
     *            The path of the JAR that contains the application
     *            to be launched. The JAR must contain a JavaFX application with a class
     *            that extends javafx.application.Application.
     *
     * @param className 
     *             The name of the class im the JAR that extends
     *             javafx.application.Application to be launched.
     */
    @RobotKeyword
    @ArgumentNames({"applicationJAR", "className"})
    public void launchJARApplication(String applicationJAR, String className)
            throws Exception {
        FxToolkit.registerPrimaryStage();
        ClassLoader classLoader = loadClassesFromJar(applicationJAR);
        FxToolkit.setupApplication((Class<? extends Application>) classLoader.loadClass(className));
        FxToolkit.showStage();
    }

    private ClassLoader loadClassesFromJar(String applicationJAR) throws IOException, ClassNotFoundException {
        JarFile jarFile = new JarFile(applicationJAR);
        Enumeration<JarEntry> e = jarFile.entries();

        URL[] urls = {new URL("jar:file:" + applicationJAR + "!/")};
        URLClassLoader cl = URLClassLoader.newInstance(urls);

        while (e.hasMoreElements()) {
            JarEntry je = e.nextElement();
            if (je.isDirectory() || !je.getName().endsWith(".class")) {
                continue;
            }
            // -6 because of .class
            String className = je.getName().substring(0, je.getName().length() - 6);
            className = className.replace('/', '.');
            Class c = cl.loadClass(className);
            out.println(className);

        }

        return cl;

    }

    /**
     * Closes the Java FX application. 
     * The primary stage is hidden and cleaned-up.
     *
     */
    @RobotKeyword
    public void closeApplication() throws TimeoutException {
        FxToolkit.hideStage();
        FxToolkit.cleanupStages();
    }

    /**
     * Clicks on a indentifier.<br>
     *
     * @param identifier 
     *             A string containing the identifier of the node to be clicked.
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void clickOn(String identifier) throws TimeoutException {
        new FxRobot().clickOn(identifier);
    }

    /**
     * Double Click on a node.
     *
     * @param identifier 
     *            The identifier of the node
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void doubleClickOn(String identifier) {
        new FxRobot().doubleClickOn(identifier);
    }

    /**
     * Drag a node.<br>
     *
     * @param identifier 
     *             The identifier of the node to be draged.
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void drag(String identifier) {
        new FxRobot().drag(identifier);
    }

    /**
     * Drop a node that is being draged.
     * 
     *
     * @param identifier
     *            The identifier of the node
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void drop(String identifier) {
        new FxRobot().drop();
    }

    /**
     * Drop to specific node.<br>
     *
     * @param identifier
     *            The identifier of the node
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void dropTo(String identifier) {
        new FxRobot().dropTo(identifier);
    }

    /**
     * Move the mouse to a x,y coordinate
     *
     * @param xCoordinate
     *            The x coordinate
     * @param yCoordinate
     *            The y coordinate 
     */
    @RobotKeyword
    @ArgumentNames({"xCoordinate", "yCoordinate"})
    public void moveBy(double xCoordinate, double yCoordinate) {
        new FxRobot().moveBy(0, 0, Motion.DIRECT);
    }
    
    /**
     * Move Mouse to node
     * 
     * @param identifier 
     *            The identifier of the node
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void moveTo(String identifier) {
        new FxRobot().moveTo(identifier, Motion.DIRECT);
    }

    /**
     * Right Click on node
     * 
     * @param identifier 
     *            The identifier of the node
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void rightClickOn(String identifier) {
        new FxRobot().rightClickOn(identifier, Motion.DIRECT);
    }
    
    /**
     * Scroll left
     * 
     * @param amount 
     *            The amount to be scrolled
     */
    @RobotKeyword
    @ArgumentNames({"amount"})
    public void scrollLeft(int amount) {
        new FxRobot().scroll(0, HorizontalDirection.LEFT);
    }

    
    /**
     * Scroll right
     * 
     * @param amount 
     *            The amount to be scrolled
     */
    @RobotKeyword
    @ArgumentNames({"amount"})
    public void scrollRight(int amount) {
        new FxRobot().scroll(0, HorizontalDirection.RIGHT);
    }

    
    /**
     * Scroll up
     * 
     * @param amount 
     *            The amount to be scrolled
     */
    @RobotKeyword
    @ArgumentNames({"amount"})
    public void scrollUp(int amount) {
        new FxRobot().scroll(0, VerticalDirection.UP);
    }

    
    /**
     * Scroll down
     * 
     * @param amount 
     *            The amount to be scrolled
     */
    @RobotKeyword
    @ArgumentNames({"amount"})
    public void scrollDown(int amount) {
        new FxRobot().scroll(0, VerticalDirection.DOWN);
    }

  
    
    /**
     * Sleep. Pause the execution during a period
     * 
     * @param milliseconds 
     *            The number of millisenconds to pause the execution
     */
    @RobotKeyword
    @ArgumentNames({"milliseconds"})
    public void sleep(int milliseconds) {
        new FxRobot().sleep(milliseconds);
    }

    @RobotKeyword
    @ArgumentNames({"identifier", "timeout"})
    public void waitUntilElementIsVisible(String identifier, int timeout){
        new WaitUntilSupport().waitUntil(getNode(identifier), Matchers.is(isVisible()),timeout);
    }

    @RobotKeyword
    @ArgumentNames({"identifier", "timeout"})
    public void waitUntilElementIsNotVisible(String identifier, int timeout){
        new WaitUntilSupport().waitUntil(getNode(identifier), Matchers.not(isVisible()),timeout);
    }

    @RobotKeyword
    @ArgumentNames({"identifier", "textToValidate", "timeout"})
    public void waitUntilElementHasText(String identifier,String textToValidate, int timeout){
        new WaitUntilSupport().waitUntil(getNode(identifier), hasText(textToValidate),timeout);
    }

    @RobotKeyword
    @ArgumentNames({"identifier", "timeout"})
    public void waitUntilElementIsDisabled(String identifier, int timeout){
        new WaitUntilSupport().waitUntil(getNode(identifier), Matchers.is(isDisabled()),timeout);
    }

    @RobotKeyword
    @ArgumentNames({"identifier", "timeout"})
    public void waitUntilElementIsEnabled(String identifier, int timeout){
        new WaitUntilSupport().waitUntil(getNode(identifier), Matchers.not(isDisabled()),timeout);
    }



    private Node getNode(String identifier) {
        return new FxRobot().lookup(identifier).query();
    }


    /**
     * Close the current focused window
     */
    @RobotKeyword
    public void closeCurrentWindow() {
        new FxRobot().closeCurrentWindow();
    }

    /**
     * List all target windows
     * 
     * @return
     *          A list of javafx.stage.Window
     */
    @RobotKeyword
    public List<javafx.stage.Window> listTargetWindows() {
        List<javafx.stage.Window> targetWindows = new FxRobot().listTargetWindows();
        return targetWindows;
    }

    /**
     * List all Windows
     * 
     * @return 
     *          A list of javafx.stage.Window
     */
    @RobotKeyword
    public List<javafx.stage.Window> listWindows() {
        List<javafx.stage.Window> windows = new FxRobot().listWindows();
        return windows;
    }

    /**
     * Target a scpecific window
     * 
     * @param identifier
     *          the identifier of the window
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void targetWindow(String identifier) {
        new FxRobot().targetWindow(identifier);
    }

    /**
     * Choose? window
     * 
     * @param identifier 
     *          the identifier of the window
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void window(String identifier) {
        new FxRobot().window(identifier);
    }

    /**
     * Press a key
     * 
     * @param keycode 
     *          the keycode of the key to be pressed. eg. "Enter"
     */
    @RobotKeyword
    @ArgumentNames({"keycode"})
    public void press(String keycode) {
        new FxRobot().press(KeyCode.getKeyCode(keycode));
    }

    /**
     * Erase Text from a text field
     * 
     * @param numberOfCharacters 
     *          The number of characters to be erased
     */
    @RobotKeyword
    @ArgumentNames({"numberOfCharacters"})
    public void eraseText(int numberOfCharacters) {
        new FxRobot().eraseText(numberOfCharacters);
    }

    /**
     * Writes text on the focused node. (eg. a text field)
     * 
     * @param text 
     *          The text to written
     */
    @RobotKeyword
    @ArgumentNames({"text"})
    public void write(String text) {
        new FxRobot().write(text);
    }

    /**
     * Relese a key
     * 
     * @param keycode
     *          The keycode of the key to be released. eg. "Enter"
     */
    @RobotKeyword
    @ArgumentNames({"keycode"})
    public void relase(String keycode) {
        new FxRobot().release(KeyCode.getKeyCode(keycode));
    }

    /**
     * Type a keycode
     * 
     * @param keycode 
     *      The keycode to be typed
     */
    @RobotKeyword
    @ArgumentNames({"keycode"})
    public void type(String keycode) {
        new FxRobot().type(KeyCode.getKeyCode(keycode));
    }
    
    
    
    
    @RobotKeyword
    @ArgumentNames({"identifier","identifierToValidate"})
    public void verifyThatContains(String identifier, String identifierToValidate) {
        verifyThat(identifier, (Predicate) contains( identifierToValidate ));
        
    }
    
    @RobotKeyword
    @ArgumentNames({"identifier","textToValidate"})
    public void verifyThatHasText(String identifier, String textToValidate) {
        verifyThat( identifier, hasText(textToValidate));
    }
    
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void verifyThatIsEnabled(String identifier) {
        verifyThat( identifier, isEnabled() );
        
    }
    
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void verifyThatIsDisabled(String identifier) {
        verifyThat( identifier, isDisabled() );
        
    }
    
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void verifyThatIsVisible(String identifier) {
        verifyThat( identifier, isVisible() );
        
    }
    
    @RobotKeyword
    @ArgumentNames({"identifier","identifierToValidate"})
    public void verifyThatHasChild(String identifier, String identifierToValidate) {
        verifyThat( identifier, hasChild(identifierToValidate) );
    }
    
    
    /*@RobotKeyword
    @ArgumentNames({"identifier"})
    public void getText(String identifier) {
         new FxRobot().lookup(identifier).query().get
      
        
    }*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    //new FxRobot().from(nodeQuery);
    //new FxRobot().fromAll();
    //new FxRobot().interact(runnable);
    //new FxRobot().interactNoWait(runnable);
    //new FxRobot().interrupt();
    //new FxRobot().interrupt(0);
    //new FxRobot().lookup(identifier);
    //new FxRobot().robotContext();
    //new FxRobot().rootNode(scene);
    //new FxRobot().sleep(0);
    //new FxRobot().offset(identifier, 0, 0);
    //new FxRobot().point(identifier);
    //new FxRobot().point(0, 0);
    //new FxRobot().press(MouseButton.valueOf(identifier));
    //FxAssert.assertContext();
    //FxAssert.verifyThat(identifier, nodeMatcher);
    //FxAssert.verifyThatIter(identifier, nodesMatcher);
}
