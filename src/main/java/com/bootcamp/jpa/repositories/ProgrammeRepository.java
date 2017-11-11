
package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.Programme;

public class ProgrammeRepository extends BaseRepository<Programme>{
  
    public ProgrammeRepository(String unitPersistence) {
        super(unitPersistence, Programme.class);
    }
}
