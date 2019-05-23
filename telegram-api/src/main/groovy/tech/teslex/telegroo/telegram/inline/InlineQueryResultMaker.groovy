package tech.teslex.telegroo.telegram.inline

import groovy.transform.NamedDelegate
import groovy.transform.NamedVariant
import tech.teslex.telegroo.telegram.api.types.inline.*

class InlineQueryResultMaker {

	static <T extends InlineQueryResult> T make(Class<T> type, @DelegatesTo(type = "T", strategy = Closure.DELEGATE_FIRST) Closure closure) {
		T t = type.newInstance()
		closure.delegate = t
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		t
	}

	static InlineQueryResultCachedAudio cachedAudio(@DelegatesTo(value = InlineQueryResultCachedAudio, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultCachedAudio q = new InlineQueryResultCachedAudio()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultCachedAudio cachedAudio(@NamedDelegate InlineQueryResultCachedAudio q) {
		q
	}


	static InlineQueryResultCachedDocument cachedDocument(@DelegatesTo(value = InlineQueryResultCachedDocument, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultCachedDocument q = new InlineQueryResultCachedDocument()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultCachedDocument cachedDocument(@NamedDelegate InlineQueryResultCachedDocument q) {
		q
	}


	static InlineQueryResultCachedGif cachedGif(@DelegatesTo(value = InlineQueryResultCachedGif, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultCachedGif q = new InlineQueryResultCachedGif()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultCachedGif cachedGif(@NamedDelegate InlineQueryResultCachedGif q) {
		q
	}


	static InlineQueryResultCachedMpeg4Gif cachedMpeg4Gif(@DelegatesTo(value = InlineQueryResultCachedMpeg4Gif, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultCachedMpeg4Gif q = new InlineQueryResultCachedMpeg4Gif()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultCachedMpeg4Gif cachedMpeg4Gif(@NamedDelegate InlineQueryResultCachedMpeg4Gif q) {
		q
	}


	static InlineQueryResultCachedPhoto cachedPhoto(@DelegatesTo(value = InlineQueryResultCachedPhoto, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultCachedPhoto q = new InlineQueryResultCachedPhoto()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultCachedPhoto cachedPhoto(@NamedDelegate InlineQueryResultCachedPhoto q) {
		q
	}


	static InlineQueryResultCachedSticker cachedSticker(@DelegatesTo(value = InlineQueryResultCachedSticker, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultCachedSticker q = new InlineQueryResultCachedSticker()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultCachedSticker cachedSticker(@NamedDelegate InlineQueryResultCachedSticker q) {
		q
	}


	static InlineQueryResultCachedVideo cachedVideo(@DelegatesTo(value = InlineQueryResultCachedVideo, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultCachedVideo q = new InlineQueryResultCachedVideo()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultCachedVideo cachedVideo(@NamedDelegate InlineQueryResultCachedVideo q) {
		q
	}


	static InlineQueryResultCachedVoice cachedVoice(@DelegatesTo(value = InlineQueryResultCachedVoice, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultCachedVoice q = new InlineQueryResultCachedVoice()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultCachedVoice cachedVoice(@NamedDelegate InlineQueryResultCachedVoice q) {
		q
	}


	static InlineQueryResultArticle article(@DelegatesTo(value = InlineQueryResultArticle, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultArticle q = new InlineQueryResultArticle()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultArticle article(@NamedDelegate InlineQueryResultArticle q) {
		q
	}


	static InlineQueryResultAudio audio(@DelegatesTo(value = InlineQueryResultAudio, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultAudio q = new InlineQueryResultAudio()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultAudio audio(@NamedDelegate InlineQueryResultAudio q) {
		q
	}


	static InlineQueryResultContact contact(@DelegatesTo(value = InlineQueryResultContact, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultContact q = new InlineQueryResultContact()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultContact contact(@NamedDelegate InlineQueryResultContact q) {
		q
	}


	static InlineQueryResultGame game(@DelegatesTo(value = InlineQueryResultGame, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultGame q = new InlineQueryResultGame()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultGame game(@NamedDelegate InlineQueryResultGame q) {
		q
	}


	static InlineQueryResultDocument document(@DelegatesTo(value = InlineQueryResultDocument, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultDocument q = new InlineQueryResultDocument()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultDocument document(@NamedDelegate InlineQueryResultDocument q) {
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
	static InlineQueryResultGif gif(@NamedDelegate InlineQueryResultGif q) {
		q
	}


	static InlineQueryResultLocation location(@DelegatesTo(value = InlineQueryResultLocation, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultLocation q = new InlineQueryResultLocation()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultLocation location(@NamedDelegate InlineQueryResultLocation q) {
		q
	}


	static InlineQueryResultMpeg4Gif mpeg4Gif(@DelegatesTo(value = InlineQueryResultMpeg4Gif, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultMpeg4Gif q = new InlineQueryResultMpeg4Gif()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultMpeg4Gif mpeg4Gif(@NamedDelegate InlineQueryResultMpeg4Gif q) {
		q
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


	static InlineQueryResultVenue venue(@DelegatesTo(value = InlineQueryResultVenue, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultVenue q = new InlineQueryResultVenue()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultVenue venue(@NamedDelegate InlineQueryResultVenue q) {
		q
	}


	static InlineQueryResultVideo video(@DelegatesTo(value = InlineQueryResultVideo, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultVideo q = new InlineQueryResultVideo()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultVideo video(@NamedDelegate InlineQueryResultVideo q) {
		q
	}


	static InlineQueryResultVoice voice(@DelegatesTo(value = InlineQueryResultVoice, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultVoice q = new InlineQueryResultVoice()
		closure.delegate = q
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
		q
	}

	@NamedVariant
	static InlineQueryResultVoice voice(@NamedDelegate InlineQueryResultVoice q) {
		q
	}

}
