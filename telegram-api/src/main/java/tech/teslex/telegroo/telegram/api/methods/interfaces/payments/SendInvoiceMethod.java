package tech.teslex.telegroo.telegram.api.methods.interfaces.payments;

import tech.teslex.telegroo.telegram.api.methods.objects.payments.SendInvoice;

import java.util.Map;
import java.util.function.Consumer;

public interface SendInvoiceMethod<R> {

	R sendInvoice(Map data);

	R sendInvoice(SendInvoice data);

	R sendInvoice(Consumer<SendInvoice> data);
}
