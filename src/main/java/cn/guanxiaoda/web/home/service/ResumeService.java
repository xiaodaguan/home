package cn.guanxiaoda.web.home.service;

import cn.guanxiaoda.web.home.mapper.MongoResumeMapper;
import cn.guanxiaoda.web.home.model.Resume;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author guanxiaoda
 * @date 2019-02-01
 */
@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
@Slf4j
public class ResumeService {

    @Autowired private MongoResumeMapper dao;

    public void save(String json) {
        Resume resume = null;
        try {
            resume = JSON.parseObject(json, Resume.class);
        } catch (Exception e) {
            log.warn("格式错误", e);
            return;
        }

        if (dao.create(resume)) {
            log.info("save succeed: {}", resume);
        } else {
            log.info("save failed: {}", resume);
        }
    }

    public Resume find(String personName){
        return dao.read(personName);
    }
}
