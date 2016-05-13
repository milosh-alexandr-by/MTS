/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package by.it.academy.command.admin;

import by.it.academy.command.support.DisplayAllUsers;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by USER on 11.02.2016.
 */
public class GoAbonentPageCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        DisplayAllUsers displayAllUsers = new DisplayAllUsers();
        displayAllUsers.display(request, response);

        String sortParam = request.getParameter("sortParam");
        request.setAttribute("sortParam", sortParam);

        page = ConfigurationManager.getProperty("path.page.abonent");

        return page;
    }
}
