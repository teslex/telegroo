package tech.teslex.telegroo.api;

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

import tech.teslex.telegroo.telegram.methods.MethodObject;
import tech.teslex.telegroo.telegram.methods.MethodObjectWithFile;
import tech.teslex.telegroo.telegram.methods.MethodObjectWithMedia;

import java.util.Map;

/**
 * TelegramClient
 * @param <T>
 */
public interface TelegramClient<T> {

	T go(String method, Map parameters);

	T go(MethodObject methodObject);

	T go(MethodObjectWithFile methodObjectWithFile);

	T go(MethodObjectWithMedia methodObjectWithMedia);

	Map getDefaultParams();

	void setDefaultParams(Map params);
}
