package tech.teslex.telegroo.api.annotation;


/**
 * unimplemented now
 */
public @interface Command {

	String value();

	boolean pattern() default false;
}
