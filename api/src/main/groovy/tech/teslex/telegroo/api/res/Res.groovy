package tech.teslex.telegroo.api.res

import tech.teslex.telegroo.api.Context
import tech.teslex.telegroo.api.Telegroo
import tech.teslex.telegroo.api.update.Update

import java.util.regex.Matcher

interface Res {

	Update getUpdate()

	Context getContext()

	Matcher getMatcher()

	Telegroo getTelegroo()
}
