package module2.globant.calculator.bus.observers;

public abstract class StringBusObserver extends BusObserver<String> {
    public StringBusObserver() {
        super(String.class);
    }
}
