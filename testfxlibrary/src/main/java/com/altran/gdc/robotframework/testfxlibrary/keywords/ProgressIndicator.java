package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

@RobotKeywords
public class ProgressIndicator {

    private static final String IDENTIFIER_NOT_EXIST = "The identifier %s not exists!";

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Double getProgressIndicatorValue(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        Double value;
        try {
            javafx.scene.control.ProgressIndicator progressIndicator = TestFxLibraryCommon.lookup(identifier);
            value = progressIndicator.getProgress();
        }catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }

        return value;
    }
}
