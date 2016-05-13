/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.user.control;

import by.it.academy.commandMain.ActionCommand;
import by.it.academy.pojos.Number;
import by.it.academy.pojos.Service;
import by.it.academy.pojos.Tariff;
import by.it.academy.pojos.User;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.services.NumberService;
import by.it.academy.services.ServiceService;
import by.it.academy.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by USER on 10.02.2016.
 */
public class GoUserMainFromChangeTariffCommand implements ActionCommand {

    public static NumberService numberService = NumberService.getInstance();
    public static UserService userService = UserService.getInstance();
    public static ServiceService serviceService = ServiceService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        long tariffID = Long.parseLong(request.getParameter("tariff"));
        Tariff tariff = new Tariff();
        tariff.setTariffId(tariffID);

        user.setTariff(tariff);
        userService.addUserTariffById(user, tariffID);

        Number number = numberService.userInfoNumber(user);
        int yourNumber = number.getNumber();
        String yourTariff = userService.userInfoTariff(user);
        int yourAccount = userService.userInfoAccount(user);
        List<Service> yourServices = serviceService.userInfoServices(user);

        request.setAttribute("user", user);
        request.setAttribute("yourNumber", yourNumber);
        request.setAttribute("yourTariff", yourTariff);
        request.setAttribute("yourServices", yourServices);
        request.setAttribute("yourAccount", yourAccount);

        page = ConfigurationManager.getProperty("path.page.usermain");

        return page;
    }
}
