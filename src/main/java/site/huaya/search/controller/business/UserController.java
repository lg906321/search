package site.huaya.search.controller.business;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import site.huaya.search.bean.Request;
import site.huaya.search.bean.Response;
import site.huaya.search.bean.UserInfo;
import site.huaya.search.db.UserInfoRepository;
import site.huaya.search.utils.VerifyUtils;

@RestController
@RequestMapping("/user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    //数据库操作类
    @Autowired
    private UserInfoRepository userInfoRepository;

    /**
     * 用户登录 如果表中有对应uid 返回用户信息，没有就创建用户并返回用户信息
     *
     * @return
     */
    @RequestMapping("/login")//对应url
    @ResponseBody//返回
    public Response login(@RequestBody Request request) {

        if (VerifyUtils.isTimeOut(request.getTime())) {
            //超时
            return Response.createTimeOutResponse();

        } else {
            //请求正常
            UserInfo userInfo = userInfoRepository.findByUid(request.getUid());
            if (userInfo!=null) {
                //用户存在
                    Response successResponse = Response.createSuccessResponse();
                    successResponse.msg = "拉取用户信息成功！";
                    successResponse.data = userInfo;
                    return successResponse;

            }
            return createUserInfo(request);


        }

    }

    /**
     * 创建用户信息
     * @param request
     * @return
     */
    private Response createUserInfo(@RequestBody Request request) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUid(request.getUid());
        userInfo.setDev(request.getDev());
        //初始化时用户拥有6个金币
        userInfo.setCoin(UserInfo.ORIGIN_COIN);
        userInfo = userInfoRepository.save(userInfo);
        userInfoRepository.flush();
        Response successResponse = Response.createSuccessResponse();
        successResponse.msg = "创建用户成功！";
        successResponse.data = userInfo;
        return successResponse;
    }




}
