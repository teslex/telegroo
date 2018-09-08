# telegroo
| version: 0.3.0

**Telegram bot framework for [Groovy](http://groovy-lang.org)**

- [Telegroo Docs](DOCS.md)
- [Telegram Bot API](https://core.telegram.org/bots/api)

Sample bot:

```groovy
@GrabResolver(name = 'dk-repo', root = 'https://gitlab.com/TesLex/repo/raw/master')
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
