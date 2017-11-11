
package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.BailleurProgramme;

public class BailleurProgrammeRepository extends BaseRepository<BailleurProgramme>{
  
    public BailleurProgrammeRepository(String unitPersistence) {
        super(unitPersistence, BailleurProgramme.class);
    }
}
