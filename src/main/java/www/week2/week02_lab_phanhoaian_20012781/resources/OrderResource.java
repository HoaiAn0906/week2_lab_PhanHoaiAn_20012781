package www.week2.week02_lab_phanhoaian_20012781.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import www.week2.week02_lab_phanhoaian_20012781.models.Order;
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
}
