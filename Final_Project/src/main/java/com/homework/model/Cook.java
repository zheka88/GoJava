package com.homework.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Cook extends Employee {

    @OneToMany(mappedBy = "cook",
            fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<KitchenJournalItem> cookedDishes;

    public List<KitchenJournalItem> getCookedDishes() {
        return cookedDishes;
    }

    public void setCookedDishes(List<KitchenJournalItem> cookedDishes) {
        this.cookedDishes = cookedDishes;
    }
}
