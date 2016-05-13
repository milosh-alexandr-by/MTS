package by.it.academy.support;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by USER on 21.04.2016.
 */

public class CookiesController {

    public void getCookies(HttpServletRequest request, HttpServletResponse response) {
        String loginCookie = null;
        Cookie[] cookies = request.getCookies();
        String cookName = "userLoginCookie";
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                Cookie сook = cookies[i];
                if (cookName.equals(сook.getName())) {
                    loginCookie = сook.getValue();
                    break;
                }
            }
        }
        request.setAttribute("loginCookie", loginCookie);
    }

    public void deleteCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = null;
        Cookie[] cookies =  request.getCookies();
        String cookName = "userLoginCookie";
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().equals(cookName)) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }
            }
        }
    }




}