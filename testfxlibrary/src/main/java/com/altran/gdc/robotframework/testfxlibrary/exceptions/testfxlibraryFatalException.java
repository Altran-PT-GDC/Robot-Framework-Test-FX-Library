package com.altran.gdc.robotframework.testfxlibrary.exceptions;

/**
 * A raised exception of this type ends all test executions.
 */
@SuppressWarnings("serial")
public class testfxlibraryFatalException extends RuntimeException {

	/**
	 * Mark this exception as fatal
	 */
	public static final boolean ROBOT_EXIT_ON_FAILURE = true;

	public testfxlibraryFatalException() {
		super();
	}

	public testfxlibraryFatalException(String string) {
		super(string);
	}

	public testfxlibraryFatalException(Throwable t) {
		super(t);
	}

	public testfxlibraryFatalException(String string, Throwable t) {
		super(string, t);
	}
}
