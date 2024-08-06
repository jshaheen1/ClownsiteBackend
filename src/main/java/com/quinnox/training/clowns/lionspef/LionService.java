package com.quinnox.training.clowns.lionspef;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quinnox.training.clowns.clownspef.Clown;
import com.quinnox.training.clowns.clownspef.ClownRepository;
import com.quinnox.training.clowns.exceptions.BadRequestException;
import com.quinnox.training.clowns.exceptions.ResourceNotFoundException;


@Service
public class LionService {
	
	
	@Autowired
    private LionRepository lionRepository;
	
	@Autowired
	private ClownRepository clownRepository;


    public Lion findById(Long id) {
        return lionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lion with id: " + id + "does not exist."));
    }
    
    public void trainerUpdate(Long id, Long trainerId) {
    	Lion lion = lionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Lion with id: " + id + "does not exist."));
    	Clown trainer = clownRepository.findById(trainerId).orElseThrow(() -> new ResourceNotFoundException("Clown with id: " + id + "does not exist."));
    	try {
    		lion.setClown(trainer);
    	}
    	catch(Exception e) {
    		throw new BadRequestException("Unable to set that lion's trainer to trainer id: " + trainerId);
    	}
    	try {
        	lionRepository.save(lion);
    	}
    	catch(Exception e) {
    		throw new BadRequestException("Unable to save lion: " + id + "after changing it's trainer");
    	}
    }
    
    

    public Lion newLion(Lion newLion) {
    	try {
    		lionRepository.save(newLion);
    	}
    	catch(Exception e) {
    		throw new BadRequestException("Unable to save lion");
    	}
        return newLion;
    }
    
	public List<LionDTO> all() {
		try {
	        List<LionDTO> ted =  lionRepository.findAllDTOs();
	        return ted;
		}
    	catch(Exception e) {
    		System.out.println(e);
    		throw new BadRequestException("Unable fetch lions");
    	}
    }
	
	public void deleteLionById(Long id) {
		try {
			lionRepository.deleteById(id);
		}
		catch(Exception e) {
			throw new BadRequestException("Unable to delete lion with id: " + id);
		}
	}

    public LionRepository getLionRepository() {
		return lionRepository;
	}

	public void setLionRepository(LionRepository lionRepository) {
		this.lionRepository = lionRepository;
	}


}
