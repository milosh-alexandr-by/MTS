/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.main;

import by.it.academy.command.support.DisplayAllTariffs;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.services.TariffService;
import by.it.academy.services.UserService;
import by.it.academy.support.CookiesController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by USER on 05.02.2016.
 */

public class GoTariffMainPageCommand implements ActionCommand {

    public static TariffService tariffService = TariffService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        DisplayAllTariffs displayAllTariffs = new DisplayAllTariffs();
        displayAllTariffs.display(request, response);

        CookiesController cookiesController = new CookiesController();
        cookiesController.getCookies(request, response);

        page = ConfigurationManager.getProperty("path.page.tariffMain");

        return page;
    }
}
