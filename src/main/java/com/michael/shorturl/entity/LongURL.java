package com.michael.shorturl.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class LongURL {

    //LongURL variables, getters and setters defined here
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String longUrl;
    private Integer clicks;
    private LocalDateTime createTime;
    private LocalDateTime lastVisited;

    public Integer getId() {
        return id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public Integer getClicks() {
        return clicks;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LocalDateTime getLastVisited(){
        return lastVisited;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public void setCreateTime(){
        this.createTime = LocalDateTime.now();
    }

    public void setLastVisited(){
        this.lastVisited = LocalDateTime.now();
    }
}
