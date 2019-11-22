package io.turntabl.CustomerService.dao;

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
import java.util.List;
import java.util.Map;


import io.turntabl.CustomerService.mapper.CustomerMapper;
@Repository
public class CustomerDaoImpl implements CustomerDao {

    public CustomerDaoImpl(NamedParameterJdbcTemplate template){
        this.template = template;
    }
    NamedParameterJdbcTemplate template;

    @Override
    public List<ClientTO> getAllCustomers() {
        return template.query("select * from customer", new CustomerMapper());
    }

    @Override
    public void insertCustomer(ClientTO customer){
        final String sql = "insert into customer(id, name, address, email) values(:id, :name, :address, :email)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", customer.getId())
                .addValue("name", customer.getName())
                .addValue("address", customer.getAddress())
                .addValue("email", customer.getEmail());
                    template.update(sql,param,holder);
    }

    @Override
    public void updateCustomer(ClientTO customer){
        final String sql = "update customer set name=:name, address=:address, email=:email where id=:id";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", customer.getId())
                .addValue("name", customer.getName())
                .addValue("address", customer.getAddress())
                .addValue("email", customer.getEmail());
                    template.update(sql,param,holder);
    }

    @Override

    public void executeUpdateCustomer(ClientTO customer){
        final String sql = "update customer set name=:name, address=:address, email=:email where id=:id";

        Map<String,Object> map= new HashMap<String, Object>();
        map.put("id", customer.getId());
        map.put("name", customer.getName());
        map.put("address", customer.getAddress());
        map.put("email", customer.getEmail());

        template.execute(sql, map, new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                throws SQLException, DataAccessException{
                return ps.executeUpdate();
            }
        });
    }
        @Override
        public void deleteCustomer(ClientTO customer){
            final String sql = "delete from customer where id=:id";

            Map<String, Object> map = new HashMap<String, Object>();
           map.put("id", customer.getId());

            template.execute(sql, map, new PreparedStatementCallback<Object>() {
                @Override
                public Object doInPreparedStatement(PreparedStatement ps)
                        throws SQLException, DataAccessException {
                    return ps.executeUpdate();
                }
            });
        }

    }

