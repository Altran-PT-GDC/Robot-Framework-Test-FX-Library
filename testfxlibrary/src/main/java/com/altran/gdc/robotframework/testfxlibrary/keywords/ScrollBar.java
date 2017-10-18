package com.altran.gdc.robotframework.testfxlibrary.keywords;


import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;


@RobotKeywords
public class ScrollBar {

    @Autowired
    private Wait wait;

    /**
     * <b>Description:</b> This keyword returns the maximum value of a scroll bar specified by <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @return value
     * : The maximum value of the scroll bar
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
     *         <td>float</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>${max_value}=</td>
     *         <td>Get Scroll Bar Max Value/td>
     *         <td>\#scrollbar</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Double getScrollBarMaxValue(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ScrollBar scrollBar = TestFxLibraryCommon.lookup(identifier);
        return scrollBar.getMax();
    }

    /**
     * <b>Description:</b> This keyword returns the minimum value of a scroll bar specified by <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @return value
     * : The minimum value of the scroll bar
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
     *         <td>float</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>${min_value}=</td>
     *         <td>Get Scroll Bar Min Value/td>
     *         <td>\#scrollbar</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Double getSCrollBarMinValue(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ScrollBar scrollBar = TestFxLibraryCommon.lookup(identifier);
        return scrollBar.getMin();
    }

    /**
     * <b>Description:</b> This keyword returns the current value of a scroll bar specified by <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @return value
     * : The current value of the scroll bar
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
     *         <td>float</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>${current_value}=</td>
     *         <td>Get Scroll Bar Value/td>
     *         <td>\#scrollbar</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Double getScrollBarValue(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ScrollBar scrollBar = TestFxLibraryCommon.lookup(identifier);
        return scrollBar.getValue();
    }

    /**
     * <b>Description:</b> This keyword sets the scroll bar value to a specified <i>value</i>.
     *
     * @param identifier
     * : The id of the component
     * @param value
     * : The value to be set
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
     *         <td>float</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Set Scroll Bar Value</td>
     *         <td>\#scrollbar</td>
     *         <td>105.2</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "value"})
    public void setScrollBarValue(String identifier, Double value){
        TestFxLibraryValidation.validateArguments(identifier, value);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ScrollBar scrollBar = TestFxLibraryCommon.lookup(identifier);
        scrollBar.setValue(value);
    }

    /**
     * <b>Description:</b> This keyword fails if the value specified by <i>value</i> is not the current scroll bar specified by <i>identifier</i> value.
     *
     * @param identifier
     * : The id of the component
     * @param value
     * : The value to verify
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
     *         <td>float</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Scroll Bar Value Should Be</td>
     *         <td>\#scrollbar</td>
     *         <td>95.1</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "value"})
    public void scrollBarValueShouldBe(String identifier, Double value){
        TestFxLibraryValidation.validateArguments(identifier, value);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ScrollBar scrollBar = TestFxLibraryCommon.lookup(identifier);
        if (scrollBar.getValue()!=value){
            throw new TestFxLibraryFatalException("ScrollBar value is " + scrollBar.getValue());
        }
    }

}
