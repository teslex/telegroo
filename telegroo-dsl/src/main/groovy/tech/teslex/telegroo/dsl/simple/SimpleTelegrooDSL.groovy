package tech.teslex.telegroo.dsl.simple

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 * © 2019 TesLex
 */

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.Telegroo
import tech.teslex.telegroo.api.context.MethodsContext
import tech.teslex.telegroo.dsl.api.CommandsDSL
import tech.teslex.telegroo.dsl.api.TelegrooDSL
import tech.teslex.telegroo.telegram.enums.UpdateType

@CompileStatic
class SimpleTelegrooDSL implements TelegrooDSL {

	private Telegroo telegroo

	SimpleTelegrooDSL(Telegroo telegroo) {
		this.telegroo = telegroo
	}

	@Override
	void update(UpdateType type, @DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(type, handler)
	}

	@Override
	void command(String command, @DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command(command, handler)
	}

	@Override
	void commands(@DelegatesTo(CommandsDSL.class) Closure closure) {
		SimpleCommandsDSL commandsDSL = new SimpleCommandsDSL(telegroo)
		closure.delegate = commandsDSL
		closure()
	}

	@Override
	void message(String message, @DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.message(message, handler)
	}

	@Override
	void update(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(handler)
	}

	@Override
	void message(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.message(handler)
	}

	@Override
	void editedMessage(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(UpdateType.EDITED_MESSAGE, handler)
	}

	@Override
	void channelPost(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(UpdateType.CHANNEL_POST, handler)
	}

	@Override
	void inlineQuery(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(UpdateType.INLINE_QUERY, handler)
	}

	@Override
	void chosenInlineResult(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(UpdateType.CHOSEN_INLINE_QUERY, handler)
	}

	@Override
	void callbackQuery(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(UpdateType.CALLBACK_QUERY, handler)
	}

	@Override
	void shippingQuery(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(UpdateType.SHIPPING_QUERY, handler)
	}

	@Override
	void preCheckoutQuery(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.update(UpdateType.PRE_CHECKOUT_QUERY, handler)
	}
}
