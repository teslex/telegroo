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

package tech.teslex.telegroo.api.context;

import tech.teslex.telegroo.api.client.TelegramClient;
import tech.teslex.telegroo.api.methods.DefaultDefaultGetUpdatesMethod;
import tech.teslex.telegroo.api.methods.DefaultSendMessageMethod;
import tech.teslex.telegroo.telegram.api.types.update.Update;

/**
 * Context
 */
public interface Context extends
		DefaultDefaultGetUpdatesMethod,
		DefaultSendMessageMethod {

	/**
	 * Returns {@link Update} of the context
	 *
	 * @return context update
	 */
	Update getCurrentUpdate();

	/**
	 * Returns {@link TelegramClient} of the context
	 *
	 * @return telegram client
	 */
	TelegramClient getTelegramClient();

	/**
	 * Returns instance of this context
	 *
	 * @return {@literal this}
	 */
	@Override
	default Context getContext() {
		return this;
	}
}