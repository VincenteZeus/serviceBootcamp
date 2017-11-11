
package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.Livrable;

public class LivrableRepository extends BaseRepository<Livrable>{
  
    public LivrableRepository(String unitPersistence) {
        super(unitPersistence, Livrable.class);
    }
}
