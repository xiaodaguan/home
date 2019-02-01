package cn.guanxiaoda.web.home.controller;

import cn.guanxiaoda.web.home.model.LinkModel;
import cn.guanxiaoda.web.home.service.LinkService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author guanxiaoda
 * @date 2019-01-31
 */
@Controller
@Slf4j
public class Index {


    @Autowired private LinkService service;

    @GetMapping("/")
    public String index(ModelMap map) {
        // load
        Map<String, List<LinkModel>> models = service.selectAll();
        // set
        map.addAttribute("subTitle", "欢迎！");
        map.addAttribute("models", models);
        // return
        return "index";
    }

    @PostMapping("/addlink")
    public String addLink(@RequestParam String title, @RequestParam String url, @RequestParam String tag) {
        service.insert(new LinkModel(title, url, tag));
        return "redirect:/";
    }

    @GetMapping("/create")
    public String create() {
        return "create";
    }

    @GetMapping("/delLink/{title}")
    public String delLink(@PathVariable String title) {
        service.delete(title);
        return "redirect:/";
    }

}
