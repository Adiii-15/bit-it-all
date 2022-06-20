package com.isu.cs309.biditall;

import com.isu.cs309.biditall.service.ItemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@RestController
public class BiditallApplication implements CommandLineRunner{

    @Resource
    ItemService.FileService fileService;

    public static void main(String[] args) {
        SpringApplication.run(BiditallApplication.class, args);
    }

    @Override
    public void run(String ... arg) throws Exception {
        fileService.deleteAll();
        fileService.init();
    }

    @PostMapping("/secure")
    public String secured(){
        return "Secured Link";
    }

}

