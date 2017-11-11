
package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.Impact;

public class ImpactRepository extends BaseRepository<Impact>{
  
    public ImpactRepository(String unitPersistence) {
        super(unitPersistence, Impact.class);
    }
}
