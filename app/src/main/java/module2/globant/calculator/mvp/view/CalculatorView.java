package module2.globant.calculator.mvp.view;

import android.app.Activity;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import module2.globant.calculator.Constants.Constants;
import module2.globant.calculator.R;
import module2.globant.calculator.bus.RxBus;
import module2.globant.calculator.bus.observers.OperationButtonBusObserver;
import module2.globant.calculator.bus.observers.ResultButtonBusObserver;

public class CalculatorView extends ActivityView {

    @BindView(R.id.result_label)
    TextView resultLabel;

    @BindView(R.id.operation_symbol_label)
    TextView operationSymbolLabel;

    @BindView(R.id.field_one_edittext)
    EditText fieldOneEditText;

    @BindView(R.id.field_two_edittext)
    EditText fieldTwoEditText;


    public CalculatorView(Activity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    public String getFieldOne() {
        return fieldOneEditText.getText().toString();
    }

    public void showToastError(int message){
        Toast.makeText(super.getActivity(), super.getActivity().getResources().getString(message), Toast.LENGTH_SHORT).show();
    }

    public String getFieldTwo() {
        return fieldTwoEditText.getText().toString();
    }


    public void setResultLabel(String result) {
        resultLabel.setText(result);
    }

    public void setOperationSymbol(int operationSymbol) {
        operationSymbolLabel.setText(operationSymbol);
    }


    @OnClick(R.id.sum_button)
    public void sumButtonPressed() {
        RxBus.post(new OperationButtonBusObserver.OperationButtonButton(Constants.SUM));
    }


    @OnClick(R.id.result_button)
    public void resultButtonPressed() {
        RxBus.post(new ResultButtonBusObserver.ResultButtonButton());
    }


}
