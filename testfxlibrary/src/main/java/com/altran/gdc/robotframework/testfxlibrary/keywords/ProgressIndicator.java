package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryConstants;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

@RobotKeywords
public class ProgressIndicator {

    @Autowired
    private Wait wait;

    private static final String IDENTIFIER_NOT_EXIST = "The identifier %s not exists!";

    /**
     * <b>Description:</b> This keyword returns value from ProgressIndicator specified with <i>identifier</i>.
     * <br><br>
     * @param identifier
     * : The progress indicator id
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
     * </table>
     *
     * @return
     *  The value of the progress indicator
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Get Progress Indicator Value</td>
     *         <td>\# progressIndicatorId</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Double getProgressIndicatorValue(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        Double value;
        try {
            javafx.scene.control.ProgressIndicator progressIndicator = TestFxLibraryCommon.lookup(identifier);
            value = progressIndicator.getProgress();
        }catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }

        return value;
    }

    /**
     * <b>Description:</b> This keyword check if the ProgressIndicator specified with <i>identifier</i> is enabled
     * <br><br>
     * @param identifier
     * : The progress indicator id
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
     * </table>
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Progress Indicator Should Be Enabled</td>
     *         <td>\# progressIndicatorId</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void progressIndicatorShouldBeEnabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ProgressIndicator progressIndicator;
        try {
            progressIndicator = TestFxLibraryCommon.lookup(identifier);
        }catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }

        if (progressIndicator.isDisable()){
            throw new TestFxLibraryNonFatalException(String.format("The %s is not enabled", identifier));
        }
    }

    /**
     * <b>Description:</b> This keyword check if the ProgressIndicator specified with <i>identifier</i> is disabled
     * <br><br>
     * @param identifier
     * : The progress indicator id
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
     * </table>
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Progress Indicator Should Be Disabled</td>
     *         <td>\# progressIndicatorId</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void progressIndicatorShouldBeDisabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ProgressIndicator progressIndicator;
        try {
            progressIndicator = TestFxLibraryCommon.lookup(identifier);
        }catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }

        if (!progressIndicator.isDisable()){
            throw new TestFxLibraryNonFatalException(String.format("The %s is not disabled", identifier));
        }
    }

    /**
     * <b>Description:</b> This keyword wait until the Progress Indicator specified with <i>identifier</i> is completed given the timeout.
     * <br><br>
     * @param identifier
     * : The progress indicator id
     *
     * @param timeout
     * : The timeout in seconds
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
     * </table>
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Wait Until Progress Indicator Is Complete</td>
     *         <td>\# progressIndicatorId</td>
     *         <td>20</td>
     *     </tr>
     * </table>
     */
    public void waitUntilProgressIndicatorIsComplete(String identifier, int timeout){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ProgressIndicator progressIndicator;
        boolean isCompleted = false;

        for(int i = 1; i <= timeout; i++){
            try {
                Thread.sleep(TestFxLibraryConstants.TIMEOUT);

                progressIndicator = this.getProgressIndicator(identifier);

                if(progressIndicator.getProgress() == new Double(1).doubleValue()){
                    isCompleted = true;
                    break;
                }

            } catch (InterruptedException e) {
                throw new TestFxLibraryNonFatalException("Error to check Progress Indicator is completed", e);
            }
        }

        if(!isCompleted){
            throw new TestFxLibraryNonFatalException(String.format("Identifier %s is not completed", identifier));
        }

    }

    /**
     * Get the Progress Indicator.
     *
     * @param identifier
     *      The identifier to search the Progress Indicator
     * @return
     *      The Progress Indicator
     */
    private javafx.scene.control.ProgressIndicator getProgressIndicator(String identifier){
        javafx.scene.control.ProgressIndicator progressIndicator;
        try {
            progressIndicator = TestFxLibraryCommon.lookup(identifier);
        }catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }

        return progressIndicator;
    }
}
