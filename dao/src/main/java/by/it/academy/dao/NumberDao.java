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

import by.it.academy.pojos.Number;
import by.it.academy.pojos.User;

/**
 * Created by USER on 02.02.2016.
 */

public interface NumberDao extends Dao<Number> {

    /** получить из базы один номер телефона для пользователя
     * @return номер телефона */
    public int oneNumberFromBase();

    /** закрепить выбранный номер из базы для абонента
     * @param user - объект абонента
     * @param numberOfUser - номер телефона */
    public void addNumberUser(User user, int numberOfUser);



}
