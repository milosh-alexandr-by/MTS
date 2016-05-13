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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 08.02.2016.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "account")
    private int account;

    @ManyToOne
    @JoinColumn(name = "f_tariff_id")
    private Tariff tariff;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "t_user_service",
            joinColumns = {@JoinColumn(name = "f_user_id")},
            inverseJoinColumns = {@JoinColumn(name = "f_service_id")})
    private List<Service> services = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<Number> numbers;

    private boolean valid;

    public User() {

    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public Tariff getTariff() {
        return tariff;
    }

    public void setTariff(Tariff tariff) {
        this.tariff = tariff;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Service> getServices() {
        return services;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!(id == user.id)) return false;
        if (!(login.equals(user.login))) return false;
        if (!(password.equals(user.password))) return false;
        if (!(account == user.account)) return false;
        if (!(tariff == user.tariff)) return false;
        if (!(services == user.services)) return false;
        if (!(numbers == user.numbers)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "User: id = " + this.id +
                ", login = " + this.login +
                ", password = " + this.password +
                ", account = " + this.account +
                ".";
    }

}
