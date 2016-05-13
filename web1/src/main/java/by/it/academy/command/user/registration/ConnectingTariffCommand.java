/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.user.registration;

import by.it.academy.command.support.DisplayAllServices;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.pojos.Service;
import by.it.academy.pojos.Tariff;
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

public class ConnectingTariffCommand implements ActionCommand {

    public static UserService userService = UserService.getInstance();
    public static ServiceService serviceService = ServiceService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        long tariffID = Integer.parseInt(request.getParameter("tariff"));

        Tariff tariff = new Tariff();
        tariff.setTariffId(tariffID);

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        userService.addUserTariffById(user, tariffID);

        request.setAttribute("user", user);

        DisplayAllServices displayAllServices = new DisplayAllServices();
        displayAllServices.display(request, response);

        List<Service> servicesForUser = serviceService.getAllForUser(user);
        request.setAttribute("servicesForUser", servicesForUser);

        page = ConfigurationManager.getProperty("path.page.connectingservice");

        return page;
    }
}
