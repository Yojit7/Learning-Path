package org.springPro.springpro.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
 


@RestController
public class CheckController{


  
    @GetMapping("/check")
    public String checkProject(){
        return "Project is Working";
    }

}