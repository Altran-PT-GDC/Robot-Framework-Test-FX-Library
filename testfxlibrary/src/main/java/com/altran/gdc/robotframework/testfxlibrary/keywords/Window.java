/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;

import javafx.scene.Node;
import javafx.stage.Stage;
import org.loadui.testfx.GuiTest;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testfx.api.FxRobot;

import org.testfx.api.FxRobotContext;
import org.testfx.api.FxToolkitContext;


import java.util.List;

/**
 *
 * @author pcosta
 */
@RobotKeywords
public class Window {

    /**
     * Close the current focused window
     */
    @RobotKeyword
    public void closeCurrentWindow() {
        try {
            new FxRobot().closeCurrentWindow();
        } catch (Exception e){
            throw new TestFxLibraryNonFatalException("Error Close Window");
        }
    }

    /**
     * List all target windows
     *
     * @return
     *          A list of javafx.stage.Window
     */
    @RobotKeyword
    public List<javafx.stage.Window> listTargetWindows() {
        return new FxRobot().listTargetWindows();
    }

    /**
     * List all Windows
     *
     * @return
     *          A list of javafx.stage.Window
     */
    @RobotKeyword
    public List<javafx.stage.Window> listWindows() {

        return new FxRobot().listWindows();
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
     * Choose window
     *
     * @param identifier
     *          the identifier of the window8
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void window(String identifier) {
        new FxRobot().window(identifier);
    }

    /**
     * Select the Main Window
     *
     * Example:
     * Select Main Window
     */
    @RobotKeyword("Select the mais Window\n\n" +
            "Example:\n" +
            "Select Main Window")
    public void selectMainWindow(){
        try {
            new FxToolkitContext().getPrimaryStageFuture().get();
        } catch (Exception e){
            throw new TestFxLibraryNonFatalException("Error get main window");
        }
    }
}
