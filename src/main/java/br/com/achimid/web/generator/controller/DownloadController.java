package br.com.achimid.web.generator.controller;

import br.com.achimid.web.generator.DTO.DelivoroCRUDParams;
import br.com.achimid.web.generator.service.GeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/api/v1/download")
public class DownloadController {


    @Autowired
    private GeneratorService generatorService;

    @GetMapping("/xml")
    public ResponseEntity<InputStreamResource> downloadXml(@RequestBody DelivoroCRUDParams config) throws IOException {

        String xmlContent = generatorService.gerarTemplate(config);

        InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(xmlContent.getBytes(StandardCharsets.UTF_8)));

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=teste")
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }

}
