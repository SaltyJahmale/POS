package com.pos.jaxrs;

import com.pos.*;
import javax.ws.rs.*;
import javax.ws.rs.core.*;

/**
 * Created by dewi on 21.09.16.
 */
@Path("/products/")
public class ProductResource {

    private static Inventory inventory = Inventory.getTheInventory();
    private TransactionFactory transactionFactory = new TransactionFactory();

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Product getProduct(@HeaderParam("digitcode") String digitcode) {

        for (Product product : inventory.getInventoryList()) {
            if (product.getDigitcode().equals(digitcode)) {
                return product;
            }
        }

        return null;
    }

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response postMethod(Product product, @Context UriInfo uriInfo) {

        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(product.getDigitcode());

        if(inventory.getInventoryList().add(product)) {
            return Response.created(uriBuilder.build()).build();
        } else {
            return Response.status(400).build();
        }

    }
}
