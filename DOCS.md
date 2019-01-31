## Sample bot:

```groovy
@GrabResolver(name = 'teslex-repo', root = 'https://gitlab.com/TesLex/repo/raw/master')
@Grab(group = 'tech.teslex.telegroo', module = 'telegroo', version = '0.3.0')

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

**Webhook:**
```groovy
bot.setWebhook('https://kek.localtunnel.me') // setting webhook url
bot.startWebhook(3000) // starting server on 3000 port
```

## [Telegram api](https://core.telegram.org/bots/api)

`api.go(method, [params])` |
`api.goWithFile(method, File, fieldName, [params])`
`api.goWithMediaGroup(method, List<Map<String, Object>>, [params])`

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
args with `?` are optional

- `getMe()`

- `sendMessage(text, chat_id?, [params]?)`

- `forward(from_chat_id?, message_id, chat_id?, [params]?)`

- `reply(reply_to_message_id, message, chat_id?, [params]?)`

- `sendPhoto(File, chat_id?, [params]?)` | `sendPhoto(url_to_file, chat_id?, [params]?)` | `sendPhotoId(file_id, chat_id?, [params]?)`

- `sendAudio(File, chat_id?, [params]?)` | `sendAudio(url_to_file, chat_id?, [params]?)` | `sendAudioId(file_id, chat_id?, [params]?)`

- `sendDocument(File, chat_id?, [params]?)` | `sendDocument(url_to_file, chat_id?, [params]?)` | `sendDocumentId(file_id, chat_id?, [params]?)`

- `sendSticker(File, chat_id?, [params]?)` | `sendSticker(url_to_file, chat_id?, [params]?)` | `sendStickerId(file_id, chat_id?, [params]?)`

- `sendVideo(File, chat_id?, [params]?)` | `sendVideo(url_to_file, chat_id?, [params]?)` | `sendVideoId(file_id, chat_id?, [params]?)`

- `sendVoice(File, chat_id?, [params]?)` | `sendVoice(url_to_file, chat_id?, [params]?)` | `sendVoiceId(file_id, chat_id?, [params]?)`

- `sendLocation(latitude, longitude, chat_id?, [params]?)`

- `sendVenue(latitude, longitude, title, address, chat_id?, [params]?)`

- `sendContact(phone_number?, first_name, chat_id?, [params]?)`

- `sendChatAction(action, chat_id?, [params]?)`

- `getUserProfilePhotos(user_id?, [params]?)`

- `getFile(file_id, [params]?)`

- `kickChatMember(user_id, chat_id?, [params]?)`

- `unbanChatMember(user_id, chat_id?, [params]?)`

- `answerCallbackQuery(callback_query_id, chat_id?, [params]?)`

- `editMessageText(message_id, text, chat_id?, [params]?)`

- `editMessageCaption(message_id, caption, chat_id?, [params]?)`

- `editMessageReplyMarkup(message_id, [replyMarkup], chat_id?, [params]?)`
