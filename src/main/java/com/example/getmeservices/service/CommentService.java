package com.example.getmeservices.service;

import com.example.getmeservices.model.Album;
import com.example.getmeservices.model.Comment;
import com.example.getmeservices.repository.AlbumRepository;
import com.example.getmeservices.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    public Comment saveComment(Comment comment) {

        return commentRepository.save(comment);
    }

    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(String commentId) {
        commentRepository.deleteById(commentId);
    }

    public List<Comment> getById(String id) {
        return commentRepository.findAllById(id);
    }

}
