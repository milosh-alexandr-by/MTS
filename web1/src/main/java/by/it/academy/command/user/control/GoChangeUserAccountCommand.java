/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.user.control;

import by.it.academy.commandMain.ActionCommand;
import by.it.academy.pojos.Number;
import by.it.academy.pojos.User;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.services.NumberService;
import by.it.academy.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by USER on 11.02.2016.
 */
public class GoChangeUserAccountCommand implements ActionCommand {

    public static NumberService numberService = NumberService.getInstance();
    public static UserService userService = UserService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        int changeAccount = Integer.parseInt(request.getParameter("changeaccount"));
        String userLogin = request.getParameter("userLogin");

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        request.setAttribute("user", user);

        userService.changeUserAccount(user, changeAccount);

        Number number = numberService.userInfoNumber(user);
        int yourNumber = number.getNumber();
        String yourTariff = userService.userInfoTariff(user);
        int yourAccount = userService.userInfoAccount(user);

        request.setAttribute("userLogin", userLogin);
        request.setAttribute("yourNumber", yourNumber);
        request.setAttribute("yourTariff", yourTariff);
        request.setAttribute("yourAccount", yourAccount);

        page = ConfigurationManager.getProperty("path.page.usermain");

        return page;
    }
}
