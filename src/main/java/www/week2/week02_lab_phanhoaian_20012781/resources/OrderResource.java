package www.week2.week02_lab_phanhoaian_20012781.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import www.week2.week02_lab_phanhoaian_20012781.models.Order;
import www.week2.week02_lab_phanhoaian_20012781.models.Product;
import www.week2.week02_lab_phanhoaian_20012781.services.OrderService;
import www.week2.week02_lab_phanhoaian_20012781.services.impl.OrderServiceImpl;

import java.util.List;

@Path("/orders")
public class OrderResource {
    @Inject
    private OrderService orderService;

    public OrderResource() {
        orderService = new OrderServiceImpl();
    }
    @GET
    @Produces("application/json")
    public Response getAll() {
        try {
            List<Order> orders = orderService.getAll();
            for (Order order : orders) {
                System.out.println(order);
            }
            return Response.ok(orders).status(200).build();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception and create an error response
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred: " + e.getMessage())
                    .build();
        }
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response create(Order order) {
        try {
            System.out.println("Create order");
            orderService.create(order);
            return Response.ok(order).header("Access-Control-Allow-Origin", "*").status(200).build();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception and create an error response
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred: " + e.getMessage())
                    .build();
        }
    }
}
