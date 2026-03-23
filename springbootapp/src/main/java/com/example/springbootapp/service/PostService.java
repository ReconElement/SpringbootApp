package com.example.springbootapp.service;
import com.example.springbootapp.repository.PostRepository;
import com.example.springbootapp.models.Post;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PostService{
    @Autowired
    private PostRepository postRepository;
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }
    public Optional<Post> getPostById(UUID id){
        Optional<Post> result = Optional.empty();
        var value = postRepository.findAll();
        for(Post i: value){
            if(i.getId()==id){
                result = Optional.of(i);
            }
        }
        return result;
    }
    public Post savePost(Post post){
        return postRepository.save(post);
    }
    public Post updatePost(UUID id, Post postDetails){
        Post post = getPostById(id).orElseThrow(()-> new RuntimeException("Post not found"));
        post.setTitle(postDetails.getTitle());
        post.setContent(postDetails.getContent());
        return postRepository.save(post);
    }
    public void deletePost(UUID id){
        Post post = getPostById(id).orElseThrow(()-> new RuntimeException("Post to be deleted not found"));
        postRepository.delete(post);
    }
}