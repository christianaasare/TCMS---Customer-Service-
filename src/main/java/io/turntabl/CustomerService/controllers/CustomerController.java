package io.turntabl.CustomerService.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import io.turntabl.CustomerService.models.ClientTO;
import io.turntabl.CustomerService.service.CustomerService;
import javax.annotation.Resource;
import java.util.List;

@Api
@RestController
@RequestMapping("/customerApp")
public class CustomerController {

    @Resource
    CustomerService customerService;

    @ApiOperation("List Customers")
    @GetMapping("/customerList")
    public List<ClientTO> getAllCustomers(){
        return customerService.getAllCustomers();}

    @ApiOperation("Create Customer")
    @PostMapping("/createCustomer")
    public void createCustomer(@RequestBody ClientTO customer){ customerService.insertCustomer(customer);}

    @ApiOperation("Update Customer")
    @PutMapping(value = "/updateCustomer")
    public void updateCustomer(@RequestBody ClientTO customer){ customerService.updateCustomer(customer);
        System.out.println(" Updated Successfully");
    }

    @ApiOperation("Execute Update Customer")
    @PutMapping("/executeUpdateCustomer")
    public void executeUpdateCustomer(@RequestBody ClientTO customer){customerService.executeUpdateCustomer(customer);
        System.out.println("Executed Successfully");
    }

    @ApiOperation("Delete Customer")
    @DeleteMapping("/deleteCustomer")
    public void deleteCustomer(@RequestBody ClientTO customer){
        customerService.deleteCustomer(customer);
        System.out.println("Deleted Successfully");
    }
}
