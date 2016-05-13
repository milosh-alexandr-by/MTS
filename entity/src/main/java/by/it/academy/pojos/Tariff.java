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

package by.it.academy.pojos;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by USER on 08.02.2016.
 */
@Entity
@Table(name = "tariff")
public class Tariff implements Serializable {
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tariff_id")
    private Long tariffId;

    @Column(name = "tariffName")
    private String tariffName;

    @Column(name = "abonentCost")
    private int abonentCost;

    @Column(name = "costPerMinute")
    private int costPerMinute;

    @OneToMany(mappedBy = "tariff")
    private List<User> users;

    public Tariff() {

    }

    public Tariff(String tariffName, int costPerMinute, int abonentCost) {
        this.tariffName = tariffName;
        this.costPerMinute = costPerMinute;
        this.abonentCost = abonentCost;
    }

    public Long getTariffId() {
        return tariffId;
    }

    public void setTariffId(Long tariffId) {
        this.tariffId = tariffId;
    }

    public String getTariffName() {
        return tariffName;
    }

    public void setTariffName(String tariffName) {
        this.tariffName = tariffName;
    }

    public int getCostPerMinute() {
        return costPerMinute;
    }

    public void setCostPerMinute(int costPerMinute) {
        this.costPerMinute = costPerMinute;
    }

    public int getAbonentCost() {
        return abonentCost;
    }

    public void setAbonentCost(int abonentCost) {
        this.abonentCost = abonentCost;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tariff)) return false;

        Tariff tariff = (Tariff) o;

        if (!(tariffId == tariff.tariffId)) return false;
        if (!(tariffName.equals(tariff.tariffName))) return false;
        if (!(abonentCost == tariff.abonentCost)) return false;
        if (!(costPerMinute == tariff.costPerMinute)) return false;
        if (!(users == tariff.users)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Tariff: id = " + this.tariffId +
                ", tariffName = " + this.tariffName +
                ", abonentCost = " + this.abonentCost +
                ", costPerMinute = " + this.costPerMinute +
                ".";
    }
}
