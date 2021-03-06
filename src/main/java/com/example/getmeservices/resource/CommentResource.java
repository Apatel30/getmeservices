package com.example.getmeservices.resource;

import com.example.getmeservices.model.Comment;
import com.example.getmeservices.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/comments")
public class CommentResource {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public Comment saveComment(@RequestBody @Valid Comment comment){
        return commentService.saveComment(comment);
    }

    @GetMapping
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }
    @CrossOrigin
    @GetMapping("/find")
    public List<Comment> getById(@RequestParam(name = "id") String id){
        return commentService.getById(id);
    }

    @PutMapping
    public Comment updateComment(@RequestBody Comment comment){
        return commentService.updateComment(comment);
    }
    @DeleteMapping
    public void deleteComment(@RequestParam(name = "CommentId") String CommentId){
        commentService.deleteComment(CommentId);
    }

}
