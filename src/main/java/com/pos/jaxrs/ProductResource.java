package com.pos.jaxrs;

import com.pos.Customer;
import com.pos.Inventory;
import com.pos.Product;
import com.pos.ProductSpec;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * Created by dewi on 21.09.16.
 */
@Path("/products")
public class ProductResource {

    private static Inventory inventory = Inventory.getTheInventory();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@HeaderParam("digitcode") String digitcode) {

        return inventory.searchProductDigitcode(digitcode);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postMethod(Product product, @Context UriInfo uriInfo) {

        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(product.getDigitcode());

        if(inventory.addProduct(product)) {
            return Response.created(uriBuilder.build()).build();
        } else {
            return Response.status(400).build();
        }

    }
}
