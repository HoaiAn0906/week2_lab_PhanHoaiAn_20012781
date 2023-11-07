package www.week2.week02_lab_phanhoaian_20012781.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;

@Path("/images")
public class ImageResource {

    @GET
    @Path("/{imageName}")
    @Produces("image/png")
    public Response getImage(@PathParam("imageName") String imageName) {
        try {
            String resourcePath = "images/" + imageName;
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream(resourcePath);

            if (inputStream == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }

            byte[] imageData = inputStream.readAllBytes();
            inputStream.close();

            return Response.ok(imageData)
                    .type("image/png")
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}