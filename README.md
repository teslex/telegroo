# telegroo
> version: **[0.4.0-SNAPSHOT](https://gitlab.com/teslex/repo/tree/master/snapshots/tech/teslex/telegroo/telegroo)**

**Telegram bot framework for [Groovy](http://groovy-lang.org)**

- [Telegroo Docs](DOCS.md)
- [Telegram Bot API](https://core.telegram.org/bots/api)

Sample bot:

```groovy
@GrabResolver(name = 'teslex-repo', root = 'https://teslex.gitlab.io/repo/snapshots')
@Grab(group = 'tech.teslex.telegroo', module = 'telegroo', version = '0.4.0-SNAPSHOT')

import tech.teslex.telegroo.simple.SimpleTelegroo

def bot = new SimpleTelegroo('TOKEN')

bot.with {
	onCommand(/start/) {
		it.context.sendMessage('Welcome!')
	}
	
	onCommand(/echo (.+)/) { res ->
		res.context.sendMessage(match[0][1])
	}
}

bot.start()
```

**Webhook:**
```groovy
bot.setWebhook('https://kek.localtunnel.me') // setting webhook url
```
