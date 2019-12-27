package com.zemoga.challenge.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "portfolio")
public class Portfolio {
    @Id
    @Column(name = "IDPORTFOLIO")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "IMAGE_URL")
    private String imageUrl;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "TWITTER_USER_NAME")
    private String twitterUserName;

    public Portfolio(Long id, String description, String imageUrl, String title, String twitterUserName) {
        this.id = id;
        this.description = description;
        this.imageUrl = imageUrl;
        this.title = title;
        this.twitterUserName = twitterUserName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTwitterUserName() {
        return twitterUserName;
    }

    public void setTwitterUserName(String twitterUserName) {
        this.twitterUserName = twitterUserName;
    }
}
