package com.homework.service;

import com.homework.model.Dish;
import com.homework.model.Order;
import com.homework.model.OrderPosition;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
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
public class OrderServiceTest {

    @Autowired
    private DishService dishService;

    @Autowired
    private OrderService orderService;
    
    @Before
    public void setUp() throws Exception {
        List<Order> all = orderService.getAll();
        all.stream().forEach(e -> orderService.delete(e.getId()));

        Dish dish = new Dish();
        dish.setName("test dish");
        dishService.save(dish);

        Order order = new Order();
        order.setIsClosed(true);
        orderService.save(order);

        OrderPosition position = new OrderPosition();
        position.setOrder(order);
        position.setDish(dish);
        position.setQuantity(10);

        List<OrderPosition> positions = new ArrayList<>();
        positions.add(position);
        order.setOrderContent(positions);
        orderService.save(order);

        Order order2 = new Order();
        order2.setIsClosed(false);
        orderService.save(order2);
    }

    @Test
    public void save() throws Exception {
        Order order = new Order();
        order.setIsClosed(false);
        orderService.save(order);

        List<Order> all = orderService.getAll();
        Assert.assertEquals(all.size(), 3);
    }

    @Test
    public void delete() throws Exception {
        orderService.delete(2L);

        List<Order> all = orderService.getAll();
        Assert.assertEquals(all.size(), 1);
    }
    
    @Test
    public void getById() throws Exception {
        List<Order> all = orderService.getAll();
        Order order = all.get(0);
        String expectedDate = order.getDate();

        order = orderService.getById(order.getId());

        Assert.assertEquals(order.getDate(), expectedDate);
    }

    @Test
    public void getAll() throws Exception {
        List<Order> all = orderService.getAll();
        Assert.assertEquals(all.size(), 2);
    }

    @Test
    @Ignore
    public void getOpen() throws Exception {
        List<Order> all = orderService.getOpen();
        Assert.assertEquals(all.size(), 1);
    }
}