package module2.globant.calculator;

public class Utils {

    public static boolean isValidNumber(String number) {
        boolean isValidNumber = true;
        try {
            Double.parseDouble(number);
        } catch (Exception e) {
            isValidNumber =  false;
        }

        return isValidNumber;
    }

}
