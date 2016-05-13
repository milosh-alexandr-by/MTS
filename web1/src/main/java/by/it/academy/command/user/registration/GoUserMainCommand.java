/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.user.registration;

import by.it.academy.commandMain.ActionCommand;
import by.it.academy.pojos.User;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.services.NumberService;
import by.it.academy.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by USER on 10.02.2016.
 */
public class GoUserMainCommand implements ActionCommand {

    public static NumberService numberService = NumberService.getInstance();
    public static UserService userService = UserService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        if (user.getLogin().equals("admin")) {
            page = ConfigurationManager.getProperty("path.page.adminmain");
        } else {
            // определяет из какой jsp-шки пришёл запрос
            if (request.getParameter("goPage").equals("connectingNumber")) {
                int numberOfUser = Integer.parseInt(request.getParameter("number"));
                numberService.addNumberUser(user, numberOfUser);
            }

            request.setAttribute("user", user);

            int yourNumber = numberService.userInfoNumber(user).getNumber();
            request.setAttribute("yourNumber", yourNumber);

            String yourTariff = userService.userInfoTariff(user);
            request.setAttribute("yourTariff", yourTariff);

            int yourAccount = userService.userInfoAccount(user);
            request.setAttribute("yourAccount", yourAccount);

            page = ConfigurationManager.getProperty("path.page.usermain");
        }

        return page;
    }
}
