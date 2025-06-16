package com.help.app_msg.controllers;

import com.help.app_msg.dtos.helpMsgRequest;
import com.help.app_msg.dtos.helpMsgRequestId;
import com.help.app_msg.models.helpMsg;
import com.help.app_msg.models.user;
import com.help.app_msg.services.helpService;
import com.help.app_msg.services.userService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/help")
public class helpController {

    private helpService helpService;

    private userService userservice;
    private helpController(helpService helpService , userService userService){
        this.helpService = helpService;
        this.userservice = userService;
    }

    @GetMapping()
    public ResponseEntity<List> All(){
        List<helpMsg> all = helpService.getHelpmsgs();
        return ResponseEntity.ok(all);
    }

    @PostMapping()
    public ResponseEntity<Void> newHelp(@RequestBody helpMsgRequest helpMsgRequest){

        Optional<user> checkuser = userservice.getbyid(helpMsgRequest.getProntuario());

        if (checkuser.isPresent()) {
            user user = checkuser.get();
            if (helpService.getHelpmsgs().isEmpty()) {

                helpService.addHelp(new helpMsg(1, helpMsgRequest.getName(), "aberto", user  ));
            } else {
                helpService.addHelp(new helpMsg(helpService.getHelpmsgs().size() + 1, helpMsgRequest.getName(), "aberto" , user));
            }
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.unprocessableEntity().build();
    }

    @GetMapping("/getone")
    public ResponseEntity<helpMsg> gettingbyid(@RequestBody helpMsgRequestId helpMsgRequestId){
        if(helpService.gettingbyid(helpMsgRequestId.getId()).isPresent()){

            return ResponseEntity.ok(helpService.gettingbyid(helpMsgRequestId.getId()).get());
        }
        else{
            return ResponseEntity.unprocessableEntity().build();
        }

    }


}
