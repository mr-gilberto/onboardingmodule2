package module2.globant.calculator.bus.observers;

public abstract class ResultButtonBusObserver extends BusObserver<ResultButtonBusObserver.ResultButtonButton> {
    public ResultButtonBusObserver() {
        super(ResultButtonButton.class);
    }

    public static class ResultButtonButton {

    }
}