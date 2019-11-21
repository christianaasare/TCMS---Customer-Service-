package io.turntabl.CustomerService.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.CustomerService.models.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api
@RestController


public class CustomerController {

    @ApiOperation("customer")
    @GetMapping("/customer")
    public Customer customer(
            @RequestParam(name = "name",defaultValue = "No Name")
            String name){
        Customer myCustomer = new Customer();
        myCustomer.setName(name);
        myCustomer.setName(" ");

        return myCustomer;
    }


}
