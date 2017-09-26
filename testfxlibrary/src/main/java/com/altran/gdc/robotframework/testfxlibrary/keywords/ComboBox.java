package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
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

    private boolean verifyComboBoxText = false;

    @Autowired
    private Wait wait;

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
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>@{list}=</td>
     *         <td>Get List Items From Combo Box</td>
     *         <td>idComboBox01</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public List<Object> getListItemsFromComboBox(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        wait.waitUntilPageContains(identifier);

        try{
        javafx.scene.control.ComboBox comboBox = TestFxLibraryCommon.lookup(identifier);

        List<Object> list = new ArrayList<>();
        comboBox.getItems().forEach(item ->
            list.add(item)
        );
        return list;
        } catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
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
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Select From Combo Box By Text</td>
     *         <td>idComboBox01</td>
     *         <td>hello world</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "text"})
    public void selectFromComboBoxByText(String identifier, String text){
        TestFxLibraryValidation.validateArguments(identifier, text);

        wait.waitUntilPageContains(identifier);

        try{

        javafx.scene.control.ComboBox comboBox = TestFxLibraryCommon.lookup(identifier);

        new FxRobot().clickOn(comboBox);

        comboBox.getItems().forEach(item -> {
            if((item).equals(text)){
                comboBox.getSelectionModel().select(item);
                comboBox.setValue(item);

                verifyComboBoxText = true;
            }
        });
        if (!verifyComboBoxText){
            throw new TestFxLibraryFatalException("Item does not match with " + text);
        }

        } catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword selects the first item from a combobox. The combobox is specified with
     * <i>identifier</i> and text is specified with <i>text</i><br>
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
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Select First From Combo Box</td>
     *         <td>idComboBox01</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void selectFristFromComboBox(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ComboBox comboBox = TestFxLibraryCommon.lookup(identifier);

        new FxRobot().clickOn(comboBox);
        comboBox.getSelectionModel().selectFirst();
    }

    /**
     * <b>Description:</b> This keyword selects an item from a combobox by position. The
     * combobox is specified with <i>identifier</i> and the position is specified with
     * <i>position</i>, which can take values from 0 to item count minus 1; a value
     * of -1 clears the selection.<br>
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
     *         <td>int (values from 0 to item count - 1)</td>
     *         <td>-1</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Select From Combo Box By Position</td>
     *         <td>idComboBox01</td>
     *         <td>1</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "position"})
    public void selectFromComboBoxByPosition(String identifier, int position){
        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateIndex(position);

        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ComboBox comboBox = TestFxLibraryCommon.lookup(identifier);

        new FxRobot().clickOn(comboBox);

        comboBox.getSelectionModel().select(position);
        comboBox.setValue(comboBox.getItems().get(position));

    }

    /**
     * <b>Description:</b> This keyword returns a selected item from a combobox. The
     * combobox is specified with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The id of the ComboBox
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
     *  The text of the selected item
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>${item}=</td>
     *         <td>Get Selected Item From Combo Box</td>
     *         <td>idComboBox23</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public String getSelectedItemFromCombox(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ComboBox comboBox = TestFxLibraryCommon.lookup(identifier);

        return (String)comboBox.getSelectionModel().getSelectedItem();

    }
}