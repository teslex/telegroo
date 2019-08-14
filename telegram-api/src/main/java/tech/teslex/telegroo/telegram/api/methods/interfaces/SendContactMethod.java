package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SendContact;

import java.util.Map;
import java.util.function.Consumer;

public interface SendContactMethod<R> {

	R sendContact(Map data);

	R sendContact(SendContact data);

	R sendContact(Consumer<SendContact> data);
}
