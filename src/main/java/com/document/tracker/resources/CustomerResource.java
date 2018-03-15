package com.document.tracker.resources;

import com.document.tracker.dao.CustomerDao;
import com.document.tracker.representations.Customer;
import org.skife.jdbi.v2.DBI;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.net.URISyntaxException;

@Path("/customer")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {

    private final CustomerDao customerDao;

    public CustomerResource(DBI jdbi) {

        customerDao = jdbi.onDemand(CustomerDao.class);
    }

    @POST
    public Response createContact(Customer customer) throws
            URISyntaxException {
        // store the new contact
        int newContactId = customerDao.createContact(customer.getFirstName(),
                customer.getLastName());

        return Response.created(new URI(String.valueOf(newContactId))).build();
    }


}
