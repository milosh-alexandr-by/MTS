/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package by.it.academy.dao;

import by.it.academy.pojos.Service;
import by.it.academy.pojos.User;

import java.util.List;

/**
 * Created by USER on 02.02.2016.
 */

public interface ServiceDao extends Dao<Service> {

    /** получить список сервисов, к которым подключен абонент
     * @param user - объект абонента
     * @return список сервисов */
    public List<Service> userInfoServices(User user);

    /** получить список сервисов, к которым подключен абонент
     * @param user - объект абонента
     * @return список сервисов */
    public List<Service> getAllForUser(User user);


}
