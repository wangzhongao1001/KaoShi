package com.example.kaoshi;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class DbBean {
    @Id(autoincrement = true)
    private Long id;
    private String title;
    private String news;
    private String html;
    private String pic;
    @Generated(hash = 1730281754)
    public DbBean(String title, String news, String html, String pic) {
        this.id = id;
        this.title = title;
        this.news = news;
        this.html = html;
        this.pic = pic;
    }
    @Generated(hash = 1953169116)
    public DbBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getNews() {
        return this.news;
    }
    public void setNews(String news) {
        this.news = news;
    }
    public String getHtml() {
        return this.html;
    }
    public void setHtml(String html) {
        this.html = html;
    }
    public String getPic() {
        return this.pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
    
}
