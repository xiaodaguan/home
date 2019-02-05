package cn.guanxiaoda.web.home.controller;

import cn.guanxiaoda.web.home.model.Resume;
import cn.guanxiaoda.web.home.service.ResumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author guanxiaoda
 * @date 2019-02-01
 */
@Controller("/resume")
@Slf4j
public class ResumeController {

    @Autowired private ResumeService service;

    @GetMapping("/save")
    public String save(String json) {
        service.save(json);
        return "redirect:resume";
    }

    @GetMapping("/index")
    public String index(ModelMap map) {
        map.addAttribute("subTitle", "简历");

        Resume resume = service.find("guanxiaoda");
        map.addAttribute("resume", resume);
        return "resume";
    }

}
