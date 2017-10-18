package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import javafx.collections.ObservableList;
import javafx.scene.control.TabPane;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;


@RobotKeywords
public class Tab {

    @Autowired
    private Wait wait;

    /**
     * <b>Description:</b> This keyword returns a list of tabs inside a tab pane specified by <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @return tabList
     * : The list of tabs inside the tabpane
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
     *         <td>@{tabList}=</td>
     *         <td>Get Tab Pane Tabs</td>
     *         <td>\#tabpane</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public String[] getTabPaneTabs(String identifier) {
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        TabPane tabPane = TestFxLibraryCommon.lookup(identifier);
        ObservableList<javafx.scene.control.Tab> tabs = tabPane.getTabs();
        String[] items = new String[tabs.size()];
        for (int i=0; i<tabs.size(); i++){
            items[i] = tabs.get(i).getText();
        }
        return items;
    }

    /**
     * <b>Description:</b> This keyword selects a tab specified with <i>text</i> inside a tab pane specified by <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @param text
     * : The tab text
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
     *         <td>Select Tab By Text</td>
     *         <td>\#tabPane</td>
     *         <td>Tab One</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "text"})
    public void selectTabByText (String identifier, String text){
        TestFxLibraryValidation.validateArguments(identifier, text);
        wait.waitUntilPageContains(identifier);

        TabPane tabPane = TestFxLibraryCommon.lookup(identifier);
        ObservableList<javafx.scene.control.Tab> tabs = tabPane.getTabs();
        Boolean tabExist = false;
        for (int i=0; i<tabs.size(); i++){
            if (tabs.get(i).getText().equals(text)){
                tabPane.getSelectionModel().select(i);
                tabExist = true;
                break;
            }
        }
        if (!tabExist){
            throw new TestFxLibraryFatalException("The tab text you specified does not exist.");
        }
    }

    /**
     * <b>Description:</b> This keyword returns the selected tab text inside a tab pane specified by <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @return tab
     * : The selected tab text
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
     *         <td>${tabText}=</td>
     *         <td>Get Tab Text</td>
     *         <td>\#tab</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public String getSelectedTab(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        TabPane tabPane = TestFxLibraryCommon.lookup(identifier);
        return tabPane.getSelectionModel().getSelectedItem().getText();
    }

    /**
     * <b>Description:</b> This keyword fails if a tab specified by <i>tab</i> is not selected in a tab pane specified by <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @param tab
     * : The text of the tab
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
     *         <td>tab</td>
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
     *         <td>Tab Item Should Be Selected</td>
     *         <td>\#tabPane</td>
     *         <td>Tab One</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "tab"})
    public void tabItemShouldBeSelected(String identifier, String tab){
        TestFxLibraryValidation.validateArguments(identifier, tab);
        wait.waitUntilPageContains(identifier);

        TabPane tabPane = TestFxLibraryCommon.lookup(identifier);
        if (!tabPane.getSelectionModel().getSelectedItem().getText().equals(tab)){
            throw new TestFxLibraryFatalException("The tab " + tab + " is not selected.");
        }
    }

    /**
     * <b>Description:</b> This keyword fails if a tab specified by <i>tab</i> is selected in a tab pane specified by <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @param tab
     * : The text of the tab
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
     *         <td>tab</td>
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
     *         <td>Tab Item Should Not Be Selected</td>
     *         <td>\#tabPane</td>
     *         <td>Tab One</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "tab"})
    public void tabItemShouldNotBeSelected(String identifier, String tab){
        TestFxLibraryValidation.validateArguments(identifier, tab);
        wait.waitUntilPageContains(identifier);

        TabPane tabPane = TestFxLibraryCommon.lookup(identifier);
        if (tabPane.getSelectionModel().getSelectedItem().getText().equals(tab)){
            throw new TestFxLibraryFatalException("The tab " + tab + " is selected.");
        }
    }

    /**
     * <b>Description:</b> This keyword fails if a tab specified by <i>tab<i> is not enabled in a tab pane specified by <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @param tab
     * : The text of the tab
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
     *         <td>tab</td>
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
     *         <td>Tab Should Be Enabled</td>
     *         <td>\#tabPane</td>
     *         <td>Tab One</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "tab"})
    public void tabShouldBeEnabled(String identifier, String tab){
        TestFxLibraryValidation.validateArguments(identifier, tab);
        wait.waitUntilPageContains(identifier);

        TabPane tabPane = TestFxLibraryCommon.lookup(identifier);
        ObservableList<javafx.scene.control.Tab> tabs = tabPane.getTabs();
        Boolean tabEnabled = false;
        for (int i=0; i<tabs.size(); i++){
            if (tabs.get(i).getText().equals(tab)){
                if (!tabs.get(i).isDisable()){
                    tabEnabled = true;
                    break;
                }
            }
        }
        if (!tabEnabled){
            throw new TestFxLibraryFatalException(tab + " is not enabled.");
        }
    }

    /**
     * <b>Description:</b> This keyword fails if a tab specified by <i>tab<i> is enabled in a tab pane specified by <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @param tab
     * : The text of the tab
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
     *         <td>tab</td>
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
     *         <td>Tab Should Be Disabled</td>
     *         <td>\#tabPane</td>
     *         <td>Tab One</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "tab"})
    public void tabShouldBeDisabled(String identifier, String tab){
        TestFxLibraryValidation.validateArguments(identifier, tab);
        wait.waitUntilPageContains(identifier);

        TabPane tabPane = TestFxLibraryCommon.lookup(identifier);
        ObservableList<javafx.scene.control.Tab> tabs = tabPane.getTabs();
        Boolean tabDisabled = false;
        for (int i=0; i<tabs.size(); i++){
            if (tabs.get(i).getText().equals(tab)){
                if (tabs.get(i).isDisable()){
                    tabDisabled = true;
                    break;
                }
            }
        }
        if (!tabDisabled){
            throw new TestFxLibraryFatalException(tab + " is enabled.");
        }
    }
}
