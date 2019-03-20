<p align="center">
	<img src="/images/telegroo-small.png">
	<h1>telegroo</h1>
</p>

> version: **[1.0-{timestamp}-SNAPSHOT](https://gitlab.com/teslex/repo/tree/master/snapshots/tech/teslex/telegroo/telegroo)**

**Telegram bot framework for [Groovy](http://groovy-lang.org)**

- [Telegroo Docs](DOCS.md)
- [Telegram Bot API](https://core.telegram.org/bots/api)


**Gradle:**

```groovy
repositories {
	maven { url 'https://teslex.gitlab.io/repo/snapshots' }
}

dependencies {
	compile 'tech.teslex.telegroo:telegroo:1.0-{timestamp}-SNAPSHOT'
}
```

Sample bot:

```groovy
@GrabResolver(name = 'teslex-repo', root = 'https://teslex.gitlab.io/repo/snapshots')
@Grab(group = 'tech.teslex.telegroo', module = 'telegroo', version = '1.0-{timestamp}-SNAPSHOT')

import tech.teslex.telegroo.simple.SimpleTelegroo

def bot = new SimpleTelegroo('TOKEN')

bot.onCommand(/start/) {
	sendMessage(text: 'Welcome!')
}
	
bot.onCommand(/echo (.+)/) {
	sendMessage(text: matcher.get()[0][1])
}

bot.start()
```

**Webhook:**
```groovy
bot.setWebhook('https://kek.localtunnel.me') // setting webhook url
```
