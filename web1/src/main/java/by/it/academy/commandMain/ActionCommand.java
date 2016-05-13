package by.it.academy.commandMain;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by USER on 02.02.2016.
 */

public interface ActionCommand {

    String execute(HttpServletRequest request, HttpServletResponse response);

}
