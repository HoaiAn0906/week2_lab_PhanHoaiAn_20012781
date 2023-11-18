package www.week2.week02_lab_phanhoaian_20012781.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import www.week2.week02_lab_phanhoaian_20012781.models.Product;
import www.week2.week02_lab_phanhoaian_20012781.services.ProductService;
import www.week2.week02_lab_phanhoaian_20012781.services.impl.ProductServiceImpl;

import java.util.List;
import java.util.Map;

@Path("/products")
public class ProductResource {
    @Inject
    private ProductService productService;

    public ProductResource() {
        productService = new ProductServiceImpl();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        try {
            System.out.println("Get all products");
            List<Product> products = productService.getAll();
            ApiResponse<List<Product>> response = new ApiResponse<>(products, "Success", 200);
            return Responder.buildCORSResponse(response);
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
    public Response create(Product product) {
        try {
            productService.create(product);
            return Response.ok(product).status(200).build();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception and create an error response
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred: " + e.getMessage())
                    .build();
        }
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response update(Product product) {
        try {
            productService.update(product);
            return Response.ok(product).status(200).build();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception and create an error response
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred: " + e.getMessage())
                    .build();
        }
    }

    @DELETE
    @Path("/{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") long id) {
        try {
            productService.delete(id);
            return Response.ok("Delete successfully").status(204).build();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception and create an error response
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred: " + e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/{id}/chartPriceByTime")
    @Produces("application/json")
    public Response chartPriceByTime(@PathParam("id") long id) {
        try {
            System.out.println("Get chart price by time");
            Map<String, List<Object>> chartPriceByTime = productService.getChartPriceByTime(id);
            ApiResponse<Map<String, List<Object>>> response = new ApiResponse<>(chartPriceByTime, "Success", 200);
            return Responder.buildCORSResponse(response);
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception and create an error response
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred: " + e.getMessage())
                    .build();
        }
    }
}
