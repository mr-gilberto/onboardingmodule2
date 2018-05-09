package module2.globant.calculator.bus.observers;

public abstract class IntegerBusObserver extends BusObserver<Integer> {
    public IntegerBusObserver() {
        super(Integer.class);
    }
}