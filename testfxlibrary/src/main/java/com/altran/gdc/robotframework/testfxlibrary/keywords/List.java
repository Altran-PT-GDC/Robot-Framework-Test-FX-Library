package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import javafx.scene.control.ListView;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testfx.api.FxRobot;

import java.util.ArrayList;

@RobotKeywords
public class List {

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public java.util.List<String> getListItemsFromListView(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();

        java.util.List<String> list = new ArrayList<>();
        listView.getItems().forEach((item) -> {
            list.add((String) item);
        });

        return list;
    }

}