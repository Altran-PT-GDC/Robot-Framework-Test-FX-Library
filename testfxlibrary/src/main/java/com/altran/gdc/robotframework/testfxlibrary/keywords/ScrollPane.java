package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

@RobotKeywords
public class ScrollPane {

    @Autowired
    Wait wait;

    /**
     * <b>Description:</b> This keyword returns the maximum horizontal value of a scroll pane specified by an <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @return value
     * : The maximum horizontal value
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
     *         <td>${max_hor_value}=</td>
     *         <td>Get Scroll Pane Max Horizontal Value</td>
     *         <td>\#scrollpane</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Double getScrollPaneMaxHorizontalValue(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ScrollPane scrollPane = TestFxLibraryCommon.lookup(identifier);
        return scrollPane.getHmax();
    }

    /**
     * <b>Description:</b> This keyword returns the minimum horizontal value of a scroll pane specified by an <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @return value
     * : The minimum horizontal value
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
     *         <td>${max_hor_value}=</td>
     *         <td>Get Scroll Pane Min Horizontal Value</td>
     *         <td>\#scrollpane</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Double getScrollPaneMinHorizontalValue(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ScrollPane scrollPane = TestFxLibraryCommon.lookup(identifier);
        return scrollPane.getHmin();
    }

    /**
     * <b>Description:</b> This keyword returns the maximum vertical value of a scroll pane specified by an <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @return value
     * : The maximum vertical value
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
     *         <td>${max_hor_value}=</td>
     *         <td>Get Scroll Pane Max Vertical Value</td>
     *         <td>\#scrollpane</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Double getScrollPaneMaxVerticalValue(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ScrollPane scrollPane = TestFxLibraryCommon.lookup(identifier);
        return scrollPane.getVmax();
    }

    /**
     * <b>Description:</b> This keyword returns the minimum vertical value of a scroll pane specified by an <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @return value
     * : The minimum vertical value
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
     *         <td>${max_hor_value}=</td>
     *         <td>Get Scroll Pane Min Vertical Value</td>
     *         <td>\#scrollpane</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Double getScrollPaneMinVerticalValue(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ScrollPane scrollPane = TestFxLibraryCommon.lookup(identifier);
        return scrollPane.getVmin();
    }

    /**
     * <b>Description:</b> This keyword returns the horizontal value of a scroll pane specified by an <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @return value
     * : The horizontal value
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
     *         <td>${hor_value}=</td>
     *         <td>Get Scroll Pane Horizontal Value</td>
     *         <td>\#scrollpane</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Double getScrollPaneHorizontalValue(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ScrollPane scrollPane = TestFxLibraryCommon.lookup(identifier);
        return scrollPane.getHvalue();
    }

    /**
     * <b>Description:</b> This keyword returns the vertical value of a scroll pane specified by an <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @return value
     * : The vertical value
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
     *         <td>${hor_value}=</td>
     *         <td>Get Scroll Pane Vertical Value</td>
     *         <td>\#scrollpane</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Double getScrollPaneVerticalValue(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ScrollPane scrollPane = TestFxLibraryCommon.lookup(identifier);
        return scrollPane.getVvalue();
    }

    /**
     * <b>Description:</b> This keyword sets the horizontal value of a scroll pane specified by an <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @param value
     * : The new horizontal value
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
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Set Scroll Pane Horizontal Value</td>
     *         <td>\#scrollpane</td>
     *         <td>0.1</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "value"})
    public void setScrollPaneHorizontalValue(String identifier, Double value){
        TestFxLibraryValidation.validateArguments(identifier, value);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ScrollPane scrollPane = TestFxLibraryCommon.lookup(identifier);
        scrollPane.setHvalue(value);
    }

    /**
     * <b>Description:</b> This keyword sets the vertical value of a scroll pane specified by an <i>identifier</i>.
     *
     * @param identifier
     * : The id of the component
     * @param value
     * : The new vertical value
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
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Set Scroll Pane Vertical Value</td>
     *         <td>\#scrollpane</td>
     *         <td>0.45</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "value"})
    public void setScrollPaneVerticalValue(String identifier, Double value){
        TestFxLibraryValidation.validateArguments(identifier, value);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ScrollPane scrollPane = TestFxLibraryCommon.lookup(identifier);
        scrollPane.setVvalue(value);
    }
}
