String defaultText = """result_id\tString\tThe unique identifier for the result that was chosen
from\tUser\tThe user that chose the result
location\tLocation\tOptional. Sender location, only for bots that require user location
inline_message_id\tString\tOptional. Identifier of the sent inline message. Available only if there is an inline keyboard attached to the message. Will be also received in callback queries and can be used to edit the message.
query\tString\tThe query that was used to obtain the result
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