package com.document.tracker.dao;

import com.document.tracker.dao.mappers.CustomerMapper;
import com.document.tracker.representations.Customer;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface CustomerDao {

    @Mapper(CustomerMapper.class)
    @SqlQuery("select * from contact where id = :id")
    Customer getContactById(@Bind("id") int id);

    @GetGeneratedKeys
    @SqlUpdate("insert into customer (id, firstName, lastName) values (NULL, :firstName, :lastName)")
    int createContact(@Bind("firstName") String firstName,
                      @Bind("lastName") String lastName);
}
