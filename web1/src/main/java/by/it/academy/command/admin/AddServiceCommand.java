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

import by.it.academy.command.support.DisplayAllServices;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.pojos.Service;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.services.ServiceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by USER on 03.02.2016.
 * Класс для добавления услуги в базу данных
 */
public class AddServiceCommand implements ActionCommand {

    public static ServiceService serviceService = ServiceService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        String title = request.getParameter("title");
        String subscribe = request.getParameter("subscribe");
        int cost = Integer.parseInt(request.getParameter("cost"));

        Service service = new Service();

        service.setServiceName(title);
        service.setSubscribe(subscribe);
        service.setCost(cost);

        serviceService.add(service);

        DisplayAllServices displayAllServices = new DisplayAllServices();
        displayAllServices.display(request, response);

        page = ConfigurationManager.getProperty("path.page.service");

        return page;

    }
}
