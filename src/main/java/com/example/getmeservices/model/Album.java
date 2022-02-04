package com.example.getmeservices.model;

import org.springframework.data.annotation.Id;


public class Album {
    @Id
    private String id;
    private String name;
    private String createdby;
    private String datecreated;
    private String coverPicUrl;

    public Album(String name, String createdby, String datecreated, String coverPicUrl) {
        this.name = name;
        this.createdby = createdby;
        this.datecreated = datecreated;
        this.coverPicUrl = coverPicUrl;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreatedby() {
        return createdby;
    }

    public void setCreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getDatecreated() {
        return datecreated;
    }

    public void setDatecreated(String datecreated) {
        this.datecreated = datecreated;
    }

    public String getCoverPicUrl() {
        return coverPicUrl;
    }

    public void setCoverPicUrl(String coverPicUrl) {
        this.coverPicUrl = coverPicUrl;
    }
}
