String defaultText = """point\tString\tThe part of the face relative to which the mask should be placed. One of “forehead”, “eyes”, “mouth”, or “chin”.
x_shift\tFloat number\tShift by X-axis measured in widths of the mask scaled to the face size, from left to right. For example, choosing -1.0 will place mask just to the left of the default mask position.
y_shift\tFloat number\tShift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom. For example, 1.0 will place the mask just below the default mask position.
scale\tFloat number\tMask scaling coefficient. For example, 2.0 means double size.
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