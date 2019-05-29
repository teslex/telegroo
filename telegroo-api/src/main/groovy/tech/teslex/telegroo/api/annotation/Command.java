package tech.teslex.telegroo.api.annotation;


/**
 * unimplemented now
 */
public @interface Command {

	/**
	 * command pattern
	 */
	String value();

	/**
	 * arguments pattern
	 */
	String argsPattern();
}
