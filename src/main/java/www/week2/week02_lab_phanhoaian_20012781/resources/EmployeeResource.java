package www.week2.week02_lab_phanhoaian_20012781.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import www.week2.week02_lab_phanhoaian_20012781.models.Employee;
import www.week2.week02_lab_phanhoaian_20012781.repositories.EmployeeRepository;
import www.week2.week02_lab_phanhoaian_20012781.services.EmployeeService;
import www.week2.week02_lab_phanhoaian_20012781.services.impl.EmployeeServiceImpl;

import java.util.List;

@Path("/employees")
public class EmployeeResource {
    @Inject
    private EmployeeService employeeService;

    public EmployeeResource() {
        employeeService = new EmployeeServiceImpl();
    }

    @GET
    @Produces("application/json")
    public Response getAll() {
        try {
            List<Employee> employees = employeeService.getAll();
            return Response.ok(employees).status(200).build();
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
    public Response create( Employee employee) {
        try {
            employeeService.create(employee);
            return Response.ok(employee).status(200).build();
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
    public Response update(Employee employee) {
        try {
            employeeService.update(employee);
            return Response.ok(employee).status(200).build();
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
            employeeService.delete(id);
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
