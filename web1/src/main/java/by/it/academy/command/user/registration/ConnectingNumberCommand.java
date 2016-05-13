/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.user.registration;

import by.it.academy.command.support.DisplayOneNumber;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.pojos.User;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.services.NumberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by USER on 10.02.2016.
 */
public class ConnectingNumberCommand implements ActionCommand {

    public static NumberService numberService = NumberService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
            String page = null;

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        request.setAttribute("user", user);

        DisplayOneNumber displayOneNumber = new DisplayOneNumber();
        displayOneNumber.display(request, response);

        page = ConfigurationManager.getProperty("path.page.connectingnumber");
        return page;
    }
}
