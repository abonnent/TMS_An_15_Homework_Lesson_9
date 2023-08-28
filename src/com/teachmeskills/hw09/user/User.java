package com.teachmeskills.hw09;

import com.teachmeskills.hw09.exception.WrongLoginException;
import com.teachmeskills.hw09.exception.WrongPasswordException;
import com.teachmeskills.hw09.verification.Verification;

import static com.teachmeskills.hw09.verification.Verification.validateLogin;

public class User {
    public static void authorization(String login, String password, String confirmPassword) {
        boolean success = false;

        try {
            Verification.validateLogin(login);
            Verification.validatePassword(password, confirmPassword);
            success = true;
        } catch (WrongLoginException e) {
            System.out.println(e);
        } catch (WrongPasswordException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка!");
        } finally {
            if (success) {
                System.out.println("Добро пожаловать!");
            }
        }
    }
}
