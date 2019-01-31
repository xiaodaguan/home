package cn.guanxiaoda.web.home.service;


import cn.guanxiaoda.web.home.mapper.HelloMapper;
import cn.guanxiaoda.web.home.model.HelloModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author guanxiaoda
 * @date 2019-01-31
 */

@Service
public class HelloService {

    @Autowired
    private HelloMapper dao;

    public boolean insert(HelloModel model) {
        return dao.insert(model) > 0;
    }

    public HelloModel select(int id) {
        return dao.select(id);
    }

    public List<HelloModel> selectAll() {
        return dao.selectAll();
    }

    public boolean updateValue(HelloModel model) {
        return dao.updateValue(model) > 0;
    }

    public boolean delete(Integer id) {
        return dao.delete(id) > 0;
    }
}