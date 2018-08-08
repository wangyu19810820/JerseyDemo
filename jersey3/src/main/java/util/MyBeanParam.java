package util;

import javax.ws.rs.*;

public class MyBeanParam {

//    @PathParam("name")
    private String pathParam;

    @QueryParam("sex")
    private String sex;

    @MatrixParam("m")
    @Encoded
    @DefaultValue("default")
    private String matrixParam;

    @HeaderParam("Content-Type")
    private String headerParam;

    public String getPathParam() {
        return pathParam;
    }

    public void setPathParam(String pathParam) {
        this.pathParam = pathParam;
    }

    public String getMatrixParam() {
        return matrixParam;
    }

    public void setMatrixParam(String matrixParam) {
        this.matrixParam = matrixParam;
    }

    public String getHeaderParam() {
        return headerParam;
    }

    public void setHeaderParam(String headerParam) {
        this.headerParam = headerParam;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
