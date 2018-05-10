package module2.globant.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import module2.globant.calculator.mvp.model.CalculatorModel;
import module2.globant.calculator.mvp.presenter.CalculatorPresenter;
import module2.globant.calculator.mvp.view.CalculatorView;


public class MainActivity extends AppCompatActivity {

    CalculatorPresenter calculatorPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorPresenter = new CalculatorPresenter(new CalculatorModel(), new CalculatorView(this));
    }

    @Override
    protected void onResume() {
        super.onResume();
        calculatorPresenter.register();
    }

    @Override
    protected void onPause() {
        super.onPause();
        calculatorPresenter.unregister();
    }
}
