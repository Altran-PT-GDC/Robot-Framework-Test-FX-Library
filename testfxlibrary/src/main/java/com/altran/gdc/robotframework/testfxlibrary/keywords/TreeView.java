package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

@RobotKeywords
public class TreeView {

    @Autowired
    private Wait wait;

    /**
     * <b>Description:</b> This keyword selects a Tree Item on the specified index <i>index</i> from a Tree View <i>identifier</i>.<br>
     *
     * @param identifier
     * : The id of the Tree View.
     *
     * @param index
     * : The index of the element
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
     *      <tr>
     *         <td>index</td>
     *         <td>Yes</td>
     *         <td>int</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>treeView</td>
     *         <td>Select Tree Node By Index</td>
     *         <td>2</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "index"})
    public void selectTreeNodeByIndex(String identifier, int index) {
        TestFxLibraryValidation.validateArguments(identifier);

        wait.waitUntilPageContains(identifier);

        try{

            javafx.scene.control.TreeView treeView = TestFxLibraryCommon.lookup(identifier);

            treeView.getSelectionModel().select(index);

        }catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword selects all the Tree Items from a Tree View <i>identifier</i>.<br>
     *
     * @param identifier
     * : The id of the Tree View.
     *
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
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>treeView</td>
     *         <td>Clear Tree Selection</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void clearTreeSelection(String identifier) {
        TestFxLibraryValidation.validateArguments(identifier);

        wait.waitUntilPageContains(identifier);

        try{

            javafx.scene.control.TreeView treeView = TestFxLibraryCommon.lookup(identifier);

            treeView.getSelectionModel().clearSelection();

        }catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword unselects a Tree Item on the specified index <i>index</i> from a Tree View <i>identifier</i>.<br>
     *
     * @param identifier
     * : The id of the Tree View.
     *
     * @param index
     * : The index of the element
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
     *      <tr>
     *         <td>index</td>
     *         <td>Yes</td>
     *         <td>int</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>treeView</td>
     *         <td>Select Tree Node By Index</td>
     *         <td>2</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "index"})
    public void unselectTreeNodeByIndex(String identifier, int index) {
        TestFxLibraryValidation.validateArguments(identifier);

        wait.waitUntilPageContains(identifier);

        try{

            javafx.scene.control.TreeView treeView = TestFxLibraryCommon.lookup(identifier);

            treeView.getSelectionModel().clearSelection(index);

        }catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword collapses the Tree View specified by <i>identifier</i>.<br>
     *
     * @param identifier
     * : The id of the Tree View.
     *
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
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>treeView</td>
     *         <td>Collapse Tree Node</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void collapseTreeNode(String identifier) {
        TestFxLibraryValidation.validateArguments(identifier);

        wait.waitUntilPageContains(identifier);

        try{

            javafx.scene.control.TreeView treeView = TestFxLibraryCommon.lookup(identifier);

            treeView.getRoot().setExpanded(false);

        }catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword returns the selected items from a Tree View <i>identifier</i>.<br>
     *
     * @param identifier
     * : The TreeView locator
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
     * The selected tree view item
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Get Selected Treeview Nodes</td>
     *         <td>\#treeView</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public String[] getSelectedTreeviewNodes(String identifier) {
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        try {

            javafx.scene.control.TreeView treeView = TestFxLibraryCommon.lookup(identifier);
            ObservableList selectedItems = treeView.getSelectionModel().getSelectedItems();
            String[] items = new String[selectedItems.size()];
            for(int i=0; i < selectedItems.size(); i++){
                TreeItem treeItem = (TreeItem) selectedItems.get(i);
                items[i] = treeItem.getValue().toString();
            }
            return items;

        } catch (IllegalArgumentException | NullPointerException e) {
            throw new TestFxLibraryFatalException(e);
        }

    }

    /**
     * <b>Description:</b> This keyword seletcs a Tree Item with the specified text <i>text</i> from a Tree View <i>identifier</i>.<br>
     *
     * @param identifier
     * : the TreeView locator
     * @param text
     * : the text of the node to be selected
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
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Select TreeView Node By Text</td>
     *         <td>\#treeView</td>
     *         <td>Item Name</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "text"})
    public void selectTreeViewNodeByText (String identifier, String text){
        TestFxLibraryValidation.validateArguments(identifier, text);
        wait.waitUntilPageContains(identifier);

        try {
            javafx.scene.control.TreeView treeView = TestFxLibraryCommon.lookup(identifier);
            int count = treeView.getExpandedItemCount();
            for (int i=0; i<count; i++){
                TreeItem treeItem =  treeView.getTreeItem(i);
                String itemName = (String) treeItem.getValue();
                if (itemName.equals(text)){
                    treeView.getSelectionModel().select(i);
                }
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword check if TreeView specified by an <i>identifier</i> is enabled.<br>
     *
     * @param identifier
     * : the id of the Hyperlink component
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
     *         <td>TreeView Should Be Enabled</td>
     *         <td>/#treeView</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void treeViewShouldBeEnabled (String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);
        javafx.scene.control.TreeView treeView = TestFxLibraryCommon.lookup(identifier);

        try {
            if(treeView.isDisabled()){
                throw new TestFxLibraryFatalException("TreeView is disabled.");
            }
        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword check if TreeView specified by an <i>identifier</i> is disabled.<br>
     *
     * @param identifier
     * : the id of the Hyperlink component
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
     *         <td>TreeView Should Be Disabled</td>
     *         <td>/#treeView</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void treeViewShouldBeDisabled (String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);
        javafx.scene.control.TreeView treeView = TestFxLibraryCommon.lookup(identifier);

        try {
            if(!treeView.isDisabled()){
                throw new TestFxLibraryFatalException("TreeView is enabled.");
            }
        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }
}
