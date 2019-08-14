<p align="center">
	<img src="https://gitlab.com/teslex/telegroo/assets/raw/master/images/telegroo-small.png">
	<h1>telegroo</h1>
</p>

**Simple Telegram Bot wrapper for Java & [Groovy](http://groovy-lang.org)**

> Version: **[0.0.1](https://gitlab.com/teslex/telegroo/telegroo)**

- [Telegroo Docs](https://teslex.gitlab.io/telegroo)
- [Telegram Bot API](https://core.telegram.org/bots/api)
- Examples:
	* [Telegroo & Micronaut](https://gitlab.com/teslex/telegroo/micronaut-example)


**Gradle:**

```groovy
repositories {
	jcenter() // or 'maven { url 'https://teslex.gitlab.io/repo' }'
}

dependencies {
	implementation "tech.teslex.telegroo:telegroo:$telegrooVersion"
}
```

### Java Example:
```java
import tech.teslex.telegroo.api.PollingTelegroo;
import tech.teslex.telegroo.simple.SimplePollingTelegroo;

class Bot {
	
	private static final String TOKEN = "...";
	private static final PollingTelegroo telegroo = new SimplePollingTelegroo(TOKEN);
	
	public static void main(String[] args){
		telegroo.listenCommand("start", (context, methods) -> methods.sendMessage("Hello!"));
		telegroo.listenCommand("echo", (context, methods) -> methods.sendMessage(context.getArgsText()));
		
		telegroo.startPolling();
	}
}
```

### Groovy Example:
```groovy
final String TOKEN = "..."
final PollingTelegroo telegroo = new SimplePollingTelegroo(TOKEN)

telegroo.listenCommand("start") { context, methods -> 
	methods.sendMessage("Hello!")
}

telegroo.listenCommand(~/echo/) { context, methods -> 
	methods.sendMessage(context.getArgsText())
}
		
telegroo.startPolling()	
```

#### Grapes
```groovy
@Grab("tech.teslex.telegroo:telegroo:$telegrooVersion")
```