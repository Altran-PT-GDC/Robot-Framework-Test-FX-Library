package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.python.icu.text.StringCharacterIterator;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import testapp.JavafxExample;

@RobotKeywords
public class ChoiceBox {
    private static final String IDENTIFIER_NOT_EXIST = "The identifier %s not exists!";

    @Autowired
    Wait wait;

    /**
     * <b>Description:</b> This keyword returns a String with the selected item of a choicebox
     * specified by an <i>identifier</i>.
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
        javafx.scene.control.ChoiceBox cb= TestFxLibraryCommon.lookup(identifier);
        return cb.getSelectionModel().getSelectedItem().toString();
    }

    /**
     *
     * <b>Description:</b> This keyword check if a radio button passed by an <i>identifier</i> is selected.
     * Fails uf is not selected.
     *
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
     *         <td>radiobutton1</td>
     *         <td>Choicebox Item Should Be Selected</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "item"})
    public void choiceboxItemShouldBeSelected(String identifier, String item){
        TestFxLibraryValidation.validateArguments(identifier);
        Boolean flag=false;

        try{
            javafx.scene.control.ChoiceBox cb= TestFxLibraryCommon.lookup(identifier);
            if(cb.getSelectionModel().getSelectedItem().toString().equals(item)){
                flag = true;
            }
        }catch(Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }
        if(flag==false){
            throw new TestFxLibraryNonFatalException(String.format("The item is not selected!"));
        }

    }

    /**
     * @param identifier
     * @param item
     */

    @RobotKeyword
    @ArgumentNames({"identifier", "item"})
    public void choiceboxItemShouldNotBeSelected(String identifier, String item){
        TestFxLibraryValidation.validateArguments(identifier);
        Boolean flag=true;

        try{
            javafx.scene.control.ChoiceBox cb= TestFxLibraryCommon.lookup(identifier);
            if(cb.getSelectionModel().getSelectedItem().toString().equals(item)){
                flag = false;
            }
        }catch(Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }
        if(flag==false){
            throw new TestFxLibraryNonFatalException(String.format("The item is selected!"));
        }
    }
}
