package by.it.academy.command.main;

import by.it.academy.command.support.DisplayAllNewsPagination;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.services.NewsService;
import by.it.academy.support.CookiesController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by USER on 11.05.2016.
 */
public class ChangeNewsPageMainCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        NewsService newsService = NewsService.getInstance();

        DisplayAllNewsPagination displayAllNewsPagination = new DisplayAllNewsPagination();
        displayAllNewsPagination.display(request, response);

        int currentPage = Integer.parseInt(request.getParameter("changePage"));

        List<Integer> infoNewsesPagination = newsService.infoNewsesPagination(currentPage);

        request.setAttribute("infoNewsesPagination", infoNewsesPagination);

        CookiesController cookiesController = new CookiesController();
        cookiesController.getCookies(request, response);

        page = ConfigurationManager.getProperty("path.page.index");

        return page;
    }

}
