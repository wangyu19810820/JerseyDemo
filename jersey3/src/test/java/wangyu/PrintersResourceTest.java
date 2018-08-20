package wangyu;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import static org.junit.Assert.assertEquals;

public class PrintersResourceTest extends BaseTest {

    @Test
    public void test() {
        String responseMsg1 = target.path("printers").request().get(String.class);
        System.out.println(responseMsg1);
        String responseMsg2 = target.path("printers/list").request().get(String.class);
        System.out.println(responseMsg2);
    }
}
