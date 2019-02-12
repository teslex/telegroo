# telegroo
| version: 0.3.0

**Telegram bot framework for [Groovy](http://groovy-lang.org)**

- [Telegroo Docs](DOCS.md)
- [Telegram Bot API](https://core.telegram.org/bots/api)

Sample bot:

```groovy
@GrabResolver(name = 'teslex-repo', root = 'https://teslex.gitlab.io/repo')
@Grab(group = 'tech.teslex.telegroo', module = 'telegroo', version = '0.4.0')

import tech.teslex.telegroo.Telegroo

def bot = new Telegroo('TOKEN')

bot.with {
	onCommand(/start/) {
		sendMessage('Welcome!')
	}
	
	onCommand(/echo (.+)/) { update, match ->
		sendMessage(match)
	}
}

bot.start()
```

**Webhook:**
```groovy
bot.setWebhook('https://kek.localtunnel.me') // setting webhook url
```
