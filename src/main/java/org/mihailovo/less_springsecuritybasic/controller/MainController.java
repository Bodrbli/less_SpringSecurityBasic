package org.mihailovo.less_springsecuritybasic.controller;

import org.mihailovo.less_springsecuritybasic.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/customers")
public class MainController {
    private final List<Customer> CUSTOMERS = baseInit();
    private List<Customer> baseInit() {
        return Stream.of(
                new Customer(0,"alex", "a@gmail.com"),
                new Customer(1,"bob", "b@gmail.com"),
                new Customer(2,"cindy", "c@gmail.com"))
                .collect(Collectors.toList());
    }

    @GetMapping("/all")
    public List<Customer> all() {
        return CUSTOMERS;
    }

    @PostMapping("/{id}")
    public Customer findById(@PathVariable int id) {
        return CUSTOMERS.stream().filter(customer -> customer.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public Customer add(@RequestBody Customer customer) {
        this.CUSTOMERS.add(customer);
        return customer;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable int id) {
        this.CUSTOMERS.removeIf(c -> c.getId() == id);
    }

}
