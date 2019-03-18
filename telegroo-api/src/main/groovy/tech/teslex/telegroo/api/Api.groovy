package tech.teslex.telegroo.api

import groovy.transform.CompileStatic
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.methods.MethodObjectWithFile
import tech.teslex.telegroo.telegram.methods.MethodObjectWithMedia

@CompileStatic
interface Api extends Cloneable {

	Response go(String method, Map parameters);

	Response go(MethodObject methodObject);

	Response go(MethodObjectWithFile methodObjectWithFile);

	Response go(MethodObjectWithMedia methodObjectWithMedia);

	Map getDefaultParams();

	void setDefaultParams(Map params);
}
