package com.altran.gdc.robotframework.testfxlibrary.keywords;

import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywordOverload;
import org.robotframework.javalib.annotation.RobotKeywords;

@RobotKeywords
public class Echo {

	/**
	 * Instantiated Logging keyword bean
	 */
	@Autowired
	protected Logging logging;

	// ******************************
	// Keywords
	// ******************************

	/**
	 * Returns the given <b>message</b>.<br>
	 * 
	 * @param message
	 *            The message to return.
	 */
	@RobotKeyword
	@ArgumentNames({ "message" })
	public String echo(String message) {
		logging.info(String.format("Keyword 'echo' with '%s' called.", message));
		return message;
	}

	@RobotKeywordOverload
	public String echoWithDefault() {
		return echoWithDefault("Hello");
	}

	/**
	 * Returns the given <b>message</b>, when given.
	 * Otherwise the default message &quot;Hello World!&quot;
	 * is returned.<br>
	 * 
	 * @param message
	 *            The message to return.
	 */
	@RobotKeyword
	@ArgumentNames({ "message=Hello" })
	public String echoWithDefault(String message) {
		return message;
	}

}
