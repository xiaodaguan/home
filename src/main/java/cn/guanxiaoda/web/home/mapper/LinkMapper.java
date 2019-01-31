package cn.guanxiaoda.web.home.mapper;

import cn.guanxiaoda.web.home.model.HelloModel;
import cn.guanxiaoda.web.home.model.LinkModel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author guanxiaoda
 * @date 2019-01-31
 */
@Mapper
@Component
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public interface LinkMapper {

    // 插入 并查询id 赋给传入的对象
    @Insert("INSERT INTO favors(title, url, tag) VALUES(#{title}, #{url}, #{tag})")
    @SelectKey(statement = "SELECT seq id FROM sqlite_sequence WHERE (name = 'favors')", before = false, keyProperty = "id", resultType = int.class)
    int insert(LinkModel model);

    // 根据 ID 查询
    @Select("SELECT * FROM favors WHERE id=#{id}")
    LinkModel select(int id);

    // 查询全部
    @Select("SELECT * FROM favors")
    List<LinkModel> selectAll();

    // 更新 value
    @Update("UPDATE favors SET title=#{title}, url=#{url}, tag=#{tag} WHERE id=#{id}")
    int updateValue(LinkModel model);

    // 根据 ID 删除
    @Delete("DELETE FROM favors WHERE id=#{id}")
    int delete(Integer id);

}