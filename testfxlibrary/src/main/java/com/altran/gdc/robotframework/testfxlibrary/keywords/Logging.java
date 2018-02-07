package com.altran.gdc.robotframework.testfxlibrary.keywords;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryConstants;
import org.python.util.PythonInterpreter;
import org.robotframework.javalib.annotation.RobotKeywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RobotKeywords
public class Logging {

    /**
     * Thread local variable with loaded logger.
     */
    protected static ThreadLocal<PythonInterpreter> loggingPythonInterpreter = ThreadLocal.withInitial(() -> {
        PythonInterpreter pythonInterpreter = new PythonInterpreter();
        pythonInterpreter.exec("from robot.variables import GLOBAL_VARIABLES; from robot.api import logger;");
        return pythonInterpreter;
    });

    protected static final Map<String, String[]> VALID_LOG_LEVELS;

    private static final Logger LOG = LoggerFactory.getLogger(Logging.class);
    private static final String DEBUG_CONSTANT = "debug";
    private static final String HTML_CONSTANT = "html";
    private static final String INFO_CONSTANT = "info";
    private static final String TRACE_CONSTANT = "trace";
    private static final String WARNING_CONSTANT = "warn";
    private static final String ERROR_CONSTANT = "error";

    static {
        VALID_LOG_LEVELS = new HashMap<>();
        VALID_LOG_LEVELS.put(DEBUG_CONSTANT, new String[]{DEBUG_CONSTANT, ""});
        VALID_LOG_LEVELS.put(HTML_CONSTANT, new String[]{HTML_CONSTANT, ", True, False"});
        VALID_LOG_LEVELS.put(INFO_CONSTANT, new String[]{INFO_CONSTANT, ""});
        VALID_LOG_LEVELS.put(TRACE_CONSTANT, new String[]{TRACE_CONSTANT, ""});
        VALID_LOG_LEVELS.put(WARNING_CONSTANT, new String[]{WARNING_CONSTANT, ""});
        VALID_LOG_LEVELS.put(ERROR_CONSTANT, new String[]{ERROR_CONSTANT, ""});
    }

    public void trace(String msg) {
        try {
            log(msg, "trace");
        } catch (IOException e) {
            LOG.error(TestFxLibraryConstants.ERROR_MESSAGE, e);
        }
    }

    protected void debug(String msg) {
        try {
            log(msg, "debug");
        } catch (IOException e) {
            LOG.error(TestFxLibraryConstants.ERROR_MESSAGE, e);
        }
    }

    public void info(String msg) {
        try {
            log(msg, "info");
        } catch (IOException e) {
            LOG.error(TestFxLibraryConstants.ERROR_MESSAGE, e);
        }
    }

    public void html(String msg) throws IOException {
        log(msg, "html");
    }

    public void warn(String msg) throws IOException {
        log(msg, "warn");
    }

    public void error(String msg) throws IOException {
        log(msg, "error");
    }

    protected void log(String msg, String logLevel) throws IOException {
        String[] methodParameters = VALID_LOG_LEVELS.get(logLevel.toLowerCase());
        if (methodParameters != null) {
            log0(msg, methodParameters[0], methodParameters[1]);
        } else {
            throw new TestFxLibraryNonFatalException(String.format("Given log level %s is invalid.", logLevel));
        }
    }

    /**
     * Log the given message with the Robot logger.<br>
     * <br>
     * There is a hard limit of 100k in the Jython source code parser.
     * Therefore messages larger than 1k are saved on disk and the later
     * read back into memory on the Jython side.
     *
     * @param msg             The message
     * @param methodName      The method name
     * @param methodArguments The arguments
     * @throws IOException If something goes wrong
     */
    protected void log0(String msg, String methodName, String methodArguments) throws IOException {
        if (msg.length() > TestFxLibraryConstants.MESSAGE_LENGTH) {
            // Message is too large.
            // There is a hard limit of 100k in the Jython source code parser
            FileWriter writer = null;
            try {
                // Write message to temp file
                File tempFile = File.createTempFile("testfxlibrary-", ".log");
                tempFile.deleteOnExit();
                writer = new FileWriter(tempFile);
                writer.write(msg);
                writer.close();

                // Read the message in Python back and log it.
                loggingPythonInterpreter.get().exec(
                        String.format("from __future__ import with_statement\n" + "\n"
                                        + "with open('%s', 'r') as msg_file:\n" + "    msg = msg_file.read()\n"
                                        + "    logger.%s(msg%s)", tempFile.getAbsolutePath().replace("\\", "\\\\"), methodName,
                                methodArguments));

            } catch (IOException e) {
                throw new TestFxLibraryNonFatalException("Error in handling temp file for long log message.", e);
            } finally {
                if (writer != null) {
                    writer.close();
                }
            }
        } else {
            // Message is small enough to get parsed by Jython
            loggingPythonInterpreter.get().exec(
                    String.format("logger.%s('%s'%s)", methodName, msg.replace("'", "\\'").replace("\n", "\\n"),
                            methodArguments));
        }
    }
}