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
}
