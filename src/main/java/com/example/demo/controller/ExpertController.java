package com.example.demo.controller;

import com.example.demo.model.Expert;
import com.example.demo.service.ExpertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ExpertController {

    private final Logger log = LoggerFactory.getLogger(ExpertController.class);

    private final ExpertService expertService;

    public ExpertController(ExpertService expertService) {
        this.expertService = expertService;
    }

    @GetMapping("/experts")
    public List<Expert> findAll() {
        return expertService.findAllFromEntityManager();
    }

    @GetMapping("/experts/{id}")
    public Expert findById(@PathVariable Long id) {
        return expertService.findByIdFromEntityManager(id);
    }

    @GetMapping("/experts/attributes/{name}")
    public List<Expert> findAllByAttribute(@PathVariable String name) {
        return expertService.findAllByAttributeFromEntityManager(name);
    }

    @PostMapping("/experts")
    public ResponseEntity<Expert> createExpert(@RequestBody Expert expert) throws URISyntaxException {
        log.debug("REST request to create an User: {} ", expert);
        if (expert.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Expert expertDB = expertService.createExpert(expert);
        return ResponseEntity
                .created(new URI("/api/experts/" + expertDB.getId()))
                .body(expertDB);
    }

    @PutMapping("/experts")
    public ResponseEntity<Expert> updateExpert(@RequestBody Expert expert) {
        log.debug("REST request to update an User: {}", expert);

        if (expert.getId() == null){
            log.warn("Updating User without id");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(expertService.updateExpert(expert));
    }

}
