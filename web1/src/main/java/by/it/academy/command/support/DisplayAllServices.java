/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.support;

import by.it.academy.pojos.Service;
import by.it.academy.services.ServiceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by USER on 03.02.2016.
 */

public class DisplayAllServices {

    public void display(HttpServletRequest request, HttpServletResponse response) {

        ServiceService serviceService = ServiceService.getInstance();

        List<Service> services = serviceService.getAll();
        request.setAttribute("services", services);

    }

}
