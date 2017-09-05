/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
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
 *
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
     * <b>Description:</b> This keyword closes the current focused window. If an error occurs
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
     * <b>Description:</b> This keyword returns a list of all target windows.<br>
     *
     * @return
     *  A list of javafx.stage.Window
     */
    @RobotKeyword
    public List<javafx.stage.Window> listTargetWindows() {
        return new FxRobot().listTargetWindows();
    }

    /**
     * <b>Description:</b> This keyword returns a list of all windows.<br>
     *
     * @return
     *  A list of javafx.stage.Window
     */
    @RobotKeyword
    public List<javafx.stage.Window> listWindows() {

        return new FxRobot().listWindows();
    }

    /**
     * <b>Description:</b> This keyword targets a specific window specified with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The identifier of the window
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
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Select Window</td>
     *         <td>idWindow02</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void selectWindow(String identifier) {
        new FxRobot().targetWindow(identifier);
    }

    /**
     * <b>Description:</b> This keyword chooses a specific window specified with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The identifier of the window
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
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Window</td>
     *         <td>idWindow23</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void window(String identifier) {
        new FxRobot().window(identifier);
    }

    /**
     * <b>Description:</b> This keyword selects the main window. If an error occurs
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
     * <b>Description:</b> This keyword takes a screenshot of the application. File
     * extension is specified with <i>format</i>. If an error occurs a TestFxLibraryNonFatalException
     * is thrown.<br>
     *
     * @param format
     * : The image format of ScreenShots
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
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Capture Screen</td>
     *         <td>jgp</td>
     *     </tr>
     *     <tr>
     *         <td>Capture Screen</td>
     *         <td>gif</td>
     *     </tr>
     * </table>
     *
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
     * <b>Description:</b> This keyword sets the folder path where you want to save screenshots,
     * sets the filename, deletes files with the same name in this folder and resets the counter
     * of screenshots. <i>filePath</i> specifies the path and <i>fileName</i> specifies the filename</i>.
     * If an error occurs a TestFxLibraryNonFatalException is thrown.<br>
     *
     * @param filePath
     * : Path of the folder where you want to save screenShots
     * @param fileName
     * : Name that you want to give to Screenshots
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
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Set File Path</td>
     *         <td>E:\MyFolder\MyInnerFolder\</td>
     *         <td>myFile</td>
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

}
