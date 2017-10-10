package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

@RobotKeywords
public class ProgressBar {

    private static final String IDENTIFIER_NOT_EXIST = "The identifier %s not exists!";

    /**
     * <b>Description:</b> This keyword returns value from ProgressBar specified with <i>identifier</i>.
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
     * @return
     *  The value of the progress bar
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Get Progress Bar Value/td>
     *         <td>\# progressBarId</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Double getProgressBarValue(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

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
     *         <td>\# menuId</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void progressBarShouldBeEnabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

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
     *         <td>\# menuId</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void progressBarShouldBeDisabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

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
}
