package com.homework.service;

import com.homework.model.Dish;
import com.homework.model.DishComponent;
import com.homework.model.Ingredient;
import com.homework.model.KitchenJournalItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class KitchenJournalServiceTest {

    @Autowired
    private KitchenJournalService kitchenJournalService;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private DishService dishService;

    @Before
    public void setUp() throws Exception {
        List<KitchenJournalItem> all = kitchenJournalService.getAll();
        all.stream().forEach(e -> kitchenJournalService.delete(e.getId()));

        Dish dish = new Dish();
        dish.setName("test dish");
        dishService.save(dish);

        KitchenJournalItem kitchenItem = new KitchenJournalItem();
        kitchenItem.setDish(dish);
        kitchenJournalService.save(kitchenItem);
    }

    @Test
    public void save() throws Exception {
        Dish dish = new Dish();
        dish.setName("test dish");
        dishService.save(dish);

        KitchenJournalItem kitchenItem = new KitchenJournalItem();
        kitchenItem.setDish(dish);
        kitchenJournalService.save(kitchenItem);

        List<KitchenJournalItem> all = kitchenJournalService.getAll();
        Assert.assertEquals(all.size(), 2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void saveNoIngredient() throws Exception {
        Ingredient ingredient = new Ingredient();
        ingredient.setName("test ingredient");
        ingredient.setQuantity(2);
        ingredientService.save(ingredient);

        Dish dish = new Dish();
        dish.setName("test dish");
        dishService.save(dish);

        DishComponent component = new DishComponent();
        component.setDish(dish);
        component.setIngredient(ingredient);
        component.setQuantity(3);

        List<DishComponent> components = new ArrayList<>();
        components.add(component);
        dish.setComponents(components);
        dishService.save(dish);

        KitchenJournalItem kitchenItem = new KitchenJournalItem();
        kitchenItem.setDish(dish);
        kitchenJournalService.save(kitchenItem);
    }

    @Test
    public void delete() throws Exception {
        kitchenJournalService.delete(1L);

        List<KitchenJournalItem> all = kitchenJournalService.getAll();
        Assert.assertEquals(all.size(), 0);
    }

    @Test
    public void getById() throws Exception {
        List<KitchenJournalItem> all = kitchenJournalService.getAll();
        KitchenJournalItem kitchenItem = all.get(0);
        String expectedDate = kitchenItem.getDate();

        kitchenItem = kitchenJournalService.getById(kitchenItem.getId());

        Assert.assertEquals(kitchenItem.getDate(), expectedDate);
    }

    @Test
    public void getAll() throws Exception {
        List<KitchenJournalItem> all = kitchenJournalService.getAll();
        Assert.assertEquals(all.size(), 1);
    }

}