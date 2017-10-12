package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.python.icu.text.StringCharacterIterator;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import testapp.JavafxExample;

@RobotKeywords
public class ChoiceBox {
    @Autowired
    Wait wait;

    /**
     * @param identifier
     * @return
     */

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public String getSelectedChoiceboxItem(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        javafx.scene.control.ChoiceBox cb= TestFxLibraryCommon.lookup(identifier);

        return cb.getSelectionModel().getSelectedItem().toString();
    }
}
