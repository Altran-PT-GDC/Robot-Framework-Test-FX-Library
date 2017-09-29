/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
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
    private Wait wait;

    /**
     * <b>Description:</b> This keyword presses the key specified with <i>keycode</i>.<br>
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
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Press</td>
     *         <td>Enter</td>
     *     </tr>
     *     <tr>
     *         <td>Press</td>
     *         <td>Control</td>
     *     </tr>
     *     <tr>
     *         <td>Press</td>
     *         <td>A</td>
     *     </tr>
     *     <tr>
     *         <td>Press</td>
     *         <td>F10</td>
     *     </tr>
     * </table>
     *
     * For more information on keycodes see: https://docs.oracle.com/javafx/2/api/javafx/scene/input/KeyCode.html
     */
    @RobotKeyword
    @ArgumentNames({"keycode"})
    public void press(String keycode) {
        new FxRobot().press(KeyCode.getKeyCode(keycode));
    }

    /**
     * <b>Description:</b> This keyword erases text from a text field. The number of characters
     * erased is specified with <i>numberOfCharacters</i>.<br>
     *
     * @param numberOfCharacters
     * : The number of characters to be erased
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
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
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Erase Text</td>
     *         <td>12</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"numberOfCharacters"})
    public void eraseText(int numberOfCharacters) {
        new FxRobot().eraseText(numberOfCharacters);
    }

    /**
     * <b>Description:</b> This keyword writes text on the focused component.
     * It does not accept special characters (eg. a text field). <br>
     *
     * @param text
     * : The text to be written
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
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Write</td>
     *         <td>Hello world</td>
     *     </tr>
     *     <tr>
     *         <td>Write</td>
     *         <td>Hello world</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"text"})
    public void write(String text) {
        new FxRobot().write(text);
    }

    /**
     * <b>Description:</b> This keyword releases the key specified with <i>keycode</i>.<br>
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
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Release</td>
     *         <td>Enter</td>
     *     </tr>
     *     <tr>
     *         <td>Release</td>
     *         <td>Control</td>
     *     </tr>
     *     <tr>
     *         <td>Release</td>
     *         <td>A</td>
     *     </tr>
     *     <tr>
     *         <td>Release</td>
     *         <td>F10</td>
     *     </tr>
     * </table>
     *
     * For more information on keycodes see: https://docs.oracle.com/javafx/2/api/javafx/scene/input/KeyCode.html
     */
    @RobotKeyword
    @ArgumentNames({"keycode"})
    public void release(String keycode) {
        new FxRobot().release(KeyCode.getKeyCode(keycode));
    }

    /**
     * <b>Description:</b> This keyword types the keycode specified with <i>keycode</i>.<br>
     *
     * @param keycode
     * : The keycode to be typed
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
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Type</td>
     *         <td>A</td>
     *     </tr>
     *     <tr>
     *         <td>Type</td>
     *         <td>b</td>
     *     </tr>
     *     <tr>
     *         <td>Type</td>
     *         <td>DIGIT0</td>
     *     </tr>
     *     <tr>
     *         <td>Type</td>
     *         <td>F10</td>
     *     </tr>
     * </table>
     *
     * For more information on keycodes see: https://docs.oracle.com/javafx/2/api/javafx/scene/input/KeyCode.html
     */
    @RobotKeyword
    @ArgumentNames({"keycode"})
    public void type(String keycode) {
        new FxRobot().type(KeyCode.getKeyCode(keycode));
    }

    /**
     * <b>Description:</b> This keyword erases all the text on the the text area specified with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The text area to be cleared of text
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
     *         <td>Clear Text Area</td>
     *         <td>TextArea02</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void  clearTextArea(String identifier) {
        TextArea text = TestFxLibraryCommon.lookup(identifier);
        text.setText("");
    }

    /**
     * <b>Description:</b> This keyword erases all the text on the the text field specified with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The text field to be cleared of text
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
     *         <td>Clear Text Field</td>
     *         <td>TextField02</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void  clearTextField(String identifier) {
        TextField text = TestFxLibraryCommon.lookup(identifier);
        text.setText("");
    }

    /**
     * <b>Description:</b> This keyword validates text in a text field. Text field is specified with
     * <i>identifier</i> and text to validate is specified with <i>textToValidate</i>. If text in the text
     * field does not match <i>textToValidate</i> a TestFxLibraryNonFatalException in thrown.<br>
     *
     * @param identifier
     * : The identifier of the text field you want to verify.
     * @param textToValidate
     * : The text you want to validate
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
     *         <td>textToValidate</td>
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
     *         <td>Text Field Text Should Be</td>
     *         <td>TextField02</td>
     *         <td>Hello world</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "textToValidate"})
    public void textFieldTextShouldBe(String identifier, String textToValidate) {

        wait.waitUntilPageContains(identifier);

        try{

            TextField node = TestFxLibraryCommon.lookup(identifier);
            String nodeText = node.getText();

            if(!nodeText.equals(textToValidate)){
                throw new TestFxLibraryNonFatalException(DIFERENT_TEXT + " - " + nodeText);
            }

        } catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword validates the text in a text area. The text area is specified with
     * <i>identifier</i> and the text to validate is specified with <i>textToValidate</i>. If the text in the
     * text area does not match <i>textToValidate</i> a TestFxLibraryNonFatalException
     * is thrown.<br>
     *
     * @param identifier
     * : The identifier of the text area you want to verify.
     * @param textToValidate
     * : The text you want to validate
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
     *         <td>textToValidate</td>
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
     *         <td>Text Area Text Should Be</td>
     *         <td>TextArea02</td>
     *         <td>Hello world</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "textToValidate"})
    public void textAreaTextShouldBe(String identifier, String textToValidate) {

        wait.waitUntilPageContains(identifier);

        try{

            TextArea node = TestFxLibraryCommon.lookup(identifier);
            String nodeText = node.getText();

            if(!nodeText.equals(textToValidate)){
                throw new TestFxLibraryNonFatalException(DIFERENT_TEXT + " - " + nodeText);
            }

        } catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword validates text in a label. The label is specified with
     * <i>identifier</i> and text to validate is specified with <i>textToValidate</i>. If text
     * in the label does not match <i>textToValidate</i> a
     * TestFxLibraryNonFatalException in thrown.<br>
     *
     * @param identifier
     * : The identifier of the label you want to verify.
     * @param textToValidate
     * : The text you want to validate
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
     *         <td>textToValidate</td>
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
     *         <td>Label Text Should Be</td>
     *         <td>Label02</td>
     *         <td>Hello world</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "textToValidate"})
    public void labelTextShouldBe(String identifier, String textToValidate) {

        wait.waitUntilPageContains(identifier);

        try{

            Label node = TestFxLibraryCommon.lookup(identifier);
            String nodeText = node.getText();

            if(!nodeText.equals(textToValidate)){
                throw new TestFxLibraryNonFatalException(DIFERENT_TEXT + " - " + nodeText);
            }

        } catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword add text to the current text in the TextField. The TextField is specified with
     * <i>identifier</i> and text to add is specified with <i>textToValidate</i>.
     *
     * @param identifier
     * : The identifier of the label you want to verify.
     * @param text
     * : The text you want to add
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
     *         <td>textToValidate</td>
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
     *         <td>Text Field Append Text</td>
     *         <td>textField2</td>
     *         <td>Text to add</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "text"})
    public void textFieldAppendText(String identifier, String text) {

        wait.waitUntilPageContains(identifier);

        try{

            TextField node = TestFxLibraryCommon.lookup(identifier);
            String nodeText = node.getText();

            node.setText(nodeText + text);

        } catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword add text to the current text in the TextArea. The TextArea is specified with
     * <i>identifier</i> and text to add is specified with <i>textToValidate</i>.
     *
     * @param identifier
     * : The identifier of the label you want to verify.
     * @param text
     * : The text you want to add
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
     *         <td>textToValidate</td>
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
     *         <td>Text Area Append Text</td>
     *         <td>textArea2</td>
     *         <td>Text to add</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "text"})
    public void textAreaAppendText(String identifier, String text) {

        wait.waitUntilPageContains(identifier);

        try{

            TextArea node = TestFxLibraryCommon.lookup(identifier);
            String nodeText = node.getText();

            node.setText(nodeText + text);

        } catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
    }

}
