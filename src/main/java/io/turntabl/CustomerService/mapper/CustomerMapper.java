package io.turntabl.CustomerService.mapper;

import io.turntabl.CustomerService.models.ClientTO;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CustomerMapper implements RowMapper<ClientTO> {

    @Override
    public ClientTO mapRow(ResultSet rs, int arg1) throws SQLException{
        ClientTO customer = new ClientTO();
        customer.setId(rs.getString("id"));
        customer.setName(rs.getString("name"));
        customer.setEmail(rs.getString("email"));
        customer.setEmail(rs.getString("address"));

        return customer;
    }

}
