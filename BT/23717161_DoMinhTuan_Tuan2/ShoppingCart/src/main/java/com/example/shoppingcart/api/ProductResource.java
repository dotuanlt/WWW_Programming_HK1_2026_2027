package com.example.shoppingcart.api;

import com.example.shoppingcart.service.ProductCatalog;
import com.example.shoppingcart.session.UserSession;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class ProductResource {

    @Inject
    ProductCatalog productCatalog;

    @Inject
    UserSession userSession;

    @GET
    public Response findAll() {
        if (!userSession.isLoggedIn()) {
            return Response.status(401)
                    .entity(Map.of(
                            "message",
                            "Bạn chưa đăng nhập"
                    ))
                    .build();
        }

        return Response.ok(
                productCatalog.findAll()
        ).build();
    }
}