package wangyu;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Singleton
@Path("/printers")
public class PrintersResource {

    @GET
    public String getRootResource() {
        return "root";
    }

    @GET
    @Path("/list")
    public String getListResource() {
        return "list";
    }
}
