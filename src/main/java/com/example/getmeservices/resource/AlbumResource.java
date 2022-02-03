package com.example.getmeservices.resource;

import com.example.getmeservices.model.Album;
import com.example.getmeservices.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumResource {
    @Autowired
    private AlbumService albumService;


    @GetMapping("/album")
    public Album getAlbum(){

        return albumService.getAlbum();

    }
    @PostMapping("/album")
    public  Album saveAlbum(@RequestBody Album album){
        return albumService.saveAlbum(album);
    }
    @GetMapping("/allAlbums")
    public List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }
    @GetMapping("/album/{AlbumId}")
    public Album getAlbumById(@PathVariable("AlbumId") int AlbumId){
        return albumService.getAlbumById(AlbumId);
    }

    @PutMapping("/album/{AlbumId}")
    public Album updateAlbum(@PathVariable("AlbumId") int AlbumId,@RequestBody Album album ){
        return albumService.updateAlbum(AlbumId,album);
    }
    @DeleteMapping("/album")
    public Album deleteAlbum(@RequestParam(name = "AlbumId") int AlbumId){
        return albumService.deleteAlbum(AlbumId);
    }
}
