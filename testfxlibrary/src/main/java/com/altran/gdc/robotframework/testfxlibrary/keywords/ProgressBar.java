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
public class ProgressBar {

    private static final String IDENTIFIER_NOT_EXIST = "The identifier %s not exists!";

    @Autowired
    private Wait wait;

    /**
     * <b>Description:</b> This keyword returns the ProgressBar specified with <i>identifier</i> value.
     * @param identifier
     * : The progress bar id
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
     *  The value of the progress bar
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Get Progress Bar Value</td>
     *         <td>\# progressBarId</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Double getProgressBarValue(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        Double value;
        try {
            javafx.scene.control.ProgressBar progressBar = TestFxLibraryCommon.lookup(identifier);
            value = progressBar.getProgress();
        }catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }

        return value;
    }

    /**
     * <b>Description:</b> This keyword check if the ProgressBar specified with <i>identifier</i> is enabled
     *
     * @param identifier
     * : The progress bar id
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
     *         <td>Progress Bar Should Be Enabled</td>
     *         <td>\# progressBarId</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void progressBarShouldBeEnabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ProgressBar progressBar;
        try {
            progressBar = TestFxLibraryCommon.lookup(identifier);
        }catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }

        if (progressBar.isDisable()){
            throw new TestFxLibraryNonFatalException(String.format("The %s is not enabled", identifier));
        }
    }

    /**
     * <b>Description:</b> This keyword check if the ProgressBar specified with <i>identifier</i> is disabled
     *
     * @param identifier
     * : The progress bar id
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
     *         <td>Progress Bar Should Be Disabled</td>
     *         <td>\# progressBarId</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void progressBarShouldBeDisabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ProgressBar progressBar;
        try {
            progressBar = TestFxLibraryCommon.lookup(identifier);
        }catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }

        if (!progressBar.isDisable()){
            throw new TestFxLibraryNonFatalException(String.format("The %s is not disabled", identifier));
        }
    }

    /**
     * <b>Description:</b> This keyword wait until the Progress Bar specified with <i>identifier</i> is completed given the timeout.
     *
     * @param identifier
     * : The progress bar id
     *
     * @param timeout
     * : The timeout
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
     *         <td>Wait Until Progress Bar Is Complete</td>
     *         <td>\# progressBarId</td>
     *         <td>timeout</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier","timeout"})
    public void waitUntilProgressBarIsComplete(String identifier, int timeout){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ProgressBar progressBar;
        boolean isCompleted = false;

        for(int i = 1; i <= timeout; i++){
            try {
                Thread.sleep(TestFxLibraryConstants.TIMEOUT);

                progressBar = this.getProgressBar(identifier);

                if(progressBar.getProgress() == 1d){
                    isCompleted = true;
                    break;
                }

            } catch (InterruptedException e) {
                throw new TestFxLibraryNonFatalException("Error to check Progress Bar is complete", e);
            }
        }

        if(!isCompleted){
            throw new TestFxLibraryNonFatalException(String.format("Identifier %s is not completed", identifier));
        }
        
    }

    /**
     * Get the Progress Bar.
     *
     * @param identifier
     *      The identifier to search the Progress Bar
     * @return
     *      The Progress Bar
     */
    private javafx.scene.control.ProgressBar getProgressBar(String identifier){
        javafx.scene.control.ProgressBar progressBar;
        try {
            progressBar = TestFxLibraryCommon.lookup(identifier);
        }catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }

        return progressBar;
    }
}
