String defaultText = """url\tString\tYes\tHTTPS url to send updates to. Use an empty string to remove webhook integration
certificate\tInputFile\tOptional\tUpload your public key certificate so that the root certificate in use can be checked. See our self-signed guide for details.
max_connections\tInteger\tOptional\tMaximum allowed number of simultaneous HTTPS connections to the webhook for update delivery, 1-100. Defaults to 40. Use lower values to limit the load on your bot‘s server, and higher values to increase your bot’s throughput.
allowed_updates\tArray of String\tOptional\tList the types of updates you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See Update for a complete list of available update types. Specify an empty list to receive all updates regardless of type (default). If not specified, the previous setting will be used.
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

String withUnderscoreAndRequired(String name, String type, String description) {
	"""\
/**
* $description
*/
@JsonProperty(value = '${name}', required = true)
${type} ${ununderscore(name)}
"""
}

String withRequired(String name, String type, String description) {
	"""\
/**
* $description
*/
@JsonProperty(required = true)
${type} ${name}
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
		if (it[2].startsWith('Optional')) {
			withUnderscoreAndOptional(it[0], it[1], it[3])
		} else if (it[2].startsWith('Yes')) {
			withUnderscoreAndRequired(it[0], it[1], it[3])
		} else {
			withUnderscore(it[0], it[1], it[3])
		}
	} else {
		if (it[2].startsWith('Optional')) {
			withOptional(it[0], it[1], it[3])
		} else if (it[2].startsWith('Yes')) {
			withRequired(it[0], it[1], it[3])
		} else {
			withNothing(it[0], it[1], it[3])
		}
	}
}

println replaced.join('\n')