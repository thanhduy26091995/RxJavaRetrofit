package com.hbbsolution.mproduction.utils.components;

import android.util.Log;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by buivu on 06/10/2016.
 */
public class Validate {
    private Validate() {
    }

    public static boolean isCheckEmailSuccess(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static boolean isCheckPhoneNumberSuccess(String phoneNumber) {
        String phone = phoneNumber.replace(" ", "").replace(".", "").replace("-", "").replace("+84", "0").replace("(", "").replace(")", "");
        if ((phone.startsWith("09") || phone.startsWith("08")) && phone.length() == 10)
            return true;

        if (phone.startsWith("01") && phone.length() == 11)
            return true;
        else return false;

    }

    public static boolean isCheckPasswordSuccess(String password) {
        boolean isValid = false;
        String passwordValidation = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";
        CharSequence inputStr = password;
        Pattern pattern = Pattern.compile(passwordValidation);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    public static long CheckSizeImage(String filePath) {
        long length = 0;
        if (filePath != null) {
            try {
                File file = new File(filePath);
                length = file.length();
                return length = length / 1024;
            } catch (Exception e) {
                Log.e("File not found : ", e.getMessage() + e);
            }
        }
        return 0;
    }

    /*^ (bắt đầu của dòng)
        [a-zA-Z] {2,} (sẽ trừ tên có ít nhất hai ký tự)
        \ s (sẽ tìm khoảng trắng giữa tên và họ)
        [a-zA-Z] {1 ,} (cần ít nhất 1 Ký tự)
        '? -? (có thể là ' hoặc - đối với họ hai cột và dấu gạch ngang)
        [a-zA-Z] {2,} (trừ tên có ít nhất hai ký tự)
        \ s? (khả năng của một khoảng trắng khác)
        ([a-zA-Z] {1,})? * (khả năng họ thứ hai)*/
    public static boolean isCheckFullName(String fullName){
        boolean isValid = false;
        String passwordValidation = "^([a-zA-Z]{2,}\\s[a-zA-z]{1,}'?-?[a-zA-Z]{2,}\\s?([a-zA-Z]{1,})?)";
        CharSequence inputStr = fullName;
        Pattern pattern = Pattern.compile(passwordValidation);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

}
