package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testfx.api.FxRobot;

import java.util.ArrayList;
import java.util.List;

@RobotKeywords
public class ComboBox {

    @Autowired
    Misc misc;

    /**
     * <b>Description:</b>This keyword returns a list of values from a ComboBox identified by the parameter.<br>
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

        misc.waitUntilPageContains(identifier);

        javafx.scene.control.ComboBox comboBox = new FxRobot().lookup(identifier).query();

        List<String> list = new ArrayList<>();
        comboBox.getItems().forEach(item ->
            list.add((String) item)
        );

        return list;
    }

    /**
     * <b>Description:</b>This keyword selects an item from a ComboBox by text. The ComboBox is identified by the
     * first parameter and the text is defined in the second parameter<br>
     *
     * @param identifier
     * : The id of the ComboBox.
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

        misc.waitUntilPageContains(identifier);

        javafx.scene.control.ComboBox comboBox = new FxRobot().lookup(identifier).query();

        new FxRobot().clickOn(comboBox);

        comboBox.getItems().forEach(item -> {
            if(((String)item).equals(text)){
                comboBox.getSelectionModel().select(item);
            }
        });
    }

    /**
     * <b>Description:</b>This keyword selects an item from a ComboBox by position. The ComboBox is identified by the
     * first parameter and the position is defined in the second parameter, a value of -1 clears the selection.<br>
     *
     * @param identifier
     * : The id of the ComboBox
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

        misc.waitUntilPageContains(identifier);

        javafx.scene.control.ComboBox comboBox = new FxRobot().lookup(identifier).query();

        new FxRobot().clickOn(comboBox);

        comboBox.getSelectionModel().select(position);

    }

    /**
     * Return the selected item from ComboBox.
     *
     * @param identifier
     *      The id of the ComboBox
     *
     * @return
     *      The text of the selected item
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public String getSelectedItemFromCombox(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        misc.waitUntilPageContains(identifier);

        javafx.scene.control.ComboBox comboBox = new FxRobot().lookup(identifier).query();

        return (String)comboBox.getSelectionModel().getSelectedItem();

    }
}