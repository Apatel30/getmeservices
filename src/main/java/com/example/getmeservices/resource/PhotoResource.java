package com.example.getmeservices.resource;

import com.example.getmeservices.model.Comment;
import com.example.getmeservices.model.Photo;
import com.example.getmeservices.service.CommentService;
import com.example.getmeservices.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photos")
public class PhotoResource {
    @Autowired
    private PhotoService photoService;

    @PostMapping
    public Photo savePhoto(@RequestBody Photo photo){
        return photoService.savePhoto(photo);
    }

    @GetMapping
    public List<Photo> getAllPhotos(){
        return photoService.getAllPhotos();
    }

    @GetMapping("/find")
    public List<Photo> getById(@RequestParam(name = "id") String id){
        return photoService.getById(id);
    }

    @PutMapping
    public Photo updatePhoto(@RequestBody Photo photo){
        return photoService.updatePhoto(photo);
    }
    @DeleteMapping
    public void deletePhoto(@RequestParam(name = "PhotoId") String PhotoId){
        photoService.deletePhoto(PhotoId);
    }

}
