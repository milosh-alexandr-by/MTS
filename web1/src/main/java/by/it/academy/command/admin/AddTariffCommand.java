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

import by.it.academy.command.support.DisplayAllTariffs;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.pojos.Tariff;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.services.TariffService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by USER on 02.02.2016.
 * Класс для добавления тарифа в базу данных
 */
public class AddTariffCommand implements ActionCommand {

    public static TariffService tariffService = TariffService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        String title = request.getParameter("title");
        int costPerMinute = Integer.parseInt(request.getParameter("costPerMinute"));
        int abonentCost = Integer.parseInt(request.getParameter("abonentCost"));

        Tariff tariff = new Tariff();

        tariff.setTariffName(title);
        tariff.setCostPerMinute(costPerMinute);
        tariff.setAbonentCost(abonentCost);

        tariffService.add(tariff);

        DisplayAllTariffs displayAllTariffs = new DisplayAllTariffs();
        displayAllTariffs.display(request, response);

        page = ConfigurationManager.getProperty("path.page.tariff");

        return page;
    }
}
