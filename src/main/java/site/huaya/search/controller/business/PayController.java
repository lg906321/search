package site.huaya.search.controller.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import site.huaya.search.bean.OrderInfo;
import site.huaya.search.bean.Request;
import site.huaya.search.bean.Response;
import site.huaya.search.config.Constants;
import site.huaya.search.db.OrderInfoRepository;

@RestController
@RequestMapping("/pay")
public class PayController {


    @Autowired
    private OrderInfoRepository orderInfoRepository;


    /**
     * 异步支付成功回调接口
     * @return
     */
    @RequestMapping("/inform")
    public String inform() {

        return "success";
    }

    /**
     * 创建订单
     *
     * @return
     */
    @RequestMapping("/create_order")
    @ResponseBody
    public Response createOrder(@RequestBody CreateOrderRequest request) {
        OrderInfo orderInfo = createOrderByRequest(request);
        orderInfo = orderInfoRepository.save(orderInfo);
        Response successResponse = Response.createSuccessResponse();
        successResponse.data=orderInfo;
        successResponse.msg="创建订单成功";
        return successResponse;
    }


    public static class CreateOrderRequest extends Request {

        public Data data;

        public static class Data {
            //充值类型
            public int type;

            public String channel;

        }


    }


    /**
     * 创建订单
     *
     * @param request
     * @return
     */
    public static OrderInfo createOrderByRequest(PayController.CreateOrderRequest request) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setTradeName(OrderInfo.matchTradeName(request.data.type));
        orderInfo.setOutTradeNo(OrderInfo.createOutTradeNo());
        orderInfo.setAmount(OrderInfo.matchAmount(request.data.type));
        orderInfo.setPayUserId(request.getUid());
        orderInfo.setChannel(request.data.channel);
        orderInfo.setTimestamp(System.currentTimeMillis()+"");
        orderInfo.setAppkey(Constants.APP_KEY);
        return orderInfo;

    }

}
