package io.turntabl.CustomerService.dao;

import io.turntabl.CustomerService.models.ClientTO;

import java.util.List;
import java.util.Map;

public interface ClientDao {
    List<ClientTO> getAllClients();
    List<ClientTO> getClientByName(String clientName);
    void addClient(Map<String,String> client);
    void deleteClient(String clientID);

}
