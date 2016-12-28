package com.homework.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TABLE_NUMBER")
    private int tableNumber;

    @Column(name = "DATE")
    private String date = String.valueOf(new Date());

    @ManyToOne
    @JoinColumn(name = "WAITER")
    private Employee waiter;

    @OneToMany(mappedBy="order", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @Fetch(FetchMode.SELECT)
    private List<OrderPosition> orderContent = new ArrayList<>();

    @Column(name = "CLOSED")
    private Boolean isClosed;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<OrderPosition> getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(List<OrderPosition> orderContent) {
        this.orderContent = orderContent;
    }

    public Employee getWaiter() {
        return waiter;
    }

    public void setWaiter(Employee waiter) {
        this.waiter = waiter;
    }

    public Boolean getIsClosed() {
        return isClosed;
    }

    public void setIsClosed(boolean closed) {
        isClosed = closed;
    }
}
