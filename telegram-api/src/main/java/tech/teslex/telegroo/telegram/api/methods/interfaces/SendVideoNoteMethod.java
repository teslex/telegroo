package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SendVideoNote;

import java.util.Map;
import java.util.function.Consumer;

public interface SendVideoNoteMethod<R> {

	R sendVideoNote(Map data);

	R sendVideoNote(SendVideoNote data);

	R sendVideoNote(Consumer<SendVideoNote.SendVideoNoteBuilder> data);
}
