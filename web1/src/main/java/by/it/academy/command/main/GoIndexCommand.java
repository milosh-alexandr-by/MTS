package by.it.academy.command.main;

import by.it.academy.command.support.DisplayAllNewsPagination;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.pojos.User;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.services.NewsService;
import by.it.academy.services.UserService;
import by.it.academy.support.CookiesController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by USER on 11.05.2016.
 */
public class GoIndexCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        NewsService newsService = NewsService.getInstance();
        UserService userService = UserService.getInstance();

        DisplayAllNewsPagination displayAllNewsPagination = new DisplayAllNewsPagination();
        displayAllNewsPagination.display(request, response);

        int currentPage = 1;

        List<Integer> infoNewsesPagination = newsService.infoNewsesPagination(currentPage);
        request.setAttribute("infoNewsesPagination", infoNewsesPagination);

        CookiesController cookiesController = new CookiesController();
        cookiesController.getCookies(request, response);

        String loginParam = null;
        loginParam = (String)request.getAttribute("loginCookie");

        if (loginParam != null ) {
            HttpSession session = request.getSession();
            session.setAttribute("user", userService.getUserByLogin(loginParam));
        }

        String hello = "Privet";
        request.setAttribute("hello", hello);

        String page = ConfigurationManager.getProperty("path.page.index");

        return page;
    }

}
