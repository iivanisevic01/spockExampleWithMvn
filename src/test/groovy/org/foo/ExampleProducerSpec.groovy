package org.foo

import spock.lang.Specification

class ExampleProducerSpec extends Specification {
	ExampleProducer producer

	def setup() {
		// runs before each test
		producer = new ExampleProducer()
	}
	
	def cleanup() {
		// runs after each test
	}

	// example of a typical happy path Spock unit test
	def 'UNIT: produce creates a widget when everything is ok' () {
		// setup blocks are optional and setup label can be omitted (in which case it is implied)
		setup: // initialize any test conditions
		// mock the Factory since this is a unit test and we don't want to invoke the real thing
		producer.widgetFactory = Mock(WidgetFactory)
		String widgetName = 'My widget'
		
		// when blocks can contain arbitrary code
		when: // stimulus
		1 * producer.widgetFactory.produceWidget(widgetName) >> { String wn ->
			new Widget(wn)
		}
		Widget widget = producer.produce(widgetName)

		// then blocks are restricted to conditions, exception conditions, interactions, 
		// and variable definitions
		then: // response check
		widget.name == widgetName
	}

	def 'UNIT: produce raises an exception when something went wrong' () {
		setup:
		producer.widgetFactory = Mock(WidgetFactory)
		String widgetName = 'My widget'

		when:
		1 * producer.widgetFactory.produceWidget(widgetName) >> {
			throw new InterruptedException('Test failed.')
		}
		producer.produce(widgetName)

		then:
		Exception e = thrown()
		e.message == 'Failed to produce widget.'
	}

	// Spock integration test - no mocking of business logic
	// note the longer run time of this test because it actually executes the sleep in WidgetFactory
	def 'INTEGRATION: produce creates a widget' () {
		setup:
		String widgetName = 'My widget'

		when:
		Widget widget = producer.produce(widgetName)

		then:
		widget.name == widgetName
	}

	// example of a data driven integration test (replacement to junit parametrizations)
	def 'INTEGRATION: produce creates multiple widgets' () {
		// alternative to then blocks, limited to just conditions and variable declarations
		expect:
		producer.produce(name)?.getName() == name

		// A where block always comes last in a method, and may not be repeated. 
		// It is used to write data-driven feature methods.
		where:
		name << ['test', 'test1', 'test28569']
	}
}
