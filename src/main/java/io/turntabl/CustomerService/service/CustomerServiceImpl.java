package io.turntabl.CustomerService.service;

import io.turntabl.CustomerService.dao.CustomerDao;
import io.turntabl.CustomerService.models.ClientTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public class CustomerServiceImpl implements CustomerService{
    @Resource
    CustomerDao customerDao;

    @Override
    public List<ClientTO> getAllCustomers() {
        return customerDao.getAllCustomers();
    }
    @Override
    public void insertCustomer(ClientTO customer) {
        customerDao.insertCustomer(customer);

    }

    @Override
    public void updateCustomer(ClientTO customer) {
        customerDao.updateCustomer(customer);

    }

    @Override
    public void executeUpdateCustomer(ClientTO customer) {
        customerDao.executeUpdateCustomer(customer);

    }

    @Override
    public void deleteCustomer(ClientTO customer) {
        customerDao.deleteCustomer(customer);

    }
}
