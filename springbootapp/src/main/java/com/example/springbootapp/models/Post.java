package com.example.springbootapp.models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.util.UUID;
public class Post{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String content;
    
    @Override
    public String toString(){
        return String.format("Post[id=%s, title='%s', content='%s']", id, title, content);
    }
    
    public void setId(UUID id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setContent(String content){
        this.content = content;
    }
    public UUID getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public String getContent(){
        return this.content;
    }
};