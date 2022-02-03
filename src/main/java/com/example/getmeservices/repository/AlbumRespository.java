package com.example.getmeservices.repository;

import com.example.getmeservices.model.Album;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Repository
@Service
public class AlbumRespository {

    List<Album> albumList= new ArrayList();

    public Album getAlbum() {

        Album album = new Album("Album1", "I am Album",  "//ABC");
        return album;


    }

    public Album saveAlbum(Album album) {
        album.setAlbumId(albumList.size() + 1);
        albumList.add(album);
        return album;
    }

    public List<Album> getAllAlbums() {
        return albumList;
    }

    public Album getAlbumById(int albumId) {
        for(Album album:albumList){
            if(album.getAlbumId() == albumId){
                return album;
            }
        }
        return null;
    }

    public Album updateAlbum(int albumId, Album album) {
        for(Album a:albumList){
            if (a.getAlbumId() == albumId) {
                a.setName(album.getName());
                a.setDescription(album.getDescription());
                a.setCoverPicUrl(album.getCoverPicUrl());
                return a;
            }
        }
        return null;
    }

    public Album deleteAlbum(int albumId) {
        Album deleteAlbum=albumList.get(albumId);
        albumList.remove(deleteAlbum);
        return deleteAlbum;
    }


}