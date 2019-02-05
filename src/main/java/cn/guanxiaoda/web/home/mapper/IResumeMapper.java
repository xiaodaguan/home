package cn.guanxiaoda.web.home.mapper;

import cn.guanxiaoda.web.home.model.Resume;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author guanxiaoda
 * @date 2019-02-01
 */
public interface IResumeMapper {
    boolean create(Resume r);
    Resume read(String name);
    boolean update(Resume r);
    boolean delete(String name);

}
