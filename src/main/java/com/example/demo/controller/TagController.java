package com.example.demo.controller;

import com.example.demo.model.Expert;
import com.example.demo.model.Tag;
import com.example.demo.service.TagService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TagController {

    private final Logger log = LoggerFactory.getLogger(TagController.class);

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/tags")
    public List<Tag> tagsFilters(@RequestParam(name="nombre", required=false) String nombre,
                                 @RequestParam(name="limite", required=false, defaultValue = "5") Integer limite,
                                 @RequestParam(name="pagina", required=false, defaultValue = "0") Integer pagina)
    {

         if (nombre != null){
            return tagService.findAllFilterNombre(nombre, limite, pagina);
        }
        else{
        return tagService.findAll(limite, pagina);
        }
    }


    @GetMapping("/tags/{id}")
    public Optional<Tag> findById(@PathVariable Long id) {
        return tagService.findByIdFromEntityManager(id);
    }

    @PostMapping("/tags")
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) throws URISyntaxException {
        log.debug("REST request to create an User: {} ", tag);
        if (tag.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Tag tagDB = tagService.createTag(tag);
        return ResponseEntity
                .created(new URI("/api/tags/" + tagDB.getId()))
                .body(tagDB);
    }

    @PutMapping("/tags")
    public ResponseEntity<Tag> updateTag(@RequestBody Tag tag) {
        log.debug("REST request to update an User: {}", tag);

        if (tag.getId() == null){
            log.warn("Updating User without id");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(tagService.updateTag(tag));
    }


    @DeleteMapping("/tags/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id){
        log.debug("REST request to delete an Tag by id {}", id);
        tagService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
