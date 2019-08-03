package tech.teslex.telegroo.telegram.api.methods.interfaces;

import tech.teslex.telegroo.telegram.api.methods.objects.SendAnimation;

import java.util.Map;
import java.util.function.Consumer;

public interface SendAnimationMethod<R> {

	R sendAnimation(Map data);

	R sendAnimation(SendAnimation data);

	R sendAnimation(Consumer<SendAnimation.SendAnimationBuilder> data);
}
