
package com.bootcamp.jpa.repositories;

import com.bootcamp.jpa.entities.IndicateurPerformance;

public class IndicateurPerformanceRepository extends BaseRepository<IndicateurPerformance>{
  
    public IndicateurPerformanceRepository(String unitPersistence) {
        super(unitPersistence, IndicateurPerformance.class);
    }
}
