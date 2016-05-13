package by.it.academy.resource;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by USER on 02.02.2016.
 */

public class ConfigurationManager {

    private final static Locale loc = new Locale("en", "US");
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config", loc);
    // класс извлекает информацию из файла config_en_En.properties
    private ConfigurationManager() {}
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}
