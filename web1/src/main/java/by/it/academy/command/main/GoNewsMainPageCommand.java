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

import by.it.academy.command.support.DisplayAllNewsPagination;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.services.NewsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by USER on 05.02.2016.
 */

public class GoNewsMainPageCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        NewsService newsService = NewsService.getInstance();

        DisplayAllNewsPagination displayAllNewsPagination = new DisplayAllNewsPagination();
        displayAllNewsPagination.display(request, response);

        int currentPage = 1;

        List<Integer> infoNewsesPagination = newsService.infoNewsesPagination(currentPage);

        request.setAttribute("infoNewsesPagination", infoNewsesPagination);

        page = ConfigurationManager.getProperty("path.page.newsMain");

        return page;
    }
}
