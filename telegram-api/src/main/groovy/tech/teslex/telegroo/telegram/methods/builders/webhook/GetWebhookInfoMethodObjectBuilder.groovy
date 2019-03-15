package tech.teslex.telegroo.telegram.methods.builders.webhook

import groovy.transform.CompileStatic
import groovy.transform.builder.Builder
import groovy.transform.builder.ExternalStrategy
import tech.teslex.telegroo.telegram.methods.objects.webhook.GetWebhookInfoMethodObject

@CompileStatic
@Builder(builderStrategy = ExternalStrategy, forClass = GetWebhookInfoMethodObject)
class GetWebhookInfoMethodObjectBuilder {}
