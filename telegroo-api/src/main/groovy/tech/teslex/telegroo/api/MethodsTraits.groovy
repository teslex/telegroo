package tech.teslex.telegroo.api

import groovy.transform.CompileStatic
import tech.teslex.telegroo.api.traits.GetUpdatesMethodTrait
import tech.teslex.telegroo.api.traits.SendMediaGroupMethodTrait
import tech.teslex.telegroo.api.traits.SendMessageMethodTrait
import tech.teslex.telegroo.api.traits.SendPhotoMethodTrait

@CompileStatic
trait MethodsTraits implements
		SendMessageMethodTrait,
		SendPhotoMethodTrait,
		GetUpdatesMethodTrait,
		SendMediaGroupMethodTrait {}
