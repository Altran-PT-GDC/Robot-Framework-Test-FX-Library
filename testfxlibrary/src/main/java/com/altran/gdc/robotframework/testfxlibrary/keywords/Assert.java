/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altran.gdc.robotframework.testfxlibrary.keywords;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

import java.util.function.Predicate;

import static org.hamcrest.Matchers.contains;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.*;
import static org.testfx.matcher.base.NodeMatchers.hasChild;

/**
 *
 * @author pcosta
 */
@RobotKeywords
public class Assert {

    /**
     * Verify if a node contains an element with specific identifier.
     *
     * @param identifier
     *          The node you want to verify
     * @param identifierToValidate
     *          The node you want to validate
     */
    @RobotKeyword
    @ArgumentNames({"identifier","identifierToValidate"})
    public void verifyThatContains(String identifier, String identifierToValidate) {
        verifyThat(identifier, (Predicate) contains( identifierToValidate ));
    }

    /**
     * Verify if a node contains a specific text.
     *
     * @param identifier
     *          The node you want to verify
     * @param textToValidate
     *          The text you want to validate
     */
    @RobotKeyword
    @ArgumentNames({"identifier","textToValidate"})
    public void verifyThatHasText(String identifier, String textToValidate) {
        verifyThat( identifier, hasText(textToValidate));
    }

    /**
     * Verify if an element is enabled.
     *
     * @param identifier
     *          The node you want to verify
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void verifyThatIsEnabled(String identifier) {
        verifyThat( identifier, isEnabled() );

    }

    /**
     * Verify if an element is disabled.
     *
     * @param identifier
     *          The node you want to verify
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void verifyThatIsDisabled(String identifier) {
        verifyThat( identifier, isDisabled() );

    }

    /**
     * Verify if an element is visible.
     *
     * @param identifier
     *          The node you want to verify
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void verifyThatIsVisible(String identifier) {
        verifyThat( identifier, isVisible() );

    }

    /**
     * Verify if a node has childs.
     *
     * @param identifier
     *          The node you want to verify
     * @param identifierToValidate
     *          The node you want to validate
     */
    @RobotKeyword
    @ArgumentNames({"identifier","identifierToValidate"})
    public void verifyThatHasChild(String identifier, String identifierToValidate) {
        verifyThat( identifier, hasChild(identifierToValidate) );
    }
}
