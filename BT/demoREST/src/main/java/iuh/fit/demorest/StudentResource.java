package iuh.fit.demorest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

@Path("/student")
public class StudentResource {

    @GET
    @Path("/getName/{name}")
    public String getName(@PathParam("name") String name){
        return name;
    }

    @GET
    @Path("/getMark")
    public String getMark(@QueryParam("diem") String diem, @QueryParam("ten") String ten){
        return ten + " " + diem;
    }
}
