package tech.teslex.telegroo.telegram.methods.objects

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.MapConstructor
import groovy.transform.ToString
import tech.teslex.telegroo.telegram.enums.UpdateType
import tech.teslex.telegroo.telegram.methods.MethodObject

@ToString
@MapConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@CompileStatic
class GetUpdatesMethodObject implements MethodObject {

	Integer offset

	Integer limit

	Integer timeout

	@JsonProperty(value = 'allowed_updates', required = false)
	List<UpdateType> allowedUpdates

	GetUpdatesMethodObject() { super() }

	@JsonIgnore
	String pathMethod = 'getUpdates'
}
