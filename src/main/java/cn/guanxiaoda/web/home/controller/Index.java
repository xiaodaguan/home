package cn.guanxiaoda.web.home.controller;

import cn.guanxiaoda.web.home.model.LinkModel;
import cn.guanxiaoda.web.home.service.LinkService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        Cookie[] cookies = servletRequestAttributes.getRequest().getCookies();
        if (cookies == null || cookies.length == 0) {
            log.info("no cookies");
            return "login";
        }
        Map<String, String> coo = Arrays.asList(cookies).parallelStream().collect(Collectors.toMap(c -> c.getName(), c -> c.getValue(), (o1, o2) -> o2));
        if (!coo.containsKey("login") || !coo.get("login").equals("true")) {
            log.info("未登录");
            return "login";
        }

        // load
        Map<String, List<LinkModel>> models = service.selectAll();
        // set
        map.addAttribute("subTitle", "FAVORITES");
        map.addAttribute("models", models);
        // return
        return "index";
    }

    @PostMapping("/addlink")
    public String addLink(@RequestParam String title, @RequestParam String url, @RequestParam String tag) {
        if (StringUtils.isEmpty(title)) {
            return "redirect:/";
        }
        service.insert(new LinkModel(title, url, tag));
        return "redirect:/";
    }

    @GetMapping("/delLink/{title}")
    public String delLink(@PathVariable String title) {
        service.delete(title);
        return "redirect:/";
    }


}
