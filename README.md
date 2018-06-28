# telegroo

**Telegram bot framework for [Groovy](http://groovy-lang.org)**

Sample bot:

```groovy
@GrabResolver(name = 'dk-repo', root = 'https://gitlab.com/david.kohut/maven-repo/raw/master')
@Grab(group = 'tech.teslex.telegroo', module = 'telegroo', version = '0.1')

import tech.teslex.telegroo.Telegroo

TOKEN = ''

def bot = new Telegroo(TOKEN)

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