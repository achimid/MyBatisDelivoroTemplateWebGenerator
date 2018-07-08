package br.com.achimid.web.generator.controller;

import br.com.achimid.web.generator.DTO.DelivoroCRUDParams;
import br.com.achimid.web.generator.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/generator")
public class GeneratorController {

    @Autowired
    private GeneratorService generatorService;

    @PostMapping
    public HttpEntity<?> gerarTemplate(@RequestBody DelivoroCRUDParams config){
        return ResponseEntity.ok(generatorService.gerarTemplate(config));
    }

}
