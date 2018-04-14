package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import javafx.scene.control.Control;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testfx.api.FxRobot;

import java.util.ArrayList;


@RobotKeywords
public class Component {


    @Autowired
    Wait wait;

    /**
     * <b>Description:</b> This keyword returns the number of instance's locators find in the window
     * specified with <i>identifier</i>.
     * <br><br>
     * @param identifier
     * : The css class of the component
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
     *  The number of instance's locators
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>.button</td>
     *         <td>Get Matching Locator Count</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public int getMatchingLocatorCount(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);
        java.util.ArrayList<Object> count = new ArrayList<>();
        count.addAll(new FxRobot().lookup(identifier).queryAll());
        return count.size();
    }

    /**
     * <b>Description:</b> This keyword returns the text within a tooltip specified by an
     *  <i>identifier</i>.
     *
     * @param identifier
     * : the id of the component with a tooltip
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
     *  The text present in a tooltip
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>/#button2</td>
     *         <td>Get Tooltip Text</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public String getTooltipText(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        Control object=new FxRobot().lookup(identifier).query();
        
        return object.getTooltip().getText();
    }

    /**
     * <b>Description:</b> This keyword verifies it a given <i>text</i> is the same as the tooltip text found on the <i>identifier</i>.<br>
     *
     * @param identifier
     * : The id of the component
     * @param text
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
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Tooltip Text Should Be</td>
     *         <td>textfield</td>
     *         <td>Hello World</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "text"})
    public void tooltipTextShouldBe(String identifier, String text){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        Control object= new FxRobot().lookup(identifier).query();

        if (!object.getTooltip().getText().equals(text)){
            throw new TestFxLibraryNonFatalException("Tooltip text does not match");
        }
    }

}
