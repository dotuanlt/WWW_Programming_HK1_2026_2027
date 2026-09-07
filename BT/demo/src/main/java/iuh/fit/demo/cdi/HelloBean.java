package iuh.fit.demo.cdi;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class HelloBean {
    public String sayHello() {
        return "Hello CDI Bean";
    }
}
