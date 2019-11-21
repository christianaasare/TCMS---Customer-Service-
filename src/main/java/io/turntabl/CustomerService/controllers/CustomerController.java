package io.turntabl.CustomerService.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.turntabl.CustomerService.models.ClientTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Api
@RestController


public class CustomerController {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @ApiOperation("customer")
    @GetMapping("/customer")
    public ClientTO customer(
            @RequestParam(name = "name",defaultValue = "Name of Client")
            String name,
            @RequestParam(name ="address",defaultValue = "Address of Client")
                    String address,
            @RequestParam(name = "email",defaultValue = "Email of of Client")
                    String email,
            @RequestParam(name = "telephone",defaultValue = "Telephone of Client")
                    String telephone){
        ClientTO myCustomer = new ClientTO();
        myCustomer.setName(name);
        myCustomer.setAddress(address);
        myCustomer.setEmail(email);
        myCustomer.setTelephone(telephone);

        return myCustomer;
    }


}
