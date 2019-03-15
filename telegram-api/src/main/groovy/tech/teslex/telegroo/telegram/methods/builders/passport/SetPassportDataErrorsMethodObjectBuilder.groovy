package tech.teslex.telegroo.telegram.methods.builders.passport

import groovy.transform.CompileStatic
import groovy.transform.builder.Builder
import groovy.transform.builder.ExternalStrategy
import tech.teslex.telegroo.telegram.methods.objects.passport.SetPassportDataErrorsMethodObject

@CompileStatic
@Builder(builderStrategy = ExternalStrategy, forClass = SetPassportDataErrorsMethodObject)
class SetPassportDataErrorsMethodObjectBuilder {}
