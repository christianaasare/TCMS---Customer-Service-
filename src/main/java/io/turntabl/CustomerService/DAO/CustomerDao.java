package io.turntabl.CustomerService.DAO;

import io.turntabl.CustomerService.models.ClientTO;

import java.util.List;

public interface CustomerDao {
    List<ClientTO> getAll();

    void insertCustomer(ClientTO customer);

    void updateCustomer(ClientTO customer);

    void executeUpdateCustomer(ClientTO customer);

    void deleteCustomer(ClientTO customer);
}
