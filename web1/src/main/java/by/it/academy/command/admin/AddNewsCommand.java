package by.it.academy.command.admin;

import by.it.academy.command.support.DisplayAllNewsPagination;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.pojos.*;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.services.NewsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by USER on 11.05.2016.
 */
public class AddNewsCommand implements ActionCommand {

    public static NewsService newsService = NewsService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        String content = request.getParameter("content");

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.mm.yy hh:mm");
        String contentNew = "" + simpleDateFormat.format(date) + "\n" + content;

        News news = new News();

        news.setContent(contentNew);

        newsService.add(news);

        DisplayAllNewsPagination displayAllNewsPagination = new DisplayAllNewsPagination();
        displayAllNewsPagination.display(request, response);

        int currentPage = Integer.parseInt(request.getParameter("changePage"));

        List<Integer> infoNewsesPagination = newsService.infoNewsesPagination(currentPage);
        request.setAttribute("infoNewsesPagination", infoNewsesPagination);

        page = ConfigurationManager.getProperty("path.page.news");

        return page;

    }

}
