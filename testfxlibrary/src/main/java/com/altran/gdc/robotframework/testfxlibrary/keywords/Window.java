/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altran.gdc.robotframework.testfxlibrary.keywords;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testfx.api.FxRobot;

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
}
