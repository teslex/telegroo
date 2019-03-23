<p align="center">
	<img src="https://gitlab.com/teslex/telegroo/assets/raw/master/images/telegroo-small.png">
	<h1>telegroo</h1>
</p>

**Telegram Bot framework for [Groovy](http://groovy-lang.org)**

> Version: **[1.0-{timestamp}-SNAPSHOT](https://gitlab.com/teslex/repo/tree/master/snapshots/tech/teslex/telegroo/telegroo)**

- [Telegroo Docs](https://teslex.gitlab.io/telegroo)
- [Telegram Bot API](https://core.telegram.org/bots/api)
- Examples:
	* [Telegroo & Micronaut](https://gitlab.com/teslex/telegroo/micronaut-example)


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
	sendMessage(text: matcher[0][1])
}

bot.start()
```
