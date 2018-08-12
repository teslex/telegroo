package tech.teslex.telegroo.api.req

class SomeSticker extends SomeFile {

	SomeSticker(File file, Map params) {
		super('sendSticker', 'sticker', file, params)
	}
}
