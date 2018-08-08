package wangyu;

import util.Fav;
import util.MyBeanParam;
import util.Sex;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.List;
import java.util.Map;

/**
 * jersey
 * 支持@Get，@POST，@PUT，@DELETE等标签，分别对应Http的get,post,put,delete请求
 * @Path定义匹配路径，方法上的注解和类上的注解结合在一起使用。
 * @Path和@PathParam结合使用，支持命名路径参数
 * @Produces定义返回MIME类型，方法上的注解会覆盖类上的注解
 * @Consumes定义消费MIME类型，方法上的注解会覆盖类上的注解。只有该请求有合适的MIME类型（Accept或者Content-Type），才会被响应。
 * @QueryParam定义查询参数，@DefaultValue可以指定该参数的默认值，查询参数除了是基本类型外，也可以是自定义类型
 * @FormParam定义表单参数
 * @Context注解和UriInfo类型定义参数组合Map，getQueryParameters()获取查询参数，getPathParameters()获取路径参数
 * 而表单参数组合Map，只需将参数定义为MultivaluedMap类型，无需其他注解
 * @Context注解和HttpHeaders类型定义Http表头和cookie组合的Map
 * @BeanParam可以自定义参数组合
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

    @POST
    @Consumes("application/x-www-form-urlencoded")
    // @FormParam是表单参数，其MIME类型需为application/x-www-form-urlencoded
    public String post(@FormParam("name") String name) {
        return "post form:id:0,name:" + name + ".";
    }

    // 将参数组装成Map类型，获取http头和cookie。
    // 获取cookie，文档上这样写，但是用接口工具没有模拟出来
    @GET
    @Path("efg")
    public String get(@Context UriInfo ui, @Context HttpHeaders hh) {
        MultivaluedMap<String, String> queryParams = ui.getQueryParameters();
        MultivaluedMap<String, String> pathParams = ui.getPathParameters();
        MultivaluedMap<String, String> headerParams = hh.getRequestHeaders();
        Map<String, Cookie> cookieParams = hh.getCookies();

        final StringBuffer sb = new StringBuffer();
        sb.append("queryParams ");
        queryParams.forEach((key, value) -> sb.append(key).append(":").append(value).append(","));
        sb.append(".pathParams ");
        pathParams.forEach((key, value) -> sb.append(key).append(":").append(value).append(","));
        sb.append(".headerParams ");
        headerParams.forEach((key, value) -> sb.append(key).append(":").append(value).append(","));
        sb.append(".cookieParams ");
        cookieParams.forEach((key, value) -> sb.append(key).append(":").append(value).append(","));

        return sb.toString();
    }

    // 将表单参数封装在Map中，不能写@Context注解
    @POST
    @Path("efg")
    @Consumes("application/x-www-form-urlencoded")
    public String post(MultivaluedMap<String, String> formParams) {
        final StringBuffer sb = new StringBuffer();
        formParams.forEach((key, value) -> sb.append(key).append(":").append(value).append(","));
        return sb.toString();
    }

    // 自定义参数组合，一个Bean中有多个参数
    @GET
    @Path("hij")
    public String get(@BeanParam MyBeanParam param) {
        final StringBuffer sb = new StringBuffer();
        sb.append("header:").append(param.getHeaderParam());
        sb.append(",sex:").append(param.getSex());
        sb.append(",matrix:").append(param.getMatrixParam());
        return sb.toString();
    }
}
