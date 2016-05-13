/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.main;

import by.it.academy.commandMain.ActionCommand;
import by.it.academy.pojos.User;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.services.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by USER on 02.02.2016.
 */

public class RegistrationCommand implements ActionCommand {

    public static UserService userService = UserService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        String page = null;

        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        User user = new User();
        user.setLogin(login);
        user.setPassword(pass);

        userService.add(user);

        Cookie userLoginCookie = new Cookie("userLoginCookie", login);
        response.addCookie(userLoginCookie);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        request.setAttribute("user", user);

        if (user.getLogin().equals("admin")) {
            page = ConfigurationManager.getProperty("path.page.adminmain");
        } else {
            page = ConfigurationManager.getProperty("path.page.main");
        }
        return page;
    }
}
