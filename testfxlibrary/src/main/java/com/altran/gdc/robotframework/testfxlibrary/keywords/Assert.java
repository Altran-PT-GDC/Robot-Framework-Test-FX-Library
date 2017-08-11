/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altran.gdc.robotframework.testfxlibrary.keywords;

import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsIterableContainingInOrder;
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

    @RobotKeyword
    @ArgumentNames({"identifier","identifierToValidate"})
    public void verifyThatContains(String identifier, String identifierToValidate) {

        verifyThat(identifier, (Predicate) contains( identifierToValidate ));


    }

    @RobotKeyword
    @ArgumentNames({"identifier","textToValidate"})
    public void verifyThatHasText(String identifier, String textToValidate) {
        verifyThat( identifier, hasText(textToValidate));
    }

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void verifyThatIsEnabled(String identifier) {
        verifyThat( identifier, isEnabled() );

    }

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void verifyThatIsDisabled(String identifier) {
        verifyThat( identifier, isDisabled() );

    }

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void verifyThatIsVisible(String identifier) {
        verifyThat( identifier, isVisible() );

    }

    @RobotKeyword
    @ArgumentNames({"identifier","identifierToValidate"})
    public void verifyThatHasChild(String identifier, String identifierToValidate) {
        verifyThat( identifier, hasChild(identifierToValidate) );
    }
}
