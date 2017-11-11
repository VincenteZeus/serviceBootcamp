
package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.FournisseurProgramme;


public class FournisseurProgrammeRepository extends BaseRepository<FournisseurProgramme>{   
  
    public FournisseurProgrammeRepository(String unitPersistence) {
        super(unitPersistence, FournisseurProgramme.class);
    }
}
