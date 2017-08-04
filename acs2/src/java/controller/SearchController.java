/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.factory.FactoryService;
import model.search.FindDevice;
import model.search.SearchIn;

/**
 *
 * @author G0042204
 */
@Path("/search")
public class SearchController extends RestAbstractController {

    private FindDevice find;

    @POST
    @Path("/search")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(SearchIn in) {
        try {
            find = FactoryService.create();
            return ok(find.find(in));
        } catch (Exception e) {
            return internalServerError(e);
        }
    }

}