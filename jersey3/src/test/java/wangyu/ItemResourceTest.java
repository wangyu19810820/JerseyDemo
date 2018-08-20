package wangyu;

import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class ItemResourceTest extends BaseTest {

    @Test
    public void test() {
        String responseMsg1 = target.path("item/content").request().get(String.class);
        System.out.println(responseMsg1);

        Response responseMsg2 = target.path("item/content").request().post(Entity.html(""));
        System.out.println(responseMsg2.readEntity(String.class));

        String responseMsg3 = target.path("item/content/list").request().get(String.class);
        System.out.println(responseMsg3);
    }
}
