package tech.teslex.telegroo.telegram.inline

import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.types.inline.*

class InlineQueryResultMaker {

	static <T extends InlineQueryResult> T make(Class<T> type, @DelegatesTo(type = "T", strategy = Closure.DELEGATE_FIRST) Closure closure) {
		T t = type.newInstance()
		closure.delegate = t
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		t
	}


	static InlineQueryResultPhoto photo(@DelegatesTo(value = InlineQueryResultPhoto, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultPhoto q = new InlineQueryResultPhoto()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultPhoto photo(@NamedDelegate InlineQueryResultPhoto q) {
		q
	}

	static InlineQueryResultCachedPhoto cachedPhoto(@DelegatesTo(value = InlineQueryResultCachedPhoto, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultCachedPhoto q = new InlineQueryResultCachedPhoto()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	static InlineQueryResultGif gif(@DelegatesTo(value = InlineQueryResultGif, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultGif q = new InlineQueryResultGif()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultCachedGif gif(@NamedDelegate InlineQueryResultCachedGif q) {
		q
	}


	// todo: implement all
}
