package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryConstants;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.testfx.api.FxRobot;
import org.testfx.service.support.WaitUntilSupport;

import static com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation.validateArguments;

public class TemplateKW {

    /**
     * template kw.
     *
     * @param identifier
     *            The identifier of the node
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void templateKw(String identifier) {
        /* validate arguments */
        validateArguments(identifier);

        /* wait */
        try {
            new WaitUntilSupport().wait(TestFxLibraryConstants.TIMEOUT);
        } catch (InterruptedException e) {

        }

        /* action */
        new FxRobot().clickOn(identifier);
    }
}
