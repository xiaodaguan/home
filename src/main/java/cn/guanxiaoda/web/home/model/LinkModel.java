package cn.guanxiaoda.web.home.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author guanxiaoda
 * @date 2019-01-31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "link_coll")
public class LinkModel {

    @Id
    private String title;
    private String url;
    private String tag;

    public LinkModel(String title, String url) {
        this.title = title;
        this.url = url;
        this.tag = "未分类";
    }

    public LinkModel(String title) {
        this.title = title;
        this.url = "未定义";
        this.tag = "未分类";
    }
}
