package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import javafx.scene.Node;
import javafx.scene.control.Control;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToggleGroup;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testfx.api.FxRobot;


@RobotKeywords
public class RadioButton {
    private static final String IDENTIFIER_NOT_EXIST = "The identifier %s not exists!";

    @Autowired
    Wait wait;
    @Autowired
    Mouse mouse;

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void radioButtonShouldBeSelected(String identifier) throws TestFxLibraryNonFatalException {
        TestFxLibraryValidation.validateArguments(identifier);
        Boolean flag=false;

        try {
            javafx.scene.control.RadioButton radiobutton = TestFxLibraryCommon.lookup(identifier);
            if(radiobutton.isSelected())
                flag=true;

        }catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }

        if(!flag){
            throw new TestFxLibraryNonFatalException(String.format("The radio button is not selected!"));
        }

    }

}
