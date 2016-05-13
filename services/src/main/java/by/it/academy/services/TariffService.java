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

package by.it.academy.services;

import by.it.academy.daoImpl.TariffDaoImpl;
import by.it.academy.pojos.Tariff;

import java.util.List;

/**
 * Created by USER on 02.02.2016.
 */

public class TariffService {

    private static TariffService instance;
    private TariffService() {
    }
    public static synchronized TariffService getInstance() {
        if (instance == null) {
            instance = new TariffService();
        }
        return instance;
    }

    TariffDaoImpl tariffDaoImpl = TariffDaoImpl.getInstance();

    public List<Tariff> getAll() {
        return tariffDaoImpl.getAll();
    }

    public void add(Tariff tariff) {
        tariffDaoImpl.add(tariff);
    }

}
