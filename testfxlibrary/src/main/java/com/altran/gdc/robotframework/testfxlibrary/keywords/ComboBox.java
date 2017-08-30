package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testfx.api.FxRobot;

import java.util.ArrayList;
import java.util.List;

@RobotKeywords
public class ComboBox {

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public List<String> getListItemsFromComboBox(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        javafx.scene.control.ComboBox comboBox = new FxRobot().lookup(identifier).query();

        List<String> list = new ArrayList<>();
        comboBox.getItems().forEach((item) -> {
            list.add((String) item);
        });

        return list;
    }

    public void selectFromComboBox(String identifier, String text, int position){
        TestFxLibraryValidation.validateArguments(identifier, text);
        TestFxLibraryValidation.validateIndex(position);


    }

}