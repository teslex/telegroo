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

@CompileStatic
class SimpleCommandsDSL implements CommandsDSL {

	private Telegroo telegroo

	SimpleCommandsDSL(Telegroo telegroo) {
		this.telegroo = telegroo
	}

	@Override
	void start(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('start', handler)
	}

	@Override
	void stop(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('stop', handler)
	}

	@Override
	void create(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('create', handler)
	}

	@Override
	void delete(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('delete', handler)
	}

	@Override
	void edit(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('edit', handler)
	}

	@Override
	void join(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('join', handler)
	}

	@Override
	void leave(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('leave', handler)
	}

	@Override
	void open(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('open', handler)
	}

	@Override
	void close(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('close', handler)
	}

	@Override
	void echo(@DelegatesTo(MethodsContext.class) Closure handler) {
		telegroo.command('echo', handler)
	}

	@Override
	def invokeMethod(String name, Object args) {
		telegroo.command(name, args as Closure)
	}
}
