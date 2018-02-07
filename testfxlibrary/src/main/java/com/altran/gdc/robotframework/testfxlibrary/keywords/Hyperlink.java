package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

@RobotKeywords
public class Hyperlink {

    @Autowired
    private Wait wait;

    /**
     * <b>Description:</b> This keyword returns the text within a Hyperlink specified by an
     *  <i>identifier</i>.
     * <br><br>
     * @param identifier
     * : the id of the Hyperlink component
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

    /**
     * <b>Description:</b> This keyword returns the status of an Hyperlink specified by an
     *  <i>identifier</i>.
     * <br><br>
     * @param identifier
     * : the id of the Hyperlink component
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
     *  The current status of an Hyperlink
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>/#hyperlink</td>
     *         <td>Get Hyperlink Status</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Boolean getHyperlinkStatus(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.Hyperlink hyperlink = TestFxLibraryCommon.lookup(identifier);

        try {
            return hyperlink.isVisited();
        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword set the status of an Hyperlink specified by an
     *  <i>identifier</i>.
     * <br><br>
     * @param identifier
     * : the id of the Hyperlink component
     * @param value
     * : the value of the Hyperlink status
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
     *      <tr>
     *         <td>value</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>/#hyperlink</td>
     *         <td>Set Hyperlink Status</td>
     *         <td>true</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier", "value"})
    public void setHyperlinkStatus(String identifier, String value){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.Hyperlink hyperlink = TestFxLibraryCommon.lookup(identifier);

        try {
            hyperlink.setVisited(Boolean.parseBoolean(value));
        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword check if Hyperlink status specified by an
     *  <i>identifier</i> is visited.
     * <br><br>
     * @param identifier
     * : the id of the Hyperlink component
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
     *         <td>/#hyperlink</td>
     *         <td>Hyperlink Should Be Visited</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void hyperlinkShouldBeVisited(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.Hyperlink hyperlink = TestFxLibraryCommon.lookup(identifier);


        try {
            if(!hyperlink.isVisited()){

                throw new TestFxLibraryFatalException("Hyperlink was not visited yet.");

            }
        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword check if Hyperlink status specified by an
     *  <i>identifier</i> is visited.
     * <br><br>
     * @param identifier
     * : the id of the Hyperlink component
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
     *         <td>/#hyperlink</td>
     *         <td>Hyperlink Should Not Be Visited</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void hyperlinkShouldNotBeVisited(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.Hyperlink hyperlink = TestFxLibraryCommon.lookup(identifier);


        try {
            if(hyperlink.isVisited()){

                throw new TestFxLibraryFatalException("Hyperlink was visited already.");

            }
        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword check if Hyperlink specified by an
     *  <i>identifier</i> is enabled.
     * <br><br>
     * @param identifier
     * : the id of the Hyperlink component
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
     *         <td>/#hyperlink</td>
     *         <td>Hyperlink Should Be Enabled</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void hyperlinkShouldBeEnabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.Hyperlink hyperlink = TestFxLibraryCommon.lookup(identifier);


        try {
            if(hyperlink.isDisabled()){

                throw new TestFxLibraryFatalException("Hyperlink is disabled.");

            }
        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }

    /**
     * <b>Description:</b> This keyword check if Hyperlink specified by an
     *  <i>identifier</i> is enabled.
     * <br><br>
     * @param identifier
     * : the id of the Hyperlink component
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
     *         <td>/#hyperlink</td>
     *         <td>Hyperlink Should Be Enabled</td>
     *     </tr>
     * </table>
     */

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void hyperlinkShouldBeDisabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.Hyperlink hyperlink = TestFxLibraryCommon.lookup(identifier);


        try {
            if(!hyperlink.isDisabled()){

                throw new TestFxLibraryFatalException("Hyperlink is Enabled.");

            }
        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }
}
