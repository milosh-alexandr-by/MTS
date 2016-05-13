/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.command.main;

import by.it.academy.commandMain.ActionCommand;
import by.it.academy.pojos.Number;
import by.it.academy.pojos.Service;
import by.it.academy.pojos.User;
import by.it.academy.resource.ConfigurationManager;
import by.it.academy.resource.MessageManager;
import by.it.academy.services.NumberService;
import by.it.academy.services.ServiceService;
import by.it.academy.services.UserService;
import by.it.academy.support.CookiesController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by USER on 02.02.2016.
 */

public class LoginCommand implements ActionCommand {

    NumberService numberService = NumberService.getInstance();
    UserService userService = UserService.getInstance();

    private static final String PARAM_NAME_LOGIN = "userLogin";
    private static final String PARAM_NAME_PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String page = null;
        //извлечение из запроса логина и пароля
        String userLogin = request.getParameter(PARAM_NAME_LOGIN);
        String pass = request.getParameter(PARAM_NAME_PASSWORD);
        User user = new User();
        HttpSession session = request.getSession();

        // проверка логина и пароля
        if (LoginLogic.checkLogin(userLogin, pass)) {
            user.setLogin(userLogin);
            user.setPassword(pass);

            // создание cookie
            Cookie userLoginCookie = new Cookie("userLoginCookie", userLogin);
            response.addCookie(userLoginCookie);

            session.setAttribute("user", user);
            request.setAttribute("userLogin", userLogin);
            // определение пути к main.jsp
                if (user.getLogin().equals("admin")) {
                    page = ConfigurationManager.getProperty("path.page.adminmain");
                } else {

                    CookiesController cookiesController = new CookiesController();
                    cookiesController.getCookies(request, response);

                    long user_id = userService.getIdUser(user);
                        user.setId(user_id);
                    Number number = numberService.userInfoNumber(user);
                    int yourNumber = number.getNumber();
                    String yourTariff = userService.userInfoTariff(user);
//                        user.setTariffName(yourTariff);
                    int yourAccount = userService.userInfoAccount(user);
                        user.setAccount(yourAccount);
                    ServiceService serviceService = ServiceService.getInstance();
                    List<Service> yourServices = serviceService.userInfoServices(user);
                        user.setServices(yourServices);
                    request.setAttribute("yourNumber", yourNumber);
                    request.setAttribute("yourTariff", yourTariff);
                    request.setAttribute("yourServices", yourServices);
                    request.setAttribute("yourAccount", yourAccount);
                    request.setAttribute("user", user);
                    page = ConfigurationManager.getProperty("path.page.usermain");
                }
        } else {
            request.setAttribute("errorLoginPassMessage",
                    MessageManager.getProperty("message.loginerror"));
            page = ConfigurationManager.getProperty("path.page.login");
        }
        return page;
    }
}
