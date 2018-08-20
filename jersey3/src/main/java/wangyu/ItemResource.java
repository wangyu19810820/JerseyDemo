package wangyu;

import javax.ws.rs.Path;

@Path("/item")
public class ItemResource {

    @Path("content")
    public ItemContentResource getItemContentResource() {
        return new ItemContentResource();
    }


}
