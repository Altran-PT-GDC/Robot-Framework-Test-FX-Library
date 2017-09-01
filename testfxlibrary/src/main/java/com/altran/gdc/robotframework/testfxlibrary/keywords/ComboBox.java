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
     * <b>Description:</b> This keyword returns a list of values from a combobox specified with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The id of the combobox.
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * @return
     *  The list of values
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
     * <b>Description:</b> This keyword selects an item from a combobox by text. The combobox is specified with
     * <i>identifier</i> and text is specified with <i>text</i><br>
     *
     * @param identifier
     * : The id of the combobox.
     * @param text
     * : The text to get the selected item
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>text</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
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
     * <b>Description:</b> This keyword selects an item from a combobox by position. The
     * combobox is specified with <i>identifier</i> and the position is specified with
     * <i>position</i>, a value of -1 clears the selection.<br>
     *
     * @param identifier
     * : The id of the combobox
     *
     * @param position
     * : The position to get the selected item
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>position</td>
     *         <td>Yes</td>
     *         <td>int (values from 1 to max number of items)</td>
     *         <td>-1</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "position"})
    public void selectFromComboBoxByPosition(String identifier, int position){
        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateIndex(position);

        javafx.scene.control.ComboBox comboBox = new FxRobot().lookup(identifier).query();

        new FxRobot().clickOn(comboBox);

        comboBox.getSelectionModel().select(position);

    }
}