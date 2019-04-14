package tech.teslex.telegroo.dsl

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
import tech.teslex.telegroo.dsl.api.TelegrooDSL
import tech.teslex.telegroo.dsl.simple.SimpleTelegrooDSL

@CompileStatic
class TDSL {

	static forBot(Telegroo telegroo, @DelegatesTo(TelegrooDSL) Closure closure) {
		SimpleTelegrooDSL telegrooDSL = new SimpleTelegrooDSL(telegroo)
		closure.delegate = telegrooDSL
		closure()
	}

	protected static fromText(Telegroo telegroo, String text) {
		// todo: implement it
	}
}
