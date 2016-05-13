package by.it.academy.command.user.control;

import by.it.academy.command.support.DisplayAllServices;
import by.it.academy.commandMain.ActionCommand;
import by.it.academy.pojos.Service;
import by.it.academy.pojos.User;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.services.ServiceService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by USER on 18.04.2016.
 */
public class GoChangeUserServicesCommand implements ActionCommand {

    ServiceService serviceService = ServiceService.getInstance();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;

        String userLogin = request.getParameter("userLogin");
        request.setAttribute("userLogin", userLogin);

        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");

        request.setAttribute("user", user);

        DisplayAllServices displayAllServices = new DisplayAllServices();
        displayAllServices.display(request, response);

        List<Service> servicesForUser = serviceService.getAllForUser(user);
        request.setAttribute("servicesForUser", servicesForUser);

        page = ConfigurationManager.getProperty("path.page.changeuserservices");

        return page;
    }

}
