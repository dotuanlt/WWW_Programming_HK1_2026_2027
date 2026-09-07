package iuh.fit.demorestapi;

import jakarta.enterprise.context.RequestScoped;

import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jdk.jfr.Name;

@Named
@Path("/user")
public class UserResource {

    @GET
    @Path("/view")
    @Produces("text/json")
    public String doInputUser(){
        return "Tuan";
    }
}
