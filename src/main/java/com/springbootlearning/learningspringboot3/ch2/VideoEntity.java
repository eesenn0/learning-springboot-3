package com.springbootlearning.learningspringboot3.ch2;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class VideoEntity {
    
    // @Id - JPA's annotation to flag the primary key
    private @Id @GeneratedValue Long id;
    private String name;
    private String username;
    private String description;

    protected VideoEntity() {
        
    }

    public VideoEntity(String username, String name, String description) {
        this.id = null;
        this.username = username;
        this.description = description;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    
}
