package by.it.academy.command.support;

import by.it.academy.pojos.*;
import by.it.academy.pojos.Number;
import by.it.academy.services.NewsService;
import by.it.academy.services.NumberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by USER on 11.05.2016.
 */
public class DisplayAllNewsPagination {

    public void display(HttpServletRequest request, HttpServletResponse response) {

        NewsService newsService = NewsService.getInstance();

        int firstElement = Integer.parseInt(request.getParameter("changePage"));

        String inverse = request.getParameter("inverse");
        if (inverse.equals("yes")) {
            List<News> newsesPaginationInverse = newsService.getAllPaginationInverse(firstElement);
            request.setAttribute("newsesPaginationInverse", newsesPaginationInverse);
        } else if (inverse.equals("no")) {
            List<News> newsesPagination = newsService.getAllPagination(firstElement);
            request.setAttribute("newsesPagination", newsesPagination);
        }



    }

}
