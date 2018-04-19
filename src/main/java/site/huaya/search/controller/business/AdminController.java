package site.huaya.search.controller.business;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 管理员相关接口
 */

@RestController
public class AdminController {

    private static String USERNAME="zhuruqiao";

    private static String PASSWORD="Luoduo110";

    /**
     * 管理员登录
     * @return
     */
    @RequestMapping("/login")
    public String login(String username,String password){
        if (USERNAME.equals(username)&&PASSWORD.equals(password)){

            return "manage.html";

        }else {

            return "登录失败";
        }

    }

//    @RestController注解，相当于@Controller+@ResponseBody两个注解的结合，返回json数据不需要在方法前面加@ResponseBody注解了，但使用@RestController这个注解，就不能返回jsp,html页面，视图解析器无法解析jsp,html页面



}
