package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.GetFile;

import java.util.Map;
import java.util.function.Consumer;

public interface GetFileMethod<R> {

	R getFile(Map data);

	R getFile(GetFile data);

	R getFile(Consumer<GetFile.GetFileBuilder> data);
}
