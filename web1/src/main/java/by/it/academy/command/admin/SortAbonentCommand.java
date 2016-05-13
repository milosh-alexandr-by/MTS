package by.it.academy.command.admin;

import by.it.academy.command.support.DisplayAllUsers;
import by.it.academy.command.support.DisplayAllUsersSort;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.resource.ConfigurationManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by USER on 11.05.2016.
 */
public class SortAbonentCommand implements ActionCommand {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        DisplayAllUsersSort displayAllUsersSort = new DisplayAllUsersSort();
        displayAllUsersSort.display(request, response);

        page = ConfigurationManager.getProperty("path.page.abonent");

        return page;
    }


}
