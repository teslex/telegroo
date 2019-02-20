package tech.teslex.telegroo.api.update

import tech.teslex.telegroo.api.Context
import tech.teslex.telegroo.api.Telegroo

import java.util.regex.Matcher

interface UpdateRes {

	Update getUpdate()

	Context getContext()

	Matcher getMatcher()

	Telegroo getTelegroo()
}
