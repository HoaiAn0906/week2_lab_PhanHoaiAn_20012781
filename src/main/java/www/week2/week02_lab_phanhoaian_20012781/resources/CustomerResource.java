package www.week2.week02_lab_phanhoaian_20012781.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import www.week2.week02_lab_phanhoaian_20012781.models.Customer;
import www.week2.week02_lab_phanhoaian_20012781.services.CustomerService;
import www.week2.week02_lab_phanhoaian_20012781.services.impl.CustomerServiceImpl;

import java.util.List;

@Path("/customers")
public class CustomerResource {
    @Inject
    private CustomerService customerService;

    public CustomerResource() {
        customerService = new CustomerServiceImpl();
    }
    @GET
    @Produces("application/json")
    public Response getAll() {
        try {
            List<Customer> customers = customerService.getAll();
            return Response.ok(customers).status(200).build();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception and create an error response
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred: " + e.getMessage())
                    .build();
        }
    }

    //create
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(Customer customer) {
        try {
            customerService.create(customer);
            return Response.ok(customer).status(200).build();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception and create an error response
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred: " + e.getMessage())
                    .build();
        }
    }

    //update
    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(Customer customer) {
        try {
            customerService.update(customer);
            return Response.ok(customer).status(200).build();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception and create an error response
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred: " + e.getMessage())
                    .build();
        }
    }

    //delete
    @DELETE
    @Produces("application/json")
    @Path("/{id}")
    public Response delete(@PathParam("id") long id) {
        try {
            customerService.delete(id, Customer.class);
            return Response.ok("Delete success").status(200).build();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception and create an error response
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred: " + e.getMessage())
                    .build();
        }
    }
}
