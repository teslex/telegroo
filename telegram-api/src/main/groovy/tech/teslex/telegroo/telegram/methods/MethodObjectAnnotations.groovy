package tech.teslex.telegroo.telegram.methods

import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.AnnotationCollector
import groovy.transform.Canonical
import groovy.transform.CompileStatic
import groovy.transform.builder.Builder

@Builder
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
@AnnotationCollector([Canonical])
@interface MethodObjectAnnotations {}