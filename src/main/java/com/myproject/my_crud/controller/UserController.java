package com.myproject.my_crud.controller;

import com.myproject.my_crud.business.UserService;
import com.myproject.my_crud.infrastructure.entitys.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<Void> saveUser(@RequestBody Usuario user){
        userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Usuario> searchUserToEmail(@RequestParam String email){
        return ResponseEntity.ok(userService.searchUserToEmail(email));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUserToEmail(@RequestParam String email){
        userService.deleteUserToEmail(email);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<Void> updateUserToId(@RequestParam Long id, @RequestBody Usuario user){
        userService.updateUserToId(id, user);
        return ResponseEntity.ok().build();
    }
}
