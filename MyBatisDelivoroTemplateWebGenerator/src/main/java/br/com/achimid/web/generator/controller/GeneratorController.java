package br.com.achimid.web.generator.controller;

import br.com.achimid.web.generator.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/generator")
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;


    @GetMapping
    public HttpEntity<?> gerarTemplate(){
        return ResponseEntity.ok(generatorService.gerarTemplate());
    }

}
