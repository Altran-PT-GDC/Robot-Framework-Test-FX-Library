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
     *<b>Description:</b>This keyword presses the key passed as parameter.<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>keycode</td>
     *         <td>Yes</td>
     *         <td>the keycode of the key to be pressed. eg. "Enter"</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"keycode"})
    public void press(String keycode) {
        new FxRobot().press(KeyCode.getKeyCode(keycode));
    }

    /**
     * <b>Description:</b>This keyword erases text from a text field. The number of characters
     * erased is passed as argument.<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>numberOfCharacters</td>
     *         <td>Yes</td>
     *         <td>The number of characters to be erased</td>
     *         <td>int</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"numberOfCharacters"})
    public void eraseText(int numberOfCharacters) {
        new FxRobot().eraseText(numberOfCharacters);
    }

    /**
     * <b>Description:</b>This keyword writes text on the focused node. (eg. a text field)<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>text</td>
     *         <td>Yes</td>
     *         <td>The text to written</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"text"})
    public void write(String text) {
        new FxRobot().write(text);
    }

    /**
     * <b>Description:</b>This keyword releases the key passed as argument.<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>keycode</td>
     *         <td>Yes</td>
     *         <td>The keycode of the key to be released. eg. "Enter"</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"keycode"})
    public void release(String keycode) {
        new FxRobot().release(KeyCode.getKeyCode(keycode));
    }

    /**
     *<b>Description:</b>This keyword types the keycode passed as argument.<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>keycode</td>
     *         <td>Yes</td>
     *         <td>The keycode to be typed</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     *
     */
    @RobotKeyword
    @ArgumentNames({"keycode"})
    public void type(String keycode) {
        new FxRobot().type(KeyCode.getKeyCode(keycode));
    }

    /**
     *<b>Description:</b>This keyword erases all the text on the the text area passed as argument.<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>The text area to be cleared of text</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void  clearTextArea(String identifier) {
        TextArea text = new FxRobot().lookup(identifier).query();
        text.setText("");
    }

    /**
     *
     *<b>Description:</b>This keyword erases all the text on the the text field passed as argument.<br><br>
     *
     *<b>Input Arguments:</b><br>
     *
     *<table>
     *     <tr>
     *         <th>Argument</th>
     *         <th>Mandatory</th>
     *         <th>Summary</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>The text field to be cleared of text</td>
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
     * Verify if the text contained in a TextField is equals to the text you want to validate. The test fails if the text is diferent
     *
     * @param identifier
     *          The identifier of the TextField you want to validate
     * @param textToValidate
     *          The text you want to validate
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
     * Verify if the text contained in a TextArea is equals to the text you want to validate. The test fails if the text is diferent
     *
     * @param identifier
     *          The identifier of the TextField you want to validate
     * @param textToValidate
     *          The text you want to validate
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
     * Verify if the text contained in a Label is equals to the text you want to validate. The test fails if the text is diferent
     *
     * @param identifier
     *          The identifier of the Label you want to validate
     * @param textToValidate
     *          The text you want to validate
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
