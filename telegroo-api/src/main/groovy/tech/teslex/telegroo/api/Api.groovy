package tech.teslex.telegroo.api

import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.methods.MethodObjectWithFile
import tech.teslex.telegroo.telegram.methods.MethodObjectWithMedia

@CompileStatic
interface Api<T> extends Cloneable {

	T go(String method, Map parameters)

	T go(MethodObject methodObject)

	T go(MethodObjectWithFile methodObjectWithFile)

	T go(MethodObjectWithMedia methodObjectWithMedia)

	Map getDefaultParams()

	void setDefaultParams(Map params)
}
