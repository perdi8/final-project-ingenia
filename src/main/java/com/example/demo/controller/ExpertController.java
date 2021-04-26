package com.example.demo.controller;

import com.example.demo.model.Expert;
import com.example.demo.model.Tag;
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
@CrossOrigin(origins = "https://final-project-ingenia-angular-288ppyhah-perdi8.vercel.app", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ExpertController {

    private final Logger log = LoggerFactory.getLogger(ExpertController.class);

    private final ExpertService expertService;

    public ExpertController(ExpertService expertService) {
        this.expertService = expertService;
    }


    @GetMapping("/expertos")
    public List<Expert> expertFilters(@RequestParam(name="nombre", required=false) String nombre,
                                            @RequestParam(name="modalidad",required=false) String modalidad,
                                            @RequestParam(name="estado",required=false) String estado,
                                            @RequestParam(name="tag",required=false) Long tag,
                                            @RequestParam(name="limite", required=false, defaultValue = "5") Integer limite,
                                            @RequestParam(name="pagina", required=false, defaultValue = "0") Integer pagina

                                      ) {


        if (tag != null) {
            return expertService.findAllByTagExperts(tag, limite, pagina);

        } else if (nombre != null) {
            return expertService.findAllNombreExperts(nombre, limite, pagina);

        }else if(modalidad != null) {
            return expertService.findAllModalidadExperts(modalidad, limite, pagina);

        }else if (estado != null) {
            return expertService.findAllEstadoExperts(estado, limite, pagina);
        }

        return expertService.findAllFromEntityManager(limite, pagina);
    }


    @GetMapping("/expertos/{id}")
    public Expert findById(@PathVariable Long id) {
        return expertService.findByIdFromEntityManager(id);
    }

    @PostMapping("/expertos")
    public ResponseEntity<Expert> createExpert(@RequestBody Expert expert) throws URISyntaxException {
        log.debug("REST request to create an User: {} ", expert);
        if (expert.getId() != null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Expert expertDB = expertService.createExpert(expert);
        return ResponseEntity
                .created(new URI("/api/expertos/" + expertDB.getId()))
                .body(expertDB);
    }

    @PutMapping("/expertos")
    public ResponseEntity<Expert> updateExpert(@RequestBody Expert expert) {
        log.debug("REST request to update an User: {}", expert);

        if (expert.getId() == null){
            log.warn("Updating User without id");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(expertService.updateExpert(expert));
    }

}
