package com.help.app_msg.services;

import com.help.app_msg.models.helpMsg;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class helpService {

    List<helpMsg> helpmsgs = new ArrayList<>();




    public void addHelp(helpMsg helpmsg){
        helpmsgs.add(helpmsg);
    }

    public List<helpMsg> getHelpmsgs() {
        return helpmsgs;
    }

    public Optional<helpMsg> gettingbyid(int id){
        Optional<helpMsg> selected = helpmsgs.stream().filter(h -> h.getId() == id ).findFirst();
        System.out.println(selected.isPresent());
        System.out.println("O id é " + id);
        System.out.println(helpmsgs.get(0).getId());
        System.out.println("foradoif");
        if (selected.isPresent()){
            System.out.println("Achei!");
            helpMsg selectedmsg = selected.get();
            catchid(selectedmsg);
            return selected;

        }
        System.out.println("foradoif2");
        return selected;
    }

    public helpMsg catchid(helpMsg helpMsg){
        return helpMsg;
    }
}
