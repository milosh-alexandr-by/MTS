/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.support;

import by.it.academy.pojos.User;
import by.it.academy.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by USER on 11.02.2016.
 */
public class DisplayAllUsers {

    public void display(HttpServletRequest request, HttpServletResponse response) {

        UserService userService = UserService.getInstance();

        List<User> users = userService.getAll();
        request.setAttribute("users", users);
    }

}
