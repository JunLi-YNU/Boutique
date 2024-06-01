package com.junli.boutique.controller;

import com.junli.boutique.domain.NormalUser;
import com.junli.boutique.service.NormalUserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;


/**
 * @program: boutique
 * @description: Boutique controller
 * @author: Cageling
 * @created: 2023/07/29 15:48
 */
@RestController
@Slf4j
public class BoutiqueController {

    @Tag(name = "Loading Boutique Home Page!", description = "获取Boutique项目主页")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() throws FileNotFoundException {
        log.info("Boutique Start");
        return "Hello!This is Boutique.";
    }
}
