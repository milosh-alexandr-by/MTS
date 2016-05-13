/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.user.registration;

import by.it.academy.command.support.DisplayAllServices;
import by.it.academy.command.support.DisplayOneNumber;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.pojos.Service;
import by.it.academy.pojos.User;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.services.ServiceService;
import by.it.academy.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by USER on 05.02.2016.
 */

public class ConnectingServiceCommand implements ActionCommand {

    public static ServiceService serviceService = ServiceService.getInstance();
    public static UserService userService = UserService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        String numberOfService = request.getParameter("numberOfService");
        long serviceId = Long.parseLong(numberOfService);

        userService.addUserService(user, serviceId);

        request.setAttribute("user", user);

        DisplayAllServices displayAllServices = new DisplayAllServices();
        displayAllServices.display(request, response);

        DisplayOneNumber displayOneNumber = new DisplayOneNumber();
        displayOneNumber.display(request, response);

        List<Service> servicesForUser = serviceService.getAllForUser(user);
        request.setAttribute("servicesForUser", servicesForUser);

        String goPage = request.getParameter("goPage");
        if (goPage.equals("connectingService")) {
            page = ConfigurationManager.getProperty("path.page.connectingservice");
        } else if (goPage.equals("changeUserServices")) {
            page = ConfigurationManager.getProperty("path.page.changeuserservices");
        }
        return page;
    }
}
