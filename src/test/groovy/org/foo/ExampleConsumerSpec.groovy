package org.foo

import spock.lang.Specification

class ExampleConsumerSpec extends Specification {
	def 'UNIT: consume creates a message from a widget when everything is ok' () {
		setup:
		ExampleConsumer consumer = new ExampleConsumer()
		def widget = ['name': 'My widget'] as Widget

		when:
		String message = consumer.consume(widget)

		then:
		message == 'Hello, welcome to widget consumer. You just consumed widget My widget'
	}

	def 'UNIT: we can mock the protected greeting method and only test a portion of the unit' () {
		setup:
		ExampleConsumer consumer = Mock() {
			consume(_) >> { callRealMethod() }
			getGreeting() >> { 'Greetings from Spock mock:' }
		}
		Widget widget = new Widget('My widget')

		when:
		String message = consumer.consume(widget)

		then:
		message == 'Greetings from Spock mock: You just consumed widget My widget'
	}
}
