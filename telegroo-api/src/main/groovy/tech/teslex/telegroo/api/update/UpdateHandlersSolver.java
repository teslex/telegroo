/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * © 2019 TesLex
 */

package tech.teslex.telegroo.api.update;

import tech.teslex.telegroo.telegram.enums.UpdateType;
import tech.teslex.telegroo.telegram.types.update.Update;

import java.util.List;
import java.util.Map;

public interface UpdateHandlersSolver {

	void solveOne(Update update, Map<UpdateType, List<UpdateHandler>> handlers);

	default void solve(List<Update> updates, Map<UpdateType, List<UpdateHandler>> handlers) {
		updates.forEach(update -> solveOne(update, handlers));
	}
}