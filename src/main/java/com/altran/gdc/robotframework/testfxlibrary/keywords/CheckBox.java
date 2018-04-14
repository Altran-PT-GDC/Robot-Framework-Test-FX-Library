package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testfx.api.FxRobot;

@RobotKeywords
public class CheckBox {

    @Autowired
    private Wait wait;

    /**
     * <b>Description:</b> This keyword sets the state of a checkbox specified with <i>identifier</i>.
     * <i>booleanValue</i> is a boolean which defines the state<br>
     *
     * @param identifier
     * : The identifier of the checkbox
     * @param booleanValue
     * : Boolean value to set the checkbox selection
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
     *         <td>booleanValue</td>
     *         <td>Yes</td>
     *         <td>boolean</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     *<br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Set Check Box State</td>
     *         <td>idCheckBox05</td>
     *         <td>true</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier" , "booleanValue"})
    public void setCheckBoxState(String identifier, String booleanValue) {

        TestFxLibraryValidation.validateArguments(identifier, booleanValue);
        wait.waitUntilPageContains(identifier);

        try{
            javafx.scene.control.CheckBox check = TestFxLibraryCommon.lookup(identifier);
            check.setSelected(Boolean.valueOf(booleanValue));
        } catch (IllegalArgumentException | NullPointerException e) {
            throw  new TestFxLibraryFatalException(e);
        }

    }

    /**
     * <b>Description:</b> This keyword returns the boolean value state of a given
     * checkbox identified with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The identifier of the checkbox
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
     * Boolean value if the checkbox is selected (true) or not (false)
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>${boolean}=</td>
     *         <td>Get Check Box State</td>
     *         <td>idCheckBox05</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Boolean getCheckBoxState(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        try{
            javafx.scene.control.CheckBox check = TestFxLibraryCommon.lookup(identifier);
            return check.isSelected();
        } catch (IllegalArgumentException | NullPointerException e) {
            throw  new TestFxLibraryFatalException(e);
        }

    }

    /**
     * <b>Description:</b> This keyword tests if a given checkbox specified with <i>identifier</i> is enabled.<br>
     *
     * @param identifier
     * : The identifier of the checkbox
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
     *         <td>Check Box Should Be Enabled</td>
     *         <td>idCheckBox05</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void checkBoxShouldBeEnabled(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.CheckBox checkBox = new FxRobot().lookup(identifier).query();

        try{
            if(checkBox.isDisable()){
                throw new TestFxLibraryNonFatalException("CheckBox is disabled");
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw  new TestFxLibraryFatalException(e);
        }

    }

    /**
     * <b>Description:</b> This keyword tests if a given checkbox specified
     * with <i>identifier</i> is disabled<br>
     *
     * @param identifier
     * : The identifier of the checkbox
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
     *         <td>Check Box Should Be Disabled</td>
     *         <td>idCheckBox05</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void checkBoxShouldBeDisabled(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.CheckBox checkBox = new FxRobot().lookup(identifier).query();

        try{
            if(!checkBox.isDisable()){
                throw new TestFxLibraryNonFatalException("CheckBox is enabled");
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw  new TestFxLibraryFatalException(e);
        }

    }

    /**
     * <b>Description:</b> This keyword verifies if a checkbox specified with <i>identifier</i> is selected.
     * If this checkbox is not selected a TestFxLibraryFatalException is thrown.<br>
     *
     * @param identifier
     * : The identifier of the checkbox
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
     *         <td>Check Box Should Be Selected</td>
     *         <td>idCheckBox05</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void checkBoxShouldBeSelected(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.CheckBox checkBox = TestFxLibraryCommon.lookup(identifier);

        try{
            if(!checkBox.isSelected()){
                throw new TestFxLibraryNonFatalException("CheckBox is unselected!");
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw  new TestFxLibraryFatalException(e);
        }


    }

    /**
     * <b>Description:</b> This keyword verifies if a checkbox specified with <i>identifier</i> is not selected.
     * If this checkbox is selected a TestFxLibraryFatalException is thrown.<br>
     *
     * @param identifier
     * : The identifier of the checkbox
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
     *         <td>Check Box Should Not Be Selected</td>
     *         <td>idCheckBox05</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void checkBoxShouldNotBeSelected(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.CheckBox checkBox = TestFxLibraryCommon.lookup(identifier);

        try{
            if(checkBox.isSelected()){
                throw new TestFxLibraryNonFatalException("CheckBox is selected!");
            }
        } catch (IllegalArgumentException | NullPointerException e) {
            throw  new TestFxLibraryFatalException(e);
        }

    }
}
