# telegroo

Telegram bot framework for [Groovy](http://groovy-lang.org)

Sample bot:

```groovy

@GrabResolver(name = 'dk-repo', root = 'https://gitlab.com/david.kohut/maven-repo/raw/master')
@Grab(group = 'tech.teslex.telegroo', module = 'telegroo', version = '0.1')

import tech.teslex.telegroo.Telegroo

token = ''

def bot = new Telegroo(token)

bot.with {
	onCommand(/start/) { update, match ->
		sendMessage('Hello!')
	}
	
	onMessage(/hello/) { update, match ->
		reply('Hey!')
	}
	
	onUpdate { update ->
		println update
	}
}

bot.start()




```