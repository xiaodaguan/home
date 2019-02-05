package cn.guanxiaoda.web.home.mapper;

import cn.guanxiaoda.web.home.model.Resume;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

/**
 * @author guanxiaoda
 * @date 2019-02-01
 */
@Component
@Slf4j
public class MongoResumeMapper implements IResumeMapper {

    @Autowired MongoTemplate mongoTemplate;

    @Override
    public boolean create(Resume r) {
        return Try.of(() -> mongoTemplate.insert(r)).map(re -> re != null).get();
    }

    @Override
    public Resume read(String name) {
        return Try.of(() -> mongoTemplate.find(new Query(Criteria.where("name").is(name)), Resume.class).get(0)).get();
    }

    @Override
    public boolean update(Resume r) {
        return Try.of(() -> mongoTemplate.save(r)).map(re -> re != null).get();
    }

    @Override
    public boolean delete(String name) {
        return Try.of(() -> mongoTemplate.remove(new Query(Criteria.where("name").is(name)), Resume.class)).map(re -> re != null).get();
    }
}
