package tech.teslex.telegroo.telegram.types.games

import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.Canonical
import groovy.transform.CompileStatic
import groovy.transform.ToString

@Canonical
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class CallbackGame {}
