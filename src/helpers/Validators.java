package helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validators {
    public static boolean isStringChars(String str){
        Pattern pattern = Pattern.compile("^[a-zA-Zа-яА-Я]+$");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public static boolean isStringNumber(String str){
        Pattern pattern = Pattern.compile("^[0-9]\\d*$");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

    public static boolean isStringFloat(String str){
        Pattern pattern = Pattern.compile("^(?!0*(\\.0+)?$)([1-9]\\d*|0)(\\.\\d+)?$");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}
