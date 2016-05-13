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
@Table(name = "service")
public class Service implements Serializable {
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "service_id")
    private Long serviceId;

    @Column(name = "serviceName")
    private String serviceName;

    @Column(name = "subscribe")
    private String subscribe;

    @Column(name = "cost")
    private int cost;

    @ManyToMany(mappedBy = "services")
    private List<User> users = new ArrayList<>();

    private boolean userUsed;

    public Service() {

    }

    public Service(String serviceName, String subscribe, int cost) {
        this.serviceName = serviceName;
        this.subscribe = subscribe;
        this.cost = cost;
    }

    public long getServiceId() {
        return serviceId;
    }

    public void setServiceId(long serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getSubscribe() {
        return subscribe;
    }

    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public boolean isUserUsed() {
        return userUsed;
    }

    public void setUserUsed(boolean userUsed) {
        this.userUsed = userUsed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Service)) return false;

        Service service = (Service) o;

        if (!(serviceId == service.serviceId)) return false;
        if (!(serviceName.equals(service.serviceName))) return false;
        if (!(subscribe.equals(service.subscribe))) return false;
        if (!(cost == service.cost)) return false;
        if (!(users == service.users)) return false;

        return true;
    }

    @Override
    public String toString() {
        return "Service: id = " + this.serviceId +
                ", serviceName = " + this.serviceName +
                ", subscribe = " + this.subscribe +
                ", cost = " + this.cost +
                ", userUsed = " + this.userUsed +
                ".";
    }

}
