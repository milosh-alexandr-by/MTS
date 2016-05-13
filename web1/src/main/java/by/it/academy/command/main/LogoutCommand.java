/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.main;

import by.it.academy.commandMain.ActionCommand;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.support.CookiesController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by USER on 02.02.2016.
 */

public class LogoutCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        // удаление логина пользователя из куки
        CookiesController cookiesController = new CookiesController();
        cookiesController.deleteCookies(request, response);

        // уничтожение сессии
        request.getSession().invalidate();

        String page = ConfigurationManager.getProperty("path.page.first");
        return page;
    }
}
