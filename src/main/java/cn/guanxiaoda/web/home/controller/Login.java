package cn.guanxiaoda.web.home.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;

/**
 * @author guanxiaoda
 * @date 2019-01-31
 */
@Controller
@Slf4j
public class Login {


    @PostMapping("/login")
    public String addLink(@RequestParam String name, @RequestParam String password) {
        if (StringUtils.compare(password, "12345abcdf") == 0) {
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            servletRequestAttributes.getResponse().addCookie(new Cookie("login", "true"));
            log.info("login success: {}", name);
            return "redirect:/";
        }

        log.info("密码错误! {}", name);
        return "login";
    }


}
