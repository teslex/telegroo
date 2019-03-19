package tech.teslex.telegroo.api;

import tech.teslex.telegroo.telegram.methods.MethodObject;
import tech.teslex.telegroo.telegram.methods.MethodObjectWithFile;
import tech.teslex.telegroo.telegram.methods.MethodObjectWithMedia;

import java.util.Map;

public interface Api<T> extends Cloneable {

	T go(String method, Map parameters);

	T go(MethodObject methodObject);

	T go(MethodObjectWithFile methodObjectWithFile);

	T go(MethodObjectWithMedia methodObjectWithMedia);

	Map getDefaultParams();

	void setDefaultParams(Map params);
}
