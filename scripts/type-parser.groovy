String defaultText = """id\tString\tUnique poll identifier
question\tString\tPoll question, 1-255 characters
options\tArray of PollOption\tList of poll options
is_closed\tBoolean\tTrue, if the poll is closed
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