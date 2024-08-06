package com.quinnox.training.clowns.lionspef;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@SecurityRequirement(name = "bearerAuth")

public class LionController {
	
	private final LionService lionService;

    @Autowired
    public LionController(LionService lionService) {
        this.lionService = lionService;
    }

    @GetMapping(path = "/lions")
    List<LionDTO> all() {
    	List<LionDTO> feed = lionService.all();
    	return feed;
      
    }


    @PostMapping(path = "/lions")
    public Lion newLion(@RequestBody Lion newLion) {
        return lionService.newLion(newLion);
    }
    
    @PutMapping(path = "/lions/{id}")
    public void trainerUpdate(@PathVariable("id") Long id, @RequestParam("trainerId") Long trainerId) {
    	lionService.trainerUpdate(id, trainerId);
    }
    
    @GetMapping(path = "/lions/{id}")
    public Lion findLion(@PathVariable("id") Long id) {
       return lionService.findById(id);
    }
    
    @DeleteMapping(path = "/lions/{id}")
    public void deleteLionById(@PathVariable("id") Long id) {
        lionService.deleteLionById(id);
    }
}
