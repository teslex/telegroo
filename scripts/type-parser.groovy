String defaultText = """url\tString\tWebhook URL, may be empty if webhook is not set up
has_custom_certificate\tBoolean\tTrue, if a custom certificate was provided for webhook certificate checks
pending_update_count\tInteger\tNumber of updates awaiting delivery
last_error_date\tInteger\tOptional. Unix time for the most recent error that happened when trying to deliver an update via webhook
last_error_message\tString\tOptional. Error message in human-readable format for the most recent error that happened when trying to deliver an update via webhook
max_connections\tInteger\tOptional. Maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery
allowed_updates\tArray of String\tOptional. A list of update types the bot is subscribed to. Defaults to all update types
"""

String text = args ? args[0] : defaultText

String withNothing(String name, String type, String description) {
	"""\
/**
* $description  
*/
${type} ${name}
"""
}

String withUnderscore(String name, String type, String description) {
	"""\
/**
* $description
*/
@JsonProperty(value = '${name}')
${type} ${ununderscore(name)}
"""
}

String withOptional(String name, String type, String description) {
	"""\
/**
* $description
*/
@JsonProperty(required = false)
${type} ${name}
"""
}

String withUnderscoreAndOptional(String name, String type, String description) {
	"""\
/**
* $description
*/
@JsonProperty(value = '${name}', required = false)
${type} ${ununderscore(name)}
"""
}

String ununderscore(String some) {
	def splited = some.split('_').toList()
	def camelCasedLast = splited.stream().skip(1).collect { "${it[0].toUpperCase()}${it.substring(1)}" }.join('')
	return "${splited[0]}${camelCasedLast}"
}


parsed = text.split('\n')*.split('\t')

replaced = parsed.collect {
	if (it[0].indexOf('_') > 1) {
		if (it[2].startsWith('Optional. ')) {
			withUnderscoreAndOptional(it[0], it[1], it[2])
		} else {
			withUnderscore(it[0], it[1], it[2])
		}
	} else {
		if (it[2].startsWith('Optional. ')) {
			withOptional(it[0], it[1], it[2])
		} else {
			withNothing(it[0], it[1], it[2])
		}
	}
}

println replaced.join('\n')