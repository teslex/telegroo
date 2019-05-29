package tech.teslex.telegroo.example.annotation

import groovy.transform.AnnotationCollector
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j

import javax.inject.Singleton

@Slf4j
@Singleton
@CompileStatic
@AnnotationCollector
@interface Component {}