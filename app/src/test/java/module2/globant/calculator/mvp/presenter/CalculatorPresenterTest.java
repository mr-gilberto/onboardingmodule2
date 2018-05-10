package module2.globant.calculator.mvp.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import module2.globant.calculator.Constants.Constants;
import module2.globant.calculator.R;
import module2.globant.calculator.mvp.model.CalculatorModel;
import module2.globant.calculator.mvp.view.CalculatorView;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CalculatorPresenterTest {

    @Mock CalculatorModel model;
    @Mock CalculatorView view;

    private CalculatorPresenter presenter;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        model = new CalculatorModel();
        presenter = new CalculatorPresenter(model, view);
    }

    @Test
    public void whenOperationsDo_ReturnResult() {
        assertEquals(2.0d, model.doOperation(Constants.SUM, 1, 1));
        assertEquals(10.0d, model.doOperation(Constants.DIVIDE, 100, 10));
        assertEquals(-100.0d, model.doOperation(Constants.SUBTRACTION, 500, 600));
        assertEquals(10.0d, model.doOperation(Constants.MULTIPLY, 5, 2));
        assertEquals(10.0d, model.doOperation(Constants.MULTIPLY, 5, 2));
    }


    @Test
    public void whenOperationsSelected_setLabelResult() {
        model.setOperation(Constants.SUM);
        when(view.getFieldOne()).thenReturn("100");
        when(view.getFieldTwo()).thenReturn("10");
        presenter.onResultButtonPressed();
        verify(view).setResultLabel("110.0");

        model.setOperation(Constants.DIVIDE);
        when(view.getFieldOne()).thenReturn("100");
        when(view.getFieldTwo()).thenReturn("10");
        presenter.onResultButtonPressed();
        verify(view).setResultLabel("10.0");


        model.setOperation(Constants.MULTIPLY);
        when(view.getFieldOne()).thenReturn("100");
        when(view.getFieldTwo()).thenReturn("10");
        presenter.onResultButtonPressed();
        verify(view).setResultLabel("1000.0");


        model.setOperation(Constants.SUBTRACTION);
        when(view.getFieldOne()).thenReturn("100");
        when(view.getFieldTwo()).thenReturn("10");
        presenter.onResultButtonPressed();
        verify(view).setResultLabel("90.0");
    }

    @Test
    public void whenErrorInput_showError(){

        model.setOperation(Constants.SUM);
        when(view.getFieldOne()).thenReturn("1..0");
        when(view.getFieldTwo()).thenReturn("10");
        presenter.onResultButtonPressed();

        when(view.getFieldOne()).thenReturn("1.0");
        when(view.getFieldTwo()).thenReturn("1-0");
        presenter.onResultButtonPressed();


        model.setOperation(Constants.DIVIDE);
        when(view.getFieldOne()).thenReturn("1.0");
        when(view.getFieldTwo()).thenReturn("0");
        presenter.onResultButtonPressed();
        presenter.onResultButtonPressed();

        verify(view, times(2)).showToastError(R.string.error_field_one_number_not_valid);
        verify(view, times(2)).showToastError(R.string.error_divide_not_valid);

    }





}