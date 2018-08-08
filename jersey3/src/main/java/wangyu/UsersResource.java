package wangyu;

import util.Fav;
import util.Sex;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * jersey
 * 支持@Get，@POST，@PUT，@DELETE等标签，分别对应Http的get,post,put,delete请求
 * @Path定义匹配路径，方法上的注解和类上的注解结合在一起使用。
 * @Path和@PathParam结合使用，支持命名路径参数
 * @Produces定义返回MIME类型，方法上的注解会覆盖类上的注解
 * @Consumes定义消费MIME类型，方法上的注解会覆盖类上的注解。只有该请求有合适的MIME类型（Accept或者Content-Type），才会被响应。
 * @QueryParam定义查询参数，@DefaultValue可以指定该参数的默认值
 */
//@Path("users/{name}")
@Path("users/{name:[0-9]*}")
@Produces(MediaType.TEXT_PLAIN)
public class UsersResource {

    @GET
    public String getUser(@PathParam("name")String name) {
        return "get:id:0,name:" + name + ".";
    }

    @GET
    @Path("abc")
//    @Produces(MediaType.TEXT_HTML)
//    @Produces("text/html")
    // 根据请求头的Accept属性来返回相应类型，优先返回qs值高的
    @Produces({"application/xml; qs=0.9", "text/html"})
    public String getUserDesc() {
        return "<html><body><h1>user desc</h1></body></html>";
    }

    @POST
    @Consumes("text/plain")
    // 请求头的Accept或者Content-Type是text/plain，才会响应请求
    public String addUser(@PathParam("name")String name) {
        return "post:id:0,name:" + name + ".";
    }

    @PUT
    // 查询参数以及该查询参数的默认值
    public String updateUser(@DefaultValue("nj") @QueryParam("addr") String addr,
                              @DefaultValue("male") @QueryParam("sex") Sex sex,
                              @QueryParam("fav") List<Fav> fav,
                              @PathParam("name") String name) {
        String result = "put:id:0,name:" + name + ",addr:" + addr + ",sex:" + sex.getDesc();
        result += ",fav:";
        for(Fav s : fav) {
            result += s.getDesc() + "_";
        }
        return result;
    }

    @DELETE
    public String deleteUser(@PathParam("name")String name) {
        return "delete:id:0,name:" + name + ".";
    }
}
