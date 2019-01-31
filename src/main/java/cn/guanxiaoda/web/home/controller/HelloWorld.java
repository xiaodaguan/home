package cn.guanxiaoda.web.home.controller;

import cn.guanxiaoda.web.home.model.HelloModel;
import cn.guanxiaoda.web.home.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author guanxiaoda
 * @date 2019-01-31
 */
@RestController
@RequestMapping("/hello")
public class HelloWorld {

    @Autowired
    private HelloService helloService;

    @GetMapping("/list")
    public List<HelloModel> list() {
        return helloService.selectAll();
    }

    @GetMapping("/")
    public String hello() {
        return "hello!";
    }

}
