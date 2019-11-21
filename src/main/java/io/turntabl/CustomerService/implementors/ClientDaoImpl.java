package io.turntabl.CustomerService.implementors;

import io.turntabl.CustomerService.dao.ClientDao;
import io.turntabl.CustomerService.models.ClientTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public class ClientDaoImpl implements ClientDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }


    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ClientTO> getAllClients() {
        List<ClientTO> customers = this.jdbcTemplate.query("select * from customers", BeanPropertyRowMapper.newInstance(ClientTO.class));
        return customers;

    }

    @Override
    public List<ClientTO> getClientByName(@PathVariable String customerName) {
        List<ClientTO> customer = this.jdbcTemplate.query("select * from customers where name like ?", new Object[]{customerName},BeanPropertyRowMapper.newInstance(ClientTO.class));
        return customer;
    }

    @Override
    public void addClient(@RequestBody Map<String,String> addClient) {
        jdbcTemplate.update(
                "insert into customers(name,address,telephone,client_email) values(?,?,?,?)",
                new Object[]{addClient.get("name"), addClient.get("address"), addClient.get("telephone"), addClient.get("email")}
        );
        System.out.println("Client has been added successfully");

    }

    @Override
    public void deleteClient(@PathVariable String clientID) {
            jdbcTemplate.update(
                    "delete from customers where client_id = ?",
                    new Object[]{clientID}
            );
            System.out.println("Client Deleted Successfully");
        }
    }

    
