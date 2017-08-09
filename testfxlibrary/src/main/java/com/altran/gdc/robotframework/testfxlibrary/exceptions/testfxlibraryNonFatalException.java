package com.altran.gdc.robotframework.testfxlibrary.exceptions;

/**
 * A raised exception of this type marks the step as failed, but does not end
 * all test executions.
 */
@SuppressWarnings("serial")
public class testfxlibraryNonFatalException extends RuntimeException {

	/**
	 * Mark this exception as non fatal
	 */
	public static final boolean ROBOT_EXIT_ON_FAILURE = false;

	public testfxlibraryNonFatalException() {
		super();
	}

	public testfxlibraryNonFatalException(String string) {
		super(string);
	}

	public testfxlibraryNonFatalException(Throwable t) {
		super(t);
	}

	public testfxlibraryNonFatalException(String string, Throwable t) {
		super(string, t);
	}
}
