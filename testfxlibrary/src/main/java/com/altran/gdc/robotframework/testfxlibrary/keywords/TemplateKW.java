package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryConstants;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.testfx.api.FxRobot;
import org.testfx.service.support.WaitUntilSupport;

import java.io.IOException;

import static com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation.validateArguments;

public class TemplateKW {

    @Autowired
    Misc misc;
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
        misc.defaultWait(TestFxLibraryConstants.TIMEOUT);

        /* action */
        new FxRobot().clickOn(identifier);
    }
}
