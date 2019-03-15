package tech.teslex.telegroo.telegram.methods.objects.webhook

import com.fasterxml.jackson.annotation.JsonIgnore
import groovy.transform.CompileStatic
import tech.teslex.telegroo.telegram.methods.MethodObject

/**
 * deleteWebhook
 * Use this method to remove webhook integration if you decide to switch back to getUpdates. Returns True on success. Requires no parameters.
 */
@CompileStatic
class DeleteWebhookMethodObject implements MethodObject {

	@Override
	@JsonIgnore
	String getPathMethod() {
		'deleteWebhook'
	}
}
