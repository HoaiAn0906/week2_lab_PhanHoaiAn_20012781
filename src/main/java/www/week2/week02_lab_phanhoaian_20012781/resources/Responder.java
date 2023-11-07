package www.week2.week02_lab_phanhoaian_20012781.resources;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import java.util.List;

public class Responder {
    public static Response buildCORSResponse(Object data) {
        Response.ResponseBuilder responseBuilder = Response.ok(data).status(200);
        responseBuilder.header("Access-Control-Allow-Origin", "*");
        responseBuilder.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        responseBuilder.header("Access-Control-Allow-Headers", "Content-Type");
        return responseBuilder.build();
    }

    public static Response buildErrorCORSResponse(Exception e) {
        e.printStackTrace();
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("An error occurred: " + e.getMessage())
                .build();
    }
}