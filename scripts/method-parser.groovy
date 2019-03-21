String defaultText = """user_id\tInteger\tYes\tTarget user id
chat_id\tInteger\tOptional\tRequired if inline_message_id is not specified. Unique identifier for the target chat
message_id\tInteger\tOptional\tRequired if inline_message_id is not specified. Identifier of the sent message
inline_message_id\tString\tOptional\tRequired if chat_id and message_id are not specified. Identifier of the inline message
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