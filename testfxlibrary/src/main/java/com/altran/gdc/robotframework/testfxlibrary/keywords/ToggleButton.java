package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

@RobotKeywords
public class ToggleButton {

    private static final String TOGGLE_EXCEPTION_BEGIN = "The specified ToggleButton ";
    @Autowired
    Wait wait;

    /**
     * <b>Description:</b> This keyword checks if the ToggleButton specified by an
     *  <i>identifier</i> is selected.
     *
     * @param identifier
     * : the id of the ToggleButton component
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
     *         <td>/#toggleButton</td>
     *         <td>ToggleButton Button Should Be Selected</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void togglebuttonButtonShouldBeSelected(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ToggleButton toggleButton = TestFxLibraryCommon.lookup(identifier);

        try {

            if(!toggleButton.isSelected()){
                throw new TestFxLibraryFatalException(TOGGLE_EXCEPTION_BEGIN + identifier +" is not selected.");
            }

        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword checks if the ToggleButton specified by an
     *  <i>identifier</i> is not selected.
     *
     * @param identifier
     * : the id of the ToggleButton component
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
     *         <td>/#toggleButton</td>
     *         <td>ToggleButton Button Should Not Be Selected</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void togglebuttonButtonShouldNotBeSelected(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ToggleButton toggleButton = TestFxLibraryCommon.lookup(identifier);

        try {

            if(toggleButton.isSelected()){
                throw new TestFxLibraryFatalException(TOGGLE_EXCEPTION_BEGIN + identifier +" is selected.");
            }

        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword checks if the ToggleButton specified by an
     *  <i>identifier</i> is Enabled.
     *
     * @param identifier
     * : the id of the ToggleButton component
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
     *         <td>/#toggleButton</td>
     *         <td>ToggleButton Should Be Enabled</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void toggleButtonShouldBeEnabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ToggleButton toggleButton = TestFxLibraryCommon.lookup(identifier);

        try {

            if(toggleButton.isDisabled()){
                throw new TestFxLibraryFatalException(TOGGLE_EXCEPTION_BEGIN + identifier +" is Disabled.");
            }

        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword checks if the ToggleButton specified by an
     *  <i>identifier</i> is Disable.
     *
     * @param identifier
     * : the id of the ToggleButton component
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
     *         <td>/#toggleButton</td>
     *         <td>ToggleButton Should Be Disabled</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void toggleButtonShouldBeDisabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ToggleButton toggleButton = TestFxLibraryCommon.lookup(identifier);

        try {

            if(!toggleButton.isDisabled()){
                throw new TestFxLibraryFatalException(TOGGLE_EXCEPTION_BEGIN + identifier +" is Enabled.");
            }

        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }
}
