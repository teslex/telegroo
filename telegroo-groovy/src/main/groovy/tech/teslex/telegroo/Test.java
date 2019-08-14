package tech.teslex.telegroo;

import lombok.extern.slf4j.Slf4j;
import tech.teslex.telegroo.api.PollingTelegroo;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.api.methods.Methods;
import tech.teslex.telegroo.api.update.UpdateListener;
import tech.teslex.telegroo.simple.SimplePollingTelegroo;
import tech.teslex.telegroo.telegram.api.methods.objects.SendMediaGroup;
import tech.teslex.telegroo.telegram.api.methods.objects.SendMessage;
import tech.teslex.telegroo.telegram.api.methods.objects.SendPhoto;
import tech.teslex.telegroo.telegram.api.types.input.InputMedia;
import tech.teslex.telegroo.telegram.attach.Attach;
import tech.teslex.telegroo.telegram.attach.Media;

import java.util.List;

@Slf4j
public class Test {

	private final static PollingTelegroo telegroo = new SimplePollingTelegroo("531557312:AAHWld_ahP04ijdY5XPYEuFzZ8co1xSjGzo");

	public static void main(String[] args) {
		final List<InputMedia> mediaList = List.of(
//				Media.photo(new File("/home/exp/Projects/teslex/telegroo/telegroo/telegroo/src/main/resources/CAGK4xZfg_M.jpg")),
				Media.photo(Attach.byUrl("http://assets.gitlab-static.net/uploads/-/system/group/avatar/1593121/CAGK4xZfg_M.jpg")),
				Media.photo(Attach.byUrl("http://assets.gitlab-static.net/uploads/-/system/group/avatar/1593121/CAGK4xZfg_M.jpg"))
		);

//		telegroo.listen(res -> res.reply(SendMessage.create().text("none")));

		//		new File("/home/exp/Projects/teslex/telegroo/telegroo/telegroo/src/main/resources/CAGK4xZfg_M.jpg")
		telegroo.listenMessage("photo", (context, methods) -> methods.sendPhoto(SendPhoto.create().photo(Attach.byUrl("http://assets.gitlab-static.net/uploads/-/system/group/avatar/1593121/CAGK4xZfg_M.jpg"))));
		telegroo.listenCommand("echo", (context, methods) -> methods.sendMessage(SendMessage.create().text(context.getArgsText())));
		telegroo.listenMessage("media", (context, methods) -> methods.sendMediaGroup(SendMediaGroup.create().media(mediaList)));

		telegroo.methods().sendMessage("@expexes", telegroo.methods().getMe().toString());

		telegroo.startPolling();
	}

	private static class Listener implements UpdateListener<Context> {

		@Override
		public void onUpdate(Context context, Methods methods) {
			System.out.println(methods.getMe());
		}
	}

//	/**
//	 * SendMessage Factory
//	 *
//	 * @see tech.teslex.telegroo.telegram.api.methods.objects.SendMessage
//	 */
//	private static class SendMessage {
//
//		public static tech.teslex.telegroo.telegram.api.methods.objects.SendMessage chatId(Object chatId) {
//			final var method = new tech.teslex.telegroo.telegram.api.methods.objects.SendMessage();
//			method.setChatId(chatId);
//			return method;
//		}
//	}
}