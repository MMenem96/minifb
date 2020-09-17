package com.mini.fb.minifb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// This class handles logic of Insertion, Updating, Selecting,Deletion of the table posts

@RestController
@RequestMapping("/posts")
public class PostController {


    @Autowired
    PostRepository postRepository;


//    //Save a post into db
//    @RequestMapping(value = "/addNewPost", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public ResponseEntity<?> signUp(@RequestBody PostModel postModel) {
//        return ResponseEntity.ok(postRepository.save(postModel));
//
//    }


    @RequestMapping(value = "/createNewPost", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PostModel createNewPost(@RequestBody PostModel postModel) {
        postRepository.save(postModel);
        return postModel;
    }


    @RequestMapping(value = "/getAllPosts",method = RequestMethod.GET,produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<PostModel> getAllPosts() {
        return postRepository.findAll();
    }

}
