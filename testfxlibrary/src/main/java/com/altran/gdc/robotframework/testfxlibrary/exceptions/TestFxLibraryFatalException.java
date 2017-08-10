package com.altran.gdc.robotframework.testfxlibrary.exceptions;

/**
 * A raised exception of this type ends all test executions.
 */
@SuppressWarnings("serial")
public class TestFxLibraryFatalException extends RuntimeException {

	/**
	 * Mark this exception as fatal
	 */
	public static final boolean ROBOT_EXIT_ON_FAILURE = true;

	public TestFxLibraryFatalException() {
		super();
	}

	public TestFxLibraryFatalException(String string) {
		super(string);
	}

	public TestFxLibraryFatalException(Throwable t) {
		super(t);
	}

	public TestFxLibraryFatalException(String string, Throwable t) {
		super(string, t);
	}
}
