package tech.teslex.telegroo.telegram.methods.interfaces;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.UploadStickerFileMethodObject;

import java.util.Map;

public interface UploadStickerFileMethod<R> {

	R uploadStickerFile(Map data);

	@NamedVariant
	R uploadStickerFile(@NamedDelegate UploadStickerFileMethodObject data);

	R uploadStickerFile(@DelegatesTo(value = UploadStickerFileMethodObject.class, strategy = Closure.DELEGATE_FIRST) Closure closure);
}
