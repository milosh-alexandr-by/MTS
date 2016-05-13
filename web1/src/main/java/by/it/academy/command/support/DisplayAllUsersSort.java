package by.it.academy.command.support;

import by.it.academy.pojos.User;
import by.it.academy.services.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by USER on 11.05.2016.
 */
public class DisplayAllUsersSort {

    public void display(HttpServletRequest request, HttpServletResponse response) {

        UserService userService = UserService.getInstance();

        String operation = request.getParameter("operation");
        String sortParam = request.getParameter("sortParam");

        List<User> users = userService.getAllSort(operation, sortParam);
        request.setAttribute("users", users);

        if (sortParam.equals("small")) {
            request.setAttribute("sortParam", "big");
        } else if (sortParam.equals("big")) {
            request.setAttribute("sortParam", "small");
        }
    }

}
