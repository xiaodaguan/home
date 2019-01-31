package cn.guanxiaoda.web.home.service;


import cn.guanxiaoda.web.home.mapper.LinkMapper;
import cn.guanxiaoda.web.home.model.LinkModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author guanxiaoda
 * @date 2019-01-31
 */

@Service
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class LinkService {

    @Autowired
    private LinkMapper dao;

    public boolean insert(LinkModel model) {
        return dao.insert(model) > 0;
    }

    public LinkModel select(int id) {
        return dao.select(id);
    }

    public Map<String, List<LinkModel>> selectAll() {
        List<LinkModel> list = dao.selectAll();
        Map<String, List<LinkModel>> models = list.stream().collect(Collectors.groupingBy(m -> Optional.ofNullable(m.getTag()).filter(StringUtils::isNotEmpty).orElse("未分类")));

        return models;
    }

    public boolean updateValue(LinkModel model) {
        return dao.updateValue(model) > 0;
    }

    public boolean delete(Integer id) {
        return dao.delete(id) > 0;
    }
}