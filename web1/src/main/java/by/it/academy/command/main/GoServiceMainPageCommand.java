/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.main;

import by.it.academy.command.support.DisplayAllServices;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.services.ServiceService;
import by.it.academy.services.UserService;
import by.it.academy.support.CookiesController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by USER on 05.02.2016.
 */

public class GoServiceMainPageCommand implements ActionCommand {

    public static ServiceService serviceService = ServiceService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        DisplayAllServices displayAllServices = new DisplayAllServices();
        displayAllServices.display(request, response);

        CookiesController cookiesController = new CookiesController();
        cookiesController.getCookies(request, response);

        page = ConfigurationManager.getProperty("path.page.serviceMain");

        return page;
    }
}
