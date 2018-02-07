import java.io.File;
import java.util.ResourceBundle;

import com.altran.gdc.robotframework.testfxlibrary.keywords.Timeout;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFXLibraryCache;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryConstants;
import com.altran.gdc.robotframework.testfxlibrary.utils.TimeoutConstants;
import org.robotframework.javalib.library.AnnotationLibrary;

import com.altran.gdc.robotframework.testfxlibrary.utils.Javadoc2Libdoc;
import org.robotframework.javalib.library.RobotJavaLibrary;

/**
 * TestFXLibrary is a Robot Framework test library for JavaFx.<br>
 * <br>
 * The library allows to create automated test scripts to test Java FX applications using the TestFX framework.
 * <br>
 * <h2>Getting Started</h2>
 * <h3>Download</h3>
 * Download the latest version of TestFXLibrary from <a href="https://github.com/Altran-PT-GDC/Robot-Framework-Test-FX-Library">TestFXLibrary GitHub</a>
 * <br>
 * <h3>Classpath</h3>
 * To be able to execute the library and the application in Robot Framework, you need to add both application and library jars to CLASSPATH.<br>
 * You can add them and jybot execution to a script and run it as execution profile in Robot Framework.<br>
 * Below is an example of a custom bat script:<br>
 * <pre>@echo off</pre>
 * <pre>set LIBRARIES_FOLDER=C:\LibraryFolder</pre>
 * <pre>set APP_FOLDER=C:\ApplicationFolder</pre>
 * <pre>set CLASSPATH=%CLASSPATH%;%LIBRARIES_FOLDER%\*;%APP_FOLDER%\*</pre>
 * <pre>jython -m robot.run %*</pre>
 * <h3>Importing</h3>
 * Import TestFxLibrary in Robot Framework:<br>
 * <br>
 * <table>
 *     <tr>
 *         <td><b>Settings</b></td>
 *         <td><b>Value</b></td>
 *     </tr>
 *     <tr>
 *         <td>Library</td>
 *         <td>TestFXLibrary</td>
 *     </tr>
 * </table>
 * <h3>Example Test Case</h3>
 * <b>My Test Case</b><br>
 * <table>
 *     <tr>
 *         <td>Start Application</td>
 *         <td>testapp.FxApplication</td>
 *         <td></td>
 *     </tr>
 *     <tr>
 *         <td>Click On Component</td>
 *         <td>buttonId</td>
 *         <td></td>
 *     </tr>
 *     <tr>
 *         <td>Select From List View By Text</td>
 *         <td>listViewId</td>
 *         <td>Example Text</td>
 *     </tr>
 *     <tr>
 *         <td>Close Application</td>
 *         <td></td>
 *         <td></td>
 *     </tr>
 * </table>
 */

//This class can't be moved to a named package.
//Is necessary to have the class in the root path, otherwise the lib doesn't work in the RobotFramework.
public class TestFXLibrary extends AnnotationLibrary implements RobotJavaLibrary {

    /**
     * The list of keyword patterns for the AnnotationLibrary
     */
    public static final String KEYWORD_PATTERN = "com/altran/gdc/robotframework/testfxlibrary/keywords/**/*.class";

    /**
     * The javadoc to libdoc converter
     */
    public static final Javadoc2Libdoc JAVADOC_2_LIBDOC = new Javadoc2Libdoc(TestFXLibrary.class);

    /**
     * The library documentation is written in HTML
     */
    public static final String ROBOT_LIBRARY_DOC_FORMAT = "HTML";

    /**
     * The scope of this library is global.
     */
    public static final String ROBOT_LIBRARY_SCOPE = "GLOBAL";

    /**
     * The actual version of this library. Loaded from maven project.
     */
    public static final String ROBOT_LIBRARY_VERSION = loadRobotLibraryVersion();

    /**
     * testfxlibrary can be imported with optional arguments.<br>
     * <br>
     * <b>Insert importing documentation here.</b>
     */
    public TestFXLibrary() {
        super();
        addKeywordPattern(KEYWORD_PATTERN);
        // init annotations
        createKeywordFactory();
        setDefaultTimeouts();
        TestFXLibraryCache.getIstance();
    }

    private static String loadRobotLibraryVersion() {
        try {
            return ResourceBundle.getBundle(TestFXLibrary.class.getCanonicalName().replace(".", File.separator))
                    .getString("version");
        } catch (RuntimeException e) {
            throw e;
        }
    }

    // ******************************
    // AnnotationLibrary overrides
    // ******************************

    @Override
    public Object runKeyword(String keywordName, Object[] args) {
        return super.runKeyword(keywordName, toStrings(args));
    }

    @Override
    public String getKeywordDocumentation(String keywordName) {
        String keywordDocumentation = JAVADOC_2_LIBDOC.getKeywordDocumentation(keywordName);
        if (keywordDocumentation == null) {
            try {
                return super.getKeywordDocumentation(keywordName);
            } catch (NullPointerException e) {
                throw e;
            }
        }
        return keywordDocumentation;
    }

    // ******************************
    // Internal Methods
    // ******************************

    /**
     * Convert all arguments in the object array to string
     *
     * @param args The arguments
     * @return The arguments converted in String
     */
    protected Object[] toStrings(Object[] args) {
        Object[] newArgs = new Object[args.length];
        for (int i = 0; i < newArgs.length; i++) {
            if (args[i].getClass().isArray()) {
                newArgs[i] = args[i];
            } else {
                newArgs[i] = args[i].toString();
            }
        }
        return newArgs;
    }

    /**
     * Set default timeouts
     */
    private void setDefaultTimeouts() {
        new Timeout().setTimeout(TimeoutConstants.GENERIC_TIMEOUT, TestFxLibraryConstants.DEFAULT_TIMEOUT);
    }
}