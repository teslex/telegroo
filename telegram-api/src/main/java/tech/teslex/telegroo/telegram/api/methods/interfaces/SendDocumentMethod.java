package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SendDocument;

import java.util.Map;
import java.util.function.Consumer;

public interface SendDocumentMethod<R> {

	R sendDocument(Map data);

	R sendDocument(SendDocument data);

	R sendDocument(Consumer<SendDocument> data);
}
