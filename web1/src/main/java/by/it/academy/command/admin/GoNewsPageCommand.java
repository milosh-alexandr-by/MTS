package by.it.academy.command.admin;

import by.it.academy.command.support.DisplayAllNewsPagination;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.services.NewsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by USER on 11.05.2016.
 */
public class GoNewsPageCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        NewsService newsService = NewsService.getInstance();

        DisplayAllNewsPagination displayAllNewsPagination = new DisplayAllNewsPagination();
        displayAllNewsPagination.display(request, response);

        int currentPage = 1;

        List<Integer> infoNewsesPagination = newsService.infoNewsesPagination(currentPage);

        request.setAttribute("infoNewsesPagination", infoNewsesPagination);

        page = ConfigurationManager.getProperty("path.page.news");

        return page;
    }

}
