package org.foo;

public class ExampleConsumer {
    public String consume(Widget widget) {
        return getGreeting() + " You just consumed widget " + widget.getName();
    }

    protected String getGreeting() {
        return "Hello, welcome to widget consumer.";
    }
}
