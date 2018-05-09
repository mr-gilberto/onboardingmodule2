package module2.globant.calculator.mvp.presenter;

import android.app.Activity;

import module2.globant.calculator.Constants.Constants;
import module2.globant.calculator.R;
import module2.globant.calculator.Utils;
import module2.globant.calculator.bus.RxBus;
import module2.globant.calculator.bus.observers.OperationButtonBusObserver;
import module2.globant.calculator.bus.observers.ResultButtonBusObserver;
import module2.globant.calculator.mvp.model.CalculatorModel;
import module2.globant.calculator.mvp.view.CalculatorView;

public class CalculatorPresenter {

    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorPresenter(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
    }


    public void onResultButtonPressed() {
        if (validated()) {
            view.setResultLabel(String.valueOf(model.doOperation(model.getOperation(), Double.parseDouble(view.getFieldOne()), Double.parseDouble(view.getFieldTwo()))));
        }
    }


    public boolean validated() {
        boolean validated = true;
        if (!Utils.isValidNumber(view.getFieldOne())) {
            validated = false;
            view.showToastError(R.string.error_field_one_number_not_valid);
        } else if (!Utils.isValidNumber(view.getFieldTwo())) {
            validated = false;
            view.showToastError(R.string.error_field_one_number_not_valid);
        }

        return validated;
    }

    public void register() {
        Activity activity = view.getActivity();

        if (activity == null) {
            return;
        }

        RxBus.subscribe(activity, new OperationButtonBusObserver() {
            @Override
            public void onEvent(OperationButtonButton value) {

                switch (value.getOperation()){
                    case Constants.SUM:
                        view.setOperationSymbol(R.string.main_plus_button);
                        model.setOperation(value.getOperation());
                        break;
                    case Constants.SUBTRACTION:
                        view.setOperationSymbol(R.string.main_subtraction_button);
                        model.setOperation(value.getOperation());
                        break;
                }
            }
        });


        RxBus.subscribe(activity, new ResultButtonBusObserver() {
            @Override
            public void onEvent(ResultButtonButton value) {
                onResultButtonPressed();
            }
        });

    }


    public void unregister() {
        Activity activity = view.getActivity();

        if (activity == null) {
            return;
        }
        RxBus.clear(activity);
    }
}
