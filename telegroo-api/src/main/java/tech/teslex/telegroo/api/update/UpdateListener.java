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

import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.api.methods.defaults.Methods;
import tech.teslex.telegroo.telegram.enums.UpdateType;

import java.util.EventListener;

public interface UpdateListener<C extends Context> extends EventListener {

	void onUpdate(C context, Methods methods);

	default UpdateType getType() {
		return UpdateType.UPDATE;
	}
}