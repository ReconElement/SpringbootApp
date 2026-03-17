package com.example.springbootapp;
import com.example.springbootapp.posts.Post;
import com.example.springbootapp.posts.Posts;
import org.springframework.web.bind.annotation.*;
import java.util.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {
    @RequestMapping(value="/post", method=RequestMethod.GET)
    @ResponseBody
    public List<Post> showSomePosts(){
        Post a = new Post();
        Post b = new Post();
        a.setTitle("I like to write lots of code");
        a.setContent("Yep, the best part about programming is writing lots of code");
        b.setTitle("You should enjoy programming as well");
        b.setContent("Yea man you should");
        List<Post> postList = new ArrayList<Post>();
        postList.add(a);
        postList.add(b);
        return postList;
    };

    @RequestMapping(value="/posts", method=RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> addSomePosts(){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("Add the title of the post: ");
            String title = sc.nextLine();
            System.out.println("Add the content of the post: ");
            String content = sc.nextLine();
            Post post = new Post();
            post.setTitle(title);
            post.setContent(content);
            Map<String, Object> resp = new HashMap<>();
            resp.put("Posts", post);
            return resp;
        }catch(Exception e){
            System.out.println("Some exception caught: "+e.toString());
            Map<String, Object> resp = new HashMap<>();
            resp.put("Message", "Internal Server Error");
            return resp;
        }
    };
}
