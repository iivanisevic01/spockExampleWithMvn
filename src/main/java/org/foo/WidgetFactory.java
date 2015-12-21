package org.foo;

public class WidgetFactory {
    public Widget produceWidget(String name) throws InterruptedException {
        // imagine there is a length bit of logic here associated with widget production and simulated by the sleep
        Thread.currentThread().sleep(1000);
        return new Widget(name);
    }
}
