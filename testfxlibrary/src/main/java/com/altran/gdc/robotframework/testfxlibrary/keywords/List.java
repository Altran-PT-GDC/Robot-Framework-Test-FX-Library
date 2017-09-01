package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import javafx.scene.control.ListView;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testfx.api.FxRobot;

import java.util.ArrayList;

@RobotKeywords
public class List {

    @Autowired
    Misc misc;

    /**
     * <b>Description:</b> This keyword returns a list with the values in a ListView passed as parameter.<br>
     *
     * @param identifier
     * : The id of the ListView
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
    public java.util.List<String> getListItemsFromListView(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();

        java.util.List<String> list = new ArrayList<>();
        listView.getItems().forEach(item ->
            list.add((String) item)
        );

        return list;
    }

    /**
     * <b>Description:</b> This keyword selects an item in a ListView by text. The ListView is identified in the first
     * parameter and the second parameter is the text that defines the item to be selected.<br>
     *
     * @param identifier
     * : The id of the ListView
     * @param text
     * : The text to get the selected item
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
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
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "text"})
    public void selectFromListViewByText(String identifier, String text){
        TestFxLibraryValidation.validateArguments(identifier, text);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();

        new FxRobot().clickOn(listView);

        listView.getItems().forEach(item -> {
            if(((String)item).equals(text)){
                listView.getSelectionModel().select(item);
            }
        });
    }

    /**
     * <b>Description:</b> This keyword selects an item in a ListView by position. The ListView is identified in the
     * first parameter. The position that defines the item to be selected is defined in the second parameter,
     * a value of -1 clears the selection.<br>
     *
     * @param identifier
     * : The id of the ListView
     * @param position
     * : The position to get the selected item
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
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
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "position"})
    public void selectFromListViewByPosition(String identifier, int position){
        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateIndex(position);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();

        new FxRobot().clickOn(listView);

        listView.getSelectionModel().select(position);

    }

    /**
     * Returns the items that's currently selected in the list.
     *
     * @param identifier
     *      The id of the ListView
     *
     * @return
     *      The items selected
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public java.util.List<String> getSelectedItemsFromList(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();
        return listView.getSelectionModel().getSelectedItems();
    }

    /**
     * Count the number of items selected.
     *
     * @param identifier
     *      The id of the ListView
     *
     * @return
     *      The number of items selected
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public int getListItemCountFromList(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();
        return listView.getSelectionModel().getSelectedItems().size();
    }

    /**
     * Clear all itemns selected from ListView
     *
     * @param identifier
     *      The id of the ListView
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void clearSelectionFromList(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();

        listView.getSelectionModel().clearSelection();
    }

    /**
     * Select all itemns from the ListView
     *
     * @param identifier
     *      The id of the ListView
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void selectAllFromList(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();

        listView.getSelectionModel().selectAll();
    }

    /**
     * Clear selection
     * @param identifier
     * @param position
     */
    @RobotKeyword
    @ArgumentNames({"identifier","position"})
    public void unselectFromListByPosition(String identifier, int position){
        TestFxLibraryValidation.validateArguments(identifier);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();

        listView.getSelectionModel().clearSelection(position);
    }

    /**
     * Clear selection by specific text.
     *
     * @param identifier
     *      The id of the ListView
     *
     * @param text
     *      The text to clear the selection
     */
    @RobotKeyword
    @ArgumentNames({"identifier","text"})
    public void unselectFromListByText(String identifier, String text){
        TestFxLibraryValidation.validateArguments(identifier);

        misc.waitUntilPageContains(identifier);

        ListView listView = new FxRobot().lookup(identifier).query();

        for(int i=0 ; i< listView.getItems().size(); i++){
            if(((String)listView.getItems().get(i)).equals(text)){
                listView.getSelectionModel().clearSelection(i);
            }
        }
    }

}