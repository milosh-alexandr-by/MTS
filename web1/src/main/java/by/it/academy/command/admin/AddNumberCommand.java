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

import by.it.academy.command.support.DisplayAllNumbers;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.pojos.Number;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.services.NumberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by USER on 03.02.2016.
 * Класс для добавления номера в базу данных
 */
public class AddNumberCommand implements ActionCommand {

    public static NumberService numberService = NumberService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        int number1 = Integer.parseInt(request.getParameter("number"));
        boolean beautiful = Boolean.parseBoolean(request.getParameter("beautiful"));
        int cost = Integer.parseInt(request.getParameter("cost"));
        boolean used = Boolean.parseBoolean(request.getParameter("used"));

        Number number = new Number();

        number.setNumber(number1);
        number.setBeautiful(beautiful);
        number.setCost(cost);
        number.setUsed(used);

        numberService.add(number);

        DisplayAllNumbers displayAllNumbers = new DisplayAllNumbers();
        displayAllNumbers.display(request, response);

        page = ConfigurationManager.getProperty("path.page.number");

        return page;

    }
}
