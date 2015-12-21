package org.foo;

public class ExampleProducer {

	private WidgetFactory widgetFactory = new WidgetFactory();

	public Widget produce(String name) throws Exception {
		try {
			return widgetFactory.produceWidget(name);
		} catch (InterruptedException ie) {
		}
		throw new Exception("Failed to produce widget.");
	}
}
