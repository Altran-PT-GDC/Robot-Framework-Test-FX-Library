package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

@RobotKeywords
public class FileChooser {

    @Autowired
    Wait wait;

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void cancelFileChooser(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);



        javafx.stage.FileChooser chooser = null;
        chooser.setTitle("Chooser");

    }
}
