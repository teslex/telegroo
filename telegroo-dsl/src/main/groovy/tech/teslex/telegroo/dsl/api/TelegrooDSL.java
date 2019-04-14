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

package tech.teslex.telegroo.dsl.api;

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import tech.teslex.telegroo.api.context.MethodsContext;
import tech.teslex.telegroo.dsl.api.CommandsDSL;
import tech.teslex.telegroo.telegram.enums.UpdateType;

public interface TelegrooDSL {

	void update(UpdateType type, @DelegatesTo(MethodsContext.class) Closure handler);

	void command(String command, @DelegatesTo(MethodsContext.class) Closure handler);

	void commands(@DelegatesTo(CommandsDSL.class) Closure closure);

	void message(String message, @DelegatesTo(MethodsContext.class) Closure handler);


	void update(@DelegatesTo(MethodsContext.class) Closure handler);

	void message(@DelegatesTo(MethodsContext.class) Closure handler);

	void editedMessage(@DelegatesTo(MethodsContext.class) Closure handler);

	void channelPost(@DelegatesTo(MethodsContext.class) Closure handler);

	void inlineQuery(@DelegatesTo(MethodsContext.class) Closure handler);

	void chosenInlineResult(@DelegatesTo(MethodsContext.class) Closure handler);

	void callbackQuery(@DelegatesTo(MethodsContext.class) Closure handler);

	void shippingQuery(@DelegatesTo(MethodsContext.class) Closure handler);

	void preCheckoutQuery(@DelegatesTo(MethodsContext.class) Closure handler);
}
