package module2.globant.calculator.Constants;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class Constants {

    public static final int SUM = 1;
    public static final int MULTIPLY = 2;
    public static final int DIVIDE = 3;
    public static final int SUBTRACTION = 4;

    private Constants() { }

    @IntDef({SUM, MULTIPLY, DIVIDE, SUBTRACTION})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Operations { }

}
