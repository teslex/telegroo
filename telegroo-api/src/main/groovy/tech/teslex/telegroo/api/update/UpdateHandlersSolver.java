package tech.teslex.telegroo.api.update;

import tech.teslex.telegroo.telegram.enums.UpdateType;
import tech.teslex.telegroo.telegram.types.update.Update;

import java.util.List;
import java.util.Map;

public interface UpdateHandlersSolver {

	void solve(Update update, Map<UpdateType, List<UpdateHandler>> handlers);
}