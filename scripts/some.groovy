def makes = [
		'InlineQueryResultCachedAudio',
		'InlineQueryResultCachedDocument',
		'InlineQueryResultCachedGif',
		'InlineQueryResultCachedMpeg4Gif',
		'InlineQueryResultCachedPhoto',
		'InlineQueryResultCachedSticker',
		'InlineQueryResultCachedVideo', 'InlineQueryResultCachedVoice', 'InlineQueryResultArticle', 'InlineQueryResultAudio', 'InlineQueryResultContact', 'InlineQueryResultGame', 'InlineQueryResultDocument', 'InlineQueryResultGif', 'InlineQueryResultLocation', 'InlineQueryResultMpeg4Gif', 'InlineQueryResultPhoto', 'InlineQueryResultVenue', 'InlineQueryResultVideo', 'InlineQueryResultVoice'
]

def getMethodName = { String make ->
	make.substring(17, make.length()).with {
		it[0].toLowerCase() + it.substring(1, it.length())
	}
}

def printMake = { String make ->
	println """\
static $make ${getMethodName(make)}(@DelegatesTo(value = $make, strategy = Closure.DELEGATE_FIRST) Closure closure) {
\t\t$make q = new $make()
\t\tclosure.delegate = q
\t\tclosure.resolveStrategy = Closure.DELEGATE_FIRST
\t\tclosure()
\t\tq
\t}

\t@NamedVariant
\tstatic $make ${getMethodName(make)}(@NamedDelegate $make q) {
\t\tq
\t}
"""
}


makes.each {
	println("\n\n")
	printMake(it)
}