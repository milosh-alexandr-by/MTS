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

import by.it.academy.command.support.DisplayAllNumbers;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by USER on 03.02.2016.
 */

public class GoNumberPageCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        DisplayAllNumbers displayAllNumbers = new DisplayAllNumbers();
        displayAllNumbers.display(request, response);

        page = ConfigurationManager.getProperty("path.page.number");

        return page;
    }
}
