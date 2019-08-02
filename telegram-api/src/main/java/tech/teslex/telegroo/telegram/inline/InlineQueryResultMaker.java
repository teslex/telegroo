package tech.teslex.telegroo.telegram.inline;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import tech.teslex.telegroo.telegram.api.types.inline.*;

import java.util.Map;

public class InlineQueryResultMaker {
//	public static <T extends InlineQueryResult> T make(Class<T> type, @DelegatesTo(type = "T", strategy = Closure.DELEGATE_FIRST) Closure closure) {
//		T t = type.newInstance();
//		closure.setDelegate(t);
//		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
//		closure.call();
//		return t;
//	}

	public static InlineQueryResultCachedAudio cachedAudio(@DelegatesTo(value = InlineQueryResultCachedAudio.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultCachedAudio q = new InlineQueryResultCachedAudio();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultCachedAudio cachedAudio(InlineQueryResultCachedAudio q) {
		return q;
	}

	public static InlineQueryResultCachedDocument cachedDocument(@DelegatesTo(value = InlineQueryResultCachedDocument.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultCachedDocument q = new InlineQueryResultCachedDocument();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultCachedDocument cachedDocument(InlineQueryResultCachedDocument q) {
		return q;
	}

	public static InlineQueryResultCachedGif cachedGif(@DelegatesTo(value = InlineQueryResultCachedGif.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultCachedGif q = new InlineQueryResultCachedGif();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultCachedGif cachedGif(InlineQueryResultCachedGif q) {
		return q;
	}

	public static InlineQueryResultCachedMpeg4Gif cachedMpeg4Gif(@DelegatesTo(value = InlineQueryResultCachedMpeg4Gif.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultCachedMpeg4Gif q = new InlineQueryResultCachedMpeg4Gif();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultCachedMpeg4Gif cachedMpeg4Gif(InlineQueryResultCachedMpeg4Gif q) {
		return q;
	}

	public static InlineQueryResultCachedPhoto cachedPhoto(@DelegatesTo(value = InlineQueryResultCachedPhoto.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultCachedPhoto q = new InlineQueryResultCachedPhoto();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultCachedPhoto cachedPhoto(InlineQueryResultCachedPhoto q) {
		return q;
	}

	public static InlineQueryResultCachedSticker cachedSticker(@DelegatesTo(value = InlineQueryResultCachedSticker.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultCachedSticker q = new InlineQueryResultCachedSticker();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultCachedSticker cachedSticker(InlineQueryResultCachedSticker q) {
		return q;
	}

	public static InlineQueryResultCachedVideo cachedVideo(@DelegatesTo(value = InlineQueryResultCachedVideo.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultCachedVideo q = new InlineQueryResultCachedVideo();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultCachedVideo cachedVideo(InlineQueryResultCachedVideo q) {
		return q;
	}

	public static InlineQueryResultCachedVoice cachedVoice(@DelegatesTo(value = InlineQueryResultCachedVoice.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultCachedVoice q = new InlineQueryResultCachedVoice();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultCachedVoice cachedVoice(InlineQueryResultCachedVoice q) {
		return q;
	}

	public static InlineQueryResultArticle article(@DelegatesTo(value = InlineQueryResultArticle.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultArticle q = new InlineQueryResultArticle();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultArticle article(InlineQueryResultArticle q) {
		return q;
	}

	public static InlineQueryResultAudio audio(@DelegatesTo(value = InlineQueryResultAudio.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultAudio q = new InlineQueryResultAudio();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultAudio audio(InlineQueryResultAudio q) {
		return q;
	}

	public static InlineQueryResultContact contact(@DelegatesTo(value = InlineQueryResultContact.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultContact q = new InlineQueryResultContact();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultContact contact(InlineQueryResultContact q) {
		return q;
	}

	public static InlineQueryResultGame game(@DelegatesTo(value = InlineQueryResultGame.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultGame q = new InlineQueryResultGame();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultGame game(InlineQueryResultGame q) {
		return q;
	}

	public static InlineQueryResultDocument document(@DelegatesTo(value = InlineQueryResultDocument.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultDocument q = new InlineQueryResultDocument();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultDocument document(InlineQueryResultDocument q) {
		return q;
	}

	public static InlineQueryResultGif gif(@DelegatesTo(value = InlineQueryResultGif.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultGif q = new InlineQueryResultGif();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultGif gif(InlineQueryResultGif q) {
		return q;
	}

	public static InlineQueryResultLocation location(@DelegatesTo(value = InlineQueryResultLocation.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultLocation q = new InlineQueryResultLocation();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultLocation location(InlineQueryResultLocation q) {
		return q;
	}

	public static InlineQueryResultMpeg4Gif mpeg4Gif(@DelegatesTo(value = InlineQueryResultMpeg4Gif.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultMpeg4Gif q = new InlineQueryResultMpeg4Gif();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultMpeg4Gif mpeg4Gif(InlineQueryResultMpeg4Gif q) {
		return q;
	}

	public static InlineQueryResultPhoto photo(@DelegatesTo(value = InlineQueryResultPhoto.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultPhoto q = new InlineQueryResultPhoto();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultPhoto photo(InlineQueryResultPhoto q) {
		return q;
	}

	public static InlineQueryResultVenue venue(@DelegatesTo(value = InlineQueryResultVenue.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultVenue q = new InlineQueryResultVenue();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultVenue venue(InlineQueryResultVenue q) {
		return q;
	}

	public static InlineQueryResultVideo video(@DelegatesTo(value = InlineQueryResultVideo.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultVideo q = new InlineQueryResultVideo();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultVideo video(InlineQueryResultVideo q) {
		return q;
	}

	public static InlineQueryResultVoice voice(@DelegatesTo(value = InlineQueryResultVoice.class, strategy = Closure.DELEGATE_FIRST) Closure closure) {
		InlineQueryResultVoice q = new InlineQueryResultVoice();
		closure.setDelegate(q);
		closure.setResolveStrategy(Closure.DELEGATE_FIRST);
		closure.call();
		return q;
	}

	public static InlineQueryResultVoice voice(InlineQueryResultVoice q) {
		return q;
	}

}
