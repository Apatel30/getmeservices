package com.example.getmeservices.resource;

import com.example.getmeservices.model.Album;
import com.example.getmeservices.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class AlbumResource {
    @Autowired
    private AlbumService albumService;

    @PostMapping
    public  Album saveAlbum(@RequestBody @Valid Album album){
        return albumService.saveAlbum(album);
    }

    @GetMapping
    public List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/find")
    public List<Album> getById(@RequestParam(name = "id") String id){
       return albumService.getById(id);
    }

    @PutMapping
    public Album updateAlbum(@RequestBody Album album){
        return albumService.updateAlbum(album);
    }
    @DeleteMapping
    public void deleteAlbum(@RequestParam(name = "AlbumId") String AlbumId){
         albumService.deleteAlbum(AlbumId);
    }

}
