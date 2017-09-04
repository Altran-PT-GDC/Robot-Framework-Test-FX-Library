/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altran.gdc.robotframework.testfxlibrary.keywords;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import java.util.function.Predicate;
import static org.hamcrest.Matchers.contains;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.base.NodeMatchers.*;
import static org.testfx.matcher.base.NodeMatchers.hasChild;

/**
 *
 * @author pcosta
 */
@RobotKeywords
public class Assert {

    /**
     * <b>Description:</b> This keyword verifies if a given component specified with <i>identifier</i>
     * contains a child component specified with <i>identifierToValidate</i>. If child component is
     * not present in parent component an error message is displayed.<br>
     *
     * @param identifier
     * : Parent component you want to validate
     * @param identifierToValidate
     * : Child component you want to verify
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
     *         <td>identifierToValidate</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Verify That Contains</td>
     *         <td>idPane</td>
     *         <td>idButton</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier","identifierToValidate"})
    public void verifyThatContains(String identifier, String identifierToValidate) {
        verifyThat(identifier, (Predicate) contains( identifierToValidate ));
    }

    /**
     * <b>Description:</b> This keyword verifies if a component specified with <i>identifier</i>
     * contains text specified with <i>textToValidate</i>. If the component does not contain the given
     * text an error message is displayed.<br>
     *
     * @param identifier
     * : The component you want to validate
     * @param textToValidate
     * : The text you want to validate
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
     *         <td>textToValidate</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Verify That Has Name</td>
     *         <td>idButton</td>
     *         <td>click here</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier","textToValidate"})
    public void verifyThatHasText(String identifier, String textToValidate) {
        verifyThat( identifier, hasText(textToValidate));
    }

    /**
     * <b>Description:</b> This keyword verifies if a component specified with <i>identifier</i>
     * is enabled. If the given component is disabled an error message is displayed.<br>
     *
     * @param identifier
     * : The component you want to verify
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
     *
     *</table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Verify That Is Enabled</td>
     *         <td>idButton</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void verifyThatIsEnabled(String identifier) {
        verifyThat( identifier, isEnabled() );

    }

    /**
     * <b>Description:</b> This keyword verifies if a component specified with <i>identifier</i>
     * is disabled. If the given component is enabled an error message is displayed.<br>
     *
     * @param identifier
     * : The component you want to verify
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
     *
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Verify That Is Disabled</td>
     *         <td>idButton</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void verifyThatIsDisabled(String identifier) {
        verifyThat( identifier, isDisabled() );

    }

    /**
     * <b>Description:</b> This keyword verifies if a component specified with <i>identifier</i> is
     * visible. If the given component is not visible an error message is displayed.<br>
     *
     * @param identifier
     * : The node you want to verify
     *
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
     *
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Component Should Be Visible</td>
     *         <td>idButton</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void componentShouldBeVisible(String identifier) {
        verifyThat( identifier, isVisible() );

    }


    /**
     * <b>Description:</b> This keyword verifies if the component specified with <i>identifierToValidate</i>
     * is a child to the component specified with <i>identifier</i>. If <i>identifierToValidate</i> is not
     * a child of <i>identifier</i> an error message is displayed.<br>
     *
     * @param identifier
     * : The component you want to verify as parent
     * @param identifierToValidate
     * : The component you want to verify as child
     *
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
     *         <td>identifierToValidate</td>
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
     *         <td>Verify That Has Child</td>
     *         <td>idPane</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier","identifierToValidate"})
    public void verifyThatHasChild(String identifier, String identifierToValidate) {
        verifyThat( identifier, hasChild(identifierToValidate) );
    }
}
