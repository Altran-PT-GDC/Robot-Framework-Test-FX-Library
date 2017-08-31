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
     * <b>Description:</b> Verifies if a given node identified as the first parameter contains
     * a child node identified as the second parameter. If the child node is
     * not present in the parent node an error message is displayed.<br>
     *
     * @param identifier
     * : The node you want to validate
     * @param identifierToValidate
     * : The node you want to verify
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
     */
    @RobotKeyword
    @ArgumentNames({"identifier","identifierToValidate"})
    public void verifyThatContains(String identifier, String identifierToValidate) {
        verifyThat(identifier, (Predicate) contains( identifierToValidate ));
    }

    /**
     * <b>Description:</b> Verifies if a node identified as the first parameter contains text
     * passed as the second parameter. If the node does not contain the given
     * text an error message is displayed.<br>
     *
     * @param identifier
     * : The node you want to validate
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
     */
    @RobotKeyword
    @ArgumentNames({"identifier","textToValidate"})
    public void verifyThatHasText(String identifier, String textToValidate) {
        verifyThat( identifier, hasText(textToValidate));
    }

    /**
     * <b>Description:</b> Verifies if a node identified as the parameter is enabled. If The
     * given node is disabled an error message is displayed.<br>
     *
     * @param identifier
     * : The node you want to verify
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
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void verifyThatIsEnabled(String identifier) {
        verifyThat( identifier, isEnabled() );

    }

    /**
     * <b>Description:</b>Verifies if a node identified as the parameter is disabled. If the
     * given node is enabled an error message is displayed.<br>
     *
     * @param identifier
     * : The node you want to verify
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
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void verifyThatIsDisabled(String identifier) {
        verifyThat( identifier, isDisabled() );

    }

    /**
     * <b>Description:</b>Verifies if a node identified as the parameter is visible. If the
     * given node is not visible an error message is displayed.<br>
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
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void componentShouldBeVisible(String identifier) {
        verifyThat( identifier, isVisible() );

    }


    /**
     * <b>Description:</b>Verifies if the node passed as the second parameter is a child
     * to the node passed as the first parameter. If the node identified as
     * the second parameter is not a child of the node identified as the
     * first parameter an error message is displayed.<br>
     *
     * @param identifier
     * : The node you want to verify as parent
     * @param identifierToValidate
     * : The node you want to verify as child
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
     */
    @RobotKeyword
    @ArgumentNames({"identifier","identifierToValidate"})
    public void verifyThatHasChild(String identifier, String identifierToValidate) {
        verifyThat( identifier, hasChild(identifierToValidate) );
    }
}
