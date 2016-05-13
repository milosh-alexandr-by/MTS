/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.dao;

import by.it.academy.pojos.User;

import java.util.List;

/**
 * Created by USER on 02.02.2016.
 */

public interface UserDao extends Dao<User> {

    /** получить абонента по логину и паролю
     * @param user - объект абонента
     * @return объект абонента */
    public User getByLoginAndPassword(User user);

    /** получить ID-номер абонента
     * @param user - объект абонента
     * @return ID-номер абонента  */
    public long getIdUser(User user);

    /** получить тариф, к которому подключен абонент
     * @param user - объект абонента
     * @return название тарифа */
    public String userInfoTariff(User user);

    /** узнать количество денег на лицевом счёте абонента
     * @param user - объект абонента
     * @return число денег на счёте */
    public int userInfoAccount(User user);

    /** закрепить тарифф за абонентом
     * @param user - объект абонента */
    public void addUserTariffById(User user, long tariff_id);

    /** подключить абонента к выбранному сервису
     * @param user - объект абонента
     * @param serviceId - ID-номкр сервиса */
    public void addUserService(User user, long serviceId);

    /** положить деньги на счёт абонента
     * @param user - объект абонента
     * @param changeAccount - количество денег, которые надо положить */
    public void changeUserAccount(User user, int changeAccount);

    /** отключить абонента от сервиса
     * @param user - объект абонента
     * @param serviceId - ID-номкр сервиса */
    public void deleteUserService(User user, long serviceId);

    /** получить абонента по логину
     * @param login - логин абонента
     * @return объект абонента */
    public User getUserByLogin(String login);

    /** получить список абонентов, отсортированных по параметру operation
     * @param operation - имя поля, по которому идёт сортировка
     * @param sortParam - параметр сортировки: от большего к меньшему или от меньшего к большему
     * @return отсортированный список абонентов  */
    public List<User> getAllSort(String operation, String sortParam);

}
