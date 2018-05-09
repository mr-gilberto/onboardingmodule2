package module2.globant.calculator.bus.observers;

public abstract class OperationButtonBusObserver extends BusObserver<OperationButtonBusObserver.OperationButtonButton> {
    public OperationButtonBusObserver() {
        super(OperationButtonButton.class);
    }

    public static class OperationButtonButton {
        private  Integer operation;

        public OperationButtonButton(int operation){
            this.operation = operation;
        }

        public Integer getOperation() {
            return operation;
        }
    }
}