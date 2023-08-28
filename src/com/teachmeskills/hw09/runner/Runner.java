package com.teachmeskills.hw09;

public class Runner {
    public static void main(String[] args) {
        String login = "abonnent";
        String password = "abc1";
        String confirmPassword = "abc11";

        User.authorization(login, password, confirmPassword);
    }
}
