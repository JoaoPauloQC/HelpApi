package com.help.app_msg.services;

import com.help.app_msg.dtos.userRequest;
import com.help.app_msg.models.user;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class userService {

    List<user> users = new ArrayList<user>();


    public String addUser(user user) {
        ;
        if (validate(user)) {
            users.add(user);
            return "Adicionado";
        } else {
            return "Não foi possivel adicionar";
        }
    }

    public Optional<user> getbyid(String id){
        System.out.println("to procurando");
        Optional<user> selected_user = users.stream()
                .filter(u -> Objects.equals(u.getProntuario(), id))
                .findFirst();
        return selected_user;
    }

    public List<user> getusers(){
        return users;
    }

    public boolean validate(user User){
        if(User.getProntuario().length() == 9 ){
            if( User.getProntuario().toLowerCase().contains("sp")){
                return true;
            }
            return false;
        }
        return false;
    }

    public List<user> login(String nome, String prontuario){
        List<user> searchuser = new ArrayList<>();
        List<String> prontuarios = users.stream().map(u -> u.getProntuario()).collect(Collectors.toList());
        System.out.println(prontuarios);


        if (prontuarios.contains(prontuario) ){
            System.out.println("if");
            user searchedprontuario = users.stream().filter(u -> u.getProntuario().equals(prontuario)).findFirst().get();
            if(Objects.equals(nome, searchedprontuario.getNome())){
                searchuser.add(searchedprontuario);
            }
        }
        return searchuser;
    }





}
