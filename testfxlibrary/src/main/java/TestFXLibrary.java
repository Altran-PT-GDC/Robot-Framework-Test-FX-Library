import java.io.File;
import java.util.ResourceBundle;

import com.altran.gdc.robotframework.testfxlibrary.keywords.Timeout;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFXLibraryCache;
import com.altran.gdc.robotframework.testfxlibrary.utils.TimeoutConstants;
import org.robotframework.javalib.library.AnnotationLibrary;

import com.altran.gdc.robotframework.testfxlibrary.utils.Javadoc2Libdoc;
import org.robotframework.javalib.library.RobotJavaLibrary;

/**
 * TestFXLibrary is a ... library for the Robot Framework.<br>
 * <br>
 * <b>Insert library introduction here.</b>
 */
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

	private static String loadRobotLibraryVersion() {
		try {
			return ResourceBundle.getBundle(TestFXLibrary.class.getCanonicalName().replace(".", File.separator))
					.getString("version");
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	/**
	 * testfxlibrary can be imported with optional arguments.<br>
	 * <br>
	 * <b>Insert importing documentation here.</b>
	 */
	public TestFXLibrary() {
		super();
		addKeywordPattern(KEYWORD_PATTERN);
		createKeywordFactory(); // => init annotations
        setDefaultTimeouts();
		TestFXLibraryCache.getIstance();
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
     * @param args
     *      The arguments
     * @return
     *      The arguments converted in String
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
        new Timeout().setTimeout(TimeoutConstants.GENERIC_TIMEOUT, 20);
    }
}