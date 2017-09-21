package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryProperties;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import com.altran.gdc.robotframework.testfxlibrary.utils.TimeoutConstants;
import org.awaitility.Awaitility;
import org.hamcrest.Matchers;
import org.robotframework.javalib.annotation.*;
import org.testfx.service.support.WaitUntilSupport;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testfx.matcher.base.NodeMatchers.hasText;
import static org.testfx.matcher.base.NodeMatchers.isDisabled;
import static org.testfx.matcher.base.NodeMatchers.isVisible;

@RobotKeywords
public class Wait {

    @Autowired
    private Misc misc;

    @Autowired
    private Logging log;

    /**
     * <b>Description:</b> This keyword waits until component specified with <i>identifier</i> is
     * visible. Fails if <i>timeout</i> expires before the component is visible.<br>
     *
     * @param identifier
     * : The name of the component that you are going to test
     * @param timeout
     * : The time limit to complete the test
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
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Wait Until Element Is Visible</td>
     *         <td>idComponent01</td>
     *         <td>250</td>
     *     </tr>
     *     <tr>
     *         <td>Wait Until Element Is Visible</td>
     *         <td>idComponent3A2</td>
     *         <td></td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "timeout=20"})
    public void waitUntilElementIsVisible(String identifier, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateTimeout(timeout);

        try{

            new WaitUntilSupport().waitUntil(misc.getNode(identifier), Matchers.is(isVisible()), timeout);

        } catch (IllegalArgumentException | NullPointerException e){

            throw new TestFxLibraryFatalException(e);

        }

    }

    /**
     * <b>Description:</b> This keyword waits until component specified with <i>identifier</i> is
     * visible. Fails if default timeout expires before the component is visible.<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
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
     *         <td>Wait Until Element Is Visible</td>
     *         <td>idComponent01</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilElementIsVisible(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilElementIsVisible(identifier, waitTimeout);

    }

    /**
     * <b>Description:</b> This keyword waits until component specified with <i>identifier</i> is
     * not visible. Fails if <i>timeout</i> expires before the component is not visible.<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * @param timeout
     * : The time limit to complete the test
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
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Wait Until Element Is Not Visible</td>
     *         <td>idComponent01</td>
     *         <td>250</td>
     *     </tr>
     *     <tr>
     *         <td>Wait Until Element Is Not Visible</td>
     *         <td>idComponent3a</td>
     *         <td></td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "timeout=20"})
    public void waitUntilElementIsNotVisible(String identifier, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateTimeout(timeout);

        try{

            new WaitUntilSupport().waitUntil(misc.getNode(identifier), Matchers.not(isVisible()), timeout);

        } catch (IllegalArgumentException | NullPointerException e){

            throw new TestFxLibraryFatalException(e);

        }
    }

    /**
     * <b>Description:</b> This keyword waits until component specified with <i>identifier</i> is
     * not visible. Fails if default timeout expires before the component is not visible.<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
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
     *         <td>Wait Until Element Is Not Visible</td>
     *         <td>idComponent01</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilElementIsNotVisible(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilElementIsNotVisible(identifier, waitTimeout);

    }

    /**
     * <b>Description:</b>This keyword waits until given component contains <i>textToValidate</i>.
     * Fails if <i>timeout</i> expires before the text appears on given component specified with
     * <i>identifier</i>.<br>
     *
     * @param identifier
     * : The name of the component that you are going to test
     * @param textToValidate
     * : The Text you want to validate
     * @param timeout
     * : The time limit to complete the test
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
     *     <tr>
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Wait Until Element Contains</td>
     *         <td>idComponent01</td>
     *         <td>250</td>
     *     </tr>
     *     <tr>
     *         <td>Wait Until Element Contains</td>
     *         <td>idComponent3a</td>
     *         <td></td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "textToValidate", "timeout=20"})
    public void waitUntilElementContains(String identifier, String textToValidate, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier, textToValidate);
        TestFxLibraryValidation.validateTimeout(timeout);

        try{

            new WaitUntilSupport().waitUntil(misc.getNode(identifier), hasText(textToValidate), timeout);

        } catch (IllegalArgumentException | NullPointerException e){

            throw new TestFxLibraryFatalException(e);

        }
    }

    /**
     * <b>Description:</b>This keyword waits until given component contains <i>textToValidate</i>.
     * Fails if default timeout expires before the text appears on given component specified with
     * <i>identifier</i>.<br>
     *
     * @param identifier
     * : The name of the component that you are going to test
     * @param textToValidate
     * : The Text you want to validate
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
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Wait Until Element Contains</td>
     *         <td>idComponent01</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilElementContains(String identifier, String textToValidate) {

        TestFxLibraryValidation.validateArguments(identifier, textToValidate);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilElementContains(identifier, textToValidate, waitTimeout);

    }

    /**
     * <b>Description:</b> This keyword waits until given component does not contain <i>textToValidate</i>.
     * Fails if <i>timeout</i> expires before the text disappears from given component specified with
     * <i>identifier</i>. <br>
     *
     * @param identifier
     * : The name of the component that you are going to test
     * @param textToValidate
     * : The Text you want to validate
     * @param timeout
     * : The time limit to complete the test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameters</th>
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
     *     <tr>
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Wait Until Element Does Not Contain</td>
     *         <td>idComponent01</td>
     *         <td>250</td>
     *     </tr>
     *     <tr>
     *         <td>Wait Until Element Does Not Contain</td>
     *         <td>idComponent3a</td>
     *         <td></td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "textToValidate", "timeout=20"})
    public void waitUntilElementDoesNotContains(String identifier, String textToValidate, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier, textToValidate);
        TestFxLibraryValidation.validateTimeout(timeout);

        try{

            new WaitUntilSupport().waitUntil(misc.getNode(identifier), Matchers.not(hasText(textToValidate)), timeout);

        } catch (IllegalArgumentException | NullPointerException e){

            throw new TestFxLibraryFatalException(e);

        }
    }

    /**
     * <b>Description:</b> This keyword waits until given component does not contain <i>textToValidate</i>.
     * Fails if default timeout expires before the text disappears from given component specified with
     * <i>identifier</i>. <br>
     *
     * @param identifier
     * : The name of the component that you are going to test
     * @param textToValidate
     * : The Text you want to validate
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
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
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Wait Until Element Does Not Contain</td>
     *         <td>idComponent01</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilElementDoesNotContains(String identifier, String textToValidate) {

        TestFxLibraryValidation.validateArguments(identifier, textToValidate);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilElementDoesNotContains(identifier, textToValidate, waitTimeout);

    }

    /**
     * <b>Description:</b> This keyword waits until component specified with <i>identifier</i> is disabled.
     * Fails if <i>timeout</i> expires before the component is disabled.<br>
     *
     * @param identifier
     * : The name of the component that you are going to test
     * @param timeout
     * : The time limit to complete the test
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
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Wait Until Element Is Disabled</td>
     *         <td>idComponent01</td>
     *         <td>250</td>
     *     </tr>
     *     <tr>
     *         <td>Wait Until Element Is Disabled</td>
     *         <td>idComponent3a</td>
     *         <td></td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "timeout=20"})
    public void waitUntilElementIsDisabled(String identifier, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateTimeout(timeout);

        try{

            new WaitUntilSupport().waitUntil(misc.getNode(identifier), Matchers.is(isDisabled()),timeout);

        } catch (IllegalArgumentException | NullPointerException e){

            throw new TestFxLibraryFatalException(e);

        }
    }

    /**
     * <b>Description:</b> This keyword waits until component specified with <i>identifier</i> is disabled.
     * Fails if default timeout expires before the component is disabled.<br>
     *
     * @param identifier
     * : The name of the component that you are going to test
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
     *         <td>Wait Until Element Is Disabled</td>
     *         <td>idComponent01</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilElementIsDisabled(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilElementIsDisabled(identifier, waitTimeout);

    }

    /**
     * <b>Description:</b> This keyword waits until component specified with <i>identifier</i> is enabled.
     * Fails if <i>timeout</i> expires before the component is enabled.<br>
     *
     * @param identifier
     * : The name of the component that you are going to test
     * @param timeout
     * : The time limit to complete the test
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
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Wait Until Element Is Enabled</td>
     *         <td>idComponent01</td>
     *         <td>250</td>
     *     </tr>
     *     <tr>
     *         <td>Wait Until Element Is Enabled</td>
     *         <td>idComponent3a</td>
     *         <td></td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "timeout=20"})
    public void waitUntilElementIsEnabled(String identifier, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateTimeout(timeout);

        try{

            new WaitUntilSupport().waitUntil(misc.getNode(identifier), Matchers.not(isDisabled()), timeout);

        } catch (IllegalArgumentException | NullPointerException e){

            throw new TestFxLibraryFatalException(e);

        }
    }

    /**
     * <b>Description:</b> This keyword waits until component specified with <i>identifier</i> is enabled.
     * Fails if default timeout expires before the component is disabled.<br>
     *
     * @param identifier
     * : The name of the component that you are going to test
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Argument</th>
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
     *         <td>Wait Until Element Is Enabled</td>
     *         <td>idComponent01</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilElementIsEnabled(String identifier) {

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilElementIsEnabled(identifier, waitTimeout);
    }

    /**
     * <b>Description:</b> This keyword waits until component specified with text containing <i>identifier</i>
     * appears on current page. Fails if <i>timeout</i> expires before the element appears.<br>
     *
     * @param identifier
     * : Text to identify the component that you are going to test
     * @param timeout
     * : The time limit to complete the test
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
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Wait Until Page Contains</td>
     *         <td>idComponent01</td>
     *         <td>250</td>
     *     </tr>
     *     <tr>
     *         <td>Wait Until Page Contains</td>
     *         <td>idComponent3a</td>
     *         <td></td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "timeout=20"})
    public void waitUntilPageContains(String identifier, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateTimeout(timeout);

        try{

            Awaitility.setDefaultTimeout(timeout, TimeUnit.SECONDS);
            Awaitility.await().until(() -> misc.getNode(identifier) != null);

        } catch (IllegalArgumentException | NullPointerException e){
            throw new TestFxLibraryFatalException(e);

        }
    }

    /**
     * <b>Description:</b> This keyword waits until component specified with text containing <i>identifier</i>
     * appears on current page. Fails if default timeout expires before the element appears.<br>
     *
     * @param identifier
     * : Text to identify the component that you are going to test
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
     *         <td>Wait Until Page Contains</td>
     *         <td>idComponent01</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilPageContains(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilPageContains(identifier, waitTimeout);

    }

    /**
     * <b>Description:</b> This keyword waits until component specified with text containing <i>identifier</i>
     * disappears from current page. Fails if <i>timeout</i> expires before the element disappears.<br>
     *
     * @param identifier
     * : Text to identify the component that you are going to test
     * @param timeout
     * : The time limit to complete the test
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
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Wait Until Page Does Not Contain</td>
     *         <td>idComponent01</td>
     *         <td>250</td>
     *     </tr>
     *     <tr>
     *         <td>Wait Until Page Does Not Contain</td>
     *         <td>idComponent3a</td>
     *         <td></td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "timeout=20"})
    public void waitUntilPageDoesNotContains(String identifier, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateTimeout(timeout);

        try{

            Awaitility.setDefaultTimeout(timeout, TimeUnit.SECONDS);
            Awaitility.await().until(() -> misc.getNode(identifier) == null);

        } catch (IllegalArgumentException | NullPointerException e){

            throw new TestFxLibraryFatalException(e);

        }
    }

    /**
     * <b>Description:</b> This keyword waits until component specified with text containing <i>identifier</i>
     * disappears from current page. Fails if default timeout expires before the element disappears.<br>
     *
     * @param identifier
     * : Text to identify the component that you are going to test
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
     *         <td>Wait Until Page Does Not Contain</td>
     *         <td>idComponent01</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilPageDoesNotContains(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilPageDoesNotContains(identifier, waitTimeout);

    }

    /**
     * <b>Description:</b> This keyword waits until component specified with <i>identifier</i> appears on
     * current page. Fails if <i>timeout</i> expires before the element appears.<br>
     *
     * @param identifier
     * : The name of the component that you are going to test
     * @param timeout
     * : The time limit to complete the test
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
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Wait Until Page Contains Element</td>
     *         <td>idComponent01</td>
     *         <td>250</td>
     *     </tr>
     *     <tr>
     *         <td>Wait Until Page Contains Element</td>
     *         <td>idComponent3a</td>
     *         <td></td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "timeout=20"})
    public void waitUntilPageContainsElement(String identifier, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateTimeout(timeout);

        if (identifier.startsWith("#")) {
            try{

                Awaitility.setDefaultTimeout(timeout, TimeUnit.SECONDS);
                Awaitility.await().until(() -> misc.getNode(identifier) != null);

            } catch (IllegalArgumentException | NullPointerException e){

                throw new TestFxLibraryFatalException(e);

            }
        } else {
            final String changedIdentifier = "#" + identifier;
            try {

                Awaitility.setDefaultTimeout(timeout, TimeUnit.SECONDS);
                Awaitility.await().until(() -> misc.getNode(changedIdentifier) != null);

            } catch (IllegalArgumentException | NullPointerException e) {

                throw new TestFxLibraryFatalException(e);

            }
        }
    }

    /**
     * <b>Description:</b> This keyword waits until component specified with <i>identifier</i> appears on
     * current page. Fails if default timeout expires before the element appears.<br>
     *
     * @param identifier
     * : The name of the component that you are going to test
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
     *         <td>Wait Until Page Contains Element</td>
     *         <td>idComponent01</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilPageContainsElement(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        String changedIdentifier = null;

        if (identifier.substring(0) != "#") {
            changedIdentifier = "#" + identifier;
        }

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilPageContainsElement(changedIdentifier, waitTimeout);

    }

    /**
     * <b>Description:</b> This keyword waits until component specified with <i>identifier</i> disappears from
     * current page. Fails if <i>timeout</i> expires before the element disappears.<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
     * @param timeout
     * : The time limit to complete the test
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
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Wait Until Page Does Not Contain Element</td>
     *         <td>idComponent01</td>
     *         <td>250</td>
     *     </tr>
     *     <tr>
     *         <td>Wait Until Page Does Not Contain Element</td>
     *         <td>idComponent3a</td>
     *         <td></td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "timeout=20"})
    public void waitUntilPageDoesNotContainElement(String identifier, int timeout) {

        TestFxLibraryValidation.validateArguments(identifier);
        TestFxLibraryValidation.validateTimeout(timeout);

        if (identifier.startsWith("#")) {
            try{

                Awaitility.setDefaultTimeout(timeout, TimeUnit.SECONDS);
                Awaitility.await().until(() -> misc.getNode(identifier) == null);

            } catch (IllegalArgumentException | NullPointerException e){

                throw new TestFxLibraryFatalException(e);

            }
        } else {
            final String changedIdentifier = "#" + identifier;
            try {

                Awaitility.setDefaultTimeout(timeout, TimeUnit.SECONDS);
                Awaitility.await().until(() -> misc.getNode(changedIdentifier) == null);

            } catch (IllegalArgumentException | NullPointerException e) {

                throw new TestFxLibraryFatalException(e);

            }
        }
    }

    /**
     * <b>Description:</b> This keyword waits until component specified with <i>identifier</i> disappears from
     * current page. Fails if default timeout expires before the element disappears.<br>
     *
     * @param identifier
     * : The name of the element that you are going to test
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
     *         <td>Wait Until Page Does Not Contain Element</td>
     *         <td>idComponent01</td>
     *     </tr>
     * </table>
     */
    @RobotKeywordOverload
    public void waitUntilPageDoesNotContainElement(String identifier) {

        TestFxLibraryValidation.validateArguments(identifier);

        String changedIdentifier = null;

        if (identifier.substring(0) != "#") {
            changedIdentifier = "#" + identifier;
        }

        int waitTimeout = Integer.parseInt(TestFxLibraryProperties.getProperty(TimeoutConstants.GENERIC_TIMEOUT, "20"));

        waitUntilPageDoesNotContainElement(changedIdentifier, waitTimeout);

    }

    /**
     * <b>Description:</b> This keyword sets the default <i>timeout</i> for wait keywords.
     * This value is used if another timeout is not specified.<br>
     *
     * @param timeout
     * : The time limit to complete the test in milliseconds
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>timeout</td>
     *         <td>No</td>
     *         <td>int</td>
     *         <td>0</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Default Wait</td>
     *         <td>1000</td>
     *     </tr>
     * </table>
     * @throws IOException
     *  If something goes wrong
     */
    @RobotKeyword()
    @ArgumentNames({"timeout"})
    public void defaultWait(long timeout) throws IOException {
        try {
            new WaitUntilSupport().wait(timeout);
        } catch (InterruptedException e) {
            log.error("Error!");
        }
    }
}
