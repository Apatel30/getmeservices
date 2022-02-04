package com.example.getmeservices.service;

import com.example.getmeservices.model.Album;
import com.example.getmeservices.model.Photo;
import com.example.getmeservices.repository.AlbumRepository;
import com.example.getmeservices.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PhotoService {
    @Autowired
    private PhotoRepository photoRepository;

    public Photo savePhoto(Photo photo) {

        return photoRepository.save(photo);
    }

    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }

    public Photo updatePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    public void deletePhoto(String photoId) {
        photoRepository.deleteById(photoId);
    }

    public List<Photo> getById(String id) {
        return photoRepository.findAllById(id);
    }

}
