/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altran.gdc.robotframework.testfxlibrary.keywords;

import javafx.scene.input.KeyCode;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testfx.api.FxRobot;

/**
 *
 * @author pcosta
 */
@RobotKeywords
public class Keyboard {

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
}
