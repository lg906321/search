package site.huaya.search.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Response {
    @JsonIgnore
    public static final int TIME_OUT = -1;

    @JsonIgnore
    public static final int ERROR = 0;

    @JsonIgnore
    public static final int SUCCESS = 1;

    //消息
    public String msg;

    //状态码 0 异常  1成功
    public int status;

    public Object data;


    public static Response createTimeOutResponse() {

        Response response = new Response();
        response.status = TIME_OUT;
        response.msg = "请求超时";
        return response;

    }

    public static Response createSuccessResponse() {

        Response response = new Response();
        response.status = SUCCESS;
        return response;

    }

    public static Response createErrorResponse() {

        Response response = new Response();
        response.status = ERROR;
        return response;

    }

    public interface  Message{

        String USER_NONE="用户不存在！";

    }

}
