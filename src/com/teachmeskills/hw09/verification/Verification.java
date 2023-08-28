package com.teachmeskills.hw09.verification;

import com.teachmeskills.hw09.exception.WrongLoginException;
import com.teachmeskills.hw09.exception.WrongPasswordException;

public class Verification {
    private static final int LOGIN_PASSWORD_LENGTH = 19;

    public static void validateLogin(String login) throws WrongLoginException {
        if (login.length() > LOGIN_PASSWORD_LENGTH) {
            throw new WrongLoginException("Длина имени должна быть менее 20 знаков!");
        }

        if (login.contains(" ")) {
            throw new WrongLoginException("Имя не должно содержать пробелов!");
        }
    }

    public static void validatePassword(String password, String confirmPassword) throws WrongPasswordException {
        if (password.length() > LOGIN_PASSWORD_LENGTH) {
            throw new WrongPasswordException("Длина ключа должна быть менее 20 знаков!");
        }

        if (password.contains(" ")) {
            throw new WrongPasswordException("Ключ не должен содержать пробелов!");
        }

        if (validateDigits(password)) {
            throw new WrongPasswordException("Ключ должен содержать хотя бы одну цифру!");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Ключи не совпадают!");
        }
    }

    private static boolean validateDigits(String password) {
        boolean hasDigit = true;
        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigit = false;
                break;
            }
        }

        return hasDigit;
    }
}
