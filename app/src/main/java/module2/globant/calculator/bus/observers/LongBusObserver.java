package module2.globant.calculator.bus.observers;

public abstract class LongBusObserver extends BusObserver<Long> {
    public LongBusObserver() {
        super(Long.class);
    }
}
