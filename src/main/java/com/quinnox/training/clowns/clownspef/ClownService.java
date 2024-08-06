package com.quinnox.training.clowns.clownspef;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.training.clowns.exceptions.BadRequestException;

@Service
public class ClownService {
	
	@Autowired
    private ClownRepository clownRepository;


    public Optional<Clown> findById(Long id) {
        return clownRepository.findById(id);
        
    }

    public Clown newClown(Clown newClown) {
    	try {
            clownRepository.save(newClown);
    	}
    	catch(Exception e) {
    		throw new BadRequestException("Unable to save clown. Likely server or JPA repository error.");
    	}
        return newClown;
    }
    
	public List<Clown> all() {
        return clownRepository.findAll();
    }
	
	public void deleteClownById(Long id) {
		clownRepository.deleteById(id);
	}
	
	/*
	 * public void addLion(Long id, Long lionId) { Clown trainer =
	 * clownRepository.findById(id).orElseThrow(() -> new
	 * IllegalStateException("Clown with id: " + id + "does not exist."));
	 * System.out.println(trainer); Lion lion =
	 * lionRepository.findById(lionId).orElseThrow(() -> new
	 * IllegalStateException("Lion with id: " + id + "does not exist."));
	 * System.out.println(lion); trainer.addLion(lion); System.out.println(trainer);
	 * clownRepository.save(trainer); }
	 */
    public ClownRepository getClownRepository() {
		return clownRepository;
	}

	public void setClownRepository(ClownRepository clownRepository) {
		this.clownRepository = clownRepository;
	}


    
}
