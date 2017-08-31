/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testfx.api.FxRobot;

/**
 *
 * @author pcosta
 */
@RobotKeywords
public class Keyboard {

    private static final String DIFERENT_TEXT = "The text is diferent";

    @Autowired
    Misc misc;

    /**
     * <b>Description:</b>This keyword presses the key passed as parameter.<br>
     *
     * @param keycode
     * : The keycode of the key to be pressed. eg. "Enter"
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>keycode</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"keycode"})
    public void press(String keycode) {
        new FxRobot().press(KeyCode.getKeyCode(keycode));
    }

    /**
     * <b>Description:</b>This keyword erases text from a text field. The number of characters
     * erased is passed as argument.<br>
     *
     * @param numberOfCharacters
     * : The number of characters to be erased
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>numberOfCharacters</td>
     *         <td>Yes</td>
     *         <td>int</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"numberOfCharacters"})
    public void eraseText(int numberOfCharacters) {
        new FxRobot().eraseText(numberOfCharacters);
    }

    /**
     * <b>Description:</b>This keyword writes text on the focused node. (eg. a text field)<br>
     *
     * @param text
     * : The text to written
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>text</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"text"})
    public void write(String text) {
        new FxRobot().write(text);
    }

    /**
     * <b>Description:</b>This keyword releases the key passed as argument.<br>
     *
     * @param keycode
     * : The keycode of the key to be released. eg. "Enter"
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>keycode</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"keycode"})
    public void release(String keycode) {
        new FxRobot().release(KeyCode.getKeyCode(keycode));
    }

    /**
     * <b>Description:</b>This keyword types the keycode passed as argument.<br>
     *
     * @param keycode
     * : The keycode to be typed
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>keycode</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"keycode"})
    public void type(String keycode) {
        new FxRobot().type(KeyCode.getKeyCode(keycode));
    }

    /**
     * <b>Description:</b>This keyword erases all the text on the the text area passed as argument.<br>
     *
     * @param identifier
     * : The text area to be cleared of text
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
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
    public void  clearTextArea(String identifier) {
        TextArea text = new FxRobot().lookup(identifier).query();
        text.setText("");
    }

    /**
     * <b>Description:</b>This keyword erases all the text on the the text field passed as argument.<br>
     *
     * @param identifier
     * : The text field to be cleared of text
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
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
    public void  clearTextField(String identifier) {
        TextField text = new FxRobot().lookup(identifier).query();
        text.setText("");
    }

    /**
     * <b>Description:</b>This keyword validates the text in a text field. The text filed is identified in the first
     * parameter and the text to validate is defined in the second parameter. If the text in the text field does not
     * match the text passed as a parameter a TestFxLibraryNonFatalException in thrown.<br>
     *
     * @param identifier
     * : The identifier of the text field you want to verify.
     * @param textToValidate
     * : The text you want to validate
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
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
     *         <td>textToValidate</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "textToValidate"})
    public void textFieldTextShouldBe(String identifier, String textToValidate) {

        misc.waitUntilPageContains(identifier);

        try{

            TextField node = new FxRobot().lookup(identifier).query();
            String nodeText = node.getText();

            if(!nodeText.equals(textToValidate)){
                throw new TestFxLibraryNonFatalException(DIFERENT_TEXT);
            }

        } catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b>This keyword validates the text in a text area. The text area is identified in the first
     * parameter and the text to validate is defined in the second parameter. If the text in the text area does not
     * match the text passed as a parameter a TestFxLibraryNonFatalException in thrown.<br>
     *
     * @param identifier
     * : The identifier of the text area you want to verify.
     * @param textToValidate
     * : The text you want to validate
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
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
     *         <td>textToValidate</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "textToValidate"})
    public void textAreaTextShouldBe(String identifier, String textToValidate) {

        misc.waitUntilPageContains(identifier);

        try{

            TextArea node = new FxRobot().lookup(identifier).query();
            String nodeText = node.getText();

            if(!nodeText.equals(textToValidate)){
                throw new TestFxLibraryNonFatalException(DIFERENT_TEXT);
            }

        } catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b>This keyword validates the text in a label. The label is identified in the first
     * parameter and the text to validate is defined in the second parameter. If the text in the label does not
     * match the text passed as a parameter a TestFxLibraryNonFatalException in thrown.<br>
     *
     * @param identifier
     * : The identifier of the label you want to verify.
     * @param textToValidate
     * : The text you want to validate
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
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
     *         <td>textToValidate</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "textToValidate"})
    public void labelTextShouldBe(String identifier, String textToValidate) {

        misc.waitUntilPageContains(identifier);

        try{

            Label node = new FxRobot().lookup(identifier).query();
            String nodeText = node.getText();

            if(!nodeText.equals(textToValidate)){
                throw new TestFxLibraryNonFatalException(DIFERENT_TEXT);
            }

        } catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
    }

}
