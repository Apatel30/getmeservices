package com.example.getmeservices.service;

import com.example.getmeservices.model.Album;
import com.example.getmeservices.repository.AlbumRespository;
import com.example.getmeservices.repository.AlbumRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {
    @Autowired
    private AlbumRespository albumRespository;



    public Album getAlbum() {
        return albumRespository.getAlbum();
    }

    public Album saveAlbum(Album album) {
        return albumRespository.saveAlbum(album);
    }

    public List<Album> getAllAlbums() {
        return albumRespository.getAllAlbums();
    }

    public Album getAlbumById(int albumId) {
        return albumRespository.getAlbumById(albumId);
    }

    public Album updateAlbum(int albumId, Album album) {
        return albumRespository.updateAlbum(albumId,album);
    }

    public Album deleteAlbum(int albumId) {
        return albumRespository.deleteAlbum(albumId);
    }
}
