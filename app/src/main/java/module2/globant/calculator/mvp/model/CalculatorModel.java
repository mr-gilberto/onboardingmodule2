package module2.globant.calculator.mvp.model;

import module2.globant.calculator.Constants.Constants;

public class CalculatorModel {

    @Constants.Operations int operation = Constants.SUM;

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public int getOperation() {
        return operation;
    }

    public double doOperation(double a, double b) {
        switch (operation) {
            case Constants.SUM:
                return a + b;
             case Constants.SUBTRACTION:
                    return a - b;
            default:
                return 0;
        }
    }


}
