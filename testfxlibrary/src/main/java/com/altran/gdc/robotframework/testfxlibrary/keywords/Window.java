/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import javafx.geometry.Point2D;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testfx.api.FxRobot;
import org.testfx.api.FxToolkitContext;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

/**
 * @author pcosta
 */
@RobotKeywords
public class Window {

    private String filePath;
    private int counter;
    private String fileName;
    private static final Logger LOG = LoggerFactory.getLogger(Window.class);
    private static final String ERROR_MSG = "Error";

    @Autowired
    Misc misc;

    /**
     * <b>Description:</b>This keyword closes the current focused window. If an error occurs
     * a TestFxLibraryNonFatalException is thrown.<br>
     */
    @RobotKeyword
    public void closeCurrentWindow() {
        try {
            new FxRobot().closeCurrentWindow();
        } catch (Exception e){
            LOG.error(ERROR_MSG, e);
            throw new TestFxLibraryNonFatalException("Error Close Window");
        }
    }

    /**
     * <b>Description:</b>This keyword returns a list of all target windows.<br>
     *
     * @return
     * : A list of javafx.stage.Window
     */
    @RobotKeyword
    public List<javafx.stage.Window> listTargetWindows() {
        return new FxRobot().listTargetWindows();
    }

    /**
     * <b>Description:</b>This keyword returns a list of all windows.<br>
     *
     * @return
     * : A list of javafx.stage.Window
     */
    @RobotKeyword
    public List<javafx.stage.Window> listWindows() {

        return new FxRobot().listWindows();
    }

    /**
     * <b>Description:</b>This keyword targets a specific window identified through the parameter.<br>
     *
     * @param identifier
     * : the identifier of the window
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
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void selectWindow(String identifier) {
        new FxRobot().targetWindow(identifier);
    }

    /**
     * <b>Description:</b>This keyword chooses a specific window identified through the parameter.<br>
     *
     * @param identifier
     * : the identifier of the window
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
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void window(String identifier) {
        new FxRobot().window(identifier);
    }

    /**
     * <b>Description:</b>This keyword selects the main window. If an error occurs
     * a TestFxLibraryNonFatalException is thrown.<br>
     *
     */
    @RobotKeyword("Select the mais Window\n\n" +
            "Example:\n" +
            "Select Main Window")
    public void selectMainWindow(){
        try {
            new FxToolkitContext().getPrimaryStageFuture().get();
        } catch (Exception e){
            LOG.error(ERROR_MSG, e);
            throw new TestFxLibraryNonFatalException("Error get main window");
        }
    }

    /**
     * <b>Description:</b>This keyword takes a screenshot of the application. The file extension is defined by
     * the parameter. If an error occurs a TestFxLibraryNonFatalException is thrown.<br>
     *
     * @param format
     * : The image format of the ScreenShots
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>format</td>
     *         <td>Yes</td>
     *         <td>string (jpg, png, gif, bmp, wbmp)</td>
     *         <td>png</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"format"})
    public void captureScreen(String format){

        TestFxLibraryValidation.validateArguments(format);

        try {

            Stage primaryStage = new FxToolkitContext().getPrimaryStageFuture().get();
            Rectangle r = new Rectangle();
            r.setBounds((int)primaryStage.getX(),(int)primaryStage.getY(),(int)primaryStage.getWidth(),(int)primaryStage.getHeight());

            BufferedImage image = new Robot().createScreenCapture(r);
            String fp = filePath + fileName + counter + "." + format;
            ImageIO.write(image, format, new File(fp));
            System.out.println("*HTML* <img src=\"" + fp + "\">");
            counter++;

        } catch (Exception e){
            LOG.error(ERROR_MSG, e);
            throw new TestFxLibraryNonFatalException("Error taking screenshot");
        }
    }

    /**
     * <b>Description:</b>This keyword sets the path of the folder where you want to save the screenshots, deletes
     * the files with the same name on the directory set by the user and resets the counter of the Screenshots. If
     * an error occurs a TestFxLibraryNonFatalException is thrown.<br>
     *
     * @param filePath
     * : The Path of the folder where you want to save the ScreenShots
     * @param fileName
     * : The name that you want to give to the Screenshots
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>filePath</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>fileName</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
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
            LOG.error(ERROR_MSG, e);
            throw new TestFxLibraryFatalException("Error setting the filePath");
        }
    }

    public void deleteFiles(){
        File directory = new File(filePath);

        File[] files = directory.listFiles();
        for (File f : files) {
            if (f.getName().startsWith(fileName)) {
                f.delete();
            }
        }
    }

    /**
     * Get the position of the node on the screen
     *
     * @param identifier the identifier of the node
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Point2D getComponentPosition(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);
        misc.waitUntilPageContains(identifier);

        try {

            Point2D p = new FxRobot().point(identifier).query();
            LOG.info("X - " + (int)p.getX() + " Y - " + (int)p.getY());
            return p;

        } catch (Exception e) {
            LOG.error(ERROR_MSG, e);
            throw new TestFxLibraryFatalException("Something goes wrong");
        }
    }

    /**
     * Get the position of the node on the screen
     *
     */
    @RobotKeyword
    public void cancelFileChooser() {

        //FileChooser fileChooser = new FxRobot().targetWindow().getScene();

        try {
            //TODO implement the method.

        } catch (Exception e) {
            LOG.error(ERROR_MSG, e);
            throw new TestFxLibraryFatalException("Something goes wrong");
        }
    }

}
