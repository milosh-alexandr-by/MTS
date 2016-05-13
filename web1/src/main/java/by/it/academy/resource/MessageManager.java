package by.it.academy.resource;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by USER on 02.02.2016.
 */

public class MessageManager {

    private final static Locale loc = new Locale("en", "US");
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("messages", loc);
    // класс извлекает информацию из файла messages_en_En.properties
    private MessageManager() {}
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
