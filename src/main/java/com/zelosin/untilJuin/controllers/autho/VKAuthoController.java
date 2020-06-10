package com.zelosin.untilJuin.controllers.autho;

import com.zelosin.untilJuin.entities.destination.VKGroup;
import com.zelosin.untilJuin.entities.material.info.Attachment;
import com.zelosin.untilJuin.entities.material.info.MilledMaterial;
import com.zelosin.untilJuin.entities.users.info.SPUser;
import com.zelosin.untilJuin.services.UserServiceInter;
import com.zelosin.untilJuin.services.VKServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VKAuthoController {

    @Autowired
    private VKServiceImpl appliendVKService;

    @Autowired
    private UserServiceInter userService;


    @GetMapping("/vk-autho-confirm")
    public String confirmCodeReceiveVkAutho(@RequestParam(name = "code", required = false) String code,
                                            @RequestParam(name = "access_token", required = false) String access_token,
                                            Model model,
                                            @AuthenticationPrincipal SPUser user){
        if(!user.hasLinkedAccount()) {
            model.addAttribute("vkAuthResult", appliendVKService.authService(code, user.getLinkedVKAccount()));
        }
        else
            model.addAttribute("isVkLinked", true);
        user.defineAccountRelation();

        user.getLinkedVKAccount().getAccountGroups().get(2).addPost(new MilledMaterial("1","1","1","1"));

        userService.update(user);
        return "services-autho";
    }
}
