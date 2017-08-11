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
    public final static String[] TIMEOUTS = new String[] {
            TimeoutConstants.ElEMENT_IS_VISIBLE,
            TimeoutConstants.ELEMENT_IS_NOT_VISIBLE,
            TimeoutConstants.ELEMENT_HAS_TEXT,
            TimeoutConstants.ELEMENT_IS_DISABLED,
            TimeoutConstants.ELEMENT_IS_ENABLED
    };

    /**
     * Sets the timeout used for waiting a component.
     *
     * @param timeoutName
     *      The timeout name
     *
     * @param timeoutInSeconds
     *      The timeout in seconds
     */
    @RobotKeyword
    @ArgumentNames({"timeoutName", "timeoutInSeconds"})
    public void setTimeout(String timeoutName, int timeoutInSeconds) {
        TestFxLibraryProperties.setProperty(timeoutName, String.valueOf(timeoutInSeconds));
    }

    /**
     * Sets all relevant timeouts
     * By default, they are all set to 10 seconds
     *
     * @param timeoutInSeconds
     *      The timeout in seconds
     */
    @RobotKeyword
    @ArgumentNames({"timeoutInSeconds"})
    public void setTimeouts(int timeoutInSeconds) {
        for (String timeoutType : TIMEOUTS) {
            TestFxLibraryProperties.setProperty(timeoutType, String.valueOf(timeoutInSeconds));
        }
    }
}
