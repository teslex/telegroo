package tech.teslex.telegroo.telegram

import com.fasterxml.jackson.annotation.JsonInclude
import groovy.transform.AnnotationCollector
import groovy.transform.Canonical
import groovy.transform.CompileStatic

@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
@AnnotationCollector([Canonical])
@interface TypeAnnotations {}