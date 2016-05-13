/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.support;

import by.it.academy.services.NumberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by USER on 10.02.2016.
 */
public class DisplayOneNumber {

    public void display(HttpServletRequest request, HttpServletResponse response) {

        NumberService numberService = NumberService.getInstance();

        int oneNumberFromBase = numberService.oneNumberFromBase();

        request.setAttribute("oneNumberFromBase", oneNumberFromBase);

    }

}
