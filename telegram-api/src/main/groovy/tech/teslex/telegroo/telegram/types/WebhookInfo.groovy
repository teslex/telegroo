package tech.teslex.telegroo.telegram.types

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import groovy.transform.CompileStatic
import groovy.transform.Canonical

/**
 * Contains information about the current status of a webhook.
 */
@Canonical
@CompileStatic
@JsonInclude(JsonInclude.Include.NON_NULL)
class WebhookInfo {

	/**
	 * Webhook URL, may be empty if webhook is not set up
	 */
	String url

	/**
	 * True, if a custom certificate was provided for webhook certificate checks
	 */
	@JsonProperty(value = 'has_custom_certificate')
	Boolean hasCustomCertificate

	/**
	 * Number of updates awaiting delivery
	 */
	@JsonProperty(value = 'pending_update_count')
	Integer pendingUpdateCount

	/**
	 * Optional. Unix time for the most recent error that happened when trying to deliver an update via webhook
	 */
	@JsonProperty(value = 'last_error_date', required = false)
	Integer lastErrorDate

	/**
	 * Optional. Error message in human-readable format for the most recent error that happened when trying to deliver an update via webhook
	 */
	@JsonProperty(value = 'last_error_message', required = false)
	String lastErrorMessage

	/**
	 * Optional. Maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery
	 */
	@JsonProperty(value = 'max_connections', required = false)
	Integer maxConnections

	/**
	 * Optional. A list of update types the bot is subscribed to. Defaults to all update types
	 */
	@JsonProperty(value = 'allowed_updates', required = false)
	List<String> allowedUpdates
}
