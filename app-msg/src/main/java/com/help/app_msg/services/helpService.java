package com.help.app_msg.services;

import com.help.app_msg.models.helpMsg;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class helpService {

    List<helpMsg> helpmsgs = new ArrayList<>();




    public void addHelp(helpMsg helpmsg){
        helpmsgs.add(helpmsg);
    }

    public List<helpMsg> getHelpmsgs() {
        return helpmsgs;
    }
}
