package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;


@RobotKeywords
public class RadioButton {
    private static final String IDENTIFIER_NOT_EXIST = "The identifier does not exist!";

    @Autowired
    private Wait wait;

    /**
     *
     * <b>Description:</b> This keyword check if a radio button passed by an <i>identifier</i> is selected.
     * Fails uf is not selected.
     * <br><br>
     * @param identifier
     * : The identifier if the radiobutton
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
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>radiobutton1</td>
     *         <td>Radio Button Should Be Selected</td>
     *     </tr>
     * </table>
     *
     */

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void radioButtonShouldBeSelected(String identifier) {
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);
        Boolean flag=false;

        try {
            javafx.scene.control.RadioButton rb=TestFxLibraryCommon.lookup(identifier);
            if(rb.isSelected()) {
                flag = true;
            }
        }catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }

        if(!flag){
            throw new TestFxLibraryNonFatalException(String.format("The radio button is not selected!"));
        }

    }

    /**
     ** <b>Description:</b> This keyword check if a radio button passed by an <i>identifier</i> is not selected.
     * Fails uf is selected.
     * <br><br>
     * @param identifier
     * : The identifier if the radiobutton
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
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>radiobutton1</td>
     *         <td>Radio Button Should Not Be Selected</td>
     *     </tr>
     * </table>
     *
     */

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void radioButtonShouldNotBeSelected(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);
        Boolean flag=true;

        try{
            javafx.scene.control.RadioButton rb=TestFxLibraryCommon.lookup(identifier);
            if(rb.isSelected()){
                flag = false;
            }
        }catch(Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }
        if(!flag){
            throw new TestFxLibraryNonFatalException(String.format("This radio button is selected"));
        }
    }

    /**
     *<b>Description:</b> This keyword check if a radio button passed by an <i>identifier</i> is enabled.
     * Fails if radio button is disable.
     * <br><br>
     * @param identifier
     * : The identifier if the radiobutton
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
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>radiobutton1</td>
     *         <td>Radio Button Should Be Enable</td>
     *     </tr>
     * </table>
     *
     */

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void radioButtonShouldBeEnabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);
        Boolean flag=true;
        try{
            javafx.scene.control.RadioButton rb=TestFxLibraryCommon.lookup(identifier);
           if(rb.isDisable()){
               flag=false;
           }
        }catch(Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }

        if(!flag){
            throw new TestFxLibraryNonFatalException(String.format("This radio button is disabled"));
        }

    }

    /**
     *<b>Description:</b> This keyword check if a radio button passed by an <i>identifier</i> is disable.
     * Fails if radio button is enable.
     * <br><br>
     * @param identifier
     * : The identifier if the radiobutton
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
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>radiobutton1</td>
     *         <td>Radio Button Should Be Disabled</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void radioButtonShouldBeDisabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);
        Boolean flag=false;
        try{
            javafx.scene.control.RadioButton rb=TestFxLibraryCommon.lookup(identifier);
            if (rb.isDisable()) {
                flag = true;
            }
        }catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }

        if(!flag){
            throw new TestFxLibraryNonFatalException(String.format("This radio button is enabled"));
        }
    }

    /**
     * <b>Description:</b> This keyword get the name of the selected radio button toggle group passed by an <i>identifier</i> of a
     * contained Radio Button.
     * <br><br>
     * @param identifier
     * : The identifier if the radiobutton
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
     * The selected radio button
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>radiobutton1</td>
     *         <td>Get Selected Radio Button</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public String getSelectedRadioButton(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);
        try{
            javafx.scene.control.RadioButton rb = TestFxLibraryCommon.lookup(identifier);
            javafx.scene.control.RadioButton selectedToggle = (javafx.scene.control.RadioButton) rb.getToggleGroup().getSelectedToggle();

            return selectedToggle.getText();
        }catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }
    }
}
