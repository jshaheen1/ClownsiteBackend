package com.quinnox.training.clowns.lionspef;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;




@Repository
public interface LionRepository extends JpaRepository<Lion, Long> {
    
    @Query(value = "select NEW com.quinnox.training.clowns.lionspef.LionDTO(l.id, l.name, l.roarstrength, c.name) from Lion l LEFT JOIN l.clown c")
    public List<LionDTO> findAllDTOs();
}
