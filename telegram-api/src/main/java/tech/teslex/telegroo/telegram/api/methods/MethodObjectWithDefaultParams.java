package tech.teslex.telegroo.telegram.api.methods;

import com.fasterxml.jackson.annotation.JsonIgnore;
import tech.teslex.telegroo.telegram.api.types.update.Update;

public interface MethodObjectWithDefaultParams extends MethodObject {

	/**
	 * Sets values from update if not specified.
	 * <p>
	 * Example from {@link tech.teslex.telegroo.telegram.api.methods.objects.SendMessage}:
	 * <pre>
	 *     {@literal @}Override
	 *     void useDefault(Update update) {
	 *         if (this.getChatId() == null)
	 *             this.setChatId(update.getMessage().getChat().getId());
	 *     }
	 * </pre>
	 *
	 * @param update update
	 */
	@JsonIgnore
	void useDefault(Update update);
}
