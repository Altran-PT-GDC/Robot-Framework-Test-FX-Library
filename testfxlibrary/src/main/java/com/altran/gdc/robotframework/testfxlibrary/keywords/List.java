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
     * <b>Description:</b> This keyword returns a list with the values in a listview specified with
     * <i>identifier</i>.<br>
     *
     * @param identifier
     * : The id of the listview
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
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>@{list}=</td>
     *         <td>Get List Items From List View</td>
     *         <td>idListView01</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public java.util.List<String> getListItemsFromListView(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();

        java.util.List<String> list = new ArrayList<>();
        listView.getItems().forEach(item ->
            list.add((String) item)
        );

        return list;
    }

    /**
     * <b>Description:</b> This keyword selects an item in a listview by text. The listview is specified with
     * <i>identifier</i> and <i>text</i> is the text that specifies the item to be selected.<br>
     *
     * @param identifier
     * : The id of the listview
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
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Select From List View By Text</td>
     *         <td>idListView01</td>
     *         <td>hello world</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "text"})
    public void selectFromListViewByText(String identifier, String text){
        TestFxLibraryValidation.validateArguments(identifier, text);

        ListView listView = new FxRobot().lookup(identifier).query();

        new FxRobot().clickOn(listView);

        listView.getItems().forEach(item -> {
            if(((String)item).equals(text)){
                listView.getSelectionModel().select(item);
            }
        });
    }

    /**
     * <b>Description:</b> This keyword selects an item in a listview by position. The listview is
     * specified with <i>identifier</i>. The position that defines the item to be selected is
     * specified with <i>position</i>, a value of -1 clears the selection.<br>
     *
     * @param identifier
     * : The id of the listview
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
     *         <td>posiotion</td>
     *         <td>Yes</td>
     *         <td>int (values from 1 to max number of items)</td>
     *         <td>-1</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Select From List View By Position</td>
     *         <td>idListView01</td>
     *         <td>1</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "position"})
    public void selectFromListViewByPosition(String identifier, int position){
        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateIndex(position);

        ListView listView = new FxRobot().lookup(identifier).query();

        new FxRobot().clickOn(listView);

        listView.getSelectionModel().select(position);

    }

}