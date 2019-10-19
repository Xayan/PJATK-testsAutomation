package pl.xayan.tau.tau1.entity;

import pl.xayan.tau.tau1.DI.AbstractEntity;

import java.sql.Date;

public class Entry extends AbstractEntity {
    private int id;

    private Feed feed;

    private String url;

    private String content;

    private Date publishDate;

    private Date lastFetchDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Feed getFeed() {
        return feed;
    }

    public void setFeed(Feed feed) {
        this.feed = feed;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getLastFetchDate() {
        return lastFetchDate;
    }

    public void setLastFetchDate(Date lastFetchDate) {
        this.lastFetchDate = lastFetchDate;
    }
}
