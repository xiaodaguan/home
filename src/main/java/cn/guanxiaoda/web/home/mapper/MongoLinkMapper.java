package cn.guanxiaoda.web.home.mapper;

import cn.guanxiaoda.web.home.model.LinkModel;
import com.mongodb.client.result.DeleteResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author guanxiaoda
 * @date 2019-01-31
 */
@Component
@Slf4j
public class MongoLinkMapper implements LinkMapper {


    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public void save(LinkModel item) {
        mongoTemplate.save(item);
    }

    @Override
    public void remove(LinkModel item) {
        DeleteResult result = mongoTemplate.remove(item);
        if (result.getDeletedCount() > 0) {
            log.info("删除成功:{}", item.getTitle());
        } else {
            log.warn("没有删除:{}", item.getTitle());
        }
    }

    @Override
    public void update(LinkModel demoEntity) {
    }

    @Override
    public LinkModel findById(LinkModel item) {
        return null;
    }

    @Override
    public List<LinkModel> findAll() {
        return mongoTemplate.findAll(LinkModel.class);
    }
}
