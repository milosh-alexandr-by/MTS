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

import by.it.academy.command.support.DisplayAllTariffs;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by USER on 02.02.2016.
 */

public class GoTariffPageCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        DisplayAllTariffs displayAllTariffs = new DisplayAllTariffs();
        displayAllTariffs.display(request, response);

        page = ConfigurationManager.getProperty("path.page.tariff");

        return page;
    }
}
