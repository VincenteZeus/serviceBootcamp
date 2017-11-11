
package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.Projet;

public class ProjetRepository extends BaseRepository<Projet>{
  
    public ProjetRepository(String unitPersistence) {
        super(unitPersistence, Projet.class);
    }
}
