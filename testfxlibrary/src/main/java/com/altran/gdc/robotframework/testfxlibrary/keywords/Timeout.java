package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryProperties;
import com.altran.gdc.robotframework.testfxlibrary.utils.TimeoutConstants;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

/**
 * @author slourenco
 */
@RobotKeywords
public class Timeout {
    public static final String[] TIMEOUTS = new String[] {
            TimeoutConstants.GENERIC_TIMEOUT
    };

    /**
     * <b>Description:</b>This keyword sets the timeout used for waiting for a component. The timeout name is passed
     * as the first parameter and the timeout in seconds is defined by the second parameter.<br>
     *
     * @param timeoutName
     * : The timeout name
     *
     * @param timeoutInSeconds
     * : The timeout in seconds
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>timeoutName</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>timeoutInSeconds</td>
     *         <td>Yes</td>
     *         <td>int (greater than 0)</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"timeoutName", "timeoutInSeconds"})
    public void setTimeout(String timeoutName, int timeoutInSeconds) {
        TestFxLibraryProperties.setProperty(timeoutName, String.valueOf(timeoutInSeconds));
    }
}
