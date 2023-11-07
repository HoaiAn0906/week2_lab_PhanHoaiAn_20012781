package www.week2.week02_lab_phanhoaian_20012781.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import www.week2.week02_lab_phanhoaian_20012781.models.Product;
import www.week2.week02_lab_phanhoaian_20012781.models.ProductPrice;
import www.week2.week02_lab_phanhoaian_20012781.services.ProductPriceService;
import www.week2.week02_lab_phanhoaian_20012781.services.ProductService;
import www.week2.week02_lab_phanhoaian_20012781.services.impl.ProductPriceServiceImpl;
import www.week2.week02_lab_phanhoaian_20012781.services.impl.ProductServiceImpl;

import java.util.List;

@Path("/product_prices")
public class ProductPriceResource {
    @Inject
    private ProductPriceService productPriceService;

    public ProductPriceResource() {
        productPriceService = new ProductPriceServiceImpl();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        try {
            List<ProductPrice> productPrices = productPriceService.getAll();
            return Response.ok(productPrices).status(200).build();
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
    public Response create(ProductPrice productPrice) {
        try {
            productPriceService.create(productPrice);
            return Response.ok(productPrice).status(200).build();
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
    public Response update(ProductPrice productPrice) {
        try {
            productPriceService.update(productPrice);
            return Response.ok(productPrice).status(200).build();
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
            productPriceService.delete(id);
            return Response.ok("Delete successfully").status(204).build();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception and create an error response
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred: " + e.getMessage())
                    .build();
        }
    }
}
