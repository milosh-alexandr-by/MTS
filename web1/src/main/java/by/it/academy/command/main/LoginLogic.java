/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.main;

import by.it.academy.pojos.User;
import by.it.academy.services.UserService;

/**
 * Created by USER on 02.02.2016.
 */

public class LoginLogic {

    public static UserService userService = UserService.getInstance();
    static String eLogin;
    static String ePass;

    public static boolean checkLogin(String enterLogin, String enterPass) {

        boolean flag = false;
        User user = new User();
        user.setLogin(enterLogin);
        user.setPassword(enterPass);

        user = userService.getByLoginAndPassword(user);

        if (user.isValid()) {
            flag = true;
        }

        return flag;

    }

}
