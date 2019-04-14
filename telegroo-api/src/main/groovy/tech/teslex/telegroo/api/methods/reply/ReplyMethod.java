package tech.teslex.telegroo.api.methods.reply;

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

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import tech.teslex.telegroo.api.context.MethodsContext;

public interface ReplyMethod {

	void reply(Object replyTo, Closure closure);

	void reply(@DelegatesTo(MethodsContext.class) Closure closure);

	MethodsContext reply(Object replyTo);

	MethodsContext reply();
}