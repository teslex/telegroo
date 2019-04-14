String defaultText = """question\tString\tYes\tPoll question, 1-255 characters
options\tArray of String\tYes\tList of answer options, 2-10 strings 1-100 characters each
disable_notification\tBoolean\tOptional\tSends the message silently. Users will receive a notification with no sound.
reply_to_message_id\tInteger\tOptional\tIf the message is a reply, ID of the original message"""

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