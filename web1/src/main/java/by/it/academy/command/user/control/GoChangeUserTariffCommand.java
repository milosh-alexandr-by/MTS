/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.user.control;

import by.it.academy.command.support.DisplayAllTariffs;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.pojos.User;
import by.it.academy.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by USER on 10.02.2016.
 */
public class GoChangeUserTariffCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        String userLogin = request.getParameter("userLogin");
        request.setAttribute("userLogin", userLogin);

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        request.setAttribute("user", user);

        DisplayAllTariffs displayAllTariffs = new DisplayAllTariffs();
        displayAllTariffs.display(request, response);

        page = ConfigurationManager.getProperty("path.page.changeusertariff");

        return page;
    }
}
