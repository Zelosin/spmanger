package com.zelosin.untilJuin.controllers.autho;

import com.zelosin.untilJuin.entities.users.info.SPUser;
import com.zelosin.untilJuin.services.UserServiceInter;
import com.zelosin.untilJuin.services.VKServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainAuthoController {

    @Autowired
    private VKServiceImpl vkService;

    @Autowired
    private UserServiceInter userManager;


    @GetMapping("services-autho")
    public String authoServices(Model model){
        model.addAttribute("vk", vkService.createVKAuthorizationURL());
        return "services-autho";
    }
}
