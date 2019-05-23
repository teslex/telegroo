path = "/home/exp/Projects/Idea/teslex/telegroo"

additionPath = "webhook"

traitsPath = "$path/telegroo/src/main/groovy/tech/teslex/telegroo/simple/methods/traits/$additionPath" as File
methodsPath = "$path/telegroo-api/src/main/groovy/tech/teslex/telegroo/api/methods/$additionPath" as File

traitsPath.listFiles().findAll { it.isFile() }.each { File file ->
	String fileName = file.name.substring(0, file.name.length() - 12)
	Closure<String> template = { String clazz ->
		"""\
package tech.teslex.telegroo.api.methods${additionPath ? ".${additionPath}" : additionPath};

import groovy.lang.Closure;
import groovy.lang.DelegatesTo;
import groovy.transform.NamedDelegate;
import groovy.transform.NamedVariant;
import tech.teslex.telegroo.telegram.api.methods.objects.${fileName}Object;

import java.util.Map;

public interface ${clazz}<R> {

	R ${clazz.substring(0, 1).toLowerCase()}${clazz.substring(1, clazz.length() - 6)}(Map data);

	@NamedVariant
	R ${clazz.substring(0, 1).toLowerCase()}${clazz.substring(1, clazz.length() - 6)}(@NamedDelegate ${fileName}Object data);

	R ${clazz.substring(0, 1).toLowerCase()}${clazz.substring(1, clazz.length() - 6)}(@DelegatesTo(${fileName}Object.class) Closure closure);
}
"""
	}

	if (fileName != 'Reply') {
		new File("$methodsPath", "${fileName}.java").withWriter('utf-8') {
			it.write(template(fileName))
		}
	}

//	System.exit(0)
}