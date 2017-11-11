
package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.Beneficiaire;
import com.bootcamp.jpa.entities.BeneficiaireProgramme;
import com.bootcamp.jpa.entities.Programme;


public class BeneficiaireProgrammeRepository extends BaseRepository<BeneficiaireProgramme>{
  
    public BeneficiaireProgrammeRepository(String unitPersistence) {
        super(unitPersistence, BeneficiaireProgramme.class);
    }
}
