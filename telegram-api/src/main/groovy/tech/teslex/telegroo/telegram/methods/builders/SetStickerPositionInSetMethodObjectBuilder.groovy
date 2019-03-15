package tech.teslex.telegroo.telegram.methods.builders

import groovy.transform.CompileStatic
import groovy.transform.builder.Builder
import groovy.transform.builder.ExternalStrategy
import tech.teslex.telegroo.telegram.methods.objects.SetStickerPositionInSetMethodObject

@CompileStatic
@Builder(builderStrategy = ExternalStrategy, forClass = SetStickerPositionInSetMethodObject)
class SetStickerPositionInSetMethodObjectBuilder {}
