package www.week2.week02_lab_phanhoaian_20012781.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import www.week2.week02_lab_phanhoaian_20012781.models.Order;
import www.week2.week02_lab_phanhoaian_20012781.models.OrderDetail;
import www.week2.week02_lab_phanhoaian_20012781.services.OrderDetailService;
import www.week2.week02_lab_phanhoaian_20012781.services.OrderService;
import www.week2.week02_lab_phanhoaian_20012781.services.impl.OrderDetailServiceImpl;
import www.week2.week02_lab_phanhoaian_20012781.services.impl.OrderServiceImpl;

import java.util.List;

@Path("/order-details")
public class OrderDetailResource {
    @Inject
    private OrderDetailService orderDetailService;

    public OrderDetailResource() {
        orderDetailService = new OrderDetailServiceImpl();
    }
    @GET
    @Produces("application/json")
    public Response getAll() {
        try {
            List<OrderDetail> orderDetails = orderDetailService.getAll();
            return Response.ok(orderDetails).status(200).build();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception and create an error response
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred: " + e.getMessage())
                    .build();
        }
    }
}
