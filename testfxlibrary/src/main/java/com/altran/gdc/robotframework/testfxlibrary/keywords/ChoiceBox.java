package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

@RobotKeywords
public class ChoiceBox {
    private static final String IDENTIFIER_NOT_EXIST = "The identifier %s not exists!";

    @Autowired
    Wait wait;

    /**
     * <b>Description:</b> This keyword returns a String with the selected item of a choicebox
     * specified by an <i>identifier</i>.
     * <br><br>
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
     *
     * @return
     *  The slected item in the choicebox
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>.button</td>
     *         <td>Get Selected Item In ChoiceBox</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public String getSelectedChoiceboxItem(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);
        javafx.scene.control.ChoiceBox cb= TestFxLibraryCommon.lookup(identifier);
        return cb.getSelectionModel().getSelectedItem().toString();
    }

    /**
     *
     * <b>Description:</b> This keyword fails if a choicebox item given by <i>item</i> is not selected.
     * <br><br>
     * @param identifier
     * : The id of the component
     * @param item
     * : The text that you want to compare <b>//</b>.
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
     *         <td>Choicebox Item Should Be Selected</td>
     *         <td>\#choicebox</td>
     *         <td>Text To Verify</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "item"})
    public void choiceboxItemShouldBeSelected(String identifier, String item){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);
        Boolean flag=false;

        try{
            javafx.scene.control.ChoiceBox cb= TestFxLibraryCommon.lookup(identifier);
            if(cb.getSelectionModel().getSelectedItem().toString().equals(item)){
                flag = true;
            }
        }catch(Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }
        if(!flag){
            throw new TestFxLibraryNonFatalException(String.format("The item is not selected!"));
        }

    }

    /**
     * <b>Description:</b> This keyword fails if a choicebox item given by <i>item</i> is selected.
     * <br><br>
     * @param identifier
     * : The id of the component
     * @param item
     * : The text that you want to compare <b>//</b>.
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
     *         <td>Choicebox Item Should Not Be Selected</td>
     *         <td>\#choicebox</td>
     *         <td>Text To Verify</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "item"})
    public void choiceboxItemShouldNotBeSelected(String identifier, String item){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);
        Boolean flag=true;

        try{
            javafx.scene.control.ChoiceBox cb= TestFxLibraryCommon.lookup(identifier);
            if(cb.getSelectionModel().getSelectedItem().toString().equals(item)){
                flag = false;
            }
        }catch(Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }
        if(!flag){
            throw new TestFxLibraryNonFatalException(String.format("The item is selected!"));
        }
    }

    /**
     * <b>Description:</b> This keyword fails if a choicebox given by <i>identifier</i> is disabled.
     * <br><br>
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
     *         <td>Choicebox Item Should Be Enabled</td>
     *         <td>\#choicebox</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void choiceboxShouldBeEnabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ChoiceBox choiceBox = TestFxLibraryCommon.lookup(identifier);
        try {
            if(choiceBox.isDisabled()){
                throw new TestFxLibraryFatalException("Choicebox is disabled.");
            }
        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword fails if a choicebox given by <i>identifier</i> is enabled.
     * <br><br>
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
     *         <td>Choicebox Item Should Be Disabled</td>
     *         <td>\#choicebox</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void choiceboxShouldBeDisabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ChoiceBox choiceBox = TestFxLibraryCommon.lookup(identifier);
        try {
            if(!choiceBox.isDisabled()){
                throw new TestFxLibraryFatalException("Choicebox is enabled.");
            }
        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }
}
