package cn.guanxiaoda.web.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author guanxiaoda
 * @date 2019-01-31
 */
@Controller
@RequestMapping("/index")
public class Index {


    @GetMapping("/")
    public String index(ModelMap map) {
        map.addAttribute("subTitle", "欢迎！");
        return "index";
    }

}
