/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.support;

import by.it.academy.pojos.Tariff;
import by.it.academy.services.TariffService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by USER on 02.02.2016.
 */

public class DisplayAllTariffs {

    public void display(HttpServletRequest request, HttpServletResponse response) {

        TariffService tariffService = TariffService.getInstance();

        List<Tariff> tariffs = tariffService.getAll();
        request.setAttribute("tariffs", tariffs);

    }

}
