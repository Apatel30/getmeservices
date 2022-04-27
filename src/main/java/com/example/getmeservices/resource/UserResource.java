package com.example.getmeservices.resource;

import com.example.getmeservices.exception.restrictedInfoException;
import com.example.getmeservices.model.FirebaseUser;
import com.example.getmeservices.model.User;
import com.example.getmeservices.service.FirebaseService;
import com.example.getmeservices.service.UserService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    private UserService userService;


    @Autowired
    private FirebaseService firebaseService;

    @PostMapping
    public User saveUser(@RequestBody @Valid User user, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser != null) {
            return userService.saveUser(user);
        }
        return null;
    }


    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @CrossOrigin
     @GetMapping("/find")
    public List<User> getByName(@RequestParam("name")String name) throws restrictedInfoException {
         if(name.equalsIgnoreCase("root")){
            throw new restrictedInfoException();
        }
        return userService.getByName(name);
    }

    @GetMapping("/find-by-id")
    public User getById(@RequestParam("userId") String userId){
        return userService.getById(userId);
    }

    @PutMapping
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }
    @DeleteMapping
    public void deleteUser(@RequestParam(name = "UserId") String UserId){
        userService.deleteUser(UserId);
    }

}

