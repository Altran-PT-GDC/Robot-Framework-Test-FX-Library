/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;

import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import com.google.common.io.PatternFilenameFilter;
import com.sun.javafx.robot.impl.FXRobotHelper;
import com.sun.javafx.scene.SceneHelper;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.WritableImage;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testfx.api.FxRobot;

import org.testfx.api.FxToolkit;
import org.testfx.api.FxToolkitContext;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.util.List;

/**
 *
 * @author pcosta
 */
@RobotKeywords
public class Window {

    private String filePath;
    private int counter;
    private String fileName;

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
    public void selectWindow(String identifier) {
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

    /**
     * Take a screenshot of the application
     *
     * @param format
     *
     */
    @RobotKeyword
    @ArgumentNames({"format"})
    public void captureScreen(String format){

        TestFxLibraryValidation.validateArguments(format);

        try {

            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
            String fp = filePath + fileName + counter + "." + format;
            ImageIO.write(image, format, new File(fp));
            counter++;
        } catch (Exception e){
            throw new TestFxLibraryNonFatalException("Error taking screenshot");
        }
    }

    /**
     * Set the Path of the folder where you want to save the screenshots
     *
     * @param filePath
     *
     */
    @RobotKeyword
    @ArgumentNames({"filePath" , "fileName"})
    public void setFilePath(String filePath, String fileName){

        TestFxLibraryValidation.validateArguments(filePath, fileName);

        try {
            this.filePath = filePath;
            this.fileName = fileName;
            deleteFiles();
            counter = 1;

        } catch (Exception e){
            throw new TestFxLibraryFatalException("Error setting the filePath");
        }
    }

    public void deleteFiles(){
        File directory = new File(filePath);

        File[] files = directory.listFiles();
        for (File f : files)
        {
            if (f.getName().startsWith(fileName))
            {
                f.delete();
            }
        }
    }

}
