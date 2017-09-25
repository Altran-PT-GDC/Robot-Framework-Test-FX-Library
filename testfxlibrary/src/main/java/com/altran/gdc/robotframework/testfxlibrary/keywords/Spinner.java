package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.python.jline.internal.Log;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;


@RobotKeywords
public class Spinner {

    @Autowired
    private Wait wait;

    /**
     * <b>Description:</b> This keyword returns the value on a spinner <i>identifier</i>.<br>
     *
     * @param identifier
     * : The id of the spinner.
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
     *  the int value of the spinner
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>spinnerTest</td>
     *         <td>Spinner Get Value</td>
     *         <td>100</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public int spinnerGetValue(String identifier) {
        TestFxLibraryValidation.validateArguments(identifier);

        wait.waitUntilPageContains(identifier);

        try{

        javafx.scene.control.Spinner spinner = TestFxLibraryCommon.lookup(identifier);

        return (int) spinner.getValueFactory().getValue();
        }catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword set the value of a spinner <i>identifier</i>.<br>
     *
     * @param identifier
     * : The id of the spinner.
     * @param value
     * : The value to set on the spinner.
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
     *         <td>value</td>
     *         <td>Yes</td>
     *         <td>int</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>spinnerTest</td>
     *         <td>Spinner Get Value</td>
     *         <td>100</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "value"})
    public void spinnerSetValue(String identifier, int value) {
        TestFxLibraryValidation.validateArguments(identifier);

        wait.waitUntilPageContains(identifier);

        try{

        javafx.scene.control.Spinner spinner = TestFxLibraryCommon.lookup(identifier);

        spinner.getValueFactory().setValue(value);
        Log.info("Value - " + value);

        }catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword increments the value of a spinner <i>identifier</i> the amount steps that you want.<br>
     *
     * @param identifier
     * : The id of the spinner.
     * @param steps
     * : The amount of steps to increment
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
     *         <td>steps</td>
     *         <td>Yes</td>
     *         <td>int</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>spinnerTest</td>
     *         <td>100</td>
     *         <td>Spinner Increment</td>
     *         <td>101</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "steps"})
    public void spinnerIncrement(String identifier, int steps) {
        TestFxLibraryValidation.validateArguments(identifier);

        wait.waitUntilPageContains(identifier);
        try{

            javafx.scene.control.Spinner spinner = TestFxLibraryCommon.lookup(identifier);
            spinnerSetValue(identifier, (int)spinner.getValueFactory().getValue()+steps);

        }catch (IllegalArgumentException | NullPointerException e){

            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword decrements the value of a spinner <i>identifier</i> the amount steps that you want.<br>
     *
     * @param identifier
     * : The id of the spinner.
     * @param steps
     * : The amount of steps to decrement
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
     *         <td>steps</td>
     *         <td>Yes</td>
     *         <td>int</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>spinnerTest</td>
     *         <td>100</td>
     *         <td>Spinner Decrement</td>
     *         <td>99</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "steps"})
    public void spinnerDecrement(String identifier, int steps) {
        TestFxLibraryValidation.validateArguments(identifier);

        wait.waitUntilPageContains(identifier);

        try {

            javafx.scene.control.Spinner spinner = TestFxLibraryCommon.lookup(identifier);
            spinnerSetValue(identifier, (int) spinner.getValueFactory().getValue() - steps);

        }catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword verify the value of a spinner <i>identifier</i> and confirm if the value match the value provided <i>valueToValidate</i> <br>
     *
     * @param identifier
     * : The id of the spinner.
     * @param valueToValidate
     * : The value to compare with the spinner value
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
     *         <td>valueToValidate</td>
     *         <td>Yes</td>
     *         <td>int</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>spinnerTest</td>
     *         <td>100</td>
     *         <td>Spinner Value Should Be</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "steps"})
    public void spinnerValueShouldBe(String identifier, int valueToValidate) {
        TestFxLibraryValidation.validateArguments(identifier);

        wait.waitUntilPageContains(identifier);

        try {
            
            int value = spinnerGetValue(identifier);


            if (value != valueToValidate){

                throw new TestFxLibraryFatalException(String.format("Value on the spinner does not match:  %s", valueToValidate));
            }

        }catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);
        }
    }
}