/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.support;

import by.it.academy.pojos.Number;
import by.it.academy.services.NumberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by USER on 03.02.2016.
 */
public class DisplayAllNumbers {

    public void display(HttpServletRequest request, HttpServletResponse response) {

        NumberService numberService = NumberService.getInstance();

        List<Number> numbers = numberService.getAll();
        request.setAttribute("numbers", numbers);

    }

}
