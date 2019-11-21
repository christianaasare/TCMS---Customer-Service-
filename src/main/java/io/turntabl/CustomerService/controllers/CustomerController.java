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
            String name,
            @RequestParam(name ="address",defaultValue = "No ad")
                    String address,
            @RequestParam(name = "email",defaultValue = "No email")
                    String email,
            @RequestParam(name = "telephone",defaultValue = "No number")
                    String telephone){
        Customer myCustomer = new Customer();
        myCustomer.setName(name);
        myCustomer.setAddress(address);
        myCustomer.setEmail(email);
        myCustomer.setTelephone(telephone);

        return myCustomer;
    }


}
