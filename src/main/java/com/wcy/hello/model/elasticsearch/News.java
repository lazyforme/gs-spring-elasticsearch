package com.wcy.hello.model.elasticsearch;

import com.wcy.hello.model.mongo.CoverImg;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

@Document(indexName = "sznongfu_merchant", type = "ec.news")
public class News {
    @Id
    private String id;

    private String title;

    private String desc;

    private String content;

    private String catalogCode;

    private Integer type;

    private String scopes;

    private CoverImg[] coverImg;

    private String status;

    private String areaCode;

    @Field(type = FieldType.Date)
    private Date createdTime;

    @Field(type = FieldType.Date)
    private Date lastModTime;

    @Field(type = FieldType.Date)
    private Date publishedTime;

    private Boolean archived;

    public News() {
    }

    public News(String id) {
        this.id = id;
    }

    public News(String id, String title, String desc, String content, String catalogCode, Integer type, String scopes, CoverImg[] coverImg, String status, String areaCode, Date createdTime, Date lastModTime, Date publishedTime, Boolean archived) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.content = content;
        this.catalogCode = catalogCode;
        this.type = type;
        this.scopes = scopes;
        this.coverImg = coverImg;
        this.status = status;
        this.areaCode = areaCode;
        this.createdTime = createdTime;
        this.lastModTime = lastModTime;
        this.publishedTime = publishedTime;
        this.archived = archived;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCatalogCode() {
        return catalogCode;
    }

    public void setCatalogCode(String catalogCode) {
        this.catalogCode = catalogCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    public CoverImg[] getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(CoverImg[] coverImg) {
        this.coverImg = coverImg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getLastModTime() {
        return lastModTime;
    }

    public void setLastModTime(Date lastModTime) {
        this.lastModTime = lastModTime;
    }

    public Date getPublishedTime() {
        return publishedTime;
    }

    public void setPublishedTime(Date publishedTime) {
        this.publishedTime = publishedTime;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }
}
