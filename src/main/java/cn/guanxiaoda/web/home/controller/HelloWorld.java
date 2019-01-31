package cn.guanxiaoda.web.home.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guanxiaoda
 * @date 2019-01-31
 */
@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @GetMapping("/")
    public String hello() {
        return "hello!";
    }

}
