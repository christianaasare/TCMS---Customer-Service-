package io.turntabl.CustomerService.implimentor;

import io.turntabl.CustomerService.DAO.CustomerDao;
import io.turntabl.CustomerService.models.ClientTO;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    public CustomerDaoImpl(NamedParameterJdbcTemplate template){
        this.template = template;
    }
    NamedParameterJdbcTemplate template;

    @Override
    public void insertCustomer(ClientTO customer){
        final String sql = "insert into customer(customerId, customerName, customerAddress, customerEmail) values(:customerId, :customerName, :customerAddress, :customerEmail)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("customerId", customer.getCustomerId())
                .addValue("customerName", customer.getCustomerName())
                .addValue("customerAddress", customer.getCustomerAddress())
                .addValue("customerEmail", customer.getCustomerEmail());
                    template.update(sql,param,holder);
    }

    @Override
    public void updateCustomer(ClientTO customer){
        final String sql = "update customer set customerName=:customerName, customerAddres=:customerAddress, customerEmail=:customerEmail where customerId=:customerId";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("customerId", customer.getCustomerId())
                .addValue("customerName", customer.getCustomerName())
                .addValue("customerAddress", customer.getCustomerAddress())
                .addValue("customerEmail", customer.getCustomerEmail());
                    template.update(sql,param,holder);
    }

    @Override

    public void executeUpdateCustomer(ClientTO customer){
        final String sql = "update customer set customerName=:customerName, customerAddres=:customerAddress, customerEmail=:customerEmail where customerId=:customerId";

        Map<String,Object> map= new HashMap<String, Object>();
        map.put("customerId", customer.getCustomerId());
        map.put("customerName", customer.getCustomerName();
        map.put("customerAddress", customer.getCustomerAddress());
        map.put("customerEmail", customer.getCustomerEmail());

        template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                throws SQLException, DataAccessException{
                return ps.executeUpdate();
            }
        });

        @Override
                public void deleteCustomer

    }
}
