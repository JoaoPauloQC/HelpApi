package com.help.app_msg.controllers;

import com.help.app_msg.dtos.helpMsgRequest;
import com.help.app_msg.models.helpMsg;
import com.help.app_msg.services.helpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/help")
public class helpController {

    private helpService helpService;

    private helpController(helpService helpService){
        this.helpService = helpService;
    }

    @GetMapping()
    public ResponseEntity<List> All(){
        List<helpMsg> all = helpService.getHelpmsgs();
        return ResponseEntity.ok(all);
    }

    @PostMapping()
    public ResponseEntity<Void> newHelp(@RequestBody helpMsgRequest helpMsgRequest){
        if(helpService.getHelpmsgs().isEmpty()) {
            helpService.addHelp(new helpMsg(1, helpMsgRequest.getName(), "aberto"));
        }
        else{
            helpService.addHelp(new helpMsg(helpService.getHelpmsgs().size()+1, helpMsgRequest.getName(), "aberto"));
        }
        return ResponseEntity.ok().build();
    }

}
