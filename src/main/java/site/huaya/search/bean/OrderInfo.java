package site.huaya.search.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class OrderInfo {

    @JsonIgnore
    public static final int TRADE_1 = 0;

    @JsonIgnore
    public static final int TRADE_2 = 1;

    @JsonIgnore
    public static final int TRADE_3 = 2;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Transient
    private String appkey;  //string	是	32	软件的appkey	4d803b2874874780a881d2362eb0a1b0
    @Transient
    private String method; // string	是	32	请求方法	trpay.trade.notify
    @Transient
    private String sign;     //string	是	32	签名,加密规则见下面	9BF3162452BBD9736A18EE44EF895DC3
    private String timestamp;  //	string	是	32	时间戳	1515722592
    private String version; // string	是	32	版本，固定值	1.0
    private String outTradeNo;    //string	是	32	订单号	e52bc78c-32c9-4457-9aca-c594bceb4c69
    private String payType; //string	是	1	订单类型：1支付宝2微信3银联	1
    private String tradeName;    //string	是	50	商品名称	一个月会员
    private long amount; //string	是	9	订单金额，单位分	1
    private String status; //string	是	100	支付状态：1.未支付2.支付成功.3支付失败	2
    private String notifyTime;    //string	是	100	通知时间	2016-08-12 22:10:32
    private String payUserId;    //string	否	30	支付用户id	e52bc78c-32c9-4457-9aca-c594bceb4c69
    private String channel; //string	否	50	渠道	baidu
    @Transient
    private String backParams="age=20";    //string	否	200	回传参数	age=20
    @Transient
    public String notifyUrl="http://47.93.0.227:80/pay/inform";    //异步通知地址


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotifyTime() {
        return notifyTime;
    }

    public void setNotifyTime(String notifyTime) {
        this.notifyTime = notifyTime;
    }

    public String getPayUserId() {
        return payUserId;
    }

    public void setPayUserId(String payUserId) {
        this.payUserId = payUserId;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getBackParams() {
        return backParams;
    }

    public void setBackParams(String backParams) {
        this.backParams = backParams;
    }

    /**
     * 生成商品名称
     *
     * @param tradeNameType
     * @return
     */
    public static String matchTradeName(int tradeNameType) {

        switch (tradeNameType) {

            case 0:
                return "5元搜搜币";

            case 1:
                return "10元搜搜币";

            case 2:
                return "20元搜搜币";
        }

        return "";


    }

    /**
     * 获取商品价格
     *
     * @param tradeNameType
     * @return
     */
    public static long matchAmount(int tradeNameType) {

        switch (tradeNameType) {

            case 0:
                return 5*100;

            case 1:
                return 10*100;

            case 2:
                return 20*100;
        }

        return 0;


    }

    /**
     * 生成订单号
     *
     * @return
     */
    public static String createOutTradeNo() {

        int machineId = 1;//最大支持1-9个集群机器部署
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return machineId + String.format("%015d", hashCodeV);
    }




}
