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

    /**
     * Get values from ListView.
     *
     * @param identifier
     *      The id of the ListView
     *
     * @return
     *      The list of values
     */
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

    /**
     * Select item from ListView by text.
     *
     * @param identifier
     *      The id of the ListView.
     *
     * @param text
     *      The text to get the selected item
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "text"})
    public void selectFromListViewByText(String identifier, String text){
        TestFxLibraryValidation.validateArguments(identifier, text);

        ListView listView = new FxRobot().lookup(identifier).query();

        new FxRobot().clickOn(listView);

        listView.getItems().forEach((item) -> {
            if(((String)item).equals(text)){
                listView.getSelectionModel().select(item);
            }
        });
    }

    /**
     * Select item from ListView by position.
     *
     * @param identifier
     *      The id of the ListView
     *
     * @param position
     *      The position to get the selected item
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "text"})
    public void selectFromListViewByPosition(String identifier, int position){
        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateIndex(position);

        ListView listView = new FxRobot().lookup(identifier).query();

        new FxRobot().clickOn(listView);

        listView.getSelectionModel().select(position);

    }

}