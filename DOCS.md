## Sample bot:

```groovy
@GrabResolver(name = 'dk-repo', root = 'https://gitlab.com/david.kohut/maven-repo/raw/master')
@Grab(group = 'tech.teslex.telegroo', module = 'telegroo', version = '0.1')

import tech.teslex.telegroo.Telegroo

def bot = new Telegroo('TOKEN')

bot.with {
	onCommand(/start/) {
		sendMessage('Welcome!')
	}
	
	onCommand(/echo (.+)/) { update, match ->
		sendMessage(match[0][1].toString())
	}
}

bot.start() // or startAsync()
```

## [Telegram api](https://core.telegram.org/bots/api)

`api.go(method, [params])` |
`api.goWithFile(method, File, fieldName, [params])`

```groovy
bot.api.go('sendMessage', [chat_id: '1', text: 'message text'])
```


## [Getting updates](https://core.telegram.org/bots/api#getting-updates)

- `message`: New incoming message of any kind — text, photo, sticker, etc. 
- `edited_message`:  New version of a message that is known to the bot and was edited
- `channel_post`: New incoming channel post of any kind — text, photo, sticker, etc.
- `edited_channel_post`: New version of a channel post that is known to the bot and was edited
- `inline_query`: New incoming inline query
- `chosen_inline_result`: The result of an inline query that was chosen by a user and sent to their chat partner. Please see our documentation on the feedback collecting for details on how to enable these updates for your bot.
- `callback_query`: New incoming callback query
- `shipping_query`: New incoming shipping query. Only for invoices with flexible price
- `pre_checkout_query`: New incoming pre-checkout query. Contains full information about checkout


```groovy
on('edited_message') {
	sendMessage('-_-')
}
```

--

```groovy
onCommand(/start/) { update, match ->
	sendMessage('Welcome!')
}
```
or
```groovy
onCommand(/start/) {
	sendMessage('Welcome!')
}

// it.update, it.match
```
```groovy
onMessage(/go/) {
	reply('go go go!')
} 
```

## [Methods](https://core.telegram.org/bots/api#available-methods)
`chat_id`, `[params]` is optional

- `getMe()`

- `sendMessage(chat_id, text, [params])`

- `forward(from_chat_id, message_id, chat_id, [params])`

- `reply(chat_id, reply_to_message_id, message, [params])`

- `sendPhoto(chat_id, File, [params])` | `sendPhoto(chat_id, url_to_file, [params])` | `sendPhotoId(chat_id, file_id, [params])`

- `sendAudio(chat_id, File, [params])` | `sendAudio(chat_id, url_to_file, [params])` | `sendAudioId(chat_id, file_id, [params])`

- `sendDocument(chat_id, File, [params])` | `sendDocument(chat_id, url_to_file, [params])` | `sendDocumentId(chat_id, file_id, [params])`

- `sendSticker(chat_id, File, [params])` | `sendSticker(chat_id, url_to_file, [params])` | `sendStickerId(chat_id, file_id, [params])`

- `sendVideo(chat_id, File, [params])` | `sendVideo(chat_id, url_to_file, [params])` | `sendVideoId(chat_id, file_id, [params])`

- `sendVoice(chat_id, File, [params])` | `sendVoice(chat_id, url_to_file, [params])` | `sendVoiceId(chat_id, file_id, [params])`

- `sendLocation(chat_id, latitude, longitude, [params])`

- `sendVenue(chat_id, latitude, longitude, title, address, [params])`

- `sendContact(chat_id, phone_number, first_name, [params])`

- `sendChatAction(chat_id, action, [params])`

- `getUserProfilePhotos(user_id, [params])`

- `getFile(file_id, [params])`

- `kickChatMember(chat_id, user_id, [params])`

- `unbanChatMember(chat_id, user_id, [params])`

- `answerCallbackQuery(chat_id, callback_query_id, [params])`

- `editMessageText(chat_id, message_id, text, [params])`

- `editMessageCaption(chat_id, message_id, caption, [params])`

- `editMessageReplyMarkup(chat_id, message_id, [replyMarkup], [params])`
