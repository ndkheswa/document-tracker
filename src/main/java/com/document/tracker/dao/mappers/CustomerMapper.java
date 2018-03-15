package com.document.tracker.dao.mappers;

import com.document.tracker.representations.Customer;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerMapper implements ResultSetMapper<Customer> {
    public Customer map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Customer(
                r.getInt("id"), r.getString("firstName"),
                r.getString("lastName"));
    }
}
