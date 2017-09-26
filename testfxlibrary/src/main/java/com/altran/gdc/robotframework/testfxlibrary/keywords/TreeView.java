package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
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
     * <b>Description:</b> This keyword unselects a Tree Item on the specified index <i>index</i> from a Tree View <i>identifier</i>.<br>
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
}
