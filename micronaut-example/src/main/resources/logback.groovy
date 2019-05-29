appender('STDOUT', ConsoleAppender) {
	withJansi = true
	encoder(PatternLayoutEncoder) {
		pattern = /%cyan(%d{HH:mm:ss.SSS}) %gray([%thread]) %highlight(%-5level) %magenta(%logger{36}) - %msg%n/
	}
}

root(INFO, ['STDOUT'])