package tech.teslex.telegroo.api.update;

import tech.teslex.telegroo.telegram.types.update.Update;

import java.util.List;

public interface UpdateHandlersSolver {

	void solve(Update update, List<UpdateHandler> handlers);
}