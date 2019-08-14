package tech.teslex.telegroo.simple.methods;

import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.api.methods.Methods;

public class SimpleMethods implements Methods {

	private final Context context;

	public SimpleMethods(Context context) {
		this.context = context;
	}

	@Override
	public Context getContext() {
		return context;
	}
}
