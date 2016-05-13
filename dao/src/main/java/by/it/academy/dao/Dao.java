package by.it.academy.dao;

import java.util.List;

/**
 * Created by USER on 08.02.2016.
 */

public interface Dao<T> {

    /** получить из базы коллекцию всех сущностей
     * @return ArrayList коллекция сущностей */
    public List<T> getAll();

    /** добавить сущность в базу
     * @param entity сущность */
    public void add(T entity);

}
