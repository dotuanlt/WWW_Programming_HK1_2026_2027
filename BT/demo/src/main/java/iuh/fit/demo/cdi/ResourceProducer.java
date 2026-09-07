package iuh.fit.demo.cdi;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class ResourceProducer {
    @Produces
    public String appName(){
        return "Employee Management System";
    }
}
