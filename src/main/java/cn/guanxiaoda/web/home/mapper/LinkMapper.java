package cn.guanxiaoda.web.home.mapper;

import cn.guanxiaoda.web.home.model.LinkModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author guanxiaoda
 * @date 2019-01-31
 */
public interface LinkMapper  {

    void save(LinkModel item);

    void remove(LinkModel item);

    void update(LinkModel item);

    LinkModel findById(LinkModel item);

    List<LinkModel> findAll();
}
