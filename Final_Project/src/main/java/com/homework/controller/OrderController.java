package com.homework.controller;

import com.homework.model.Dish;
import com.homework.model.Employee;
import com.homework.model.Order;
import com.homework.model.Position;
import com.homework.service.DishService;
import com.homework.service.EmployeeService;
import com.homework.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyEditorSupport;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DishService dishService;

    @RequestMapping("/orders")
    public String printList(ModelMap model) {
        model.addAttribute("orders", orderService.getAll());
        return "orders";
    }

    @RequestMapping("/orders/open")
    public String printOpen(ModelMap model) {
        model.addAttribute("orders", orderService.getOpen());
        return "orders";
    }

    @RequestMapping(value = "/orders/delete/{id}", method=RequestMethod.GET)
    public String delete(@PathVariable("id")long id, ModelMap model) {
        orderService.delete(id);
        return "redirect:/orders";
    }

    @RequestMapping(value = "/orders/edit/{id}", method=RequestMethod.GET)
    public String edit(@PathVariable("id")long id, ModelMap model) {
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("dishes", dishService.getAll());
        model.addAttribute("order", orderService.getById(id));
        return "order";
    }

    @RequestMapping(value = "/orders/view/{id}", method=RequestMethod.GET)
    public String view(@PathVariable("id")long id, ModelMap model) {
        model.addAttribute("order", orderService.getById(id));
        return "order-preview";
    }

    @RequestMapping(value = "/orders/search", method=RequestMethod.GET)
    public String find(@RequestParam("name")String name, ModelMap model) {
        model.addAttribute("orders", orderService.getByName(name));
        return "orders";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String create(ModelMap model) {
        model.addAttribute("employees", employeeService.getAll());
        model.addAttribute("dishes", dishService.getAll());
        model.addAttribute("order", new Order());
        return "order";
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String submit(@ModelAttribute("order") Order order) {
        orderService.save(order);
        return "redirect:orders";
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
}