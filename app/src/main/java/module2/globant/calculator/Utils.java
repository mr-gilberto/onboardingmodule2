package module2.globant.calculator;

public class Utils {


    public static boolean isValidNumber(String number) {
        try {
            Double.parseDouble(number);
        } catch (Exception e) {
            return false;
        }
        return true;
    }


}
