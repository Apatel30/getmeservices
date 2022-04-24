package com.example.getmeservices.resource;

import com.example.getmeservices.model.Album;
import com.example.getmeservices.model.FirebaseUser;
import com.example.getmeservices.model.User;
import com.example.getmeservices.service.AlbumService;
import com.example.getmeservices.service.FirebaseService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
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


    @Autowired
    private FirebaseService firebaseService;

    @GetMapping
    public List<Album> getAllAlbums(@RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser != null) {
            return albumService.getAllAlbums();
        }
        return null;
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
