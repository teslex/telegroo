package tech.teslex.telegroo.telegram.methods.builders

import groovy.transform.CompileStatic
import groovy.transform.builder.Builder
import groovy.transform.builder.ExternalStrategy
import tech.teslex.telegroo.telegram.methods.objects.UploadStickerFileMethodObject

@CompileStatic
@Builder(builderStrategy = ExternalStrategy, forClass = UploadStickerFileMethodObject)
class UploadStickerFileMethodObjectBuilder {}
