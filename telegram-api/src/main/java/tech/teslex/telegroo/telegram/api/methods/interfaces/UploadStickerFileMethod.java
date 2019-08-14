package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.UploadStickerFile;

import java.util.Map;
import java.util.function.Consumer;

public interface UploadStickerFileMethod<R> {

	R uploadStickerFile(Map data);

	R uploadStickerFile(UploadStickerFile data);

	R uploadStickerFile(Consumer<UploadStickerFile> data);
}
