package by.it.academy.util;

import org.hibernate.cfg.DefaultNamingStrategy;

/**
 * Created by USER on 01.05.2016.
 */
public class CustomNamingStrategy extends DefaultNamingStrategy {
    public String classToTableName(String className) {
        return "t_" + super.classToTableName(className);
    }

    public String propertyToColumnName(String propName) {
        return "f_" + super.classToTableName(propName);
    }

    public String tableName(String tableName) {
        return tableName;
    }

    public String columnName(String  columnName) {
        return columnName;
    }
}
