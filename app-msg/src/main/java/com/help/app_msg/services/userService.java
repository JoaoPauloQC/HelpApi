package com.help.app_msg.services;

import com.help.app_msg.dtos.userRequest;
import com.help.app_msg.models.user;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

}
