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


    /**
     * Get values from ComboBox.
     *
     * @param identifier
     *      The id of the combobox.
     *
     * @return
     *      The list of values
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public List<String> getListItemsFromComboBox(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        javafx.scene.control.ComboBox comboBox = new FxRobot().lookup(identifier).query();

        List<String> list = new ArrayList<>();
        comboBox.getItems().forEach(item ->
            list.add((String) item)
        );

        return list;
    }

    /**
     * Select item from ComboBox by text.
     * @param identifier
     *      The id of the ComboBox.
     *
     * @param text
     *      The text to get the selected item
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "text"})
    public void selectFromComboBoxByText(String identifier, String text){
        TestFxLibraryValidation.validateArguments(identifier, text);

        javafx.scene.control.ComboBox comboBox = new FxRobot().lookup(identifier).query();

        new FxRobot().clickOn(comboBox);

        comboBox.getItems().forEach(item -> {
            if(((String)item).equals(text)){
                comboBox.getSelectionModel().select(item);
            }
        });
    }

    /**
     * Select item from ComboBox by position.
     *
     * @param identifier
     *      The id of the ComboBox
     *
     * @param position
     *      The position to get the selected item
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "text"})
    public void selectFromComboBoxByPosition(String identifier, int position){
        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateIndex(position);

        javafx.scene.control.ComboBox comboBox = new FxRobot().lookup(identifier).query();

        new FxRobot().clickOn(comboBox);

        comboBox.getSelectionModel().select(position);

    }
}