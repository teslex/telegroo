package tech.teslex.telegroo.api

import groovy.transform.CompileStatic
import org.apache.http.client.fluent.Response
import tech.teslex.telegroo.telegram.methods.MethodObject
import tech.teslex.telegroo.telegram.methods.MethodObjectWithFile

@CompileStatic
interface Api {

	Response go(String method)

	Response go(String method, Map parameters)

	Response go(MethodObject methodObject)

	Response go(MethodObjectWithFile methodObjectWithFile)

//	Response goWithFile(String method, String type, File file, Map parameters)
//
//	Response goWithMedia(String method, String type, List<File> media, Map parameters)

	void setDefaultParams(Map params)

	Map getDefaultParams()
}
