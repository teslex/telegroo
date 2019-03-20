package tech.teslex.telegroo.telegram.methods.interfaces.payments;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.methods.objects.payments.SendInvoiceMethodObject;

import java.util.Map;

public interface SendInvoiceMethod<R> {

	R sendInvoice(Map data);

	@NamedVariant
	R sendInvoice(@NamedDelegate SendInvoiceMethodObject data);

	R sendInvoice(@DelegatesTo(SendInvoiceMethodObject.class) Closure closure);
}