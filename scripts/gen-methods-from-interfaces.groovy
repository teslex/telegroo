path = "/home/exp/Projects/teslex/telegroo/telegroo"

additionPath = "games"

methodsPath = "$path/telegram-api/src/main/java/tech/teslex/telegroo/telegram/api/methods/interfaces/$additionPath" as File
interfacesPath = "$path/telegroo-api/src/main/java/tech/teslex/telegroo/api/methods/$additionPath" as File

methodsPath.listFiles().findAll { it.isFile() }.each { File file ->

	String fileName = file.name.substring(0, file.name.length() - 5)

	println "resolving $fileName"

	Closure<String> template = { String clazz ->
		"""\
package tech.teslex.telegroo.api.methods${additionPath ? ".${additionPath}" : additionPath};

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import tech.teslex.telegroo.api.context.Context;
import tech.teslex.telegroo.telegram.api.TelegramResult;
import tech.teslex.telegroo.telegram.api.methods.interfaces${additionPath ? ".${additionPath}" : additionPath}.${clazz};
import tech.teslex.telegroo.telegram.api.methods.objects.${clazz.substring(0, clazz.length() - 6)};

import java.util.Map;
import java.util.function.Consumer;

public interface Default${clazz}<Object/*FIXME: TODO: DELETE*/> extends ${clazz}<TelegramResult<Object>> {

	/**
	 * @return update context
	 */
	Context getContext();

	/**
	 * @return object mapper
	 */
	ObjectMapper getObjectMapper();

	@Override
	default TelegramResult<Object> ${clazz.substring(0, 1).toLowerCase()}${clazz.substring(1, clazz.length() - 6)}(Map data) {
		throw new AssertionError();
	}

	@Override
	default TelegramResult<Object> ${clazz.substring(0, 1).toLowerCase()}${
			clazz.substring(1, clazz.length() - 6)
		}(Consumer<${
			clazz.substring(0, clazz.length() - 6)
		}> data) {
		${clazz.substring(0, clazz.length() - 6)} method = ${clazz.substring(0, clazz.length() - 6)}.create();
		data.accept(method);

		return ${clazz.substring(0, 1).toLowerCase()}${clazz.substring(1, clazz.length() - 6)}(method);
	}

	@Override
	default TelegramResult<Object> ${clazz.substring(0, 1).toLowerCase()}${clazz.substring(1, clazz.length() - 6)}(${
			clazz.substring(0, clazz.length() - 6)
		} data) {
		JavaType type = getObjectMapper()
				.getTypeFactory()
				.constructType(Object.class);

	return getContext()
		.getTelegramClient()
				.call(data)
				.asTelegramResult(type);
	}
}
"""
	}

	if (!(file = new File("$interfacesPath", "Default${fileName}.java")).exists())
		file.withWriter('utf-8') {
			it.write(template(fileName))
		}

//	System.exit(0)
}