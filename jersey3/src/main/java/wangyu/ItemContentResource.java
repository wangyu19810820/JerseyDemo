package wangyu;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

public class ItemContentResource {

    @GET
    public String get() {
        return "ItemContentResource_get";
    }

    @POST
    public String post() {
        return "ItemContentResource_post";
    }

    @GET
    @Path("list")
    public String list() {
        return "ItemContentResource_list";
    }
}
