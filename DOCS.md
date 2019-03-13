## Sample bot:

```groovy
@GrabResolver(name = 'teslex-repo', root = 'https://teslex.gitlab.io/repo/snapshots')
@Grab(group = 'tech.teslex.telegroo', module = 'telegroo', version = '1.0-SNAPSHOT')

import tech.teslex.telegroo.simple.SimpleTelegroo

def bot = new SimpleTelegroo('TOKEN')

bot.with {
	onCommand(/start/) {
		sendMessage(text: 'Welcome!')
	}
	
	onCommand(/echo (.+)/) {
		sendMessage(text: matcher[0][1])
	}
}

```

**Webhook:**
```groovy
bot.setWebhook('https://kek.localtunnel.me') // setting webhook url
```

## [Telegram api](https://core.telegram.org/bots/api)
- `Response go(String, Map)`
- `Response go(MethodObject methodObject)`
- `Response go(MethodObjectWithFile methodObjectWithFile)`
- `Response go(MethodObjectWithMedia methodObjectWithMedia)`

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

// or
import tech.teslex.telegroo.telegram.enums.UpdateType

on(UpdateType.EDITED_MESSAGE) {
	sendMessage('-_-')
}
```

--

```groovy
onCommand(/start/) {
	sendMessage('Welcome!')
}
```

```groovy
onMessage(/go/) {
	reply('go go go!')
} 
```

## [Methods](https://core.telegram.org/bots/api#available-methods)
args with `?` are optional

// todo: 

- `getMe()`: [tech.teslex.telegroo.telegram.methods.GetMe](/api/src/main/groovy/tech/teslex/telegroo/api/methods/GetMe.groovy) / [telegram](https://core.telegram.org/bots/api#getme)
- more methods: [tech.teslex.telegroo.telegram.methods](/api/src/main/groovy/tech/teslex/telegroo/api/methods/) and [core.telegram.org/bots#available-methods](https://core.telegram.org/bots/api#available-methods)
- // todo