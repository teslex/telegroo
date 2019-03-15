path = "/home/exp/Projects/Idea/teslex/telegroo"

additionPath = "webhook"

sourcePath = "$path/telegram-api/src/main/groovy/tech/teslex/telegroo/telegram/methods/objects/$additionPath" as File
buildersPath = "$path/telegram-api/src/main/groovy/tech/teslex/telegroo/telegram/methods/builders/$additionPath" as File

sourcePath.listFiles().findAll { it.isFile() }.each { File file ->
	def fileName = file.name.substring(0, file.name.length() - 7)
	def template = { clazz ->
		"""\
package tech.teslex.telegroo.telegram.methods.builders.$additionPath

import groovy.transform.CompileStatic
import groovy.transform.builder.Builder
import groovy.transform.builder.ExternalStrategy
import tech.teslex.telegroo.telegram.methods.objects.$additionPath.${clazz}

@CompileStatic
@Builder(builderStrategy = ExternalStrategy, forClass = ${clazz})
class ${clazz}Builder {}
"""
	}

	new File("$buildersPath", "${fileName}Builder.groovy").withWriter('utf-8') {
		it.write(template(fileName))
	}
}