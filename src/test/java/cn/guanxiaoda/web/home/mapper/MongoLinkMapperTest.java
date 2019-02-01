package cn.guanxiaoda.web.home.mapper;

import cn.guanxiaoda.web.home.HomeApplication;
import cn.guanxiaoda.web.home.model.LinkModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author guanxiaoda
 * @date 2019-01-31
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HomeApplication.class)
public class MongoLinkMapperTest {

    @Autowired private MongoLinkMapper mapper;


    @Test
    public void saveTest() {
        LinkModel model = new LinkModel("test1", "aaaaaa", "test");
        LinkModel model1 = new LinkModel("test2", "bbbbbbb", "test");
        mapper.save(model);
        mapper.save(model1);
    }

    @Test
    public void delTest(){
        LinkModel model = new LinkModel("test1");
        mapper.remove(model);
    }

    @Test
    public void findTest() {
        List<LinkModel> all = mapper.findAll();
        System.out.println(all);
    }


}
