package com.altran.gdc.robotframework.testfxlibrary.exceptions;

/**
 * A raised exception of this type marks the step as failed, but does not end
 * all test executions.
 */
@SuppressWarnings("serial")
public class TestFxLibraryNonFatalException extends RuntimeException {

	/**
	 * Mark this exception as non fatal
	 */
	public static final boolean ROBOT_EXIT_ON_FAILURE = false;

	public TestFxLibraryNonFatalException() {
		super();
	}

	public TestFxLibraryNonFatalException(String string) {
		super(string);
	}

	public TestFxLibraryNonFatalException(Throwable t) {
		super(t);
	}

	public TestFxLibraryNonFatalException(String string, Throwable t) {
		super(string, t);
	}
}
