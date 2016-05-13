/*
 * Copyright (c) 2016, Education Center of High Technologies Park. All rights reserved.
 */

package by.it.academy.pojos;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by USER on 08.02.2016.
 */
@Entity
@Table(name = "number")
public class Number implements Serializable{
    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "number_id")
    private Long numberId;

    @Column(name = "number")
    private int number;

    @Column(name = "beautiful")
    private boolean beautiful;

    @Column(name = "cost")
    private int cost;

    @Column(name = "used")
    private boolean used;

    @ManyToOne
    @JoinColumn(name = "f_user_id")
    private User user;

    private Integer id;

    public Number() {

    }

    public Number(int number, boolean beautiful, int cost, boolean used) {
        this.number = number;
        this.beautiful = beautiful;
        this.cost = cost;
        this.cost = cost;
    }

    public Long getNumberId() {
        return numberId;
    }

    public void setNumberId(Long numberId) {
        this.numberId = numberId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isBeautiful() {
        return beautiful;
    }

    public void setBeautiful(boolean beautiful) {
        this.beautiful = beautiful;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;

        Number number = (Number) o;

        if (!(numberId == number.numberId)) return false;
        if (!(number.equals(number.number))) return false;
        if (!(beautiful == number.beautiful)) return false;
        if (!(cost == number.cost)) return false;
        if (!(used == number.used)) return false;
        if (!(user == number.user)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Number: id = " + this.numberId +
                ", number = " + this.number +
                ", beautiful = " + this.beautiful +
                ", cost = " + this.cost +
                ", used = " + this.used +
                ".";
    }

}
