package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

@RobotKeywords
public class ProgressIndicator {

    private static final String IDENTIFIER_NOT_EXIST = "The identifier %s not exists!";

    /**
     * <b>Description:</b> This keyword returns value from ProgressIndicator specified with <i>identifier</i>.
     *
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
     *         <td>Get Progress Indicator Value/td>
     *         <td>\# progressIndicatorId</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Double getProgressIndicatorValue(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

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
     *
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
     *
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
}
