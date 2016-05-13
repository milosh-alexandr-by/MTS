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

package by.it.academy.command.main;

import by.it.academy.commandMain.ActionCommand;
import by.it.academy.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by USER on 02.02.2016.
 */

public class EmptyCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
    	/*
			 * в случае ошибки или прямого обращения к контроллеру
			 * переадресация на страницу ввода логина
	     */
        String page = ConfigurationManager.getProperty("path.page.login");
        return page;
    }
}
