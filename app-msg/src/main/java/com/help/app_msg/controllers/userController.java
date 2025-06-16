package com.help.app_msg.controllers;


import com.help.app_msg.dtos.userRequest;
import com.help.app_msg.models.user;
import com.help.app_msg.services.userService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class userController {

    private userService userservice;

    private userController(userService uservice){
        this.userservice = uservice;
    }

    @PostMapping("/newuser")
    public ResponseEntity<Void> newUser(@RequestBody userRequest userrequest){
         String add = userservice.addUser(new user(userrequest.getNome(), userrequest.getTurma(), userrequest.getIdade(), userrequest.getProntuario()));
        if(Objects.equals(add, "Adicionado")){

            return ResponseEntity.ok().build();
        }
        else{
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    @GetMapping("/allusers")
    public ResponseEntity<List> getAll(){

        return ResponseEntity.ok(userservice.getusers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<user> gettingbyid(@PathVariable String id){
        System.out.println("hi");
        Optional<user> ouser = userservice.getbyid(id);
        user user = ouser.get();
        System.out.println("hi");
        return ResponseEntity.ok(user);
    }

}
