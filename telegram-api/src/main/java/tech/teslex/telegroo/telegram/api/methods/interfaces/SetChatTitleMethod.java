package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SetChatTitle;

import java.util.Map;
import java.util.function.Consumer;

public interface SetChatTitleMethod<R> {

	R setChatTitle(Map data);

	R setChatTitle(SetChatTitle data);

	R setChatTitle(Consumer<SetChatTitle> data);
}
