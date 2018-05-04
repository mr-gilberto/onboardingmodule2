package module2.globant.calculator.bus.observers;

public abstract class BooleanBusObserver extends BusObserver<Boolean> {
    public BooleanBusObserver() {
        super(Boolean.class);
    }
}