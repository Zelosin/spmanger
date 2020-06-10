package com.zelosin.untilJuin.controllers.autho;

import com.zelosin.untilJuin.services.VKServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VKAuthoController {

    @Autowired
    private VKServiceImpl appliendVKService;

    @GetMapping("/vk-autho-confirm")
    public String confirmCodeReceiveVkAutho(@RequestParam(name = "code", required = false) String code,
                                            @RequestParam(name = "access_token", required = false) String access_token,
                                            Model model){
        if(!appliendVKService.isAlreadyAuthed())
            model.addAttribute("vkAuthResult", appliendVKService.authService(code));
        else
            model.addAttribute("isVkLinked", true);
        return "services-autho";
    }
}
