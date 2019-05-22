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

package tech.teslex.telegroo.simple.update.closure

import groovy.transform.CompileStatic
import tech.teslex.telegroo.simple.context.SimpleMethodsContext
import tech.teslex.telegroo.simple.update.SimpleUpdateHandler
import tech.teslex.telegroo.telegram.enums.UpdateType

@CompileStatic
class SimpleClosureUpdateHandler implements SimpleUpdateHandler {

	final UpdateType updateType

	final Closure closure

	SimpleClosureUpdateHandler(Closure closure) {
		this.updateType = UpdateType.UPDATE
		this.closure = closure
	}

	SimpleClosureUpdateHandler(UpdateType updateType, Closure closure) {
		this.updateType = updateType
		this.closure = closure
	}

	@Override
	void handle(SimpleMethodsContext context) {
		closure.delegate = context
		closure.resolveStrategy = Closure.DELEGATE_FIRST
		closure()
	}
}
