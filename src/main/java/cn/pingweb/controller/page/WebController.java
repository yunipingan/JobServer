package cn.pingweb.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhuyuping
 * @date 2018/1/18.
 */
@Controller
@RequestMapping("/PC")
public class WebController {

    @RequestMapping("/error")
    public String fail() {
        return "404";
    }

    @RequestMapping("/about")
    public String about() {
        return "about";
    }

    @RequestMapping("/agreement")
    public String agreement() {
        return "agreement";
    }

    @RequestMapping("/company")
    public String company() {
        return "company";
    }

    @RequestMapping("/detail_company")
    public String detail_company() {
        return "detail_company";
    }

    @RequestMapping("/forget")
    public String forget() {
        return "forget";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/reg")
    public String reg() {
        return "reg";
    }

    @RequestMapping("/resume")
    public String resume() {
        return "resume";
    }

}
