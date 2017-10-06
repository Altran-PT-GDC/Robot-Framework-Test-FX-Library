package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import javafx.scene.control.Control;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.testfx.api.FxRobot;

@RobotKeywords
public class Hyperlink {

    @Autowired
    Wait wait;

    /**
     * <b>Description:</b> This keyword returns the text within a Hyperlink specified by an
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
     *  The text present in a Hyperlink
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>/#hyperlink</td>
     *         <td>Get Hyperlink Text</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public String getHyperlinkText(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.Hyperlink hyperText = TestFxLibraryCommon.lookup(identifier);

        try {
            return hyperText.getText();
        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }
}
