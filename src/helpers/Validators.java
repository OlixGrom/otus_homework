package helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    private static final Pattern PATTERN_STR = Pattern.compile("^[a-zA-Zа-яА-Я]+$");
    private static final Pattern PATTERN_INT = Pattern.compile("^[0-9]\\d*$");
    private static final Pattern PATTERN_FLOAT = Pattern.compile("^(?!0*(\\.0+)?$)([1-9]\\d*|0)(\\.\\d+)?$");

    public static boolean isStringChars(String str){
        return PATTERN_STR.matcher(str).find();
    }

    public static boolean isStringNumber(String str){
        return PATTERN_INT.matcher(str).find();
    }

    public static boolean isStringFloat(String str){
        return PATTERN_FLOAT.matcher(str).find();
    }
}
