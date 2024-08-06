package com.quinnox.training.clowns.clownspef;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
//@CrossOrigin(origins = "http://localhost:3000")
@SecurityRequirement(name = "bearerAuth")
public class ClownController {
    private final ClownService clownService;

    @Autowired
    public ClownController(ClownService clownService) {
        this.clownService = clownService;
    }

    @GetMapping(path = "/clowns")
    List<Clown> all() {
      return clownService.all();
    }
    
    @PostMapping(path = "/clowns")
    public Clown newClown(@RequestBody Clown newClown) {
        return clownService.newClown(newClown);
    }

    
    @GetMapping(path = "/clowns/{id}")
    public Optional<Clown> findClown(@PathVariable("id") Long id) {
        try {
            return clownService.findById(id);
        } catch (Exception e) {
            throw new ClownNotFoundException(id);
        }
    }
    
    @DeleteMapping(path = "/clowns/{clownid}")
    public void deleteClownById(@PathVariable("clownid") Long id) {
        try {
            clownService.deleteClownById(id);
        } catch (Exception e) {
            throw new ClownNotFoundException(id);
        } 
    }
}
