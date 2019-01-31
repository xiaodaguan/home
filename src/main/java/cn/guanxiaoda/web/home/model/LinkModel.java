package cn.guanxiaoda.web.home.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author guanxiaoda
 * @date 2019-01-31
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LinkModel {

    private long id;
    private String title;
    private String url;
    private String tag;

    public LinkModel(String title, String url) {
        this.title = title;
        this.url = url;
    }

    public LinkModel(String title, String url, String tag) {
        this.title = title;
        this.url = url;
        this.tag = tag;
    }
}
