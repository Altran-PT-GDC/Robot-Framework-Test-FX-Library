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
     * (Press a key)
     *
     * Presses the key passed as parameter.
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
     * (Erase Text from a text field)
     *
     * Erases text from a text field. The number of characters erased is
     * passed as parameter.
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
     * (Relese a key)
     *
     * Releases the key passed as parameter.
     *
     * @param keycode
     *          The keycode of the key to be released. eg. "Enter"
     */
    @RobotKeyword
    @ArgumentNames({"keycode"})
    public void release(String keycode) {
        new FxRobot().release(KeyCode.getKeyCode(keycode));
    }

    /**
     * (Type a keycode)
     *
     * Types the keycode passed as parameter.
     *
     * @param keycode
     *      The keycode to be typed
     */
    @RobotKeyword
    @ArgumentNames({"keycode"})
    public void type(String keycode) {
        new FxRobot().type(KeyCode.getKeyCode(keycode));
    }

    /**
     * (Erase All Text from a text area)
     *
     * Erases all the text on the the text area passed as parameter.
     *
     * @param identifier
     *      (The node were you're going to write)
     *
     *      The text area to be cleared of text
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void  clearTextArea(String identifier) {
        TextArea text = new FxRobot().lookup(identifier).query();
        text.setText("");
    }

    /**
     * (Erase All Text from a text field)
     *
     * Erases all the text on the text field passed as parameter.
     *
     * @param identifier
     *      (The node were you're going to write)
     *
     *      The text field to be cleared of text
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void  clearTextField(String identifier) {
        TextField text = new FxRobot().lookup(identifier).query();
        text.setText("");
    }

    /**
     * (Get Text from a text field)
     *
     * Gets text from the text field passed as parameter.
     *
     * @param identifier
     *      (The node were you're going to write)
     *
     *      The text field from which to get text
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
     * (Get Text from a text area)
     *
     * Gets text from the text area passed as parameter.
     *
     * @param identifier
     *      (The node were you're going to write)
     *
     *      The text field from which to get text
     *          The identifier of the TextArea you want to validate
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
     *          The text present in the text field
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
