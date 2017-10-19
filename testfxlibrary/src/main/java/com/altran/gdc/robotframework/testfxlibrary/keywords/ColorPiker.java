package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import javafx.scene.control.ColorPicker;
import javafx.scene.paint.Color;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

@RobotKeywords
public class ColorPiker {
    @Autowired
    Wait wait;

    /**
     * <b>Description:</b> This keyword returns the Color selected in a ColorPiker specified by an
     *  <i>identifier</i>.
     *
     * @param identifier
     * : the id of the ColorPiker component
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
     *  The text present in a Hyperlink
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>/#colorPiker</td>
     *         <td>Get Selected Colorpicker Color</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public String getSelectedColorpickerColor(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        ColorPicker colorPicker = TestFxLibraryCommon.lookup(identifier);

        try {
            return String.valueOf(colorPicker.getValue());
        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword checks if the color you specified matches the color seted in the ColorPiker specified by an
     *  <i>identifier</i>.
     *
     * @param identifier
     * : the id of the ColorPicker component
     * @param colorToValidate
     * : the color you want to Check on the ColorPiker component. The Color must be in the hexadecimal format.
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
     *         <td>colorToValidate</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>/#colorPiker</td>
     *         <td>0x0000ffff</td>
     *         <td>Datepicker Date Should Be</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier", "colorToValidate"})
    public void colorpickerColorShouldBe(String identifier, String colorToValidate){
        TestFxLibraryValidation.validateArguments(identifier, colorToValidate);
        wait.waitUntilPageContains(identifier);

        String color = getSelectedColorpickerColor(identifier);

        try {
            if(!color.equals(colorToValidate)){
                throw new TestFxLibraryFatalException("The color " + color + " doesn't match the specified color "+ colorToValidate +" .");
            }

        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword sets the color in the ColorPicker specified by an
     *  <i>identifier</i>.
     *
     * @param identifier
     * : the id of the ColorPicker component
     * @param colorToSet
     * : the color you want to set on the ColorPiker component. The Color must be in the hexadecimal format.
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
     *         <td>colorToSet</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>/#colorPiker</td>
     *         <td>0x0000ffff</td>
     *         <td>Datepicker Date Should Be</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier", "colorToSet"})
    public void setColorpickerColor(String identifier, String colorToSet){
        TestFxLibraryValidation.validateArguments(identifier, colorToSet);
        wait.waitUntilPageContains(identifier);

        ColorPicker colorPicker = TestFxLibraryCommon.lookup(identifier);

        try {

            colorPicker.setValue(Color.valueOf(colorToSet));

        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }
}
