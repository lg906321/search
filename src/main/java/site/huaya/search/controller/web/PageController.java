package site.huaya.search.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/login.page")
    public String indexPage(){
        return "login.html";
    }
}
