package tech.teslex.telegroo.api.annotation;

/**
 * Represents command
 */
public @interface Command {

	/**
	 * @return string pattern
	 */
	String value();

	/**
	 * @return string args pattern
	 */
	String argsPattern() default "";
}
