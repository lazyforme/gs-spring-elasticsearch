package com.wcy.hello.model.elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.mongodb.core.index.Indexed;

import java.util.Date;

@Document(indexName = "sznongfu_merchant_dict", type = "dict.product")
public class Dict_Product {
    @Id
    private String id;

    @Indexed
    private String catalog;

    @Indexed
    private String keywords;

    @Indexed
    private String companyName;

    @Indexed
    private String registry;

    @Indexed
    private String name;

    private String productName;

    private String desc;

    private Date createdTime = new Date();

    private Date lastModTime = new Date();

    private Boolean archived = false;

    //private Dict_Product_Addons[] addons;

    public Dict_Product() {
    }

    public Dict_Product(String id, String catalog, String keywords, String companyName, String registry, String name, String productName, String desc, Date createdTime, Date lastModTime, Boolean archived) {
        this.id = id;
        this.catalog = catalog;
        this.keywords = keywords;
        this.companyName = companyName;
        this.registry = registry;
        this.name = name;
        this.productName = productName;
        this.desc = desc;
        this.createdTime = createdTime;
        this.lastModTime = lastModTime;
        this.archived = archived;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }
}
