package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;


@RobotKeywords
public class ToolBar {

    @Autowired
    private Wait wait;

    /**
     * <b>Description:</b> This keyword returns the items of a toolbar specified by <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
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
     * @return
     * The list of items inside the toolbar
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>@{listItems}=</td>
     *         <td>Get Tool Bar Items</td>
     *         <td>\#toolbar</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public String[] getToolBarItems (String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ToolBar toolBar = TestFxLibraryCommon.lookup(identifier);
        ObservableList<Node> items = toolBar.getItems();
        String[] itemList = new String[items.size()];
        for (int i=0; i<items.size(); i++){
            itemList[i] = items.get(i).toString();
        }
        return itemList;
    }

    /**
     * <b>Description:</b> This keyword fails if a toolbar specified by <i>identifier</i> is not enabled.
     *
     * @param identifier
     * : The id of the component
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
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Tool Bar Should Be Enabled</td>
     *         <td>\#toolbar</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void toolBarShouldBeEnabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ToolBar toolBar = TestFxLibraryCommon.lookup(identifier);
        try {
            if(toolBar.isDisabled()){
                throw new TestFxLibraryFatalException("ToolBar is disabled.");
            }
        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword fails if a toolbar specified by <i>identifier</i> is enabled.
     *
     * @param identifier
     * : The id of the component
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
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Tool Bar Should Be Disabled</td>
     *         <td>\#toolbar</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void toolBarShouldBeDisabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ToolBar toolBar = TestFxLibraryCommon.lookup(identifier);
        try {
            if(!toolBar.isDisabled()){
                throw new TestFxLibraryFatalException("ToolBar is enabled.");
            }
        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }
}
