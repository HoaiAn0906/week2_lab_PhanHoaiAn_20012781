package www.week2.week02_lab_phanhoaian_20012781.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataParam;
import www.week2.week02_lab_phanhoaian_20012781.configs.AppConfig;
import www.week2.week02_lab_phanhoaian_20012781.models.Product;
import www.week2.week02_lab_phanhoaian_20012781.models.ProductImage;
import www.week2.week02_lab_phanhoaian_20012781.services.ProductImageService;
import www.week2.week02_lab_phanhoaian_20012781.services.impl.ProductImageServiceImpl;

import java.io.*;

@Path("/product_images")
public class ProductImageResource {
    private String baseUrl;
    @Inject
    private ProductImageService productImageService;
    private static String UPLOAD_FOLDER = "images/";

    public ProductImageResource() throws IOException {
        AppConfig appConfig = new AppConfig();
        baseUrl = appConfig.getBaseUrl();
        productImageService = new ProductImageServiceImpl();
    }

    @POST
    @Consumes({MediaType.MULTIPART_FORM_DATA})
    @Produces("application/json")
    public Response create(
            @FormDataParam("product_id") Long productId,
            @FormDataParam("product_image") InputStream productImage
    ) {
        try {
            String uuid = java.util.UUID.randomUUID().toString();

            String imageName = uuid + "_" + productId + ".png";
            String currentDirectory = System.getProperty("user.dir");
            String newPath = currentDirectory.replace("/bin", "");
            String imagePath = newPath + "/webapps/week02_lab_PhanHoaiAn_20012781/WEB-INF/classes/" + UPLOAD_FOLDER + imageName;

            saveFile(productImage, imagePath);

            String url = baseUrl + "/" + UPLOAD_FOLDER + imageName;

            ProductImage productImageObject = new ProductImage();
            Product product = new Product(productId);
            productImageObject.setProduct(product);
            productImageObject.setPath(url);
            productImageService.create(productImageObject);

            return Response.status(Response.Status.CREATED)
                    .entity(productImageObject)
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception and create an error response
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("An error occurred: " + e.getMessage())
                    .build();
        }
    }

    private void saveFile(InputStream inputStream, String path) {
        try {
            OutputStream outputStream = new java.io.FileOutputStream(new File(path));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
