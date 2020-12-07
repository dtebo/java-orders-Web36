package com.lambdaschool.javaorders.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long ordernum;

    private double ordamount;
    private double advanceamount;

    private String orderdescription;

    @ManyToOne()
    @JoinColumn(name = "custcode", nullable = false)
    @JsonIgnoreProperties(value = "orders", allowSetters = true)
    private Customer customer;

    @ManyToMany()
    @JoinTable(name = "orderspayments",
               joinColumns = @JoinColumn(name = "ordernum"),
               inverseJoinColumns = @JoinColumn(name = "paymentid"))
    @JsonIgnoreProperties(value = "orders", allowSetters = true)
    private Set<Payment> payments = new HashSet<>();

    public Order() {
    }

    public Order(double ordamount, double advanceamount, Customer customer, String orderdescription) {
        this.ordamount = ordamount;
        this.advanceamount = advanceamount;
        this.customer = customer;
        this.orderdescription = orderdescription;
    }

    public long getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(long ordernum) {
        this.ordernum = ordernum;
    }

    public double getOrdamount() {
        return ordamount;
    }

    public void setOrdamount(double ordamount) {
        this.ordamount = ordamount;
    }

    public double getAdvanceamount() {
        return advanceamount;
    }

    public void setAdvanceamount(double advanceamount) {
        this.advanceamount = advanceamount;
    }

    public String getOrderdescription() {
        return orderdescription;
    }

    public void setOrderdescription(String orderdescription) {
        this.orderdescription = orderdescription;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Order{" +
                "ordernum=" + ordernum +
                ", ordamount=" + ordamount +
                ", advanceamount=" + advanceamount +
                ", customer=" + customer +
                ", orderdescription =" + orderdescription +
                '}';
    }
}
