package site.huaya.search.utils;

public class VerifyUtils {

    //接口请求时差 小于5秒默认请求失败
    private static long TIME_OUT=5000;

    /**
     * app端与服务器端请求时差不得超过阀值
     * @param time
     * @return
     */
    public static  boolean isTimeOut(long time){

        return (System.currentTimeMillis()-time)>TIME_OUT;
    }

}
