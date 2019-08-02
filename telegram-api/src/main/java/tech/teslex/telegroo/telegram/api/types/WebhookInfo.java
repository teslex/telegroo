package tech.teslex.telegroo.telegram.api.types;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * Contains information about the current status of a webhook.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WebhookInfo {
	/**
	 * Webhook URL, may be empty if webhook is not set up
	 */
	private String url;
	/**
	 * True, if a custom certificate was provided for webhook certificate checks
	 */
	@JsonProperty(value = "has_custom_certificate")
	private Boolean hasCustomCertificate;
	/**
	 * Number of updates awaiting delivery
	 */
	@JsonProperty(value = "pending_update_count")
	private Integer pendingUpdateCount;
	/**
	 * Optional. Unix time for the most recent error that happened when trying to deliver an update via webhook
	 */
	@JsonProperty(value = "last_error_date", required = false)
	private Integer lastErrorDate;
	/**
	 * Optional. Error message in human-readable format for the most recent error that happened when trying to deliver an update via webhook
	 */
	@JsonProperty(value = "last_error_message", required = false)
	private String lastErrorMessage;
	/**
	 * Optional. Maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery
	 */
	@JsonProperty(value = "max_connections", required = false)
	private Integer maxConnections;
	/**
	 * Optional. A list of update types the bot is subscribed to. Defaults to all update types
	 */
	@JsonProperty(value = "allowed_updates", required = false)
	private List<String> allowedUpdates;
}
