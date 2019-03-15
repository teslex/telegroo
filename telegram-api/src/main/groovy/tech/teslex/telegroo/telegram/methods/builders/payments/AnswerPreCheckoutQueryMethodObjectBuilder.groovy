package tech.teslex.telegroo.telegram.methods.builders.payments

import groovy.transform.CompileStatic
import groovy.transform.builder.Builder
import groovy.transform.builder.ExternalStrategy
import tech.teslex.telegroo.telegram.methods.objects.payments.AnswerPreCheckoutQueryMethodObject

@CompileStatic
@Builder(builderStrategy = ExternalStrategy, forClass = AnswerPreCheckoutQueryMethodObject)
class AnswerPreCheckoutQueryMethodObjectBuilder {}
