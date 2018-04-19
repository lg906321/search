package site.huaya.search.controller.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.huaya.search.bean.ConvertInfo;
import site.huaya.search.bean.Request;
import site.huaya.search.bean.Response;
import site.huaya.search.bean.UserInfo;
import site.huaya.search.db.ConvertInfoRepository;
import site.huaya.search.db.UserInfoRepository;

import java.util.Optional;

@RestController
@RequestMapping("/points")
public class PointsController {


    private static final int COIN = 2;

    //用户表操作
    @Autowired
    private UserInfoRepository userInfoRepository;


    //兑换记录操作表
    @Autowired
    private ConvertInfoRepository convertInfoRepository;

    /**
     * 消费积分 (积分可以用于充值话费)
     *
     * @return
     */
    @RequestMapping("/consume_points")
    public Response consumePoints(@RequestBody ConsumeRequest request) {


        UserInfo userInfo = userInfoRepository.findByUid(request.getUid());
        if (userInfo!=null) {
            if (userInfo.getPoint() >= request.data.points) {
                //可以兑换
                userInfo.setPoint(userInfo.getPoint() - request.data.points);
                UserInfo save = userInfoRepository.save(userInfo);
                ConvertInfo convertInfo = new ConvertInfo();
                convertInfo.setUid(save.getUid());
                convertInfo.setConvertTime(System.currentTimeMillis());
                convertInfo.setPoint(request.data.points);
                convertInfo.setPhoneNumber(request.data.phoneNumber);
                convertInfoRepository.save(convertInfo);
                Response response = Response.createSuccessResponse();
                response.data = save;
                return response;

            } else {

                Response errorResponse = Response.createErrorResponse();
                errorResponse.msg = "积分不得够";
                return errorResponse;
            }


        } else {
            //用户不存在
            Response response = Response.createErrorResponse();
            response.msg = Response.Message.USER_NONE;
            return response;
        }
    }

    /**
     * 消费种子币 (中子币用来拷贝链接 每次消费2个)
     *
     * @return
     */
    @RequestMapping("/consume_coins")
    @ResponseBody
    public Response consumeCoins(@RequestBody ConsumeRequest request) {
        //根据id获取到用户信息
        UserInfo userInfo = userInfoRepository.findByUid(request.getUid());
        if (userInfo != null) {
            if (request.data.coins == COIN) {
                if (userInfo.getCoin() >= COIN) {
                    userInfo.setCoin(userInfo.getCoin() - COIN);
                    userInfo = userInfoRepository.save(userInfo);
                    Response successResponse = Response.createSuccessResponse();
                    successResponse.data = userInfo;
                    return successResponse;
                } else {
                    Response errorResponse = Response.createErrorResponse();
                    errorResponse.msg = "金币不得够！";
                    errorResponse.status=Status.COIN_NOT_ENOUGH;
                    return errorResponse;

                }

            } else {
                //非法用户
                return Response.createErrorResponse();

            }

        } else {
            //用户不存在
            Response response = Response.createErrorResponse();
            response.msg = Response.Message.USER_NONE;
            return response;

        }

    }


    public static class ConsumeRequest extends Request {

        public Data data;

    }

    public static class Data {

        public int coins;

        public int points;

        public String phoneNumber;

    }


    public interface Status {

        //金币不够
        int COIN_NOT_ENOUGH = -11;
    }

}
